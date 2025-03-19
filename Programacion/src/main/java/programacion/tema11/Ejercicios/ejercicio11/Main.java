package programacion.tema11.Ejercicios.ejercicio11;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<Persona_v3> lista = new ArrayList<>();

        lista.add(new Persona_v3("Juam", "665823247", "6", LocalDate.of(2005, 1, 1)));
        lista.add(new Persona_v3("Pepe", "665123247", "2", LocalDate.of(2007, 9, 24)));
        lista.add(new Persona_v3("Manolo", "665456247", "3", LocalDate.of(2006, 3, 10)));
        lista.add(new Persona_v3("Isma", "665823123", "8", LocalDate.of(2002, 10, 5)));
        lista.add(new Persona_v3("Melo", "665823111", "4", LocalDate.of(1997, 07, 7)));

        // Con lambda
        Collections.sort(lista, (s1, s2) -> s1.getNombre().compareTo(s2.getNombre()));

        for (Persona_v3 persona : lista) {
            System.out.println(persona);

        }

        // ¿Debes usar un Comparator en ambos casos?
        // puedes usar comparable o usar lambda

    }
}
