package programacion.tema11.ejercicios_usando_lambda.ejercicio3;

import java.time.LocalDate;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        HashSet<Persona> hs = new HashSet<>();

        hs.add(new Persona("6", "1", "1", LocalDate.of(2006, 4, 10)));
        hs.add(new Persona("2", "2", "2", LocalDate.of(2005, 4, 10)));
        hs.add(new Persona("3", "3", "3", LocalDate.of(2001, 4, 10)));
        hs.add(new Persona("4", "4", "4", LocalDate.of(2002, 4, 10)));

        System.out.println("Media de edad:" + hs.stream().mapToDouble(Persona::getEdad).average().getAsDouble());
        System.out.println(
                "Nombre de la persona mas mayor: "
                        + hs.stream().max((arg1, arg2) -> arg1.getEdad() - arg2.getEdad()).get().getNombre());

    }
}
