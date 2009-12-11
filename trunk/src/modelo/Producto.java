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
	
	//TODO agregar este campo en la bd
	public Double getUtilidad(){
		return 1.0;
	}
	public void setUtilidad(Double utilidad){
		
	}
	
	//TODO agregar este campo en la bd
	public Long getLoteMinimo(){
		return (long) 1000;
	}
	public void setLoteMinimo(Long loteMinimo){
		
	}
}
