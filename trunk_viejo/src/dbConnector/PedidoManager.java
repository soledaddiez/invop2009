package dbConnector;

import modelo.Pedido;

public class PedidoManager extends Conexion {
	
	public void savePedido(Pedido pedido) throws Exception {
		String query = "INSERT INTO pedido (id) VALUES (";
		query += pedido.getId();
		query += ")";
		
		this.openConexion();
		stmt.executeUpdate(query);
		this.closeConexion();
	}

}
