package modelo;

public class OrdenProduccion {
	private Long tipoProducto;
	private long lotes;
	private double cantidadPorLote;
	
	public OrdenProduccion(Long tipoProducto, long lotes, double cantidadPorLote){
		this.lotes = lotes;
		this.cantidadPorLote = cantidadPorLote;
	}

	public Long getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(Long tipoProducto) {
		this.tipoProducto = tipoProducto;
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
