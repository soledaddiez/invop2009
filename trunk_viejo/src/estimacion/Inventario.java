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
	public static long getInventarioPorProducto(Long tipoProducto){
		long inventario = 100; //(long) Math.abs(Math.random()*100);
		System.out.println("Inventario del producto: " + inventario);
		return inventario;
	}
}
