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
public class Demanda {
	
	public double calcularDemanda(){
		double resultado=0;
		return resultado;
	}
	
	/**
	 * Obtiene la estimacion de la demanda para un tipo de producto en la
	 * cantidad de dias indicados a partir de la fecha actual.
	 * @param tipoProducto
	 * @param diasDelPeriodo
	 * @return demanda estimada
	 */
	public static double calcularDemanda(String tipoProducto, int diasDelPeriodo){
		double demanda=400;
		System.out.println("Demanda estimada: " + demanda);
		return demanda;
	}
	
	public static double calcularDemandaMaxima(String tipoProducto, int diasDelPeriodo){
		double demandaMaxima=400;//Math.abs(Math.random()*200 + 200);
		System.out.println("Demanda máxima: " + demandaMaxima);
		return demandaMaxima;
	}
	
	public static Vector<Probabilidad> calcularProbabilidadesDeDemanda(Long idProducto) throws DataAccessException {
		DemandaManager demandaManager = new DemandaManager();
		
		double maxima_demanda = demandaManager.demandaMaxima(idProducto, ValoresASacarDeAlgunLado.CANTIDAD_DE_DIAS_PERIODO);
		double minima_demanda = demandaManager.demandaMinima(idProducto, ValoresASacarDeAlgunLado.CANTIDAD_DE_DIAS_PERIODO);
		
		return null;
		
	}
}
