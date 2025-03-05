package programacion.tema10.Biblioteca2;

public class Libro extends Publicacion {
    private final String isbn;
    private final String titulo;
    private final Autor autor;
    private int numEjemplares;

    public Libro(String isbn, String titulo, Autor autor) throws ValorIncorrecto {
        super();
        if (!isbn.matches("[0-9]{13}"))
            throw new ValorIncorrecto("ISBN INCORRECTO");
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.numEjemplares = 1;
    }

    public Libro(String isbn, String titulo, Autor autor, int numEjemplares) throws ValorIncorrecto {
        this(isbn, titulo, autor);
        if (numEjemplares < 0)
            throw new ValorIncorrecto("NUMERO DE EJEMPLARES NEGATIVO");
        this.numEjemplares = numEjemplares;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    @Override
    public void mostrarEnLinea() {
        // TODO Auto-generated method stub

    }

}
