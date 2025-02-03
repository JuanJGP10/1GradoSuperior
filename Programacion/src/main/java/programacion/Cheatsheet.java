package programacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import programacion.tema8.Factura.LineaFactura;

public class Cheatsheet {
    static Scanner scanner = new Scanner(System.in);
    // static: atributo comun a todas los objetos (es de la clase)
    private static int contadorIds = 0;
    // final: no se puede modificar
    private final String nombre;
    private final int identificador;
    // private: no se puede ver fuera del paquete
    private int dineros;
    // Arraylist
    private ArrayList<Integer> lineas;
    // Fecha
    private final LocalDate fecha;

    //
    // Constructor se hace asi:
    //

    public Cheatsheet(String nombre, int dineros) {
        this.nombre = nombre;
        this.dineros = dineros;
        this.identificador = contadorIds;
        contadorIds++;
        this.fecha = LocalDate.now();
        this.lineas = new ArrayList<Integer>();
    }

    //
    // Funciones para validar formatos
    //

    public static double pedirDouble() {
        String valor;

        System.out.println("Volvere a preguntar si no es un double");
        do {
            valor = scanner.nextLine();
        } while (!valor.matches("\\d+([,]\\d+)?"));
        valor = valor.replace(',', '.');
        return Double.parseDouble(valor);
    }

    public static int pedirInt() {
        String valor;

        System.out.println("Volvere a preguntar si no es un int");
        do {
            valor = scanner.nextLine();
        } while (!valor.matches("\\d+"));

        return Integer.parseInt(valor);
    }

    public static String pedirString() {
        String valor;

        System.out.println("Volvere a preguntar si no son solo letras");
        do {
            valor = scanner.nextLine();
        } while (!valor.matches("[A-za-z(\s)?]+"));

        return valor;
    }

    // Iterator para arraylists

    // Iterator<Objeto> nombreIterador = obejeto.iterator();
    // while (buscarPorIdentificador.hasNext()) {
    // Objeto objetoTemp = buscarPorIdentificador.next();
    //
    // }
    // }

    // COllections para frecuencias

    // Esto dentro de un for para que guarde ordenados los elementos
    // nt frecuencia = Collections.frequency(aleatorios, i);

    //  Al indice luego habria q sumarle 1 porque la lista empieza por 0 y n por 1
    // int indiceMAximo = frecuencias.indexOf(Collections.max(frecuencias));
}
