package programacion.tema10.Ejercicio9;

import java.util.ArrayList;
import java.util.Collections;

public class Biblioteca {
    private static ArrayList<Publicacion> listaPublicaciones = new ArrayList<>();

    public void añadir(Publicacion publi) {
        listaPublicaciones.add(publi);
    }

    public void añadirLibro(String isbn, String titulo, Autor autor) {
        try {
            listaPublicaciones.add(new Libro(isbn, titulo, autor));
        } catch (ValorIncorrecto e) {
            e.toString();
            e.printStackTrace();
            System.out.println();
        }

    }

    public Publicacion buscar(String titulo) throws ValorIncorrecto {
        for (Publicacion publicacion : listaPublicaciones) {
            if (publicacion instanceof Libro l && l.getTitulo().equals(titulo))
                return l;
            if (publicacion instanceof Revista r && r.getNombre().equals(titulo))
                return r;
        }
        throw new ValorIncorrecto(titulo, "no encontrado");
    }

    public boolean buscarLibro(Libro libro) {
        for (Publicacion publicacion : listaPublicaciones) {
            if (libro.equals(publicacion))
                return true;

        }
        return false;
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
        ArrayList<Revista> revistas = revistasOrdenadas();
        ArrayList<Libro> libros = librosOrdenadas();

        listaPublicaciones.clear();

        for (Libro libro : libros) {
            listaPublicaciones.add(libro);
        }

        for (Revista revista : revistas) {
            listaPublicaciones.add(revista);
        }

    }

    public void mostrarLineas() {
        boolean unaIt = true;
        System.out.println("--------------------------------------");
        System.out.printf("%-15s %-30s %-15s %-10s\n", "ISBN", "Titulo", "Autor", "NumeroEjemplares");
        System.out.println("--------------------------------------");
        for (Publicacion publicacion : listaPublicaciones) {
            if (publicacion instanceof Revista && unaIt) {
                System.out.println("--------------------------------------");
                System.out.printf("%-15s %-30s %-10s\n", "ISNN", "Nombre", "Numero");
                System.out.println("--------------------------------------");
                unaIt = false;
            }
            publicacion.mostrarEnLinea();
        }
    }

}
