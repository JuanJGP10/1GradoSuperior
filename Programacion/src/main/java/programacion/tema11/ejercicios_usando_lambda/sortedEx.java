package programacion.tema11.ejercicios_usando_lambda;

import java.util.List;

public class sortedEx {
    public static void main(String[] args) {
        List<Double> numeros = List.of(1.2, 2.4, 3.5, 4.6, 5.7);

        double suma = numeros.stream()
                .reduce(0.0, Double::sum);

        System.out.println(suma); // 15
    }
}
