import java.awt.Image;
import java.util.Vector;

import pareto.Frecuencia;
import pareto.Pareto;

import modelo.Linea;
import modelo.OrdenProduccion;
import modelo.Planta;
import modelo.Producto;

public class TestLoteOptimo{
	public static void main(String [] args){
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
		Vector<modelo.Demanda> demandas = new Vector<modelo.Demanda>();
		Producto p1 = new Producto(1, "Producto 1", 100);
		Producto p2 = new Producto(2, "Producto 2", 200);
		Producto p3 = new Producto(3, "Producto 3", 300);
		demandas.add(new modelo.Demanda(p1, 130));
		demandas.add(new modelo.Demanda(p2, 250));
		demandas.add(new modelo.Demanda(p3, 200));
		
		Vector<Frecuencia> importancias = Pareto.calcularImportancia(demandas);

		for(int i = 0; i < importancias.size(); i++){
			Frecuencia f = importancias.elementAt(i);
			System.out.println("Importancia del prod "+f.getProducto().getNombre()+": "+f.getFrecuencia());
		}
		
	}
}
