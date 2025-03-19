package programacion.tema11.Ejercicios.ejercicio12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {

        ArrayList<Persona_v3> lista = new ArrayList<>();

        lista.add(new Persona_v3("Juam", "665823247", "6", LocalDate.of(2005, 1, 1)));
        lista.add(new Persona_v3("Pepe", "665123247", "2", LocalDate.of(2007, 9, 24)));
        lista.add(new Persona_v3("Manolo", "665456247", "3", LocalDate.of(2006, 3, 10)));
        lista.add(new Persona_v3("Isma", "665823123", "8", LocalDate.of(2002, 10, 5)));
        lista.add(new Persona_v3("Juam", "665823247", "6", LocalDate.of(2005, 1, 1)));

        Collections.sort(lista, (s1, s2) -> s1.getNombre().compareTo(s2.getNombre()));
        System.out.println("--------------------------------------------");
        System.out.println("Arraylist");
        for (Persona_v3 persona : lista) {
            System.out.println(persona);

        }
        System.out.println("--------------------------------------------");
        System.out.println("Preserva la ordenacion anterior eliminando duplicados");
        System.out.println("LinkedHashSet");
        LinkedHashSet<Persona_v3> linkedHashSet = new LinkedHashSet<>(lista);
        for (Persona_v3 persona : linkedHashSet) {
            System.out.println(persona);
        }
        System.out.println("--------------------------------------------");
        System.out.println("Sin ordenar eliminando duplicados");
        System.out.println("HashSet");
        HashSet<Persona_v3> hashSet = new HashSet<>(lista);
        for (Persona_v3 persona : hashSet) {
            System.out.println(persona);
        }

        // ¿Debes usar un Comparator en ambos casos?
        // Puedes usar comparable tambien o lambda

    }
}
