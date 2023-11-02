package Interfaz;

public class LightThemeFactory implements AbstractInterfaceFactory{
    @Override
    public Button colorBoton() {
        Button b = new BlackButton();
        return b;

    }

    @Override
    public Window colorFondo() {
        Window w = new LightWindow();
        return w;
    }

	@Override
	public Label colorEtiqueta() {
		Label l = new LightLabel();
		return l;
	}
}
