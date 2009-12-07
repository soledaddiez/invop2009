import gui.PedidosPanel;
import gui.VerDemanda;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

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
		
//		PedidoManager pm = new PedidoManager();
//		Pedido pedido = new Pedido();
//		pedido.setId(3);
//		try {
//			pm.savePedido(pedido);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	//Este METODO mail llama a la GUI...
//	public static void main(String[] args){
//		try {
//			ProductoManager productoManager = new ProductoManager();
//			
//			JFrame frame = new JFrame();
//			PedidosPanel pedidos = new PedidosPanel(productoManager.getListadoDeProductos());
//			JTabbedPane principal = new JTabbedPane();
//			principal.addTab("Nuevo Pedido", pedidos);
//			principal.setTabPlacement(JTabbedPane.LEFT);
//			double valores[] = {10,2,3,4,5,6,7,8,9,10,11,12};
//			String meses[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
//			principal.addTab("Demanda", new VerDemanda(valores, meses, "Demanda anual"));
//			frame.setPreferredSize(new Dimension(600, 500));
//			frame.setContentPane(principal);
//			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//			frame.pack();
//			frame.setVisible(true);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	
//	}
}
