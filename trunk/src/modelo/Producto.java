package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="PRODUCTO")
public class Producto {
	
	private Long id;
	private String nombre;
	private Long cc;
	private Double utilidad;
	private Long loteMinimo;
	
	public Producto(){
		super();
	}
	
	public Producto(Long id, String nombre, Long cc) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cc = cc;
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
	
    @Column(name = "cc")
	public Long getCc() {
		return cc;
	}
	public void setCc(Long cc) {
		this.cc = cc;
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
}
