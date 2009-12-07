import estimacion.Demanda;
import estimacion.Inventario;
import estimacion.TasaDeFabricacion;


/**
 * 
 * Calcula la cantidad a pedir por producto (Qp)
 *
 */
public class CantidadAPedir {
	
	static public double calcularCantidadAPedir(String tipoProducto, int diasDelPeriodo){

		double costoLanzamientoProduccion = 100;
		double costoAlmacenamiento = 0.5;
		
		//Obtengo la demanda estimada en el per�odo para el producto
		double demandaPorDia = Demanda.calcularDemanda(tipoProducto, diasDelPeriodo);
		double demanda = demandaPorDia * diasDelPeriodo;
		
		//Obtengo la tasa de fabricaci�n en todo el per�odo para el producto
		double tasaFabricacionPorDia = TasaDeFabricacion.getTasaDeFabricacion(tipoProducto);
		double tasaFabricacion = tasaFabricacionPorDia * diasDelPeriodo;
		
		//Obtengo el inventario
		long inventario = Inventario.getInventarioPorProducto(tipoProducto);
		
		long loteOptimo = LoteOptimo.calcularLoteOptimo(demanda, tasaFabricacion, inventario, costoLanzamientoProduccion, costoAlmacenamiento);
		
		long cantidadPedidos = (long) Math.ceil((demanda - inventario) / loteOptimo);

		double cantidadAPedir = cantidadPedidos * loteOptimo;

		//Impresiones para testeo
		System.out.println("D�as del per�odo: "+ diasDelPeriodo);
		System.out.println("Demanda estimada en el per�odo: "+ demanda);
		System.out.println("Tasa de fabricaci�n del producto: " + tasaFabricacion);
		System.out.println("Fabricar "+ cantidadPedidos + " lotes de "+ loteOptimo);

		return cantidadAPedir;
	}
}
