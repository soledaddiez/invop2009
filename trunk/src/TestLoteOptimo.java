import java.util.Vector;

import modelo.Demanda;
import modelo.Linea;
import modelo.Planta;
import pareto.Frecuencia;
import pareto.Pareto;
import dbConnector.DemandaManager;
import excepciones.DataAccessException;

public class TestLoteOptimo{
	public static void main(String [] args) throws DataAccessException{
		Linea l1 = new Linea(1, "Linea 1");
		Linea l2 = new Linea(2, "Linea 2");
		Linea l3 = new Linea(3, "Linea 3");
		Planta.addLinea(l1);
		Planta.addLinea(l2);
		Planta.addLinea(l3);
		
		/*
		int diasDelPeriodo = 1;
		OrdenProduccion orden = CantidadAPedir.calcularCantidadAPedir(Producto.PRODUCTO_AGUA_500_CC, diasDelPeriodo);
		System.out.println(orden.getLotes() + " de " + orden.getCantidadPorLote() + " unidades cada uno");
		*/
		
		DemandaManager demandaManager = new DemandaManager();
		Vector<Demanda> demandas = demandaManager.getDemandasTotalesPorProducto();
		
		Vector<Frecuencia> importancias = Pareto.calcularImportancia(demandas);

		for(int i = 0; i < importancias.size(); i++){
			Frecuencia f = importancias.elementAt(i);
			System.out.println("Importancia del prod "+f.getProducto().getNombre()+": "+f.getFrecuencia());
		}
		
	}
}
