package programacion.tema12.casoPractico;

import java.io.File;
import java.util.Scanner;

public class MiniTerminal {
    private static File directorioActual = new File(System.getProperty("user.dir"));
    private static MiniFileManager mfm = new MiniFileManager();

    public static void main(String[] args) {
        String comando;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print(directorioActual.getAbsolutePath() + " $ ");
            comando = scanner.nextLine().trim();
            if (comando.equals("exit"))
                break;
            String[] argumentos = comando.split(" ", 3);

            if (argumentos[0].equals("pwd")) {
                if (argumentos.length != 1)
                    throw new IllegalArgumentException("exceso de argumentos para este comando");

                System.out.println(mfm.getPwd(directorioActual));

            }

            if (argumentos[0].equals("cd")) {
                if (argumentos.length != 2)
                    throw new IllegalArgumentException("cantidad de argumentos no valida para este comando");
                File file = new File(directorioActual.getAbsolutePath() + "/" + argumentos[1]);
                directorioActual.renameTo(file);
            }
        }
    }
}
