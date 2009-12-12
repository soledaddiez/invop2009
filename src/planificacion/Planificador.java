package planificacion;

import java.util.Calendar;
import java.util.Vector;

import modelo.Linea;
import modelo.OrdenProduccion;
import modelo.Pedido;
import modelo.PlanProduccion;
import modelo.TasaProduccion;
import dao.impl.TasaProduccionDAO;

public class Planificador {
	public Planificador(){
		
	}
	
	/*
	 * Planifica la produccion de un conjunto de pedidos en un conjunto de lineas
	 * No tiene en cuenta las fechas de los pedidos, asume que es indiferente
	 * @return pedidos sin asignar
	 */
	static private Vector<Pedido> planificarPedidos(Vector<Pedido> pedidos, Vector<Linea> lineas, PlanProduccionParcial planParcial){
		
		
		TasaProduccionDAO tasaProduccionDAO = new TasaProduccionDAO();
		//Cantidad de horas a planificar
		Double horasTrabajo = 24.0;
		Double horasCambioFormato = 4.0;

		//Ordeno los pedidos en orden descendente de acuerdo a su importancia relativa
		Vector<Frecuencia> importancias = Pareto.calcularImportancia(pedidos);
		
		//Por cada pedido, en orden descendente de importancia, pongo detrás de él
		//los que tengan el mismo formato. Asumo que un cambio de formato siempre es
		//más costoso que producir un producto de mayor importancia.
		
		Vector<Pedido> pedidosOrdenados = new Vector<Pedido>();
		for (int i = 0; i < importancias.size(); i++) {
			Pedido p = importancias.elementAt(i).getPedido();
			if(!pedidosOrdenados.contains(p)){
				pedidosOrdenados.add(p);
				Long formato = p.getProducto().getCc();
				for(int j = i+1; i < importancias.size(); j++){
					Pedido ped = importancias.elementAt(j).getPedido();
					if(ped.getProducto().getCc() == formato) //Si es del mismo formato lo coloco detrás de el
						pedidosOrdenados.add(ped);
				}
			}
		}
		
		//Por cada línea, voy asignando las órdenes de produccion de los productos
		//ordenados en los pasos anteriores. Asigno en el orden en que están.
		
		Long idPedido = (long) 1;
		int nextPedido = 0;
		Vector<Pedido> pedidosAsignados = new Vector<Pedido>();
		for(int i = 0; i < lineas.size(); i++) {
			Linea linea = lineas.elementAt(i);
			Double horasOcupadas = planParcial.getHorasOcupadas(linea);
			
			while(nextPedido < pedidosOrdenados.size() && horasOcupadas < horasTrabajo){
				Pedido pedido = pedidosOrdenados.elementAt(nextPedido);
				if(pedido.getProducto().getLoteMinimo() < pedido.getCantidad()){
					TasaProduccion tasaProduccion = tasaProduccionDAO.getTasaProduccion(linea, pedido.getProducto());
					Long tasaProd = tasaProduccion.getBotellasPorHora();
					double tiempoEstimado = (double) pedido.getCantidad() / (double) tasaProd;
					//Si hay cambio de formato, le sumo las horas del cambio de formato al tiempo estimado
					if(nextPedido > 0 && pedido.getProducto().getCc() != pedidosOrdenados.elementAt(nextPedido-1).getProducto().getCc())
						tiempoEstimado += horasCambioFormato;
					//Si tengo tiempo en la linea, lo asigno. Sino, paso a la siguiente linea
					if(horasOcupadas + tiempoEstimado < horasTrabajo){
						horasOcupadas += tiempoEstimado;
						OrdenProduccion orden = new OrdenProduccion(idPedido, pedido.getProducto(), pedido.getCantidad(), tiempoEstimado);
						planParcial.addAsignacion(linea, orden);
						pedidosAsignados.add(pedido);
						nextPedido++;
						idPedido++;
					}
				}else{
					nextPedido++;
				}
			}
		}
		
		Vector<Pedido> pedidosDescartados = new Vector<Pedido>();
		for(int i = 0; i < pedidos.size(); i++){
			Pedido pedido = pedidos.elementAt(i);
			if(!pedidosAsignados.contains(pedido))
				pedidosDescartados.add(pedido);
		}

		return pedidosDescartados;
	}
	
	/*
	 * Planifica la produccion de un conjunto de pedidos en un conjunto de lineas
	 * Primero asigna los pedidos de la fecha más proxima y luego los demás
	 * Debería haber 1 solo pedido por producto en el vector de pedidos (Se puede hacer en la consulta SQL)
	 * TODO considerar el inventario de cada producto en cada dia y restarlo a la demanda
	 */
	static public PlanProduccion planificar(Vector<Pedido> pedidos, Vector<Linea> lineas){
		
		//Tomo el dia de hoy como la menor fecha dentro de los pedidos
		Calendar today = Calendar.getInstance();
		today.setTimeInMillis((long) 999999999);
		for (int i = 0; i < pedidos.size(); i++) {
			Calendar fecha = Calendar.getInstance();
			fecha.setTimeInMillis(pedidos.elementAt(i).getFechaOrden().getTime());
			int dayFecha = fecha.get(Calendar.DAY_OF_MONTH) * fecha.get(Calendar.MONTH) * fecha.get(Calendar.YEAR);
			if(fecha.compareTo(today) <= 0)
				today = fecha;
		}
		
		//Saco de la lista de pedidos aquellos que sean para el primero de los dias
		Vector<Pedido> pedidosParaHoy = new Vector<Pedido>(); 
		int day = today.get(Calendar.DAY_OF_MONTH); //Entre 1 y 31
		int month = today.get(Calendar.MONTH); //Entre 0 y 11
		int year = today.get(Calendar.YEAR);
		for (int i = 0; i < pedidos.size(); i++) {
			Pedido pedido = pedidos.elementAt(i);
			Calendar fecha = Calendar.getInstance();
			fecha.setTimeInMillis(pedido.getFechaOrden().getTime());
			if(fecha.get(Calendar.DAY_OF_MONTH) == day && fecha.get(Calendar.MONTH) == month && fecha.get(Calendar.YEAR) == year)
				pedidosParaHoy.add(pedidos.remove(i));
		}

		//1. Planifico los pedidos para el primero de los dias
		PlanProduccionParcial planParcial = new PlanProduccionParcial((long) 1);
		
		Vector<Pedido> descartados1 = planificarPedidos(pedidosParaHoy, lineas, planParcial);
		
		//2. Planifico los pedidos para los dias restantes si tengo tiempo
		if(descartados1.size() == 0){
			Vector<Pedido> descartados2 = planificarPedidos(pedidos, lineas, planParcial);
			
			//3. Asignacion de la capacidad ociosa
			// if(descartados2.size() == 0){
			//TODO completar esta planificacion
			//}
		}
		
		PlanProduccion plan = new PlanProduccion();
		plan.setAsignaciones(planParcial.getAsignaciones());
		return plan;
	}
}
