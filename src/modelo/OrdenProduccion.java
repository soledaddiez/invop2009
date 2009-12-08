package modelo;

public class OrdenProduccion {
	private long lotes;
	private double cantidadPorLote;
	
	public OrdenProduccion(long lotes, double cantidadPorLote){
		this.lotes = lotes;
		this.cantidadPorLote = cantidadPorLote;
	}

	public long getLotes() {
		return lotes;
	}

	public void setLotes(long lotes) {
		this.lotes = lotes;
	}

	public double getCantidadPorLote() {
		return cantidadPorLote;
	}

	public void setCantidadPorLote(double cantidadPorLote) {
		this.cantidadPorLote = cantidadPorLote;
	}
	
}
