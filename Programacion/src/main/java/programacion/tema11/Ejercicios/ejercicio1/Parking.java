package programacion.tema11.Ejercicios.ejercicio1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 1. Realizar un programa que contenga una LinkedList para almacenar las
 * matrículas de los
 * coches aparcados en un parking. El parking es un poco raro, mide solo 3
 * metros de ancho
 * y caben 10 coches, pero uno detrás de otro por lo que el último en entrar
 * debe ser el
 * primero en salir (esta estructura se llama pila LIFO – Last Input, First
 * Output). El programa
 * tendrá un menú para:
 * ◦ Aparcar: se le pasará el número de matrícula y lo almacenará a no ser que
 * esté lleno.
 * ◦ Desaparcar: Muestra la matrícula del coche a desaparcar o bien un mensaje
 * informando cadena vacía si el parking está vacío.
 * ◦ Mostrar la lista de las matrículas de los coches que hay en el parking, por
 * orden
 * inverso al de llegada, es decir primero el último en llegar
 * Nota: Usa los métodos que meten y sacan por el principio de la lista:
 * addFirst,
 * removeFirst
 * 
 */

public class Parking {
    private static LinkedList<String> parking = new LinkedList<>();

    public void aparcar(String matriucla) {
        if (parking.size() < 10)
            parking.addFirst(matriucla);
        else
            System.out.println("Parking lleno");
    }

    public void desaparcar() {
        if (!parking.isEmpty())
            System.out.println("Matricula que sale: " + parking.removeFirst());
        else
            System.out.println("El parking esta vacio");

    }

    public void mostrarMatriculas() {
        if (parking.isEmpty())
            System.out.println("El parking esta vacio");
        for (String string : parking) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        Parking parking = new Parking();
        Scanner scanner = new Scanner(System.in);
        String opcion = "";
        do {
            System.out.println("""
                    1.Aparcar
                    2.Desaparcar
                    3.Mostrar matriculas
                    4.Salir
                    """);

            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> {
                    System.out.println("Ingresa tu matricula");
                    String matricula = scanner.nextLine();
                    parking.aparcar(matricula);
                }

                case "2" -> parking.desaparcar();

                case "3" -> parking.mostrarMatriculas();

                case "4" -> System.out.println("Saliendo...");

                default -> System.out.println("Opcion invalida");
            }
        } while (!opcion.equals("4"));

    }
}
