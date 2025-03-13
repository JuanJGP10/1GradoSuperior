package programacion.tema11.Ejercicios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    int id;

    public static void main(String[] args) {
        Map<String, Integer> palabrasLibro = new HashMap<>();
        Scanner teclado = new Scanner(System.in); // Resource leak: 'teclado' is never closed

        while (teclado.hasNext()) {
            String palabra = teclado.next();
            if (palabra.equals("seacabo"))
                break;
            if (!palabrasLibro.containsKey(palabra)) {
                palabrasLibro.put(palabra, 1);
            } else {
                palabrasLibro.put(palabra, (palabrasLibro.get(palabra) + 1));
            }
        }

        for (String palabra : palabrasLibro.keySet()) {
            System.out.println(palabra + " : " + palabrasLibro.get(palabra));
        }
    }
}
