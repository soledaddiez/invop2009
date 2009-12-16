package planificacion;

import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import dao.impl.TasaProduccionDAO;

import modelo.Linea;
import modelo.OrdenProduccion;
import modelo.Demanda;
import modelo.PlanProduccion;
import modelo.TasaProduccion;

public class Planificador {
	public Planificador(){
		
	}
	
	/*
	 * Planifica la produccion de un conjunto de pedidos en un conjunto de lineas
	 * No tiene en cuenta las fechas de los pedidos, asume que es indiferente
	 * @return pedidos sin asignar
	 */
	static private List<Demanda> planificarDemandas(List<Demanda> demandas, List<Linea> lineas, PlanProduccionParcial planParcial){
		
		TasaProduccionDAO tasaProduccionDAO = new TasaProduccionDAO();
		//Cantidad de horas a planificar
		Double horasTrabajo = 24.0;
		Double horasCambioFormato = 4.0;

		//Ordeno los pedidos en orden descendente de acuerdo a su importancia relativa
		List<Frecuencia> importancias = Pareto.calcularImportancia(demandas);
		
		//Por cada pedido, en orden descendente de importancia, pongo detrás de él
		//los que tengan el mismo formato. Asumo que un cambio de formato siempre es
		//más costoso que producir un producto de mayor importancia.
		
		Vector<Demanda> demandasOrdenadas = new Vector<Demanda>();
		for (int i = 0; i < importancias.size(); i++) {
			Demanda d = importancias.get(i).getDemanda();
			if(!demandasOrdenadas.contains(d)){
				demandasOrdenadas.add(d);
				Long formato = d.getProducto().getCc();
				for(int j = i+1; j < importancias.size(); j++){
					Demanda dem = importancias.get(j).getDemanda();
					if(dem.getProducto().getCc() == formato) //Si es del mismo formato lo coloco detrás de el
						demandasOrdenadas.add(dem);
				}
			}
		}
		
		//Por cada línea, voy asignando las órdenes de produccion de los productos
		//ordenados en los pasos anteriores. Asigno en el orden en que están.
		
		Long idPedido = (long) 1;
		int nextDemanda = 0;
		boolean lineaCompleta = false;
		Vector<Demanda> demandasAsignadas = new Vector<Demanda>();
		for(int i = 0; i < lineas.size(); i++) {
			Linea linea = lineas.get(i);
			Double horasOcupadas = planParcial.getHorasOcupadas(linea);
			lineaCompleta = false;
			while(nextDemanda < demandasOrdenadas.size() && horasOcupadas < horasTrabajo && !lineaCompleta){
				Demanda demanda = demandasOrdenadas.elementAt(nextDemanda);
				if(demanda.getProducto().getLoteMinimo() <= demanda.getCantidad()){
					TasaProduccion tasaProduccion = tasaProduccionDAO.getTasaProduccion(linea, demanda.getProducto());
					Long tasaProd = tasaProduccion.getBotellasPorHora();
					double tiempoEstimado = (double) demanda.getCantidad() / (double) tasaProd;
					//Si hay cambio de formato, le sumo las horas del cambio de formato al tiempo estimado
					if(nextDemanda > 0 && demanda.getProducto().getCc() != demandasOrdenadas.elementAt(nextDemanda-1).getProducto().getCc())
						tiempoEstimado += horasCambioFormato;
					//Si tengo tiempo en la linea, lo asigno. Sino, paso a la siguiente linea
					if(horasOcupadas + tiempoEstimado < horasTrabajo){
						horasOcupadas += tiempoEstimado;
						OrdenProduccion orden = new OrdenProduccion(demanda.getProducto(), demanda.getCantidad(), tiempoEstimado);
						planParcial.addAsignacion(linea, orden);
						demandasAsignadas.add(demanda);
						nextDemanda++;
						idPedido++;
					}else{
						lineaCompleta = true;
					}
				}else{
					nextDemanda++;
				}
			}
		}
		
		Vector<Demanda> demandasDescartadas = new Vector<Demanda>();
		for(int i = 0; i < demandas.size(); i++){
			Demanda demanda = demandas.get(i);
			if(!demandasAsignadas.contains(demanda))
				demandasDescartadas.add(demanda);
		}

		return demandasDescartadas;
	}
	
	/*
	 * Planifica la produccion de un conjunto de pedidos en un conjunto de lineas
	 * Primero asigna los pedidos de la fecha más proxima y luego los demás
	 * Debería haber 1 solo pedido por producto en el vector de pedidos (Se puede hacer en la consulta SQL)
	 * TODO considerar el inventario de cada producto en cada dia y restarlo a la demanda
	 */
	static public PlanProduccion planificar(List<Demanda> demandas, List<Linea> lineas){
		
		//Tomo el dia de hoy como la menor fecha dentro de las demandas
		Calendar today = Calendar.getInstance();
		today.setTimeInMillis((long) 999999999*99999999);
		for (int i = 0; i < demandas.size(); i++) {
			Calendar fecha = Calendar.getInstance();
			fecha.setTimeInMillis(demandas.get(i).getFecha().getTime());
			if(fecha.compareTo(today) <= 0)
				today = fecha;
		}
		
		//Saco de la lista de demandas aquellas que sean para el primero de los dias
		List<Demanda> demandasParaHoy = new Vector<Demanda>();
		List<Demanda> demandasRestantes = new Vector<Demanda>(); 
		int day = today.get(Calendar.DAY_OF_MONTH); //Entre 1 y 31
		int month = today.get(Calendar.MONTH); //Entre 0 y 11
		int year = today.get(Calendar.YEAR);
		for (int i = 0; i < demandas.size(); i++) {
			Demanda demanda = demandas.get(i);
			Calendar fecha = Calendar.getInstance();
			fecha.setTimeInMillis(demanda.getFecha().getTime());
			if(fecha.get(Calendar.DAY_OF_MONTH) == day && fecha.get(Calendar.MONTH) == month && fecha.get(Calendar.YEAR) == year){
				demandasParaHoy.add(demandas.get(i));
			}else{
				demandasRestantes.add(demandas.get(i));
			}
		}

		//1. Planifico los pedidos para el primero de los dias
		PlanProduccionParcial planParcial = new PlanProduccionParcial((long) 1);
		
		List<Demanda> descartados1 = planificarDemandas(demandasParaHoy, lineas, planParcial);
		
		
		//2. Planifico los pedidos para los dias restantes si tengo tiempo
		if(descartados1.size() == 0){
			List<Demanda> descartados2 = planificarDemandas(demandasRestantes, lineas, planParcial);
			
			//3. Asignacion de la capacidad ociosa
			// if(descartados2.size() == 0){
			//TODO completar esta planificacion.
			//}
		}
		
		PlanProduccion plan = new PlanProduccion();
		plan.setAsignaciones(planParcial.getAsignaciones());
		return plan;
	}
}
