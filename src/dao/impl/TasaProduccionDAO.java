package dao.impl;

import java.util.Hashtable;
import java.util.List;

import dao.GenericDAO;
import modelo.Linea;
import modelo.Producto;
import modelo.TasaProduccion;

public class TasaProduccionDAO extends GenericDAO<TasaProduccion>{
	
	/**
	 * Obtiene la tasa de produccion de una linea para un producto dado.
	 * @param linea
	 * @param producto
	 * @return Tasa de Produccion
	 * @author Soledad Diez
	 * @return 
	 */
	public TasaProduccion getTasaProduccion(Linea linea, Producto producto){
		Hashtable<String, Object> criteria = new Hashtable<String, Object>();
		criteria.put("linea", linea);
		criteria.put("producto", producto);
		
		List<TasaProduccion> tasaProd = this.findByCriteria(criteria);
		
		if ((tasaProd != null) &&(tasaProd.size()>0))
			return tasaProd.get(0);
//		return null;
		//TODO (ELIMINAR)Lo dejo de prueba mientras no esten los valores reales en la base de la tasa de produccion
		return new TasaProduccion(new Long (5000), linea, producto) ;
	}
	
}
