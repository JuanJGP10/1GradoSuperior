package programacion.tema11.ejercicios_usando_lambda_v2;

import java.util.HashMap;
import java.util.Scanner;

import programacion.nomeacuerdo.nomeacuerdo;

public class Ej6 {
    public static void main(String[] args) {
        HashMap<String, Double> jugadores = new HashMap<>();
        String opcion = "";
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("""
                    1.Añadir jugador
                    2.eliminar jugador
                    3.Consultar salario
                    4.Incrementar salario
                    5.Salir
                    """);
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> añadirJugador(jugadores);

                case "2" -> eliminarJugador(jugadores);

                case "3" -> consultarSalario(jugadores);

                case "4" -> incrementarSalario(jugadores);

                case "5" -> System.out.println("Saliendo...");

                default -> System.out.println("Entrada no esperada...");
            }
        } while (!opcion.equals("5"));
    }

    public static String pedirNombre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre del jugador");
        String nombre = scanner.nextLine();

        return nombre;
    }

    public static void añadirJugador(HashMap<String, Double> jugadores) {
        System.out.println("Salario del jugador");
        double salario = nomeacuerdo.pedirDouble();
        jugadores.put(pedirNombre(), salario);

    }

    public static void eliminarJugador(HashMap<String, Double> jugadores) {
        String nombre = pedirNombre();
        jugadores.remove(nombre);
    }

    public static void consultarSalario(HashMap<String, Double> jugadores) {
        String nombre = pedirNombre();
        System.out.println("Nombre: " + nombre + " Salario: " + jugadores.getOrDefault(nombre, 0.0));
    }

    public static void incrementarSalario(HashMap<String, Double> jugadores) {
        String nombre = pedirNombre();
        jugadores.put(nombre, jugadores.get(nombre) * 1.1);
    }

}
