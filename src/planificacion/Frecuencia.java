package planificacion;

import modelo.Pedido;

public class Frecuencia {
	
	private Pedido pedido;
	private double frecuencia;
	
	public Frecuencia(Pedido pedido, double frecuencia){
		this.pedido = pedido;
		this.frecuencia = frecuencia;
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public double getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}
	
}
