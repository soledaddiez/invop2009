package modelo;

import java.util.HashMap;
import java.util.Vector;

public class PlanProduccion {
	private HashMap<Long, Vector<OrdenProduccion>> produccion;
	
	public PlanProduccion(){
		produccion = new HashMap<Long, Vector<OrdenProduccion>>();
	}
	
	public void addOrden(Long linea, OrdenProduccion orden){
		if(produccion.get(linea) == null)
			produccion.put(linea, new Vector<OrdenProduccion>());
		produccion.get(linea).add(orden);
	}
	
	public Vector<OrdenProduccion> getPlan(Long linea){
		return produccion.get(linea);
	}
}
