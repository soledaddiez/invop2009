package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

 public class VentanaGrafica extends JPanel{
     
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage grafica = null;

	public VentanaGrafica() {
		
	}

	public static void main(String args[]) {
		JFrame ventana = new JFrame("Ejemplo");
		VentanaGrafica panel = new VentanaGrafica();
		ventana.getContentPane().add(panel);
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
//		ventana.pack();
		ventana.setSize(400, 400);
		ventana.show();
	}

	public BufferedImage creaImagen() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Section 1", 23.3);
		dataset.setValue("Section 2", 56.5);
		dataset.setValue("Section 3", 43.3);
		dataset.setValue("Section 4", 11.1);

		JFreeChart chart = ChartFactory.createPieChart3D("Chart", dataset,
				false, false, false);
		PiePlot3D plot3 = (PiePlot3D) chart.getPlot();
		plot3.setForegroundAlpha(0.6f);
		plot3.setCircular(true);

		BufferedImage image = chart.createBufferedImage(300, 300);

		return image;
	}

	public void paint(java.awt.Graphics g) {
		if (grafica == null) {
			grafica = this.creaImagen();
		}
		g.drawImage(grafica, 30, 30, null);
	}
}
