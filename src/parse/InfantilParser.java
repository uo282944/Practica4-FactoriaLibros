package parse;

import Libro.Book;
import Libro.PlatformFactory;

public class InfantilParser extends Parser{
    private final String FILE_INFANTIL = "LibrosInfantiles.txt";
    public InfantilParser(PlatformFactory pf) {
        super(pf);
        this.parse();
    }

    public String getNombreFichero() {
        return FILE_INFANTIL;
    }

    public Book createBook(String[] bookData) {
        return pf.showChildBook(
                bookData[Atributes.TITULO.ordinal()],
                bookData[Atributes.AUTOR.ordinal()],
                bookData[Atributes.TEXTO.ordinal()],
                bookData[Atributes.LINK.ordinal()]
        );
    }
}