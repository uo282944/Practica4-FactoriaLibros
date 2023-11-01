package Interfaz;

import java.awt.Color;

public abstract class Window {
    protected Color colorFondo;

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }
}
