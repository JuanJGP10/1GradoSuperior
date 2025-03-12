package programacion.tema11.Ejercicios.ejercicio4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {

        LinkedHashSet<Persona> hs = new LinkedHashSet<>();

        hs.add(new Persona("1", "1", "1", LocalDate.of(2006, 4, 10)));
        hs.add(new Persona("2", "2", "2", LocalDate.of(2005, 4, 10)));
        hs.add(new Persona("3", "3", "3", LocalDate.of(2001, 4, 10)));
        hs.add(new Persona("4", "4", "4", LocalDate.of(2002, 4, 10)));

        double media = 0;
        int mayor = 0;
        String nombreMayor = "";

        for (Persona persona : hs) {
            int edad = (int) ChronoUnit.YEARS.between(persona.getFechaNacimiento(), LocalDate.now());
            System.out.println(persona);
            media += edad;
            if (edad > mayor) {
                mayor = edad;
                nombreMayor = persona.getNombre();
            }

        }

        System.out.println("Longitud de hashset: " + hs.size());
        System.out.println("Media de edad: " + media / hs.size());
        System.out.println("Nombre de la persona mas mayor: " + nombreMayor);

        hs.add(new Persona("1", "5", "5", LocalDate.of(2002, 4, 10)));

        for (Persona persona : hs) {
            System.out.println(persona);
        }

        System.out.println("Longitud de hashset: " + hs.size());

        // 4. Repite el ejercicio anterior con un LinkedHashSet ¿Qué ha cambiado?
        // Es similar al HashSet, pero los elementos, además del almacenamiento de tipo
        // hash, están enlazados
        // entre sí según el orden de inserción, lo que representa una mejora en
        // rendimiento en caso de querer
        // recorrer todo el conjunto

    }
}
