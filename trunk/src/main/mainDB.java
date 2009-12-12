package main;

import java.util.List;

import modelo.Linea;
import modelo.Producto;
import modelo.TasaProduccion;
import dao.impl.LineaDAO;
import dao.impl.ProductoDAO;
import dao.impl.TasaProduccionDAO;
import excepciones.DataAccessException;

public class mainDB {
    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();

        List<Producto> productos = productoDAO.getList();
        for(Producto p : productos)
        	System.out.println("Producto ID "+p.getId()+" -> '"+p.getNombre()+"'");
        
//        Producto prod = new Producto();
//        prod.setNombre("Agua");
//        prod.setCc(new Long(500));
//        prod.setLoteMinimo(new Long(1000));
//        prod.setUtilidad(new Double(1.0));
//        try {
//			productoDAO.save(prod);
//		} catch (DataAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		LineaDAO lineaDAO = new LineaDAO();
//		Linea linea = new Linea(new Long(1), "Linea 1");
//		try {
//			lineaDAO.save(linea);
//		} catch (DataAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		TasaProduccionDAO tasaProduccionDAO = new TasaProduccionDAO();
//		
//		TasaProduccion tasaProd = new TasaProduccion(new Long(1), new Long(500), lineaDAO.load(new Long(2)), productoDAO.load(new Long(1)));
//		try {
//			tasaProduccionDAO.save(tasaProd);
//		} catch (DataAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		TasaProduccion tp = tasaProduccionDAO.getTasaProduccion(lineaDAO.load(new Long(2)), productoDAO.load(new Long(1)));
//		System.out.println(tp.getBotellasPorHora());
    }
}
