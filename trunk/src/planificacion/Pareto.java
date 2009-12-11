package planificacion;

import java.util.Vector;

import modelo.Pedido;

public class Pareto {
	
	static public Vector<Frecuencia> calcularImportancia(Vector<Pedido> pedidos){
		
		//Calculo la demanda total
		double demandaTotal = 0;
		for(int i = 0; i < pedidos.size(); i++){
			demandaTotal += pedidos.elementAt(i).getCantidad();
		}

		//Calculo las frecuencias relativas
		Vector<Frecuencia> frecuencias = new Vector<Frecuencia>();
		for(int i = 0; i < pedidos.size(); i++){
			Pedido p = pedidos.elementAt(i);
			double frec = p.getCantidad() / demandaTotal; 
			frecuencias.add(new Frecuencia(p, frec));
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
