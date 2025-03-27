package programacion.tema12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class EjercicioA2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = "e";
        while (!entrada.isBlank()) {
            entrada = scanner.nextLine();
            File file = new File(entrada);
            try {
                muestraInfoRuta(file);
            } catch (FileNotFoundException e) {

                e.getMessage();
            }
        }

    }

    public static void muestraInfoRuta(File ruta, boolean info) throws FileNotFoundException {
        if (ruta.exists()) {
            if (ruta.isFile()) {
                System.out.println("[A] " + ruta.getName());

            }

            if (ruta.isDirectory()) {
                File[] dirfil = ruta.listFiles();
                Arrays.sort(dirfil, Comparator.comparing(File::isFile));

                for (int i = 0; i < dirfil.length; i++) {
                    if (dirfil[i].isDirectory())
                        System.out.println("[*] " + dirfil[i].getName());
                    if (dirfil[i].isFile())
                        System.out.println("[A] " + dirfil[i].getName());
                }

            }
        } else {
            throw new FileNotFoundException("Fichero no encontrado");
        }

    }
}