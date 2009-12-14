package gui;

import java.awt.*;

public class Muestra extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Pal;
	private Rectangle rect;
	private int x;
	private int y;
	private Thread t;
	private boolean running;
	private Font f;

	Muestra(){
		setSize(500,250);
		//setBackground(Color.LIGHT_GRAY);
		rect = getBounds();
		x = rect.width;
		y = (int) rect.height / 2;
		Pal = "Sistema de Ayuda para Planificacion de Produccion...";
		f = new Font("Monospaced", Font.PLAIN | Font.BOLD, 30);
	}
	
	public void paint(Graphics g){
		g.setFont(f);
		g.setColor(Color.BLUE);
		g.drawString(Pal,x,y);
	}
	
	public void update(Graphics g){
		rect = getBounds();
		Image image = createImage(rect.width,rect.height);
		Graphics gi = image.getGraphics();
		gi.clearRect(0,0,rect.width,rect.height);
		paint(gi);
		g.drawImage(image,0,0,null);
	}
	
	public void start(){
		if(t == null){
			running = true;
			t = new Thread(this);
			t.start();
		}
	}
	
	private int getPointX(){
		if (x >= -1080)
			return x-1;
		else
			return x=rect.width;
	}

	@Override
	public void run() {
		try{
			while(running){
				x = getPointX();
				repaint();
				Thread.sleep(10);
			}
		}catch(InterruptedException e){
			running = false;
		}
	}

}
