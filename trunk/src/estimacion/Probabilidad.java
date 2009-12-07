package estimacion;

/**
 *	Esta clase representa una probabilidad para un valor determinado
 */
public class Probabilidad {
	private double valor;
	private double probabilidad;
	
	public Probabilidad(double valor, double probabilidad){
		this.valor = valor;
		this.probabilidad = probabilidad;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public double getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(double probabilidad) {
		this.probabilidad = probabilidad;
	}
	
}
