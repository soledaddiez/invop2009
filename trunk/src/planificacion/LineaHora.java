package planificacion;

import modelo.Linea;

public class LineaHora {
	private Linea linea;
	private double horasLibres;
	
	public LineaHora(Linea linea, Double horasLibres){
		this.linea = linea;
		this.horasLibres = horasLibres;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public double getHorasLibres() {
		return horasLibres;
	}

	public void setHorasLibres(double horasLibres) {
		this.horasLibres = horasLibres;
	}
	

}
