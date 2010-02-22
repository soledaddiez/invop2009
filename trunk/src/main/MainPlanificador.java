package main;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import modelo.AsignacionProduccion;
import modelo.Demanda;
import modelo.Linea;
import modelo.PlanProduccion;
import modelo.Producto;
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
		
		List<Producto> productos = productoDAO.getList();
		System.out.println("Hay " + productos.size() + " productos");
		/*Producto p1 = new Producto("Producto 1", (long)100);
		Producto p2 = new Producto("Producto 2", (long)200);
		Producto p3 = new Producto("Producto 3", (long)300);
		p1.setLoteMinimo((long) 1000);
		p2.setLoteMinimo((long) 800);
		p3.setLoteMinimo((long) 900);
		p1.setUtilidad(1.0);
		p2.setUtilidad(0.8);
		p3.setUtilidad(0.9);
		
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
		
		PedidoDAO pedidoDAO = new PedidoDAO(); 
		List<Demanda> demandas = pedidoDAO.getDemandas(fecha1);
		
		
		/*List<Demanda> demandas = new Vector<Demanda>();
		demandas.add(new Demanda(productos.get(1), (long) 400, fecha1));
		demandas.add(new Demanda(productos.get(2), (long) 2000, fecha1));
		demandas.add(new Demanda(productos.get(3), (long) 3000, fecha1));
		demandas.add(new Demanda(productos.get(1), (long) 3400, fecha2));
		demandas.add(new Demanda(productos.get(2), (long) 1200, fecha2));
		demandas.add(new Demanda(productos.get(3), (long) 1700, fecha2));
		demandas.add(new Demanda(productos.get(1), (long) 300, fecha3));
		demandas.add(new Demanda(productos.get(2), (long) 2000, fecha3));
		demandas.add(new Demanda(productos.get(3), (long) 3000, fecha3));
		*/
		/*
		Vector<Linea> lineas = new Vector<Linea>();
		lineas.add(l1); lineas.add(l2); lineas.add(l3);
		*/
		/*
		Linea l1 = new Linea("Linea 1");
		Linea l2 = new Linea("Linea 2");
		Linea l3 = new Linea("Linea 3");
		
		try {
			lineaDAO.save(l1);
			lineaDAO.save(l2);
			lineaDAO.save(l3);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		LineaDAO lineaDAO = new LineaDAO();
		List<Linea> lineas = lineaDAO.getList();
		
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
