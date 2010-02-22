package gui.chart;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.AsignacionProduccion;
import modelo.Linea;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;

import dao.impl.LineaDAO;

public class PlanificacionDeTareasGantt extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage grafica = null;
	List<AsignacionProduccion> asignacion;

	public PlanificacionDeTareasGantt(List<AsignacionProduccion> asignacion) {
		super();
		this.asignacion = asignacion;
	}

	public static void main(String args[]) {
		JFrame ventana = new JFrame("Ejemplo");
		PlanificacionDeTareasGantt panel = new PlanificacionDeTareasGantt(null);
		ventana.getContentPane().add(panel);
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// ventana.pack();
		ventana.setSize(400, 400);
		ventana.show();
	}

	public BufferedImage creaImagen() {
		final IntervalCategoryDataset dataset = createDataset();
	    final JFreeChart chart = createChart(dataset);
	   
		BufferedImage image = chart.createBufferedImage(700, 500);

		return image;
	}

	public IntervalCategoryDataset createDataset() {

		LineaDAO lineaDAO = new LineaDAO();
		List<Linea> lineas = lineaDAO.getList();
		
		long[] tiempos=new long[lineas.size()];
		TaskSeries tSeries;
		TaskSeriesCollection collection = new TaskSeriesCollection();
		
		for (int j=0;j<lineas.size();j++){
			tSeries = new TaskSeries(lineas.get(j).getNombre());
			Date d=new Date(109,0,1,0,0,0);
			tiempos[j] = d.getTime(); //inicializo el contador de tiempos
			for (AsignacionProduccion a : this.asignacion) {
				
				if(a.getLinea().getId().longValue()==lineas.get(j).getId().longValue()){
					int hasta=d.getHours()+(a.getOrdenProduccion().getTiempoEstimado()).intValue();
					Date aux=new Date(109,0,1,hasta,0,0);
					long estimado=aux.getTime();
					if(!(a.getOrdenProduccion().getProducto().getNombre().equals("[ Cambio de formato ]"))){
						if(a.getOrdenProduccion().getCantidadAProducir() > 0){
							tSeries.add(new Task(a.getOrdenProduccion().getProducto().getNombre(), new SimpleTimePeriod(tiempos[j],estimado))); //TODO ese mas 10 debe ser el tiempo de la tarea real
						}else{
		//					m.setValueAt(a.getOrdenProduccion().getProducto().getNombre() + 
		//							" (" + HoursConverter.getString(a.getOrdenProduccion().getTiempoEstimado()) + " hs)",
		//							indices[a.getLinea().getId().intValue()-1],
		//							a.getLinea().getId().intValue()-1);
//							tSeries.add(new Task(a.getOrdenProduccion().getProducto().getNombre(), new SimpleTimePeriod(tiempos[j], tiempos[j]+10))); //TODO ese mas 10 debe ser el tiempo de la tarea real
						}
					}
		//			tiempos[a.getLinea().getId().intValue()-1] += 10;
					d.setHours(d.getHours()+(a.getOrdenProduccion().getTiempoEstimado()).intValue());
					tiempos[j] = estimado;
					d=new Date(aux.getTime());
				}
			}
			collection.add(tSeries);
		}
		return collection;
	}
	
//	public IntervalCategoryDataset createDataset() {
//
//		LineaDAO lineaDAO = new LineaDAO();
//		List<Linea> lineas = lineaDAO.getList();
//		
//		double[] tiempos=new double[lineas.size()];
//		TaskSeriesNutreco tSeries;
//		TaskSeriesCollectionNutreco collection = new TaskSeriesCollectionNutreco();
//		
//		for (int j=0;j<lineas.size();j++){
//			tSeries = new TaskSeriesNutreco(lineas.get(j).getNombre());
//			tiempos[j] = 0; //inicializo el contador de tiempos
//			for (AsignacionProduccion a : this.asignacion) {
//				
//				if(a.getLinea().getId().longValue()==lineas.get(j).getId().longValue()){
//					if(!(a.getOrdenProduccion().getProducto().getNombre().equals("[ Cambio de formato ]"))){
//						if(a.getOrdenProduccion().getCantidadAProducir() > 0){
//							tSeries.add(new TaskNutreco(a.getOrdenProduccion().getProducto().getNombre(), new TimePeriodNutreco(tiempos[j], tiempos[j] + a.getOrdenProduccion().getTiempoEstimado())));
//						}else{
//		//					m.setValueAt(a.getOrdenProduccion().getProducto().getNombre() + 
//		//							" (" + HoursConverter.getString(a.getOrdenProduccion().getTiempoEstimado()) + " hs)",
//		//							indices[a.getLinea().getId().intValue()-1],
//		//							a.getLinea().getId().intValue()-1);
////							tSeries.add(new Task(a.getOrdenProduccion().getProducto().getNombre(), new SimpleTimePeriod(tiempos[j], tiempos[j]+10))); //TODO ese mas 10 debe ser el tiempo de la tarea real
//						}
//					}
//		//			tiempos[a.getLinea().getId().intValue()-1] += 10;
//					
//					tiempos[j] += a.getOrdenProduccion().getTiempoEstimado();
//					
//				}
//			}
//			collection.add(tSeries);
//		}
//		return collection;
//	}
	
	  /**
     * Creates a chart.
     * @param dataset  the dataset.
     * @return The chart.
     */
    private JFreeChart createChart(final IntervalCategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createGanttChart(
            "Asignación de Producción por Línea",  // chart title
            "Producto",              // domain axis label
            "Tiempo [hs]",              // range axis label
            dataset,             // data
            true,                // include legend
            true,                // tooltips
            false                // urls
        );    
//        chart.getCategoryPlot().getDomainAxis().setMaxCategoryLabelWidthRatio(10.0f);
        return chart;    
    }

	public void paint(Graphics g) {
		if (grafica == null) {
			grafica = this.creaImagen();
		}

		g.drawImage(grafica, 30, 30, null);
		this.invalidate();
	}
}