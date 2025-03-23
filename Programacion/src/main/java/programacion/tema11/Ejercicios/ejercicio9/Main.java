package programacion.tema11.Ejercicios.ejercicio9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        int[] temp;
        temp = new int[365];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = ThreadLocalRandom.current().nextInt(10, 31);
        }

        TreeMap<Integer, ArrayList<Integer>> tempDias = new TreeMap<>();
        for (int i = 10; i < 31; i++) {
            tempDias.put(i, new ArrayList<>());
            for (int j = 0; j < temp.length; j++) {
                if (i == temp[j])
                    tempDias.get(i).add(j + 1);
            }
        }

        System.out.println(
                "Temperatura minima: " + tempDias.firstKey() + ",  Numero de apariciones: "
                        + tempDias.get(tempDias.firstKey()).size());
        System.out.println(
                "Temperatura maxima: " + tempDias.lastKey() + ",  Numero de apariciones: "
                        + tempDias.get(tempDias.lastKey()).size());
    }
}
