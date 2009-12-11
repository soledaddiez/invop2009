package dao.impl;

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
	 */
	public TasaProduccion getTasaProduccion(Linea linea, Producto producto){
		//TODO Este método tendría que recuperar de la bd la TasaProduccion
		return new TasaProduccion(new Long(1), new Long (5000), linea, producto) ;
	}
	
}
