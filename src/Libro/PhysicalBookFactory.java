package Libro;

public class PhysicalBookFactory implements PlatformFactory{
    @Override
    public Book buyChildBook(String nombre, String autor, String texto, String link) {
        Book cb = new PChildBook(nombre,autor,texto, link);
        return cb;

    }

    @Override
    public Book buyAdultBook(String nombre, String autor, String texto, String link) {
        Book ab = new PAdultBook(nombre,autor,texto, link);
        return ab;
    }
}