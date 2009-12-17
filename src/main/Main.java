package main;

import org.jfree.ui.RefineryUtilities;

import gui.MenuPrincipalVisual;
import gui.PieChartDemo;

public class Main {

	public static void main(String[] args) {
		
		PieChartDemo demo = new PieChartDemo("Pie Chart Demo");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        
		MenuPrincipalVisual m=new MenuPrincipalVisual();
		m.show();
	}

}
