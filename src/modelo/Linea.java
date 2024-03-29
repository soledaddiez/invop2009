package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Esta clase representa a una L�nea de la Planta con capacidad de producir distintos productos
 * @autor Soledad Diez
 */

@Entity
@Table (name="LINEA")
public class Linea {
	private Long id;
	private String nombre;
	private Formato ultimoFormato;
	
	public Linea() {
		super();
	}
	
	public Linea(String nombre) {
		super();
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

	@ManyToOne(targetEntity=Formato.class, fetch=FetchType.LAZY)
	@JoinColumn(name="id_ultimo_formato")
	public Formato getUltimoFormato() {
		return ultimoFormato;
	}

	public void setUltimoFormato(Formato ultimoFormato) {
		this.ultimoFormato = ultimoFormato;
	}
}