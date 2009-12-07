
/**
 * 
 * Calculos y funciones relacionadas con el cálculo del Lote Óptimo
 *
 */
public class LoteOptimo {

	/**
	 *  Calcula el lote óptimo a pedir
	 * @param tipoProducto
	 * @param diasDelPeriodo
	 * @return
	 */
	static public long calcularLoteOptimo(double demanda, double tasaFabricacion, long inventario, double costoLanzamientoProduccion, double costoAlmacenamiento){
		
		//primera parte de la formula: (2*c2*D)
		double dividendo = 2 * costoLanzamientoProduccion * demanda;
		//segunda parte de la formula: (c3*(I - D/R))
		double divisor = costoAlmacenamiento * ( inventario - demanda / tasaFabricacion );
		//calculo final
		long q = Math.round(Math.sqrt(dividendo / divisor));
		System.out.println("Q = "+q);
		return q;
	}
	
}
