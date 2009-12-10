
import java.util.Vector;

import estimacion.Demanda;
import estimacion.Probabilidad;
import excepciones.DataAccessException;

public class Main {

	public static void main(String[] args) throws DataAccessException {
		
		Vector<Probabilidad> prob = Demanda.calcularProbabilidadesDeDemanda(new Long(1));
		
		for (int i = 0; i<prob.size(); i++){
			System.out.println(((Probabilidad)prob.get(i)).getValor() + " - " + ((Probabilidad)prob.get(i)).getProbabilidad());
		}	
	}
}
