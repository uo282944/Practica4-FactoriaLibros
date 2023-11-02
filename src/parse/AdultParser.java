package parse;

import Libro.Book;
import Libro.PhysicalBookFactory;
import Libro.PlatformFactory;

public class AdultParser extends Parser{
    private final String FILE_ADULTO = "LibrosAdulto.txt";
    public AdultParser(PlatformFactory pf) {
        super(pf);
        this.parse();
    }

    public String getNombreFichero() {
        return FILE_ADULTO;
    }

    public Book createBook(String[] bookData) {
        return pf.showAdultBook(
                bookData[Atributes.TITULO.ordinal()],
                bookData[Atributes.AUTOR.ordinal()],
                bookData[Atributes.TEXTO.ordinal()],
                bookData[Atributes.LINK.ordinal()]
        );
    }
}