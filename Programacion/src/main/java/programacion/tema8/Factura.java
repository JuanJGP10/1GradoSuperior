package programacion.tema8;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Factura {

    private int identificador;
    private LocalDate fechaFactura;
    private int numeroCliente;
    private static final double iva = 0.21;
    private double importeTotal = 0;
    private ArrayList<LineaFactura> lineas;

    /**
     * Constructor Factura
     * 
     * @param identificador
     * @param numeroCliente
     */
    public Factura(int identificador, int numeroCliente) {
        this.identificador = identificador;

        this.numeroCliente = numeroCliente;

        this.fechaFactura = LocalDate.now();
        this.lineas = new ArrayList<LineaFactura>();
    }

    public void añadirLinea(String descripcion, int precioUnitario, int unidades) {

        LineaFactura linea = new LineaFactura(descripcion, precioUnitario, unidades);
        importeTotal += linea.getImporteTotalLinea();
        lineas.add(linea);

    }

    public void eliminarLinea(int numeroLinea) {
        if (numeroLinea > 0 && numeroLinea <= lineas.size()) {
            importeTotal -= lineas.get(numeroLinea - 1).getImporteTotalLinea();
            lineas.remove(numeroLinea - 1);
        }

    }

    public void imprimirFactura() {
        double importeTotalconIva = importeTotal * 1.21;
        System.out.println(
                "*********************************************************************************************");
        System.out.println("                                        FACTURA             ");
        System.out.println(
                "*********************************************************************************************");
        System.out.println("Número de Factura: " + identificador);
        System.out.println("Fecha: " + fechaFactura);
        System.out.println("Cliente: " + numeroCliente);
        System.out
                .println(
                        "-----------------------------------------------------------------------------------------------");
        System.out.println(lineas);
        System.out
                .println(
                        "-----------------------------------------------------------------------------------------------");
        System.out.printf("IVA (21%%):                                                                  %.2f\n", iva);
        System.out.printf("TOTAL:                                                                      %.2f\n",
                importeTotalconIva);
        System.out
                .println(
                        "***********************************************************************************************");
        System.out.println("                                ¡Gracias por su compra! ");
    }

    @Override
    public String toString() {
        return "Factura [" + identificador + "]\nfechaFactura=" + fechaFactura + "\nnumeroCliente="
                + numeroCliente + "\nimporteTotal=" + importeTotal + "$\nlineas=" + lineas;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int entrada = 0;
        Factura factura = new Factura(1000, 1000);
        boolean existeF = false;
        do {
            System.out.println("1. Darse de alta");
            System.out.println("2. Añadir lineas");
            System.out.println("3. Eliminar lineas");
            System.out.println("4. Imprimir factura");
            System.out.println("5. Salir");
            entrada = scanner.nextInt();
            scanner.nextLine();

            switch (entrada) {
                case 1:
                    if (!existeF) {
                        existeF = true;
                        System.out.println("Identificador:");
                        int ident = scanner.nextInt();
                        System.out.println("Numero de cliente");
                        int numCl = scanner.nextInt();
                        factura = new Factura(ident, numCl);
                    } else {
                        System.out.println("Usted ya ha creado na factura");
                    }

                    break;
                case 2:
                    if (existeF) {
                        System.out.println("Descripcion de la linea");
                        String desc = scanner.nextLine();
                        System.out.println("Precio unitario");
                        int precioUni = scanner.nextInt();
                        System.out.println("Unidades");
                        int unidades = scanner.nextInt();
                        scanner.nextLine();
                        factura.añadirLinea(desc, precioUni, unidades);
                        break;
                    } else {
                        System.out.println("Crea la factura primero");
                        break;
                    }

                case 3:

                    if (existeF) {
                        System.out.println("Numero de linea a borrar (RANGO: " + factura.lineas.size() + ")");
                        int linea = scanner.nextInt();
                        factura.eliminarLinea(linea);
                        break;
                    } else {
                        System.out.println("Crea la factura primero");
                        break;
                    }

                case 4:
                    if (existeF) {
                        factura.imprimirFactura();
                        break;
                    } else {
                        System.out.println("Crea la factura primero");
                        break;
                    }

                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    break;
            }

        } while (entrada != 5);

        scanner.close();
    }

}
