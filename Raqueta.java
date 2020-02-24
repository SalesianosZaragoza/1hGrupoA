package Ejercicio15;

import java.awt.Color;

public class Raqueta extends Block {
	public static final int VELOCIDAD = 5;

	public Raqueta(int posx, int posy, int anchura, int altura, Color color) {
		super(posx, posy, anchura, altura, color);

	}

	public void actualizar(int direccion) {

		if (direccion == Arkanoid.DERECHA) {
				x += VELOCIDAD;
		} else {
				x += (VELOCIDAD * (-1));
		}
		if (x <= 0) {// para que no se pueda salir por la izda
			x = 0;
		}
		if (x >= (300 - width)) {
			x = 300 - width;
		}


	}

}
