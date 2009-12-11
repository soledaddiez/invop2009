package main;

import modelo.Producto;
import dao.ProductoDAO;
import dao.impl.ProductoDAOImpl;

public class mainDB {
    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAOImpl();
     
        Producto prod = new Producto();
        prod.setNombre("Agua");
        prod.setCc(new Long(500));
        productoDAO.save(prod);
    }
}
