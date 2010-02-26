package main;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import modelo.AsignacionProduccion;
import modelo.Demanda;
import modelo.Formato;
import modelo.Linea;
import modelo.PlanProduccion;
import modelo.Producto;
import modelo.TasaProduccion;
import planificacion.Planificador;
//import planificacion.PlanificadorViejo;
import dao.impl.LineaDAO;
import dao.impl.PedidoDAO;
import dao.impl.ProductoDAO;
import excepciones.DataAccessException;

public class MainPlanificador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ProductoDAO productoDAO = new ProductoDAO();
		
		//List<Producto> productos = productoDAO.getList();
		List<Producto> productos = new Vector<Producto>();
		
		Formato f = new Formato();
		f.setId((long) 1);
		f.setCapacidad((long)1000);
		f.setNombre("Formato 1");
		
		Producto p1 = new Producto("Producto 1", f);
		Producto p2 = new Producto("Producto 2", f);
		p1.setLoteMinimo((long) 10);
		p2.setLoteMinimo((long) 10);
		p1.setUtilidad(0.9);
		p2.setUtilidad(0.8);
		productos.add(p1);
		productos.add(p2);
		
		System.out.println("Hay " + productos.size() + " productos");
		
		/*
		try {
			productoDAO.save(p1);
			productoDAO.save(p2);
			productoDAO.save(p3);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Long now = Calendar.getInstance().getTimeInMillis();
		Timestamp fecha1 = new Timestamp(now);
		Timestamp fecha2 = new Timestamp(now + (1000*60*60*24)*1);
		Timestamp fecha3 = new Timestamp(now + (1000*60*60*24)*2);
		
		//PedidoDAO pedidoDAO = new PedidoDAO(); 
		//List<Demanda> demandas = pedidoDAO.getDemandas(fecha1);
		
		List<Demanda> demandas = new Vector<Demanda>();
		demandas.add(new Demanda(productos.get(1), (long) 1440, fecha1));
		demandas.add(new Demanda(productos.get(2), (long) 1320, fecha1));
		demandas.add(new Demanda(productos.get(1), (long) 400, fecha2));
		demandas.add(new Demanda(productos.get(2), (long) 200, fecha2));
		demandas.add(new Demanda(productos.get(1), (long) 400, fecha3));
		demandas.add(new Demanda(productos.get(2), (long) 300, fecha3));
		
		
		Vector<Linea> lineas = new Vector<Linea>();
		Linea l1 = new Linea("Linea 1");
		Linea l2 = new Linea("Linea 2");
		Linea l3 = new Linea("Linea 3");
		
		lineas.add(l1);
		lineas.add(l2);
		lineas.add(l3);
		
		TasaProduccion tasa11 = new TasaProduccion();
		tasa11.setId((long) 1);
		tasa11.setLinea(l1);
		tasa11.setProducto(p1);
		tasa11.setBotellasPorHora((long)100);
		
		TasaProduccion tasa12 = new TasaProduccion();
		tasa11.setId((long) 2);
		tasa11.setLinea(l1);
		tasa11.setProducto(p2);
		tasa11.setBotellasPorHora((long)110);
		
		TasaProduccion tasa21 = new TasaProduccion();
		tasa11.setId((long) 3);
		tasa11.setLinea(l2);
		tasa11.setProducto(p1);
		tasa11.setBotellasPorHora((long)120);
		
		TasaProduccion tasa22 = new TasaProduccion();
		tasa11.setId((long) 4);
		tasa11.setLinea(l2);
		tasa11.setProducto(p2);
		tasa11.setBotellasPorHora((long)90);
		
		
		
		
		/*
		try {
			lineaDAO.save(l1);
			lineaDAO.save(l2);
			lineaDAO.save(l3);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		LineaDAO lineaDAO = new LineaDAO();
		//List<Linea> lineas = lineaDAO.getList();
		
		System.out.println("Hay " + lineas.size() + " lineas");
		
		PlanProduccion plan = Planificador.planificar(demandas, lineas);
		
		List<AsignacionProduccion> asignacion = plan.getAsignaciones();
		for (Iterator iterator = asignacion.iterator(); iterator.hasNext();) {
			AsignacionProduccion a = (AsignacionProduccion) iterator.next();
			System.out.println("Asignar " + a.getOrdenProduccion().getProducto().getNombre() + 
					" x " +a.getOrdenProduccion().getCantidadAProducir()+
					" a la linea " + a.getLinea().getNombre() +
					". Demora aprox:" + a.getOrdenProduccion().getTiempoEstimado() + " hs." );
		}
	}

}
