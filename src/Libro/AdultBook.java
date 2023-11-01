package Libro;

public abstract class AdultBook extends Book{
    public AdultBook(String name, String autor, String texto, String link) {
        super(name, autor, texto, link);
        this.edadMinima = 18;
    }
}
