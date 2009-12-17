package planificacion;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import simplex.Simplex;
import simplex.Variable;

import dao.impl.InventarioDAO;
import dao.impl.ProductoDAO;
import dao.impl.TasaProduccionDAO;

import modelo.AsignacionProduccion;
import modelo.Demanda;
import modelo.Inventario;
import modelo.Linea;
import modelo.OrdenProduccion;
import modelo.PlanProduccion;
import modelo.Producto;
import modelo.TasaProduccion;

public class Planificador {
	
	static Double HORAS_TRABAJO = 24.0;
	static Double HORAS_CAMBIO_FORMATO = 4.0;
	
	static public List<Demanda> filtrarDemandasSatisfechas(List<Demanda> demandas){
		ProductoDAO productoDAO = new ProductoDAO();
		List<Producto> productos = productoDAO.getList();
		
		InventarioDAO inventarioDAO = new InventarioDAO();
		
		List<Demanda> demandasInsatisfechas = new Vector<Demanda>();
		
		for (Producto producto : productos) {
			Inventario inventario = inventarioDAO.getInventarioPorProducto(producto);
			long cantidad = Math.round(inventario.getCantidad());
			for (Demanda demanda : demandas){
				if(demanda.getProducto().getId().equals(producto.getId())){
					if(cantidad > 0){
						if(cantidad - demanda.getCantidad() < 0){
							demanda.setCantidad(demanda.getCantidad() - cantidad);
							cantidad = 0;
							demandasInsatisfechas.add(demanda);
						}else{
							cantidad -= demanda.getCantidad();
							demanda.setCantidad((long) 0);
						}
					}else{
						demandasInsatisfechas.add(demanda);
					}
				}
			}
		}
		return demandasInsatisfechas;
	}
	
	static public String getNombreVariable(RangoDemanda rango, LineaHora linea){
		return "p"+rango.getProducto().getId()+":"+linea.getLinea().getId();
	}
	
	static public double getTasaProduccion(Producto producto, Linea linea){
		TasaProduccionDAO tasaProduccionDAO = new TasaProduccionDAO();
		TasaProduccion tasaProduccion = tasaProduccionDAO.getTasaProduccion(linea, producto);
		if(tasaProduccion != null){
			Long tasaProd = tasaProduccion.getBotellasPorHora();
			return (double) tasaProd;
		}else{
			return 0.0;
		}
	}

	static public double getTiempoEstimado(Demanda demanda, Linea linea){
		TasaProduccionDAO tasaProduccionDAO = new TasaProduccionDAO();
		TasaProduccion tasaProduccion = tasaProduccionDAO.getTasaProduccion(linea, demanda.getProducto());
		if(tasaProduccion != null){
			Long tasaProd = tasaProduccion.getBotellasPorHora();
			return (double) demanda.getCantidad() / (double) tasaProd;
		}else{
			return 0.0;
		}
	}
	
	//Este metodo ejecuta el algoritmo simplex
	static public List<AsignacionProduccion> calcularAsignacion(List<RangoDemanda> rangosDemanda, List<LineaHora> lineas){
		
		Simplex simplex = new Simplex();
		HashMap<Variable, Producto> mapeoVarProducto = new HashMap<Variable, Producto>();
		HashMap<Variable, Linea> mapeoVarLinea = new HashMap<Variable, Linea>();

		//Funcion objetivo
		LinkedList<Variable> objectiveVars = new LinkedList<Variable>();
		//objVars.add(new Variable("p32", 10));
		for(LineaHora linea : lineas){
			for(RangoDemanda rangoDemanda : rangosDemanda){
				String nombreVar = getNombreVariable(rangoDemanda, linea);
				Variable variable = new Variable(nombreVar, rangoDemanda.getProducto().getUtilidad());
				objectiveVars.add(variable);
				mapeoVarProducto.put(variable, rangoDemanda.getProducto());
				mapeoVarLinea.put(variable, linea.getLinea());
			}
		}
		simplex.addObjectiveFunction("u", objectiveVars);
		
		//Restricciones de demandas
		for(RangoDemanda rangoDemanda : rangosDemanda){
			LinkedList<Variable> resDemVars = new LinkedList<Variable>();
			for(LineaHora linea : lineas){
				String nombreVar = getNombreVariable(rangoDemanda, linea);
				resDemVars.add(new Variable(nombreVar, 1.0));
			}
			simplex.addConstraint(">=", rangoDemanda.getMinDemanda(), resDemVars);
			simplex.addConstraint("<=", rangoDemanda.getMaxDemanda(), resDemVars);
		}
		
		//Restricciones de horas
		for(LineaHora linea : lineas){
			LinkedList<Variable> resLineaVars = new LinkedList<Variable>();
			for(RangoDemanda rangoDemanda : rangosDemanda){
				String nombreVar = getNombreVariable(rangoDemanda, linea);
				double tasaProduccion = getTasaProduccion(rangoDemanda.getProducto(), linea.getLinea());
				System.out.println("Tasa de prod: "+ rangoDemanda.getProducto().getNombre() + " y l " + linea.getLinea().getId()+ " es: " + tasaProduccion);
				if(tasaProduccion > 0.0){
					resLineaVars.add(new Variable(nombreVar, 1.0 / tasaProduccion));
				}else{
					//Si una linea no puede producir un producto determinado, agrego una restriccion de igualdad a 0
					LinkedList<Variable> tasaCeroVars = new LinkedList<Variable>();
					tasaCeroVars.add(new Variable(nombreVar, 1.0));
					simplex.addConstraint("=", 0.0, tasaCeroVars);
				}
			}
			simplex.addConstraint("<=", linea.getHorasLibres(), resLineaVars);
		}
		
		simplex.describeProblem(System.out);
		
		//Ejecutar simplex
		try{
			simplex.solveProblem();
		}catch(Exception e){
			e.printStackTrace();
		}

		List<AsignacionProduccion> asignaciones = new Vector<AsignacionProduccion>();
		Timestamp timeNow = new Timestamp(Calendar.getInstance().getTimeInMillis());
		//Asignar al plan
		for(Variable variable : objectiveVars){
			Producto producto = mapeoVarProducto.get(variable);
			Linea linea = mapeoVarLinea.get(variable);
			if(producto != null){
				long cantidad = Math.round(simplex.getSolutionValue(variable.name()));
				Demanda demanda = new Demanda(producto, cantidad, timeNow);
				double tiempoEstimado = getTiempoEstimado(demanda, linea);
				OrdenProduccion orden = new OrdenProduccion(producto, cantidad, tiempoEstimado);
				AsignacionProduccion asignacion = new AsignacionProduccion(linea, orden);
				asignaciones.add(asignacion);
			}
		}
		return asignaciones;
	}
	
	//Planifica una lista de demandas en un conjunto de lineas
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
		for (Demanda demanda : demandas) {
			Calendar fecha = Calendar.getInstance();
			fecha.setTimeInMillis(demanda.getFecha().getTime());
			if(fecha.get(Calendar.DAY_OF_MONTH) == day && fecha.get(Calendar.MONTH) == month && fecha.get(Calendar.YEAR) == year){
				demandasParaHoy.add(demanda);
			}else{
				//Todas las demandas restantes se concentran en 1 por producto
				boolean yaEsta = false;
				for(Demanda demandaRestante : demandasRestantes){
					if(demandaRestante.getProducto().getId().equals(demanda.getProducto().getId())){
						demandaRestante.setCantidad(demandaRestante.getCantidad() + demanda.getCantidad());
						yaEsta = true;
					}
				}
				if(!yaEsta)
					demandasRestantes.add(demanda);
			}
		}
		
		//Filtro las demandas que se satisfacen con el inventario disponible
		demandasParaHoy = filtrarDemandasSatisfechas(demandasParaHoy);
		
		//Filtro las demandas que se satisfacen con el inventario disponible
		demandasRestantes = filtrarDemandasSatisfechas(demandasRestantes);
		
		//Armo los rangos de demanda para el metodo simplex
		//La demanda minima para cada producto es 
		List<RangoDemanda> demandasRango = new Vector<RangoDemanda>();
		for(Demanda demanda : demandasParaHoy){
			RangoDemanda rangoDemanda = new RangoDemanda(demanda.getProducto(), demanda.getCantidad(), demanda.getCantidad());
			Long demRestante = (long) 0; 
			for(Demanda demandaFutura : demandasRestantes)
				if(demandaFutura.getProducto().getId().equals(demanda.getProducto().getId()))
					demRestante += demandaFutura.getCantidad(); 
			rangoDemanda.setMaxDemanda(demanda.getCantidad()+demRestante);
			demandasRango.add(rangoDemanda);
		}
		
		//Creo los wrappers para las lineas con sus horas disponibles 
		List<LineaHora> lineasHora = new Vector<LineaHora>();
		for(Linea linea : lineas){
			LineaHora lineaHora = new LineaHora(linea, HORAS_TRABAJO);
			lineasHora.add(lineaHora);
		}

		List<AsignacionProduccion> asignaciones = calcularAsignacion(demandasRango, lineasHora);
		
		PlanProduccion plan = new PlanProduccion();
		plan.setAsignaciones(asignaciones);
		return plan;
	}
}
