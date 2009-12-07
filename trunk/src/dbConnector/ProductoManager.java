package dbConnector;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Producto;

public class ProductoManager extends Conexion{

	public ProductoManager() throws Exception {
		super();
	}

	/**
	 * Obtiene la lista de Productos existentes en el sistema
	 * @return
	 * @throws Exception
	 */
	public List<Producto> getListadoDeProductos() throws Exception {
		this.openConexion();
		List<Producto> productos = new ArrayList<Producto>();
		String query = "Select * FROM producto";
		
		if ((this.con != null)&&(this.stmt != null)){
			ResultSet rs = stmt.executeQuery(query);
			Producto producto;
			while (rs.next()){
				producto = new Producto(new Long(rs.getString("id")), rs.getString("nombre"), new Float (rs.getString("cc")));
				productos.add(producto);
			}
		}
		this.closeConexion();
		return productos;
	}

	public Producto getProductoByPrimaryKey(Long id) throws Exception{
		this.openConexion();
		Producto producto = null;
		String query = "Select * FROM producto WHERE id = "+id.toString();
		
		if ((this.con != null)&&(this.stmt != null)){
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()){
				producto = new Producto(new Long(rs.getString("id")), rs.getString("nombre"), new Float (rs.getString("cc")));
			}
		}
		this.closeConexion();
		return producto;
	}
	
	public Producto getProductoByNombre(String nombre) throws Exception{
		this.openConexion();
		Producto producto = null;
		String query = "Select * FROM producto WHERE nombre = '"+nombre+"'";
		
		if ((this.con != null)&&(this.stmt != null)){
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()){
				producto = new Producto(new Long(rs.getString("id")), rs.getString("nombre"), new Float (rs.getString("cc")));
			}
		}
		this.closeConexion();
		return producto;
	}

}
