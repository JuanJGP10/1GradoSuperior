package programacion.tema11.ejercicios_usando_lambda.ejercicio13;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> temperaturas = new ArrayList<>();
        int año = 2020;
        int dias = 0;
        if (new GregorianCalendar().isLeapYear(año))
            dias = 366;
        else
            dias = 365;

        for (int i = 0; i < dias; i++) {
            temperaturas.add(ThreadLocalRandom.current().nextInt(10, 31));
        }

        TreeMap<Integer, Integer> tempDias = new TreeMap<>();

        for (int i = 0; i < temperaturas.size(); i++) {
            tempDias.put(temperaturas.get(i), tempDias.getOrDefault(temperaturas.get(i), 0) + 1);
        }

        tempDias.entrySet().stream()
                .forEach(str -> System.out.println(str.getKey() + " Aparece: " + str.getValue() + " veces"));

        tempDias.entrySet().stream().sorted((s1, s2) -> s1.getValue() -
                s2.getValue()).forEach(
                        salida -> System.out
                                .println("Temperatura: " + salida.getKey() + " Apariciones: " +
                                        salida.getValue()));

        for (Integer integer : tempDias.keySet()) {
            System.out.println("LLave " + integer + " Valor: " + tempDias.get(integer));
        }
    }

}