package programacion.tema12.EjerciciosB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EjercicioB2 {
    public static void main(String[] args) {
        String[] linea;
        Map<String, Double> notasMedias = new HashMap<>();
        Path ruta = Path.of(
                "Programacion/src/main/java/programacion/tema12/EjerciciosB/Documentos/alumnos_notas.txt");
        try {

            List<String> listaNumeros = Files.readAllLines(ruta);
            for (String string : listaNumeros) {
                linea = string.split(" ");
                notasMedias.put((linea[0] + " " + linea[1]),
                        (Arrays.stream(linea)).skip(2).mapToInt(Integer::parseInt).average().orElse(0));
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

        notasMedias.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(s -> System.out.println("Nombre: " + s.getKey() + ", Nota media: " + s.getValue()));

    }
}
