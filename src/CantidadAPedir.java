import estimacion.Demanda;
import estimacion.Inventario;


/**
 * 
 * Calcula la cantidad a pedir por producto (Qp)
 *
 */
public class CantidadAPedir {

	public double calcularCantidadAPedir(String tipoProducto, int diasDelPeriodo){
		float costoLanzamientoProduccion = 10;
		float costoAlmacenamiento = 2;
		LoteOptimo q = new LoteOptimo(costoLanzamientoProduccion, costoAlmacenamiento);
		
		double cantidadAPedir = q.calcularLoteOptimo(tipoProducto, diasDelPeriodo);
		cantidadAPedir += Demanda.calcularDemandaMaxima(tipoProducto, diasDelPeriodo);
		cantidadAPedir -= 200;//Inventario.getInventarioPorProducto(tipoProducto);
		cantidadAPedir -= Demanda.calcularDemanda(tipoProducto, diasDelPeriodo);
		
		return cantidadAPedir;
	}
}
