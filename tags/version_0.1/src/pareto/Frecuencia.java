package pareto;

import modelo.Producto;

public class Frecuencia {
	
	private Producto producto;
	private double frecuencia;
	
	public Frecuencia(Producto producto, double frecuencia){
		this.producto = producto;
		this.frecuencia = frecuencia;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}
	
}
