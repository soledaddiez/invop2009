

import java.util.List;

import modelo.Pedido;
import modelo.Producto;
import dbConnector.PedidoManager;
import dbConnector.ProductoManager;

public class Main {

	public static void main(String[] args) {
		CantidadAPedir cantidadAPedir = new CantidadAPedir();
		
		System.out.println(cantidadAPedir.calcularCantidadAPedir(Producto.PRODUCTO_AGUA_500_CC, 5) + " botellas");
		
		ProductoManager conn;
		try {
			conn = new ProductoManager();
			List<Producto> productos = conn.getListadoDeProductos();
			
			for (Producto producto : productos) {
				System.out.println("ID "+producto.getId()+"\tNombre: "+producto.getNombre());
				System.out.println("\tCapacidad: "+producto.getCc());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PedidoManager pm = new PedidoManager();
		Pedido pedido = new Pedido();
		pedido.setId(3);
		try {
			pm.savePedido(pedido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
