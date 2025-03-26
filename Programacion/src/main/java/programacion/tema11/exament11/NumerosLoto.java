package programacion.tema11.exament11;

import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class NumerosLoto {
    public static void main(String[] args) {

        int[] array = new int[6];
        array = generarCombinacion();

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    public static int[] generarCombinacion() {
        TreeMap<Integer, Integer> mapa = new TreeMap<>();

        int[] array = new int[6];

        for (int i = 0; i < 50000000; i++) {
            int random = ThreadLocalRandom.current().nextInt(1, 50);
            mapa.put(random, mapa.getOrDefault(random, 0) + 1);
        }

        TreeSet<Integer> numeros6 = new TreeSet<>();
        mapa.entrySet().stream().sorted((s1, s2) -> s1.getValue() - s2.getValue()).limit(6)
                .forEach(s -> numeros6.add(s.getKey()));

        for (int i = 0; i < array.length; i++) {
            array[i] = numeros6.stream().sorted((s1, s2) -> s1 - s2).max((s1, s2) -> s1 - s2).get();
            numeros6.remove(numeros6.stream().sorted((s1, s2) -> s1 - s2).max((s1, s2) -> s1 - s2).get());
        }

        return array;
    }
}
