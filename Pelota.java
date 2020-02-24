package Ejercicio15;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public class Pelota extends Block {
	public int velx;
	public int vely;


	public Pelota(int posx, int posy, int anchura, int altura, Color color) {
		super(posx, posy, anchura, altura, color);
		velx = -6;
		vely = -4;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

	public void actualizar(Raqueta raq, List<Block> bloques) {
		x += velx;
		y += vely;
		if ((x <= 0) || (x >= 290)) {
			velx = -velx;
		}
		if (y <= 0) {
			vely *= (-1);
		}
		if (intersects(raq)) {
			vely = -vely;
		}
		
		for(int i=0;i<bloques.size();i++) {
			if(intersects(bloques.get(i))) {
				vely = -vely;
				bloques.remove(bloques.get(i));
				break;
			}
		}
	}
}
