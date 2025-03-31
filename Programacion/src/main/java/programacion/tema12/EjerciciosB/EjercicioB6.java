package programacion.tema12.EjerciciosB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class EjercicioB6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path rutaPi = Path.of(
                "C:/Users/Juan/Desktop/Grado/1GradoSuperior/Programacion/src/main/java/programacion/tema12/EjerciciosB/Documentos/pi-million.txt");
        System.out.println("Que numero quieres buscar en el numero PI");
        String numero = scanner.nextLine();
        int contador = 0;
        try {
            List<String> lineas = Files.readAllLines(rutaPi);
            for (String string : lineas) {
                if (string.contains(numero))
                    contador++;
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println("Ha aparecido el numero " + contador + " veces");
    }
}
