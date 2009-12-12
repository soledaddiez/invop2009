package planificacion;

import java.util.List;
import java.util.Vector;

import modelo.Demanda;

public class Pareto {
	
	static public Vector<Frecuencia> calcularImportancia(List<Demanda> demandas){
		
		//Calculo la demanda total
		double valorTotal = 0;
		for(int i = 0; i < demandas.size(); i++){
			Demanda d = demandas.get(i);
			valorTotal += d.getCantidad() * d.getProducto().getUtilidad();
		}

		//Calculo las frecuencias relativas
		Vector<Frecuencia> frecuencias = new Vector<Frecuencia>();
		for(int i = 0; i < demandas.size(); i++){
			Demanda d = demandas.get(i);
			double frec = (d.getCantidad() * d.getProducto().getUtilidad()) / valorTotal; 
			frecuencias.add(new Frecuencia(d, frec));
		}
		
		int limit = 0;
		//Ordeno las frecuencias relativas de forma descendente
		for(int i = 0; i < frecuencias.size(); i++){
			double maxFrec = -1;
			int mi = 0;
			for(int j = limit; j < frecuencias.size(); j++){
				Frecuencia f = frecuencias.elementAt(j);
				if(maxFrec < f.getFrecuencia()){
					maxFrec = f.getFrecuencia();
					mi = j;
				}
			}
			frecuencias.add(limit, frecuencias.remove(mi));
			limit++;
		}
		
		//Calculo las frecuencias absolutas
		for(int i = 0; i < frecuencias.size(); i++){
			Frecuencia f = frecuencias.elementAt(i);
			double anterior = 0;
			if(i > 0 && i < frecuencias.size()-1)
				anterior = frecuencias.elementAt(i - 1).getFrecuencia();
			if(i == frecuencias.size()-1)		
				f.setFrecuencia(1.0);
			else
				f.setFrecuencia(anterior + f.getFrecuencia());
		}
		return frecuencias;
	}
	
}
