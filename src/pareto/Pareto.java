package pareto;

import java.util.Vector;

public class Pareto {
	
	static public Vector<Frecuencia> calcularImportancia(Vector<modelo.Demanda> productos){
		
		//Calculo la demanda total
		double demandaTotal = 0;
		for(int i = 0; i < productos.size(); i++){
			demandaTotal += productos.elementAt(i).getCantidad();
		}

		//Calculo las frecuencias relativas
		Vector<Frecuencia> frecuencias = new Vector<Frecuencia>();
		for(int i = 0; i < productos.size(); i++){
			modelo.Demanda d = productos.elementAt(i);
			double frec = d.getCantidad() / demandaTotal; 
			frecuencias.add(new Frecuencia(d.getProducto(), frec));
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
