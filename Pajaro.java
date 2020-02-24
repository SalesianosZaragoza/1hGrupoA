package flappy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;


public class Pajaro extends Rectangle{
	public int velY;
	Color color;

	public Pajaro() {
		super(50, 20, 15, 15);
		color = Color.white;
		velY = +2;
	}
	
	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
	public void actualizar() {
		y += velY;
	}
}
