package gui.chart;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.AsignacionProduccion;
import modelo.Linea;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.data.time.TimePeriod;


import dao.impl.LineaDAO;

import util.HoursConverter;

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
		
		int[] tiempos=new int[lineas.size()];
		TaskSeries tSeries;
		TaskSeriesCollection collection = new TaskSeriesCollection();
		
		for (int j=0;j<lineas.size();j++){
			tSeries = new TaskSeries(lineas.get(j).getNombre());
			tiempos[j] = 0; //inicializo el contador de tiempos
			for (AsignacionProduccion a : this.asignacion) {
				if(a.getLinea().getId().longValue()==lineas.get(j).getId().longValue()){
					if(!(a.getOrdenProduccion().getProducto().getNombre().equals("[Cambio de formato]"))){
						if(a.getOrdenProduccion().getCantidadAProducir() > 0){
							tSeries.add(new Task(a.getOrdenProduccion().getProducto().getNombre(), new SimpleTimePeriod(tiempos[j], tiempos[j]+(a.getOrdenProduccion().getTiempoEstimado()).longValue()))); //TODO ese mas 10 debe ser el tiempo de la tarea real
						}else{
		//					m.setValueAt(a.getOrdenProduccion().getProducto().getNombre() + 
		//							" (" + HoursConverter.getString(a.getOrdenProduccion().getTiempoEstimado()) + " hs)",
		//							indices[a.getLinea().getId().intValue()-1],
		//							a.getLinea().getId().intValue()-1);
//							tSeries.add(new Task(a.getOrdenProduccion().getProducto().getNombre(), new SimpleTimePeriod(tiempos[j], tiempos[j]+10))); //TODO ese mas 10 debe ser el tiempo de la tarea real
						}
					}
		//			tiempos[a.getLinea().getId().intValue()-1] += 10;
					tiempos[j] += (a.getOrdenProduccion().getTiempoEstimado()).longValue();
				}
			}
			collection.add(tSeries);	
		}
		return collection;
	}

	/**
	 * Utility method for creating <code>Date</code> objects.
	 * @param day the date.
	 * @param month the month.
	 * @param year the year.
	 * @return a date.
	 */
	private static Date date(final int day, final int month, final int year) {

		final Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		final Date result = calendar.getTime();
		return result;

	}
	
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