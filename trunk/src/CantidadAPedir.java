import modelo.OrdenProduccion;
import modelo.Planta;
import estimacion.Inventario;
import estimacion.ProbabilidadesDemanda;
import excepciones.DataAccessException;


/**
 * 
 * Calcula la cantidad a pedir por producto (Qp)
 *
 */
public class CantidadAPedir {
	
	static public OrdenProduccion calcularCantidadAPedir(Long tipoProducto, int diasDelPeriodo) throws DataAccessException{

		double costoLanzamientoProduccion = 100;
		double costoAlmacenamiento = 0.5;
		
		//Obtengo la demanda estimada en el período para el producto
		double demandaPorDia = ProbabilidadesDemanda.calcularDemanda(tipoProducto, diasDelPeriodo);
		double demanda = demandaPorDia * diasDelPeriodo;
		
		//Obtengo la tasa de fabricación en todo el período para el producto
		double tasaFabricacionPorDia = Planta.getTasaDeFabricacion(tipoProducto);
		double tasaFabricacion = tasaFabricacionPorDia * diasDelPeriodo;
		
		//Obtengo el inventario
		long inventario = Inventario.getInventarioPorProducto(tipoProducto);
		
		long loteOptimo = LoteOptimo.calcularLoteOptimo(demanda, tasaFabricacion, inventario, costoLanzamientoProduccion, costoAlmacenamiento);
		
		long cantidadPedidos = (long) Math.ceil((demanda - inventario) / loteOptimo);

		//Impresiones para testeo
		/*System.out.println("Días del período: "+ diasDelPeriodo);
		System.out.println("Demanda estimada en el período: "+ demanda);
		System.out.println("Tasa de fabricación del producto: " + tasaFabricacion);
		System.out.println("Fabricar "+ cantidadPedidos + " lotes de "+ loteOptimo);*/
		
		return new OrdenProduccion(cantidadPedidos, loteOptimo);
	}
}
