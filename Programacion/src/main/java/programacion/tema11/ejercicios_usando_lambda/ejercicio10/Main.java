package programacion.tema11.ejercicios_usando_lambda.ejercicio10;

import java.time.LocalDate;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Persona_v2> arbol = new TreeSet<>((o1, o2) -> (o1.getNombre().compareTo(o2.getNombre())));

        arbol.add(new Persona_v2("Juam", "665823247", "1", LocalDate.of(2005, 1, 1)));
        arbol.add(new Persona_v2("Pepe", "665123247", "2", LocalDate.of(2007, 9, 24)));
        arbol.add(new Persona_v2("Manolo", "665456247", "3", LocalDate.of(2006, 3, 10)));
        arbol.add(new Persona_v2("Isma", "665823123", "4", LocalDate.of(2002, 10, 5)));

        arbol.forEach((salida) -> System.out.println(salida));
    }
}
