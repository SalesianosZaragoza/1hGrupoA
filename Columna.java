package flappy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Columna{
	public static final int HUECO = 50;
	public static final int ANCHURA = 30;
	Rectangle r1, r2;
	public static final int VELX = -1;
	
	public Columna(int posIn) {
		//Math.random devuelve un valor entre 0 y 1. Poniendole un int delante, cojo la parte entera de ese número. Si el parseo lo hago delante
		//del Math.random, el resultado va a ser siempre 9. Si el parseo lo hago tras multiplicar por 150, me devolverá un entero entre 0 y 150
		int altura = (int)(Math.random()*150) + HUECO;
		r1 = new Rectangle(posIn, 0, ANCHURA, altura);
		r2 = new Rectangle(posIn, altura + HUECO, ANCHURA, 300-(altura+HUECO));
	}
	
	public void actualizar(Pajaro pajaro) {
		r1.x += VELX;
		r2.x += VELX;
		
		if(r1.intersects(pajaro) || r2.intersects(pajaro)) {
			FlappyBird.fin = true;
		}
	}
	
	public void dibujar(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(r1.x, r1.y, r1.width, r1.height);
		g.fillRect(r2.x, r2.y, r2.width, r2.height);
	}
}
