package Interfaz;

import java.awt.Color;

public abstract class Button {
    protected Color colorFondoBoton;
    protected Color colorLetras;
    public Color getColorFondoBoton() {
        return colorFondoBoton;
    }

    public void setColorFondoBoton(Color colorFondoBoton) {
        this.colorFondoBoton = colorFondoBoton;
    }

    public Color getColorLetras() {
        return colorLetras;
    }

    public void setColorLetras(Color colorLetras) {
        this.colorLetras = colorLetras;
    }
}
