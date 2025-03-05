package programacion.tema10.Biblioteca2;

public class Revista extends Publicacion {
    private final String issn;
    private final String titulo;
    private final String numero;;

    public Libro(String isbn, String titulo, Autor autor) throws ValorIncorrecto {
        super();
        if (!isbn.matches("[0-9]{13}"))
            throw new ValorIncorrecto("ISBN INCORRECTO");
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.numEjemplares = 1;
    }
}
