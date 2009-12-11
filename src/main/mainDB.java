package main;

import java.util.List;

import modelo.Producto;
import dao.impl.ProductoDAO;
import excepciones.DataAccessException;

public class mainDB {
    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();
     
        Producto prod = new Producto();
        prod.setNombre("Agua");
        prod.setCc(new Long(500));
        try {
			productoDAO.save(prod);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Producto> productos = productoDAO.getList();
		
		for(Producto p : productos){
			System.out.println("Producto: "+p.getNombre());
		}
    }
}
