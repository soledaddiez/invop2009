package estimacion;

import java.util.Vector;

import cosasAEliminar.ValoresASacarDeAlgunLado;

import dbConnector.DemandaManager;
import excepciones.DataAccessException;

/**
 * 
 * Clase encargada de las operaciones relacionadas con la estimación
 * de la demanda.
 */
public class ProbabilidadesDemanda {
	

	public static double calcularDemanda(Long idProducto, int diasPedido) throws DataAccessException{
		Vector<Probabilidad> probabilidades = ProbabilidadesDemanda.calcularProbabilidadesDeDemanda(idProducto);
		
		return Montecarlo.getEstimacion(probabilidades, ValoresASacarDeAlgunLado.DELTA);
	}
	
	/**
	 * Arma la tabla de probabilidades de un producto.
	 * @param idProducto
	 * @return
	 * @throws DataAccessException
	 */
	public static Vector<Probabilidad> calcularProbabilidadesDeDemanda(Long idProducto) throws DataAccessException {
		DemandaManager demandaManager = new DemandaManager();
		
		int cantidad_de_intervalos = 10;
		int cantidad_demandas_intervalo;
		
		double demanda_maxima = demandaManager.demandaMaxima(idProducto, ValoresASacarDeAlgunLado.CANTIDAD_DE_DIAS_PERIODO);
		double demanda_minima = demandaManager.demandaMinima(idProducto, ValoresASacarDeAlgunLado.CANTIDAD_DE_DIAS_PERIODO);
		
		double tamanio_intervalo = Math.ceil((demanda_maxima - demanda_minima) / cantidad_de_intervalos);
		
		Vector<Probabilidad> probabilidades = new Vector<Probabilidad>();
		Probabilidad probabilidad;
		for(int index = 0; index<cantidad_de_intervalos; index++){
			cantidad_demandas_intervalo = demandaManager.getCantidadDemandasEnIntervalo(idProducto, (demanda_minima+(tamanio_intervalo*index)), (demanda_minima+(tamanio_intervalo*(index+1))));
			// TODO preguntar a ale como toma la probabilidad
			probabilidad = new Probabilidad( (demanda_minima+(tamanio_intervalo*index)), new Double(cantidad_demandas_intervalo)/ValoresASacarDeAlgunLado.CANTIDAD_ANIOS_A_CONSIDERAR);
			
			probabilidades.add(probabilidad);
		}
		return probabilidades;
	}
}
