package programacion.tema15_16.ejercicio8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Libro> biblio = new ArrayList<>();

        biblio.add(new Libro("1", 10));
        biblio.add(new Libro("4", 40));
        biblio.add(new Libro("3", 30));
        biblio.add(new Libro("2", 100));

        biblio.sort(Comparator.comparing(Libro::getPrecio));

        biblio.forEach((s1) -> System.out.println(s1.getTitulo() + " Precio: " + s1.getPrecio()));

        System.out.println("-------------------------------------");

        // a)
        biblio.stream()
                .filter((arg) -> arg.getPrecio() > 10)
                .forEach((salida) -> System.out.println(salida));
        // b)
        biblio.stream()
                .filter((arg) -> arg.getPrecio() > 10)
                .forEach(System.out.println("Titulo:" + salida.getTitulo()));
        // c)
        HashSet<Libro> set = new HashSet<>();
        biblio.stream()
                .filter((arg) -> arg.getMeGusta() > 2)
                .forEach((salida) -> set.add(salida));

        // d)
        System.out.println("Contador de libros con 0 megustas: " + biblio.stream()
                .filter((arg) -> arg.getMeGusta() == 0)
                .count());
        // e)
        System.out.println("Cantidad de megustas en total: " + biblio.stream()
                .mapToInt(Libro::getMeGusta)
                .sum());
        // d
        List<Libro> librosUsa = biblio.stream()
                .map((arg -> arg.setPrecio(arg.getPrecio() / 0.92)))
                .collect(Collectors.toList());
    }
}
