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
	private Cliente cliente;
	
	public Pedido() {
		super();
	}

	public Pedido(Producto producto, Long cantidad, Timestamp fechaOrden,Cliente cliente) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.fechaOrden = fechaOrden;
		this.cliente = cliente;
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
	
	@ManyToOne(targetEntity=Producto.class, fetch=FetchType.EAGER)
	@JoinColumn(name="id_producto", nullable=false)
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

	@ManyToOne(targetEntity=Cliente.class, fetch=FetchType.EAGER)
	@JoinColumn(name="id_cliente", nullable=false)
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
