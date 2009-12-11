package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Representa la necesidad de producción de una cantidad de un producto determinado. 
 * @author Soledad Diez
 */

@Entity
@Table (name="ORDEN_PRODUCCION")
public class OrdenProduccion {
	private Long id;
	private Producto producto;
	private Long cantidadAProducir;
	private Double tiempoEstimado;
	
	public OrdenProduccion() {
		super();
	}

	public OrdenProduccion(Long id, Producto producto, Long cantidadAProducir, Double tiempoEstimado) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidadAProducir = cantidadAProducir;
		this.tiempoEstimado = tiempoEstimado;
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

	@Column(name="cantidad_a_producir")
	public Long getCantidadAProducir() {
		return cantidadAProducir;
	}

	public void setCantidadAProducir(Long cantidadAProducir) {
		this.cantidadAProducir = cantidadAProducir;
	}

	@Column(name="tiempo_estimado")
	public Double getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(Double tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}	
}
