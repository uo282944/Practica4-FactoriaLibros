package Libro;

public interface PlatformFactory {
    Book buyChildBook(String nombre, String autor, String texto, String link);
    Book buyAdultBook(String nombre, String autor, String texto, String link);
}
