package dao.impl;

import java.util.Hashtable;
import java.util.List;

import modelo.Inventario;
import modelo.Producto;
import dao.GenericDAO;


public class InventarioDAO extends GenericDAO<Inventario>{
	
	/**
	 * Obtiene el Inventario relacionado al producto dado. 
	 * @param producto
	 * @return
	 */
	public Inventario getInventarioPorProducto(Producto producto){
		Hashtable<String, Object> criteria = new Hashtable<String, Object>();
		criteria.put("producto", producto);
		
		List<Inventario> inventario = this.findByCriteria(criteria);
		
		if ((inventario != null) &&(inventario.size()>0))
			return inventario.get(0);
		return null;
	}
}
