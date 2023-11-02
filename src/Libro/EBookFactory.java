package Libro;

public class EBookFactory implements PlatformFactory{
    @Override
    public Book showChildBook(String name, String autor, String texto, String link) {
        Book cb = new EChildBook(name,autor,texto, link);
        return cb;

    }

    @Override
    public Book showAdultBook(String name, String autor, String texto, String link) {
        Book ab = new EAdultBook(name,autor,texto, link);
        return ab;
    }
}
