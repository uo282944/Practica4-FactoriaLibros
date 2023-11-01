package Interfaz;

import java.util.List;

public class BlackThemeFactory implements AbstractInterfaceFactory {

    @Override
    public Button colorBoton() {
        Button b = new LightButton();
        return b;

    }

    @Override
    public Window colorFondo() {
        Window w = new BlackWindow();
        return w;
    }

    @Override
    public Label colorEtiqueta() {
        Label l = new BlackLabel();
        return l;
    }
}
