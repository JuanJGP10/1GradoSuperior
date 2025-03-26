package programacion.tema11.ejercicios_usando_lambda.ej3;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;

public class Ej3 {

    public static void main(String[] args) {
        HashSet<Persona> personas = new HashSet<>();

        personas.add(new Persona("Juan", "665823247", "juanillo@gmail.com", LocalDate.of(2005, 04, 10)));
        personas.add(new Persona("Mel", "665823247", "juanillo@gmail.com", LocalDate.of(2003, 04, 10)));
        personas.add(new Persona("ISma", "665823247", "juanillo@gmail.com", LocalDate.of(2001, 04, 10)));
        personas.add(new Persona("Sandra", "665823247", "juanillo@gmail.com", LocalDate.of(2000, 04, 10)));

        System.out.println("Edad media: " + personas.stream().mapToDouble(Persona::getEdad).average().getAsDouble());

        System.out.println(
                "Nombre de la persona mas mayor: "
                        + personas.stream().max(Comparator.comparing(Persona::getEdad)).get().getNombre());

        personas.add(new Persona("Juan", "665823247", "juanillo@gmail.com", LocalDate.of(2005, 04, 10)));

        personas.forEach(System.out::println);

    }
}
