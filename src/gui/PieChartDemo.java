package gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;

public class PieChartDemo extends ApplicationFrame {

    /**
     * Creates a new demo instance.
     * 
     * @param title  the frame title.
     */
    public PieChartDemo(String title) {

        super(title);
        JPanel panel = new JPanel();
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Section 1", 23.3);
        dataset.setValue("Section 2", 56.5);
        dataset.setValue("Section 3", 43.3);
        dataset.setValue("Section 4", 11.1);
        
        JFreeChart chart3 = ChartFactory.createPieChart3D("Chart 3", dataset, false, false, false);
        PiePlot3D plot3 = (PiePlot3D) chart3.getPlot();
        plot3.setForegroundAlpha(0.6f);
        plot3.setCircular(true);
       
        panel.add(new ChartPanel(chart3));
       
        panel.setPreferredSize(new Dimension(600, 400));
        setContentPane(panel);
    }
 
}