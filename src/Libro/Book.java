package Libro;

public abstract class Book {
    protected String name;
    protected String autor;
    protected String texto;
    protected String link;
    protected int edadMinima;

    public Book(String name, String autor, String texto, String link) {
        this.name = name;
        this.autor = autor;
        this.texto = texto;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    
    
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	@Override
	public String toString() {
		return name;
	}
    
    
}
