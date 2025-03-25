package programacion.tema11.ejercicios_usando_lambda_v2;

import java.time.Year;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class Ej9 {
    public static void main(String[] args) {
        /*
         * 9. Realizar un programa que genera un array con las temperaturas medias de
         * una ciudad
         * para todos los días de un año no bisiesto. La temperatura será un entero
         * entre 10 y 30
         * grados. Ayudándote de un TreeMap, muestra la temperatura mínima y cuantas
         * ocurrencias tuvo y la temperatura máxima y cuantas ocurrencias tuvo.
         * 
         */
        int año = 2020;
        int[] dias;
        if (Year.isLeap(año))
            dias = new int[366];
        else
            dias = new int[365];

        for (int i = 0; i < dias.length; i++) {
            dias[i] = ThreadLocalRandom.current().nextInt(10, 31);
        }

        HashMap<Integer, Integer> mapa = new HashMap<>();

        for (int i = 0; i < dias.length; i++) {
            mapa.put(dias[i], mapa.getOrDefault(dias[i], 0) + 1);
        }

        mapa.entrySet().forEach(s1 -> System.out.println("Temperatura: " + s1.getKey() + " Apariciones: " + s1
                .getValue()));

        TreeMap<Integer, Integer> arbol = new TreeMap<>(mapa);

        System.out.println("----------------------------------------");
        arbol.entrySet().stream().sorted((s1, s2) -> s1.getValue() - s2.getValue())
                .forEach(s1 -> System.out.println("Temperatura: " + s1.getKey() + " Apariciones: " + s1.getValue()));

        System.out.println("Mayor numero de apariciones: "
                + mapa.entrySet().stream().max((s1, s2) -> s1.getValue() - s2.getValue()).get());
        System.out.println("Menor numero de apariciones: "
                + mapa.entrySet().stream().min((s1, s2) -> s1.getValue() - s2.getValue()).get());
    }
}
