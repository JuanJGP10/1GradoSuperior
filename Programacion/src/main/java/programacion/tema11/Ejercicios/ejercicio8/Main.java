package programacion.tema11.Ejercicios.ejercicio8;

import java.util.ArrayList;
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
        } else {
            temp = new int[365];
        }

        for (int i = 0; i < temp.length; i++) {
            temp[i] = ThreadLocalRandom.current().nextInt(10, 31);
        }

        HashMap<Integer, ArrayList<Integer>> tempDias = new HashMap<>();
        for (int i = 10; i < 31; i++) {
            tempDias.put(i, new ArrayList<>());
            for (int j = 0; j < temp.length; j++) {
                if (i == temp[j])
                    tempDias.get(i).add(j + 1);
            }
        }

        for (Integer temperatura : tempDias.keySet()) {
            System.out.println("Temperatura: " + temperatura + ",  Distribucion: " + tempDias.get(temperatura));
        }

        scanner.close();
    }

}