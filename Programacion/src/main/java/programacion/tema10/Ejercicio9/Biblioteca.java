package programacion.tema10.Ejercicio9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class Biblioteca {
    private static ArrayList<Publicacion> listaPublicaciones = new ArrayList<>();

    public void añadir(Publicacion publi) {
        listaPublicaciones.add(publi);
    }

    public void añadirLibro(String isbn, String titulo, Autor autor) {
        try {
            listaPublicaciones.add(new Libro(isbn, titulo, autor));
        } catch (ValorIncorrecto e) {
            System.out.println(e.toString());
            throw new PublicacionException("Error al dar de alta el libro");
        }

    }

    public Optional<Publicacion> buscar(String titulo) throws Exception {
        for (Publicacion publicacion : listaPublicaciones) {
            if (publicacion instanceof Libro l && l.getTitulo().equals(titulo))
                return Optional.of(l);
            if (publicacion instanceof Revista r && r.getNombre().equals(titulo))
                return Optional.of(r);

        }
        return Optional.empty();
    }

    /**
     * examen alomejor tambien por id?
     * porque se complica?
     * 
     * @param libro
     * @return
     */
    public boolean buscarLibro(Libro libro) {
        for (Publicacion publicacion : listaPublicaciones) {
            if (libro.equals(publicacion))
                return true;
        }
        return false;

        // Tambien se puede con return publicaciones.contains(libro)
        // Tambien se puede con return publicaciones.indexOf(libro)
    }

    public ArrayList<Revista> revistasOrdenadas() {
        ArrayList<Revista> revistas = new ArrayList<>();
        // Primero añado todas las revistas
        for (Publicacion publi : listaPublicaciones) {
            if (publi instanceof Revista r)
                revistas.add(r);
        }

        Collections.sort(revistas);

        return revistas;
    }

    private ArrayList<Libro> librosOrdenadas() {
        ArrayList<Libro> libros = new ArrayList<>();
        // Primero añado todas las libros
        for (Publicacion publi : listaPublicaciones) {
            if (publi instanceof Libro l)
                libros.add(l);
        }

        Collections.sort(libros);

        return libros;
    }

    public void ordenar() {
        Collections.sort(listaPublicaciones);

    }

    /**
     * ARREGLAR
     */
    public void mostrarLineas() {
        ArrayList<Publicacion> listaOrdenada = new ArrayList<>(listaPublicaciones);
        Collections.sort(listaOrdenada);

        boolean unaIt = true;
        System.out.println("--------------------------------------");
        System.out.printf("%-4s %-15s %-30s %-15s %-10s\n", "ID", "ISBN", "Titulo", "Autor", "NumeroEjemplares");
        System.out.println("--------------------------------------");
        for (Publicacion publicacion : listaOrdenada) {
            if (publicacion instanceof Revista && unaIt) {
                System.out.println("--------------------------------------");
                System.out.printf("%-4s %-15s %-30s %-10s\n", "ID", "ISNN", "Nombre", "Numero");
                System.out.println("--------------------------------------");
                unaIt = false;
            }
            publicacion.mostrarEnLinea();
        }
    }

    public static ArrayList<Publicacion> getListaPublicaciones() {
        return listaPublicaciones;
    }

    public static void setListaPublicaciones(ArrayList<Publicacion> listaPublicaciones) {
        Biblioteca.listaPublicaciones = listaPublicaciones;
    }

}
