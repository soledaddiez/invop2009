package modelo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Representa, dada una orden de producción, su asignación a una linea para su producción. 
 * @author Soledad Diez
 */

@Entity
@Table (name="ASIGNACION_PRODUCCION")
public class AsignacionProduccion {
	private Long id;
	private Linea linea;
	private OrdenProduccion ordenProduccion;
	private Timestamp fechaAsignacion;
	private PlanProduccion planProduccion;

	public AsignacionProduccion() {
		super();
	}

	public AsignacionProduccion(Linea linea, OrdenProduccion ordenProduccion) {
		super();
		this.linea = linea;
		this.ordenProduccion = ordenProduccion;
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

	@ManyToOne(targetEntity=Linea.class, fetch=FetchType.EAGER)
	@JoinColumn(name="id_linea")
	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	@OneToOne(targetEntity=OrdenProduccion.class, fetch=FetchType.EAGER)
	@JoinColumn(name="id_orden_produccion")
	public OrdenProduccion getOrdenProduccion() {
		return ordenProduccion;
	}

	public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}

	@Column(name="fecha_asignacion")
	public Timestamp getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Timestamp fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	@ManyToOne(targetEntity=PlanProduccion.class, fetch=FetchType.LAZY)
	@JoinColumn(name="id_plan_produccion")
	public PlanProduccion getPlanProduccion() {
		return planProduccion;
	}

	public void setPlanProduccion(PlanProduccion planProduccion) {
		this.planProduccion = planProduccion;
	}		
}
