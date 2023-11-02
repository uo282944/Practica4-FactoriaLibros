package parse;

import Libro.Book;
import Libro.PlatformFactory;


import java.io.*;
import java.util.ArrayList;

public abstract class Parser {
    public final String SEPARATOR = "#";
    public final String BASE_PATH = "src/data/";
    protected ArrayList<Book> books;

    protected final PlatformFactory pf;

    protected Parser(PlatformFactory pf) {
        this.pf = pf;
        books = new ArrayList<Book>();
    }

    public void parse() {

        try {
            File file = new File(BASE_PATH + getNombreFichero());
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;
                // Leer el archivo línea por línea
                while ((line = bufferedReader.readLine()) != null) {
                    String[] bookData = line.split(SEPARATOR);
                    books.add(createBook(bookData));
                }
                bufferedReader.close();
            } else {
                System.out.println("El archivo " + getNombreFichero() + " no existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract String getNombreFichero();

    public abstract Book createBook(String[] bookData);

    public ArrayList<Book> getBooks() {
        return books;
    }
}



