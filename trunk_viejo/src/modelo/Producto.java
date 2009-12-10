package modelo;

public class Producto {
	
	long id;
	String nombre;
	float cc;
	
	public static String PRODUCTO_AGUA_500_CC = "AGUA_500"; 
	
	public Producto(long id, String nombre, float cc) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cc = cc;
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
	public float getCc() {
		return cc;
	}
	public void setCc(float cc) {
		this.cc = cc;
	}
}
