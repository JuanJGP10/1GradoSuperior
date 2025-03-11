package programacion.tema11.Ejercicios.ejercicio8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        int[] temp;
        System.out.println("Que año quieres ver las temperaturas");
        Scanner scanner = new Scanner(System.in);
        int año = scanner.nextInt();
        if ((año % 4 == 0 && año % 100 != 0) || (año % 100 == 0 && año % 400 == 0)) {
            temp = new int[366];
            Arrays.fill(temp, ThreadLocalRandom.current().nextInt(10, 31));
        } else {
            temp = new int[365];
            Arrays.fill(temp, ThreadLocalRandom.current().nextInt(10, 31));
        }

        HashMap<Integer, Integer> tempDias = new HashMap<>();
        for (int i = 10; i < 31; i++) {
            tempDias.put(i, 1);
        }
    }

}
