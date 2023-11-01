package Interfaz;

import java.awt.Color;

public abstract class Label {
	protected Color colorLetras;
	public Color getColorLetras() {
        return colorLetras;
    }

    public void setColorLetras(Color colorLetras) {
        this.colorLetras = colorLetras;
    }
}
