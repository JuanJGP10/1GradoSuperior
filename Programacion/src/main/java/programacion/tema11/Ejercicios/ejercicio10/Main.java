package programacion.tema11.Ejercicios.ejercicio10;

import java.time.LocalDate;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Persona_v3> arbol = new TreeSet<>();

        arbol.add(new Persona_v3("Juam", "665823247", "1", LocalDate.of(2005, 1, 1)));
        arbol.add(new Persona_v3("Pepe", "665123247", "2", LocalDate.of(2007, 9, 24)));
        arbol.add(new Persona_v3("Manolo", "665456247", "3", LocalDate.of(2006, 3, 10)));
        arbol.add(new Persona_v3("Isma", "665823123", "4", LocalDate.of(2002, 10, 5)));

        for (Persona_v3 persona : arbol) {
            System.out.println(persona);
        }

        // No funciona porque Persona no tiene implementado el comparable

        // Borrando el equals y hashcode sigue funcioanndo bien porque los Tree solo
        // necesitan de la interfaz Comparable o Comparator
    }
}
