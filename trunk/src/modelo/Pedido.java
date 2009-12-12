package modelo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Representa un pedido recibido para un producto en una cantidad indicada.
 * @author Soledad Diez
 */

@Entity
@Table (name="PEDIDO")
public class Pedido {
	
	private Long id;
	private Producto producto;
	private Long cantidad;
	private Timestamp fechaOrden;
	
	public Pedido() {
		super();
	}

	public Pedido(Long id, Producto producto, Long cantidad, Timestamp fechaOrden) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.fechaOrden = fechaOrden;
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
	
	@ManyToOne(targetEntity=Producto.class, fetch=FetchType.LAZY)
	@JoinColumn(name="id_producto")
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	@Column(name = "cantidad", nullable=false)
    public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	
	@Column(name = "fecha_orden", nullable=false)
	public Timestamp getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(Timestamp fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
}