package programacion.tema11.Ejercicios.ejercicio3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        long inicio = System.currentTimeMillis();
        HashSet<Persona> hs = new HashSet<>();

        hs.add(new Persona("6", "1", "1", LocalDate.of(2006, 4, 10)));
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

        // Intenta hacer una inserción de una persona repetida ¿Qué ocurre? (Dos
        // personas son
        // iguales si tienen exactamente el mismo nombre). Lo que ocurre es que no se
        // añade

        long fin = System.currentTimeMillis();
        System.out.println("Tiempo de ejecucion: " + (fin - inicio));
    }
}
