package programacion.tema8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Distribucion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> listaAleatorios = new ArrayList<>();
        int random = 0;
        for (int i = 0; i <= 10000; i++) {

            random = ThreadLocalRandom.current().nextInt(0, 7);
            listaAleatorios.add(i, random);
        }
        for (int index = 0; index < 7; index++) {
            System.out.println(
                    "Numero " + index + " aparece estas veces = " + Collections.frequency(listaAleatorios, index));

        }

        ArrayList<Integer> frecuencias = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            int frecuencia = Collections.frequency(listaAleatorios, i);
            frecuencias.add(frecuencia);
        }
        System.out.println("El numero que mas aparece, aparece un total de estas veces = ");
        System.out.println(Collections.max(frecuencias));
        System.out.println("El numero que menos aparece, aparece un total de estas veces = ");
        System.out.println(Collections.min(frecuencias));
        System.out.println("La diferencia es = " + (Collections.max(frecuencias) - Collections.min(frecuencias)));

        scanner.close();
    }
}