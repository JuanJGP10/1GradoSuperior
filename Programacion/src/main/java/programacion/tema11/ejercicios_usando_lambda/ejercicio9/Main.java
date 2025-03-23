package programacion.tema11.ejercicios_usando_lambda.ejercicio9;

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

        int minimo = tempDias.entrySet().stream().min((s2, s1) -> s2.getValue().size() - s1.getValue().size())
                .get().getKey();

        int maximo = tempDias.entrySet().stream().max((s2, s1) -> s2.getValue().size() - s1.getValue().size())
                .get().getKey();

        System.out.println(
                "Temperatura con el minimo numero de apariciones: "
                        + minimo
                        + ",  Numero de apariciones: "
                        + tempDias.get(minimo).size());
        System.out.println(
                "Temperatura con el maximo numero de apariciones: "
                        + maximo
                        + ",  Numero de apariciones: "
                        + tempDias.get(maximo).size());
    }
}
