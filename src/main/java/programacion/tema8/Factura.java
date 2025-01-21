package programacion.tema8;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Factura {

    private int identificador;
    private LocalDateTime fechaFactura;
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
        this.fechaFactura = LocalDateTime.now();
        this.lineas = new ArrayList<>();
    }

    public void añadirLinea(String descripcion, int precioUnitario, int unidades) {
        double descuento = 0;
        if (unidades > 10) {
            descuento = 0.05;
        }
        LineaFactura linea = new LineaFactura(descripcion, precioUnitario, unidades, descuento);
        importeTotal += linea.getImporteTotalLinea();
        lineas.add(linea);

    }

    public void eliminarLinea(int numeroLinea) {
        if (numeroLinea > 0 && numeroLinea < lineas.size())
            lineas.remove(numeroLinea - 1);
        for (int i = 0; i < lineas.size(); i++) {

        }
        importeTotal -= lineas.get(numeroLinea - 1).getImporteTotalLinea();
    }

    @Override
    public String toString() {
        return "Factura [" + identificador + "]\nfechaFactura=" + fechaFactura + "\nnumeroCliente="
                + numeroCliente + "\nimporteTotal=" + importeTotal + "$\nlineas=" + lineas + "]";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Factura factura1 = new Factura(1, 1);
        factura1.añadirLinea("Mesa", 20, 20);
        factura1.añadirLinea("Silla", 15, 20);
        factura1.añadirLinea("Libro", 10, 10);
        System.out.println(factura1);
        scanner.close();
    }

}
