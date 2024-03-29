package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="PRODUCTO")
public class Producto {
	
	private Long id;
	private String nombre;
	private Formato formato;
	private Double utilidad;
	private Long loteMinimo;
	private Double inventarioSeguridad;
	
	public Producto(){
		super();
	}
	
	public Producto(String nombre, Formato formato) {
		super();
		this.nombre = nombre;
		this.formato = formato;
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

    @Column(name = "nombre", nullable=false)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@ManyToOne(targetEntity=Formato.class, fetch=FetchType.LAZY)
	@JoinColumn(name="id_formato")
	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	@Column(name="utilidad", nullable=false)
	public Double getUtilidad(){
		return utilidad; //1.0
	}
	
	public void setUtilidad(Double utilidad){
		this.utilidad = utilidad;
	}
	
	@Column(name="lote_minimo", nullable=false)
	public Long getLoteMinimo(){
		return loteMinimo; // 1000;
	}
	
	public void setLoteMinimo(Long loteMinimo){
		this.loteMinimo = loteMinimo;
	}

	@Column(name="inventario_seguridad", nullable=false)
	public Double getInventarioSeguridad() {
		return inventarioSeguridad;
	}

	public void setInventarioSeguridad(Double inventarioSeguridad) {
		this.inventarioSeguridad = inventarioSeguridad;
	}
}
