package flappy;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class FlappyBird extends Applet implements Runnable{
	public static final int DISTANCIA = 100;
	public static final int POSINICIAL = 250;
	Thread animacion = new Thread();
	Image imagen;
	Graphics noseve;
	Pajaro bird;
	List <Columna> columnas;
	public static boolean fin = false;
	//poniendole static se puede acceder a él a través del nombre de la clase
	
	public void init() {
		bird = new Pajaro();
		imagen = createImage(300, 300);
		noseve = imagen.getGraphics();
		columnas = new ArrayList<Columna>();
		for(int i = 0; i < 3; i++) {
			//Esto es para que tengan una separación de 100 pixels, menos 30
			columnas.add(new Columna(POSINICIAL+(DISTANCIA * i)));
		}
	}
	
	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}
	
	public void run() {
		do {
			bird.actualizar();
			for(int k = 0; k < columnas.size(); k++) {
				columnas.get(k).actualizar(bird);
			}
			if(columnas.get(0).r1.x < 0) {
				columnas.remove(0);
				columnas.add(new Columna(300));
			}
			repaint();
			try {
				Thread.sleep(50);
			}catch(InterruptedException e) {}
		}while(true);
	}
	
	public void paint(Graphics g) {
		noseve.setColor(Color.black);
		noseve.fillRect(0, 0, 300, 300);
		bird.dibujar(noseve);
		for(int j = 0; j < columnas.size(); j++) {
			columnas.get(j).dibujar(noseve);
		}
		if(fin) {
			noseve.setColor(Color.white);
			noseve.drawString("GAME OVER", 100, 100);
			animacion.stop();
		}
		g.drawImage(imagen, 0, 0, this);
	}
	public boolean mouseDown(Event ev, int x, int y) {
		bird.y -= 15;
		return true;
	}
}
