package Ejercicio15;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Arkanoid extends Applet implements Runnable {
	public static final int DERECHA = 0;
	public static final int IZQUIERDA = 1;
	Thread animacion;
	List<Block> pared;
	Raqueta raqueta;
	Pelota pelota;
	Image imagen;
	Graphics noseve;

	// 5 filas por 10 columnas 28 anchura 10 altura
	Color colores[] = { Color.red, Color.MAGENTA, Color.BLUE, Color.green, Color.yellow };

	public void init() {
		imagen = createImage(300, 300); // es un metodo de la clase applet que instancia un objeto de la clase imagen
		noseve = imagen.getGraphics();
		raqueta = new Raqueta(120, 280, 60, 10, Color.blue);
		pelota = new Pelota(120, 230, 10, 10, Color.red);
		pared = new ArrayList<Block>();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				pared.add(new Block((j * 30) + 1, (i * 12) + 10, 28, 10, colores[i]));
			}
		}

	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void update(Graphics g) {
		paint(g);

	}

	public void paint(Graphics g) {
		noseve.setColor(Color.black);
		noseve.fillRect(0, 0, 300, 300);
		raqueta.dibujar(noseve);
		pelota.dibujar(noseve);
		for (int i = 0; i < pared.size(); i++) {
			pared.get(i).dibujar(noseve);
		}
		g.drawImage(imagen, 0, 0, this);

	}

	public void run() {
		do {
			pelota.actualizar(raqueta, pared);

			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		} while (true);
	}

	public boolean keyDown(Event e, int tecla) {
		if (tecla == 1006) {
			raqueta.actualizar(IZQUIERDA);
		}
		if (tecla == 1007) {
			raqueta.actualizar(DERECHA);
		}

		return true;
	}

}
