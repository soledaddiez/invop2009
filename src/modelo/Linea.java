package modelo;

/**
 * Esta clase representa a una linea de la planta
 *
 */
public class Linea {
	private long id;
	private String nombre;
	
	public Linea(long id, String nombre){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getTasaDeFabricacion(String tipoProducto){
		//Reemplazar implementacion con consulta a la BD
		return 1000;
	}
}