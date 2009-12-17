package planificacion;

import modelo.Producto;

public class RangoDemanda {
	private Producto producto;
	private Long minDemanda;
	private Long maxDemanda;
	
	public RangoDemanda(Producto producto, Long minDemanda, Long maxDemanda){
		this.producto = producto;
		this.minDemanda = minDemanda;
		this.maxDemanda = maxDemanda;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Long getMinDemanda() {
		return minDemanda;
	}

	public void setMinDemanda(Long minDemanda) {
		this.minDemanda = minDemanda;
	}

	public Long getMaxDemanda() {
		return maxDemanda;
	}

	public void setMaxDemanda(Long maxDemanda) {
		this.maxDemanda = maxDemanda;
	}
	
}
