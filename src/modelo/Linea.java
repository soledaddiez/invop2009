package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Esta clase representa a una Línea de la Planta con capacidad de producir distintos productos
 * @autor Soledad Diez
 */

@Entity
@Table (name="LINEA")
public class Linea {
	private Long id;
	private String nombre;
	
	public Linea() {
		super();
	}
	
	public Linea(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	@Id
    @GeneratedValue
    @Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="nombre", nullable=false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}