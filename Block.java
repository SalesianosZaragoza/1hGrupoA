package Ejercicio15;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle {
	Color color;

	public Block(int posx, int posy, int anchura, int altura, Color color) {
		super(posx, posy, anchura, altura);
		this.color = color;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

}
