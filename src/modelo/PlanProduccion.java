package modelo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Representación de un Plan de Producción constituido. 
 * Consta de un conjunto de asignaciones de ordenes de producción a líneas disponibles
 * @author Soledad Diez
 */

@Entity
@Table (name="PLAN_PRODUCCION")
public class PlanProduccion {
	private Long id;
	private List<AsignacionProduccion> asignaciones;
	private Timestamp fechaInicio;

	public PlanProduccion() {
		super();
	}

	public PlanProduccion(Long id, List<AsignacionProduccion> asignaciones, Timestamp fechaInicio) {
		super();
		this.id = id;
		this.asignaciones = asignaciones;
		this.fechaInicio = fechaInicio;
	}

	@Id
    @GeneratedValue
    @Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(mappedBy="planProduccion", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public List<AsignacionProduccion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<AsignacionProduccion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	@Column(name="fecha_inicio")
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
}
