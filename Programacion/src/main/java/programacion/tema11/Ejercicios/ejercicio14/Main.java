package programacion.tema11.Ejercicios.ejercicio14;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        LocalDateTime principio = LocalDateTime.now();
        Set<Integer> conjunto = new HashSet<>();
        for (int i = 0; i < 100000; i++) {
            conjunto.add(ThreadLocalRandom.current().nextInt(1, 1000001));
        }
        LocalDateTime fin = LocalDateTime.now();
        System.out.println("Usando set: ");
        System.out.print(ChronoUnit.MILLIS.between(principio, fin) + "\n");

        principio = LocalDateTime.now();

        Set<Integer> arbol = new TreeSet<>();
        for (int i = 0; i < 100000; i++) {
            arbol.add(ThreadLocalRandom.current().nextInt(1, 1000001));
        }

        fin = LocalDateTime.now();
        System.out.println("Usando Treeset: ");
        System.out.print(ChronoUnit.MILLIS.between(principio, fin) + "\n");

        // Pruebas para razonar porque hashset es mucho mas rapido q treeset, aunq de
        // primeras pienso q es porque el arbol lo ordena y el hashset no.
        int contador = 0;
        System.out.println("----------------------------------------");
        System.out.println("Imprimo el hashset");
        for (Integer integer : conjunto) {
            System.out.println(integer);
            contador++;
            if (contador == 50)
                break;
        }

        contador = 0;

        System.out.println("----------------------------------------");
        System.out.println("Imprimo el arbol");
        for (Integer integer : arbol) {
            System.out.println(integer);
            contador++;
            if (contador == 50)
                break;
        }

        // Mis pensamientos eran correctos

    }
}
