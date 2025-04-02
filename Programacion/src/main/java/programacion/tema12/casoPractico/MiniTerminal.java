package programacion.tema12.casoPractico;

import java.io.File;
import java.util.Scanner;

public class MiniTerminal {
    public static File directorioActual = new File(System.getProperty("user.dir"));
    private static MiniFileManager mfm = new MiniFileManager();

    public static File getDirectorioActual() {
        return directorioActual;
    }

    public static void main(String[] args) {
        String comando;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print(directorioActual.getAbsolutePath() + " $ ");
            comando = scanner.nextLine().trim();

            String[] argumentos = comando.split(" ", 3);

            switch (argumentos[0]) {
                case "pwd" -> {
                    if (argumentos.length == 1)
                        System.out.println(mfm.getPwd());
                    else
                        System.out.println("El sistema no puede encontrar la ruta especificada.");
                }

                case "cd" -> {
                    if (argumentos.length == 2) {
                        mfm.cd(argumentos[1]);
                    } else
                        System.out.println("El sistema no puede encontrar la ruta especificada.");
                }

                default -> System.out.println("Unexpected Error");

                case "exit" -> {
                    System.out.println("Saliendo...");
                    break;
                }
            }

        }
    }
}
