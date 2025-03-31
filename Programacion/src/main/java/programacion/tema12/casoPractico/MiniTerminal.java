package programacion.tema12.casoPractico;

import java.io.File;
import java.util.Scanner;

public class MiniTerminal {
    private static File directorioActual = new File(System.getProperty("user.dir"));

    public static void main(String[] args) {
        String comando;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print(directorioActual.getAbsolutePath() + " $ ");
            comando = scanner.nextLine().trim();
            if (comando.equals("exit"))
                break;
            String[] argumentos = comando.split("", 3);

            if (argumentos[0].equals("pwd")) {
            }
        }
    }
}
