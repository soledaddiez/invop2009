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
 * Representa la cantidad de botellas/hora que puede producir una línea para un producto dado.
 * @author Soledad Diez
 */

@Entity
@Table (name="TASA_PRODUCCION")
public class TasaProduccion {
	private Long id;
	private Long botellasPorHora;
	private Linea linea;
	private Producto producto;
	
	public TasaProduccion() {
		super();
	}
	
	public TasaProduccion(Long botellasPorHora, Linea linea, Producto producto) {
		super();
		this.botellasPorHora = botellasPorHora;
		this.linea = linea;
		this.producto = producto;
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
	
	@Column(name="botellas_hora")
	public Long getBotellasPorHora() {
		return botellasPorHora;
	}
	public void setBotellasPorHora(Long botellasPorHora) {
		this.botellasPorHora = botellasPorHora;
	}
	
	@ManyToOne(targetEntity=Linea.class, fetch=FetchType.LAZY)
	@JoinColumn(name="id_linea")
	public Linea getLinea() {
		return linea;
	}
	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	
	@ManyToOne(targetEntity=Producto.class, fetch=FetchType.LAZY)
	@JoinColumn(name="id_producto")
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
