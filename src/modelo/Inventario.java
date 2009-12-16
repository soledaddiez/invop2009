package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="INVENTARIO")
public class Inventario {
	
	private Long id;
	private Producto producto;
	private Double cantidad;

	public Inventario(Producto producto, Double cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public Inventario() {
		super();
		// TODO Auto-generated constructor stub
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
	
	@OneToOne(targetEntity=Producto.class, fetch=FetchType.LAZY)
	@JoinColumn(name="id_producto")
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	@Column(name="cantidad", nullable=false)
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
}
