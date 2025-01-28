package programacion.tema8.LaTiendaDelBarrio;

import java.util.ArrayList;

import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        String opcion;
        String opcionSub;
        ArrayList<Articulo> articulos = new ArrayList<>();
        do {
            opcion = menu();
            switch (opcion) {
                case "1":
                    mostrarArticulos(articulos);
                    break;
                case "2":
                    realizarVenta(articulos);
                    break;
                case "3":
                    realizarCompra(articulos);
                    break;
                case "4":
                    do {
                        opcionSub = submenu();
                        switch (opcionSub) {
                            case "1":
                                añadirArticulo(articulos);
                                break;
                            case "2":
                                editarArticulo(articulos);
                                break;
                            case "3":
                                eliminarArticulo(articulos);
                                break;
                            case "4":
                                System.out.println("Volviendo......");
                                break;

                            default:
                                System.err.println("Error: entrada no esperada");
                                break;
                        }
                    } while (!opcionSub.equals("4"));

                    break;
                case "5":
                    System.out.println("Saliendo......");
                    break;

                default:
                    System.err.println("Error: entrada no esperada");
                    break;
            }
        } while (!opcion.equals("5"));
    }

    private static void eliminarArticulo(ArrayList<Articulo> articulos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que articulo deseas eliminar (numero de identificador)");
        int ident = scanner.nextInt();
        if (ident > 0 && ident < articulos.size()) {
            articulos.remove(ident - 1);
            Articulo.contadorIdent--;

        }

    }

    private static void editarArticulo(ArrayList<Articulo> articulos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que articulo deseas editar (numero de identificador)");
        int ident = scanner.nextInt();
        scanner.nextLine();
        if (ident > 0 && ident <= articulos.size()) {
            System.out.println("Dame el nombre del articulo:");
            String nombre = scanner.nextLine();
            System.out.println("Dame el precio de venta al publico:");
            double precioV = scanner.nextDouble();
            System.out.println("Dame el precio de compra al proovedor:");
            double precioC = scanner.nextDouble();
            System.out.println("Dame el stock actual del articulo:");
            int stock = scanner.nextInt();

            Articulo.contadorIdent--;
            Articulo articulo = new Articulo(nombre, precioV, precioC, stock);
            articulos.set((ident - 1), articulo);
        }

    }

    private static void añadirArticulo(ArrayList<Articulo> articulos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el nombre del articulo:");
        String nombre = scanner.nextLine();
        System.out.println("Dame el precio de venta al publico:");
        double precioV = scanner.nextDouble();
        System.out.println("Dame el precio de compra al proovedor:");
        double precioC = scanner.nextDouble();
        System.out.println("Dame el stock actual del articulo:");
        int stock = scanner.nextInt();

        Articulo articulo = new Articulo(nombre, precioV, precioC, stock);
        articulos.add(articulo);
    }

    private static String submenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1.Añadir articulo
                2.Editar articulo
                3.Eliminar articulo
                4.Volver
                """);
        String opcion = scanner.nextLine();
        return opcion;
    }

    private static void realizarCompra(ArrayList<Articulo> articulos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre del proveedor:");
        String nombreProveedor = scanner.nextLine();
        System.out.println("Cuantos articulos quieres comprar a " + nombreProveedor + " ?:");
        int numeroArt = scanner.nextInt();
        int ident = 0;
        int cantidad = 0;
        double precioFinal = 0;
        ArrayList<Integer> identificadores = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();

        for (int i = 1; i <= numeroArt; i++) {

            System.out.println("Articulo " + i);
            System.out.println("Identificador:");
            ident = scanner.nextInt();
            System.out.println("Cantidad:");
            cantidad = scanner.nextInt();
            scanner.nextLine();

            if (ident > 0 && ident <= articulos.size()) {

                identificadores.add(ident - 1);
                cantidades.add(cantidad);
                precioFinal += cantidad * articulos.get(ident - 1).getArticuloPrecioVenta();

            } else {

                System.out.println("El identificador no existe");
                break;

            }

        }

        System.out.printf("""
                El precio final sera: %.2f
                Desea realizar esta compra?:
                """, precioFinal + (precioFinal * Articulo.IVA));
        String opcion = scanner.nextLine();

        if (opcion.equalsIgnoreCase("si")) {

            for (int i = 0; i < identificadores.size(); i++) {

                int cantidadSumarStock = cantidades.get(i);
                Articulo articulo = articulos.get(identificadores.get(i));
                articulo.comprar(cantidadSumarStock);
            }

            System.out.println("Venta realizada con exito");

        } else {

            System.out.println("Venta cancelada");

        }
    }

    // ------------------------------------------------------------------------//
    private static void realizarVenta(ArrayList<Articulo> articulos) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre de cliente:");
        String nombreCliente = scanner.nextLine();
        System.out.println(nombreCliente + " cuantos articulos quieres comprar?:");
        int numeroArt = scanner.nextInt();
        int ident = 0;
        int cantidad = 0;
        double precioFinal = 0;
        ArrayList<Integer> identificadores = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();

        for (int i = 1; i <= numeroArt; i++) {

            System.out.println("Articulo " + i);
            System.out.println("Identificador:");
            ident = scanner.nextInt();
            System.out.println("Cantidad:");
            cantidad = scanner.nextInt();
            scanner.nextLine();

            if (ident > 0 && ident <= articulos.size()) {

                identificadores.add(ident - 1);
                cantidades.add(cantidad);
                precioFinal += cantidad * articulos.get(ident - 1).getArticuloPrecioVenta();

            } else {

                System.out.println("El identificador no existe");
                break;

            }

        }

        System.out.printf("""
                El precio final sera: %.2f
                Desea realizar esta compra?:
                """, precioFinal + (precioFinal * Articulo.IVA));
        String opcion = scanner.nextLine();

        if (opcion.equalsIgnoreCase("si")) {

            for (int i = 0; i < identificadores.size(); i++) {
                int cantidadRestarStock = cantidades.get(i);
                Articulo articulo = articulos.get(identificadores.get(i));
                articulo.vender(cantidadRestarStock);
            }

            System.out.println("Venta realizada con exito");

        } else {

            System.out.println("Venta cancelada");

        }
    }

    private static void mostrarArticulos(ArrayList<Articulo> articulos) {
        for (int i = 0; i < articulos.size(); i++) {
            System.out.println(articulos.get(i));
        }
    }

    // ----------------------------------------------------------------------//
    private static String menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1.Mostrar articulos
                2.Venta al cliente
                3.Compra a proveedor
                4.Gestionar articulos
                5.Salir
                """);
        String opcion = scanner.nextLine();

        return opcion;
    }
}
