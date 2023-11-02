package Libro;

public interface PlatformFactory {
    Book showChildBook(String nombre, String autor, String texto, String link);
    Book showAdultBook(String nombre, String autor, String texto, String link);
}
