package dao;

import modelo.Producto;

/**
 * Interface que define los métodos para manejo de Productos 
 * @author Soledad Diez
 */

public interface ProductoDAO {
	/**
	 * Almacena un Producto.
	 * Si no existe el registro, lo crea (save). Si existe, lo actualiza (update).
	 * @param producto
	 */
	public void save(Producto producto);
	
	/**
	 * Obtiene el listado completo de Productos existentes.
	 * @return List<Producto>
	 */
//	public List<Producto> getAll();
}
