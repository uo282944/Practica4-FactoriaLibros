package Libro;

public abstract class ChildBook extends Book{
    public ChildBook(String name, String autor, String texto, String link) {
        super(name, autor, texto, link);
        this.edadMinima = 3;
    }
}
