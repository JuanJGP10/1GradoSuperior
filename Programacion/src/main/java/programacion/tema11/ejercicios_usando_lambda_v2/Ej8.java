package programacion.tema11.ejercicios_usando_lambda_v2;

import java.time.Year;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Ej8 {
    public static void main(String[] args) {
        /*
         * . Realizar un programa al que se le introduzca un año y genera un array con
         * las
         * temperaturas medias de una ciudad para todos los días de ese año (365 ó 366).
         * La
         * temperatura será un entero entre 10 y 30 grados. Almacena en un Mapa la
         * distribución de
         * temperaturas, es decir, para cada temperatura, cuantos días del año la hubo y
         * muestra
         * dicha distribución.
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

    }
}
