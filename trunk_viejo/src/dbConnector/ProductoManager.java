package dbConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import excepciones.DataAccessException;

import modelo.Producto;

public class ProductoManager extends Conexion{

	public ProductoManager(){
		super();
	}

	/**
	 * Obtiene la lista de Productos existentes en el sistema
	 * @return
	 * @throws Exception
	 */
	public List<Producto> getListadoDeProductos() throws DataAccessException {
		this.openConexion();
		List<Producto> productos = new ArrayList<Producto>();
		String query = "Select * FROM producto";
		try{
			if ((this.con != null)&&(this.stmt != null)){
				ResultSet rs = stmt.executeQuery(query);
				Producto producto;
				while (rs.next()){
					producto = new Producto(new Long(rs.getString("id")), rs.getString("nombre"), new Float (rs.getString("cc")));
					productos.add(producto);
				}
			}
			this.closeConexion();
		} catch (SQLException e){
			e.printStackTrace();
			throw new DataAccessException(DataAccessException.ERROR_EJECUCION_CONSULTA);
		}
		return productos;
	}

	public Producto getProductoByPrimaryKey(Long id) throws DataAccessException{
		this.openConexion();
		Producto producto = null;
		String query = "Select * FROM producto WHERE id = "+id.toString();	
		try {
			if ((this.con != null)&&(this.stmt != null)){
				ResultSet rs;
				rs = stmt.executeQuery(query);
				if (rs.next()){
					producto = new Producto(new Long(rs.getString("id")), rs.getString("nombre"), new Float (rs.getString("cc")));
				}
				this.closeConexion();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(DataAccessException.ERROR_EJECUCION_CONSULTA);
		}
		return producto;
	}
	
	public Producto getProductoByNombre(String nombre) throws DataAccessException{
		this.openConexion();
		Producto producto = null;
		String query = "Select * FROM producto WHERE nombre = '"+nombre+"'";

		try {
			if ((this.con != null)&&(this.stmt != null)){
				ResultSet rs;
				rs = stmt.executeQuery(query);
				if (rs.next()){
					producto = new Producto(new Long(rs.getString("id")), rs.getString("nombre"), new Float (rs.getString("cc")));
				}
			}
			this.closeConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(DataAccessException.ERROR_EJECUCION_CONSULTA);
		}
		return producto;
	}
}
