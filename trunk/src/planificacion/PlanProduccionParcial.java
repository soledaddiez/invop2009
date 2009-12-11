package planificacion;

import java.util.Vector;

import modelo.AsignacionProduccion;
import modelo.Linea;
import modelo.OrdenProduccion;

public class PlanProduccionParcial {

	private Vector<AsignacionProduccion> asignaciones;
	private Long idAsignacion;

	public PlanProduccionParcial(Long idAsignacion) {
		asignaciones = new Vector<AsignacionProduccion>();
		this.idAsignacion = idAsignacion;
	}

	public Vector<AsignacionProduccion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(Vector<AsignacionProduccion> asignaciones) {
		this.asignaciones = asignaciones;
	}
	
	public void addAsignacion(Linea linea, OrdenProduccion orden){
		AsignacionProduccion asignacion = new AsignacionProduccion(idAsignacion, linea, orden);
		this.asignaciones.add(asignacion);
		idAsignacion++;
	}
	
	public Double getHorasOcupadas(Linea linea){
		Double horas = 0.0;
		for (int i = 0; i < asignaciones.size(); i++) {
			AsignacionProduccion a = asignaciones.elementAt(i);
			if(a.getLinea().equals(linea)){
				horas += a.getOrdenProduccion().getTiempoEstimado(); 
			}
		}
		return horas;
	}

}
