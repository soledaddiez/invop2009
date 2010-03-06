package planificacion;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import simplex.Simplex;
import simplex.Variable;

import dao.impl.InventarioDAO;
import dao.impl.LineaDAO;
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
		
		List<Demanda> demandasInsatisfechas = new Vector<Demanda>();
		
		for (Producto producto : productos) {
			long cantidad = getInventario(producto);
			for (Demanda demanda : demandas){
				if(demanda.getProducto().getId().equals(producto.getId())){
					if(cantidad > 0){
						if(cantidad - demanda.getCantidad() < 0){
							demanda.setCantidad(demanda.getCantidad() - cantidad);
							cantidad = 0;
						}else{
							cantidad -= demanda.getCantidad();
							demanda.setCantidad((long) 0);
						}
					}
					demandasInsatisfechas.add(demanda);
				}
			}
		}
		return demandasInsatisfechas;
	}
	
	static public String getNombreVariable(RangoDemanda rango, LineaHora linea){
		return "p"+rango.getProducto().getId()+":"+linea.getLinea().getId();
	}
	
	static public Long getTasaProduccion(Producto producto, Linea linea){
		TasaProduccionDAO tasaProduccionDAO = new TasaProduccionDAO();
		TasaProduccion tasaProduccion = tasaProduccionDAO.getTasaProduccion(linea, producto);
		if(tasaProduccion != null){
			Long tasaProd = tasaProduccion.getBotellasPorHora();
			return tasaProd;
		}else{
			return (long) -1;
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
	
	static public Long getInventario(Producto producto){
		InventarioDAO inventarioDAO = new InventarioDAO();
		Inventario inventario = inventarioDAO.getInventarioPorProducto(producto);
		if(inventario != null)
			return inventario.getCantidad();
		else
			return (long) 0;
	}
	
	//Este metodo ejecuta el algoritmo simplex
	static public List<AsignacionProduccion> calcularAsignacion(List<RangoDemanda> rangosDemanda, List<LineaHora> lineas, List<AsignacionProduccion> asignacionPrevia){
		
		
		//Recolecto las lineas de cada producto que en la asignacion previa, puediendo producir un producto, no lo hacen
		HashMap<Long, Vector<Long>> lineasQueProducProd = new HashMap<Long, Vector<Long>>();
		
		for(RangoDemanda rangoDemanda : rangosDemanda){
			Long idProd = rangoDemanda.getProducto().getId();
			for(LineaHora linea : lineas){
				Long tasaProduccion = getTasaProduccion(rangoDemanda.getProducto(), linea.getLinea());
				
				if(tasaProduccion > 0){
					if(lineasQueProducProd.get(idProd) == null)
						lineasQueProducProd.put(idProd, new Vector<Long>());
					lineasQueProducProd.get(idProd).add(linea.getLinea().getId());
				}
			}
		}
		
		if(asignacionPrevia.size() > 0){
			
			Collection<Long> c = lineasQueProducProd.keySet();
			 
		    Iterator<Long> itr = c.iterator();
		 
		    while(itr.hasNext()){
		    	Long idProd = itr.next();
		    	Vector<Long> aBorrar = new Vector<Long>();
		    	for(Long idLinea : lineasQueProducProd.get(idProd)){
		    		boolean asignado = false;
			    	for(AsignacionProduccion asignacion : asignacionPrevia){
						if(asignacion.getOrdenProduccion().getProducto().getId().equals(idProd) && asignacion.getLinea().getId().equals(idLinea)){
							asignado = true;
						}
					}
			    	if(!asignado)
			    		aBorrar.add(idLinea);
		    	}
		    	for(Long idLinea : aBorrar){
		    		lineasQueProducProd.get(idProd).remove(idLinea);
		    	}
		    }
		    
		}
		
		Simplex simplex = new Simplex();
		HashMap<Variable, Producto> mapeoVarProducto = new HashMap<Variable, Producto>();
		HashMap<Variable, Linea> mapeoVarLinea = new HashMap<Variable, Linea>();

		//Funcion objetivo
		LinkedList<Variable> objectiveVars = new LinkedList<Variable>();

		for(LineaHora linea : lineas){
			for(RangoDemanda rangoDemanda : rangosDemanda){
				if(getTasaProduccion(rangoDemanda.getProducto(), linea.getLinea()) > 0){
					String nombreVar = getNombreVariable(rangoDemanda, linea);
					Variable variable = new Variable(nombreVar, rangoDemanda.getProducto().getUtilidad());
					objectiveVars.add(variable);
					mapeoVarProducto.put(variable, rangoDemanda.getProducto());
					mapeoVarLinea.put(variable, linea.getLinea());
				}
			}
		}
		simplex.addObjectiveFunction("u", objectiveVars);
		
		//Restricciones de horas
		for(LineaHora linea : lineas){
			LinkedList<Variable> resLineaVars = new LinkedList<Variable>();
			for(RangoDemanda rangoDemanda : rangosDemanda){
				String nombreVar = getNombreVariable(rangoDemanda, linea);
				Long tasaProduccion = getTasaProduccion(rangoDemanda.getProducto(), linea.getLinea());
				
				if(tasaProduccion > 0)
					if(!lineasQueProducProd.get(rangoDemanda.getProducto().getId()).contains(linea.getLinea().getId()))
						tasaProduccion = (long) 1;
				if(tasaProduccion > 0){
					
					if(asignacionPrevia.size() > 0 && lineasQueProducProd.get(rangoDemanda.getProducto().getId()).contains(linea.getLinea().getId())){
						//Agrego la restriccion por lote minimo
						LinkedList<Variable> resLotVars = new LinkedList<Variable>();
						resLotVars.add(new Variable(nombreVar, 1.0));
						simplex.addConstraint(">=", rangoDemanda.getProducto().getLoteMinimo(), resLotVars);
					}
					resLineaVars.add(new Variable(nombreVar, 1.0 / (double) tasaProduccion));
				}
			}
			if(resLineaVars.size() > 0){
				simplex.addConstraint("<=", linea.getHorasLibres(), resLineaVars);
			}
		}
		
		//Restricciones de demandas
		for(RangoDemanda rangoDemanda : rangosDemanda){
			LinkedList<Variable> resDemVars = new LinkedList<Variable>();
			LinkedList<Variable> resDemVars2 = new LinkedList<Variable>();
			for(LineaHora linea : lineas){
				if(getTasaProduccion(rangoDemanda.getProducto(), linea.getLinea()) > 0){
					String nombreVar = getNombreVariable(rangoDemanda, linea);
					resDemVars.add(new Variable(nombreVar, 1.0));
					resDemVars2.add(new Variable(nombreVar, 1.0));
				}
			}
			simplex.addConstraint(">=", rangoDemanda.getMinDemanda(), resDemVars);
			simplex.addConstraint("<=", rangoDemanda.getMaxDemanda(), resDemVars2);
		}
		
		//Ejecutar simplex
		try{
			simplex.solveProblem();
		}catch(Exception e){
			e.printStackTrace();
		}
		//simplex.describeProblem(System.out);

		List<AsignacionProduccion> asignaciones = new Vector<AsignacionProduccion>();
		Timestamp timeNow = new Timestamp(Calendar.getInstance().getTimeInMillis());
		//Asignar al plan
		for(Variable variable : objectiveVars){
			Producto producto = mapeoVarProducto.get(variable);
			Linea linea = mapeoVarLinea.get(variable);
			if(producto != null){
				long cantidad = Math.round(simplex.getSolutionValue(variable.name()));
				if(cantidad > 0){
					Demanda demanda = new Demanda(producto, cantidad, timeNow);
					double tiempoEstimado = getTiempoEstimado(demanda, linea);
					OrdenProduccion orden = new OrdenProduccion(producto, cantidad, tiempoEstimado);
					AsignacionProduccion asignacion = new AsignacionProduccion(linea, orden);
					asignaciones.add(asignacion);
				}
			}
		}
		return asignaciones;
	}
	
	//Planifica una lista de demandas en un conjunto de lineas
	static public PlanProduccion planificar(List<Demanda> demandas, List<Linea> lineas){
		
		LineaDAO lineaDAO = new LineaDAO();
		
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
					if(demandaRestante.getProducto().getId() == demanda.getProducto().getId()){
						demandaRestante.setCantidad(demandaRestante.getCantidad() + demanda.getCantidad());
						yaEsta = true;
					}
				}
				if(!yaEsta){
					demandasRestantes.add(demanda);
				}
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
			Long demandaMinima = demanda.getCantidad();
			RangoDemanda rangoDemanda = new RangoDemanda(demanda.getProducto(), demandaMinima, demandaMinima);
			Long demRestante = (long) 0; 
			for(Demanda demandaFutura : demandasRestantes)
				if(demandaFutura.getProducto().getId().equals(demanda.getProducto().getId()))
					demRestante += demandaFutura.getCantidad(); 
			rangoDemanda.setMaxDemanda(demandaMinima+demRestante);
			demandasRango.add(rangoDemanda);
		}
		
		//A los rangos de demandas le sumo la demanda fictícea
		for(RangoDemanda rangoDemanda : demandasRango){
			Long demandaMaxima = rangoDemanda.getMaxDemanda();
			Long inventarioActual = getInventario(rangoDemanda.getProducto());
			Long inventarioSeguridad = (long) 0;
			if(rangoDemanda.getProducto().getInventarioSeguridad() != null)
				inventarioSeguridad = Math.round(rangoDemanda.getProducto().getInventarioSeguridad());
			if(inventarioActual < inventarioSeguridad)
				rangoDemanda.setMaxDemanda(demandaMaxima + inventarioSeguridad - inventarioActual);
		}
		
		List<RangoDemanda> demandasRangoFinales = new Vector<RangoDemanda>();
		//Filtro las demandas que no sea rentable producir
		for(RangoDemanda rangoDemanda : demandasRango){
			Long demandaMinima = rangoDemanda.getMinDemanda();
			if(demandaMinima == 0 || demandaMinima != 0 && demandaMinima > rangoDemanda.getProducto().getLoteMinimo()){
				demandasRangoFinales.add(rangoDemanda);
			}
			//demandasRangoFinales.add(rangoDemanda);
		}
		
		//Creo los wrappers para las lineas con sus horas disponibles 
		List<LineaHora> lineasHora = new Vector<LineaHora>();
		for(Linea linea : lineas){
			LineaHora lineaHora = new LineaHora(linea, HORAS_TRABAJO);
			lineasHora.add(lineaHora);
		}
		
		//Calculo la asignación para todas las lineas asumiendo que todas están libres 24 hs 
		List<AsignacionProduccion> asignaciones = calcularAsignacion(demandasRangoFinales, lineasHora, new Vector<AsignacionProduccion>());
		
		//Calculo los cambios de formatos que va a tener cada linea y le resto ese tiempo a las hs disponibles
		for (LineaHora lineaHora : lineasHora) {
			List<Long> formatos = new Vector<Long>();
			int cantFormatos = 0;
			for(AsignacionProduccion asignacion : asignaciones){
				if(asignacion.getLinea().getId().equals(lineaHora.getLinea().getId())){
					if(!formatos.contains(asignacion.getOrdenProduccion().getProducto().getFormato().getId())){
						formatos.add(asignacion.getOrdenProduccion().getProducto().getFormato().getId());
						if(!lineaDAO.getIdUltimoFormato(asignacion.getLinea().getId()).equals(asignacion.getOrdenProduccion().getProducto().getFormato().getId()))
							cantFormatos++;
					}
				}	
			}
			lineaHora.setHorasLibres(lineaHora.getHorasLibres() - cantFormatos * HORAS_CAMBIO_FORMATO);
		}
		
		
		//Calculo nuevamente la asignación para todas las lineas pero sin los tiempos de cambio de formato
		//Este calculo no es el final, solo sirve para redeterminar los minimos de cada rango para que el simplex
		//pueda encontrar un optimo
		List<AsignacionProduccion> asignacionesIntermedias = calcularAsignacion(demandasRangoFinales, lineasHora, asignaciones);
		for(AsignacionProduccion asignacion : asignacionesIntermedias){
			for(RangoDemanda rangoDemanda : demandasRangoFinales){
				if(asignacion.getOrdenProduccion().getProducto().getId().equals(rangoDemanda.getProducto().getId())){
					rangoDemanda.setMinDemanda(asignacion.getOrdenProduccion().getCantidadAProducir());
				}
			}
		}
		
		//Calculo nuevamente la asignación para todas las lineas pero sin los tiempos de cambio de formato
		List<AsignacionProduccion> asignacionesFinales = calcularAsignacion(demandasRangoFinales, lineasHora, asignaciones);
		
		Producto cambioFormato = new Producto("[ Cambio de formato ]", null);
		OrdenProduccion ordenCambioFormato = new OrdenProduccion(cambioFormato, (long) 0, HORAS_CAMBIO_FORMATO);
		
		List<AsignacionProduccion> asignacionesFinales2 = new Vector<AsignacionProduccion>();
		//Coloco el formato anterior de cada linea adelante
		for(int i = 0; i < asignacionesFinales.size(); i++){
			AsignacionProduccion asignacion = asignacionesFinales.get(i);
			if(asignacion.getOrdenProduccion().getProducto().getFormato().getId().equals(lineaDAO.getIdUltimoFormato(asignacion.getLinea().getId()))){
				asignacionesFinales2.add(0, asignacion);
			}else{
				asignacionesFinales2.add(asignacion);
			}
		}
		
		//Ordeno las asignaciones por formato para minimizar los cambios
		List<AsignacionProduccion> asignacionesOrdenadas = new Vector<AsignacionProduccion>(); 
		for(int i = 0; i < asignacionesFinales2.size(); i++){
			AsignacionProduccion asignacion = asignacionesFinales2.get(i);
			if(!asignacionesOrdenadas.contains(asignacion) && asignacion.getOrdenProduccion().getCantidadAProducir() > HORAS_TRABAJO){
				//Agrego el cambio de formato como un producto más
				if(!asignacion.getOrdenProduccion().getProducto().getFormato().getId().equals(lineaDAO.getIdUltimoFormato(asignacion.getLinea().getId())))
					asignacionesOrdenadas.add(new AsignacionProduccion(asignacion.getLinea(), ordenCambioFormato));
				asignacionesOrdenadas.add(asignacion);
				Long formato = asignacion.getOrdenProduccion().getProducto().getFormato().getId();
				for(int j = i+1; j < asignacionesFinales2.size(); j++)
					//Si es del mismo formato y esta en la misma linea lo coloco detrás de el
					if(asignacionesFinales2.get(j).getLinea().getId().equals(asignacion.getLinea().getId()) &&  asignacionesFinales2.get(j).getOrdenProduccion().getProducto().getFormato().getId().equals(formato)){ 
						asignacionesOrdenadas.add(asignacionesFinales2.get(j));
					}
			}
		}
		
		PlanProduccion plan = new PlanProduccion();
		plan.setAsignaciones(asignacionesOrdenadas);
		return plan;
	}
}
