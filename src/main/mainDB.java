package main;

import java.sql.Timestamp;
import java.util.List;

import modelo.Cliente;
import modelo.Demanda;
import modelo.Pedido;
import modelo.Producto;
import dao.impl.ClienteDAO;
import dao.impl.PedidoDAO;
import dao.impl.ProductoDAO;

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
        
        PedidoDAO pedido = new PedidoDAO();
        List<Pedido> pedidos = pedido.getPedidosDesdeFecha(new Timestamp(109, 2, 20, 0, 0, 0, 0)); //20/03/2009
        for(Pedido p : pedidos)
        	System.out.println("Pedido ID "+p.getId()+" -> '"+p.getFechaOrden().toString()+"'");
        
//        List<Demanda> demandas = pedido.getDemandas(new Timestamp(109, 2, 20, 0, 0, 0, 0));//20/03/2009
//        for(Demanda d : demandas)
//        	System.out.println("Demanda ID producto "+d.getProducto().getId()+" -> '"+d.getFecha().toString()+"' / Cantidad: "+d.getCantidad());
 
        ClienteDAO clienteDAO = new ClienteDAO();
//        Cliente cliente = clienteDAO.load(new Long(1));
//        
//       Producto producto = productoDAO.load(new Long(1));
        
//        System.out.println("El total es: "+pedido.getPedidoTotal(cliente, producto, new Timestamp(109, 0, 1, 0, 0, 0, 0)));
        
    }
}
