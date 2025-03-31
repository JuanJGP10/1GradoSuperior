package programacion.tema12.EjerciciosB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EjercicioB1 {
    public static void main(String[] args) {
        /*
         * Implementa un programa que muestre por pantalla los valores máximos y mínimos
         * del
         * archivo ‘numeros.txt’.
         */

        Path ruta = Path.of(
                "C:\\Users\\Juan\\Desktop\\Grado\\1GradoSuperior\\Programacion\\src\\main\\java\\programacion\\tema12\\EjerciciosB\\Documentos\\numeros.txt");
        try {
            List<String> listaNumeros = Files.readAllLines(ruta);
            System.out
                    .println("Numero mas alto: " + listaNumeros.stream().mapToInt(Integer::parseInt).max().getAsInt());
            System.out.println(
                    "Numero mas pequeño: " + listaNumeros.stream().mapToInt(Integer::parseInt).min().getAsInt());
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
