package programacion.tema11.ejercicios_usando_lambda.ejercicio8;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
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

        HashMap<Integer, Integer> tempDias = new HashMap<>();

        temperaturas.forEach(t -> {
            if (tempDias.get(t) != null)
                tempDias.put(t, tempDias.get(t) + 1);
            else
                tempDias.put(t, 1);
        });

        tempDias.entrySet().stream()
                .forEach(str -> System.out.println(str.getKey() + " Aparece: " + str.getValue() + " veces"));
    }

}