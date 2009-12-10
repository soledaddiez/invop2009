package modelo;

import java.util.Vector;
/**
 * Esta clase representa a la planta de producción, contiene las lineas
 *
 */
public class Planta {
	static Vector<Linea> lineas = new Vector<Linea>();
	
	public static void addLinea(Linea l){
		if(l != null)
			lineas.add(l);
	}
	
	public static double getTasaDeFabricacion(Long tipoProducto){
		double tasaDeFabricacion = 0;
		
		for(int i = 0; i < lineas.size(); i++)
			tasaDeFabricacion += lineas.elementAt(i).getTasaDeFabricacion(tipoProducto);
		
		return tasaDeFabricacion;
	}
	
}
