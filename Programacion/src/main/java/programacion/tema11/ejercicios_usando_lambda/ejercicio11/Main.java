package programacion.tema11.ejercicios_usando_lambda.ejercicio11;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Persona_v3> lista = new ArrayList<>();

        lista.add(new Persona_v3("Juam", "665823247", "1", LocalDate.of(2005, 1, 1)));
        lista.add(new Persona_v3("Pepe", "665123247", "2", LocalDate.of(2007, 9, 24)));
        lista.add(new Persona_v3("Manolo", "665456247", "3", LocalDate.of(2006, 3, 10)));
        lista.add(new Persona_v3("Isma", "665823123", "4", LocalDate.of(2002, 10, 5)));

        lista.sort((s1, s2) -> s1.getEmail().compareTo(s2.getEmail()));

        lista.forEach(System.out::println);
    }
}
