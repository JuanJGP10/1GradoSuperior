package programacion.tema9.MaratonEjercicios.ej920;

import java.util.ArrayList;
import java.util.Scanner;

import programacion.nomeacuerdo.nomeacuerdo;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<VehiculosGeneral> lista = new ArrayList<>();
        Parking parking = new Parking(100, lista);
        String opcion = "";
        do {
            System.out.println("""
                    1. Entrada de un vehiculo
                    2. Salida de vehiculo
                    3. Mostrar vehiculos
                    """);
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    VehiculosGeneral vehiculo = entradaVehiculo();
                    parking.getParking().add(vehiculo);
                    break;
                case "2":
                    salidaVehiculo();
                    break;

                case "3":
                    mostrarVehiculos(parking.getParking());
                    break;
                case "4":
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Entrada no esperada");
                    break;
            }
        } while (!opcion.equals("4"));
    }

    private static void mostrarVehiculos(ArrayList<VehiculosGeneral> lista) {
        for (VehiculosGeneral vehiculosGeneral : lista) {
            System.out.println(vehiculosGeneral);
        }
    }

    private static void salidaVehiculo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salidaVehiculo'");
    }

    private static VehiculosGeneral entradaVehiculo() {
        VehiculosGeneral vehiculo = null;
        String opcion = "";
        do {
            System.out.println("""
                    1.Vehiculo general
                    2.Furgoneta
                    3.Autobus
                    """);

            System.out.println("Que vehiculo es:");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Matricula: ");
                    String matricula = scanner.nextLine();
                    vehiculo = new VehiculosGeneral(matricula);
                    break;
                case "2":
                    System.out.println("Matricula: ");
                    String matricula1 = scanner.nextLine();
                    System.out.println("Longitud de furgoneta");
                    double longitud = nomeacuerdo.pedirDouble();
                    vehiculo = new Furgonetas(matricula1, longitud);
                    break;

                case "3":
                    System.out.println("Matricula: ");
                    String matricula2 = scanner.nextLine();
                    System.out.println("Cuantos asientos tiene?:");
                    int asientos = nomeacuerdo.pedirInt();
                    vehiculo = new Autobuses(matricula2, asientos);
                    break;

                default:
                    System.out.println("Entrada no esperada");
                    break;

            }
            return vehiculo;
        } while (!opcion.equals("1") && !opcion.equals("3") && !opcion.equals("2"));

    }
}
