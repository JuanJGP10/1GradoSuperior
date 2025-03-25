package programacion.tema11.ejercicios_usando_lambda_v2;

import java.util.LinkedList;
import java.util.Scanner;

public class Ej1 {
    private LinkedList<String> matriculas = new LinkedList<>();

    public void aparcar(String matricula) {
        if (matriculas.size() < 10)
            matriculas.addFirst(matricula);
        else
            System.out.println("Parking lleno");
    }

    public void desaparcar() {
        if (matriculas.isEmpty())
            System.out.println("Parking vacio");
        else
            matriculas.removeFirst();
    }

    public void mostrarMatriculas() {
        matriculas.forEach((System.out::println));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ej1 e = new Ej1();
        String opcion = "";
        do {
            System.out.println("""
                    1.Aparcar
                    2.Desaparcar
                    3.Mostrar vehiculos
                    4.Salir
                    """);
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> e.aparcar(pedirMatricula());

                case "2" -> e.desaparcar();

                case "3" -> e.mostrarMatriculas();

                case "4" -> System.out.println("Saliendo...");

                default -> System.out.println("Entrada no esperada");
            }
        } while (!opcion.equals("4"));
    }

    public static String pedirMatricula() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Matricula:");
        String matricula = scanner.nextLine();

        return matricula;
    }
}
