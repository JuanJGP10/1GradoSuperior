package programacion.tema11.Ejercicios.ejercicio6;

import java.util.HashMap;
import java.util.Scanner;

import programacion.nomeacuerdo.nomeacuerdo;

public class Equipo {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String, Double> hashMap = new HashMap<>(25);
        String opcion = "";

        do {
            System.out.println("""
                    1.Añadir jugador
                    2.Eliminar jugador
                    3.Consultar salario de jugador
                    4.Incrementar salario a un jugador un 10 %
                    """);
            System.out.println("Opcion: ");
            opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    añadirJugador(hashMap);
                    break;
                case "2":
                    eliminarJugador(hashMap);
                    break;

                case "3":
                    consultarSalarioJugador(hashMap);
                    break;

                case "4":
                    incrementarSalarioJugador(hashMap);
                    break;

                case "5":
                    System.out.println("Saliendo....");
                    break;

                default:
                    break;
            }
        } while (!opcion.equals("5"));
    }

    private static void incrementarSalarioJugador(HashMap<String, Double> hashMap) {
        System.out.println("Que jugador quieres incrementar el salario: ");
        String nombre = scanner.nextLine();

        if (hashMap.containsKey(nombre)) {
            System.out.println("Salario del jugador: " + hashMap.get(nombre) + " Salario nuevo del jugador: ");
            hashMap.put(nombre, (hashMap.get(nombre) * 1.10));
            System.out.println("Salario nuevo del jugador: " + hashMap.get(nombre));
        }

    }

    private static void consultarSalarioJugador(HashMap<String, Double> hashMap) {
        System.out.println("Que jugador quieres ver el salario: ");
        String nombre = scanner.nextLine();

        if (hashMap.containsKey(nombre))
            System.out.println("Salario del jugador: " + hashMap.get(nombre));
    }

    private static void eliminarJugador(HashMap<String, Double> hashMap) {
        System.out.println("Que jugador quieres eliminar: ");
        String nombre = scanner.nextLine();

        if (hashMap.containsKey(nombre)) {
            hashMap.remove(nombre);
            System.out.println("Eliminado correctamente");
        }

    }

    private static void añadirJugador(HashMap<String, Double> hashMap) {
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Salario: ");
        double salario = nomeacuerdo.pedirDouble();
        hashMap.put(nombre, salario);
        System.out.println("Agregado correctamente!");
    }
}
