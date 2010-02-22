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
@Table (name="FORMATO")
public class Formato {
	private Long id;
	private String nombre;
	private Long Capacidad;
	
	public Formato() {
		super();
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
	
	@Column (name="capacidad")
	public Long getCapacidad() {
		return Capacidad;
	}

	public void setCapacidad(Long capacidad) {
		Capacidad = capacidad;
	}
}