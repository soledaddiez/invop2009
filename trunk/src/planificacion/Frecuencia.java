package planificacion;

import modelo.Demanda;

public class Frecuencia {
	
	private Demanda demanda;
	private double frecuencia;
	
	public Frecuencia(Demanda pedido, double frecuencia){
		this.demanda = pedido;
		this.frecuencia = frecuencia;
	}
	
	public Demanda getDemanda() {
		return demanda;
	}

	public void setDemanda(Demanda demanda) {
		this.demanda = demanda;
	}

	public double getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}
	
}
