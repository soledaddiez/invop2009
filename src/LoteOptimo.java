import estimacion.Demanda;
import estimacion.TasaDeFabricacion;

/**
 * 
 * Calculos y funciones relacionadas con el cálculo del Lote Óptimo
 *
 */
public class LoteOptimo {

	float costoLanzamientoProduccion; //igual para todos los productos (c2)
	float costoAlmacenamiento; //TODO ver como se calcula (c3)
	
	public LoteOptimo(float costoLanzamientoProduccion, float costoAlmacenamiento){
		this.costoLanzamientoProduccion = costoLanzamientoProduccion;
		this.costoAlmacenamiento = costoAlmacenamiento;
	}
	
	/**
	 *  Calcula el lote óptimo a pedir
	 * @param tipoProducto
	 * @param diasDelPeriodo
	 * @return
	 */
	public double calcularLoteOptimo(String tipoProducto, int diasDelPeriodo){
		double demanda = Demanda.calcularDemanda(tipoProducto, diasDelPeriodo);
		
		//primera parte de la formula: (2*c2*D)
		double dividendo = 2 * costoLanzamientoProduccion * demanda;
		//segunda parte de la formula: (c3*(I - D/R))
		double divisor = costoAlmacenamiento * (200-(demanda / TasaDeFabricacion.getTasaDeFabricacion(tipoProducto)));
		//calculo final
		double q = Math.sqrt(dividendo/divisor);
		System.out.println("Q = "+q);
		return q;
	}
	
}
