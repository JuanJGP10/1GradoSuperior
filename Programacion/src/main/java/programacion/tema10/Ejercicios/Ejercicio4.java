package programacion.tema10.Ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio4 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] vector = new int[ThreadLocalRandom.current().nextInt(1, 101)];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = ThreadLocalRandom.current().nextInt(11);
        }

        int number = 0;
        while (number >= 0) {
            try {
                number = scanner.nextInt();
                System.out.println(vector[number]);
            } catch (InputMismatchException e) {
                System.err.println("Formato de indice invalido");
                scanner.next();
            }

        }
    }
}
