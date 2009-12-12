package modelo;

import java.sql.Timestamp;

public class Demanda {
	Producto producto;
	Long cantidad;
	private Timestamp fecha;

	public Demanda(Producto producto, Long cantidad, Timestamp fecha){
		this.producto = producto;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	
}
