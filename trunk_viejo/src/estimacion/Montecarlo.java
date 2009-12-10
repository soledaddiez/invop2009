package estimacion;

import java.util.Vector;

/**
 * 
 * Clase encargada de hacer la simulación de Montecarlo
 */
public class Montecarlo {
	static int MIN_CICLOS = 1000;
	
	/**
	 * Determina si dos valores convergen para una determinada diferencia delta
	 * @param a
	 * @param b
	 * @param delta
	 * @return converge o no converge  
	 */
	static boolean converge(double a, double b, double delta){
		if(Math.abs(a-b) <= delta)
			return true;
		else
			return false;
	}
	
	/**
	 *	Calcula las probabilidades acumuladas para un vector de probabilidades
	 * @param probabilidades
	 * @return vector de probabilidades acumuladas  
	 */
	static Vector<Probabilidad> getProbabilidadAcumulada(Vector<Probabilidad> probabilidades){
		Vector<Probabilidad> acumuladas = new Vector<Probabilidad>();
		double parcial = 0.0;
		for(int i = 0; i < probabilidades.size(); i++){
			parcial += probabilidades.elementAt(i).getProbabilidad();
			double valor = probabilidades.elementAt(i).getValor();
			acumuladas.add(new Probabilidad(valor, parcial));
		}
		return acumuladas; 
	}
	
	/**
	 *	Calcula un valor aleatorio en base a un vector de probabilidades acumuladas
	 * @param probabilidades
	 * @return valor aleatorio  
	 */
	static double getValorAleatorio(Vector<Probabilidad> probabilidades){
		Vector<Probabilidad> acumuladas = getProbabilidadAcumulada(probabilidades);
		double rand = Math.random();
		for(int i = 0; i < acumuladas.size(); i++)
			if(rand < acumuladas.elementAt(i).getProbabilidad())
				return acumuladas.elementAt(i).getValor();
		return 0;
	}
	
	/**
	 *	Calcula una estimación de acuerdo a un vector de probabilidades
	 * @param probabilidades
	 * @return estimación  
	 */
	static double getEstimacion(Vector<Probabilidad> probabilidades, double delta){
		int suma = 0;
		int ciclos = 0;
		double media_anterior = 0;
		double media_actual = 0;
		double valor = 0;

		while(!converge(media_anterior, media_actual, delta) || ciclos < MIN_CICLOS){
			ciclos++;
			valor = getValorAleatorio(probabilidades);
			suma += valor;
			media_anterior = media_actual;
			media_actual = suma / ciclos;
		}
		
		return media_actual;
	}
}