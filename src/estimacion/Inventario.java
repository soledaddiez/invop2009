package estimacion;

/**
 * 
 * Manejo del Inventario existente
 *
 */
public class Inventario {

	/**
	 * Obtiene el inventario existente para el tipo de producto dado 
	 * @param tipoProducto
	 * @return
	 */
	public static long getInventarioPorProducto(String tipoProducto){
		long inventario = (long) Math.abs(Math.random()*300);
		System.out.println("Inventario: " + inventario);
		return inventario;
	}
}
