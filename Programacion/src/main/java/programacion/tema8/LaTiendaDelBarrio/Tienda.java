package programacion.tema8.LaTiendaDelBarrio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Tienda {
    static Scanner scanner = new Scanner(System.in);

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
        System.out.println("Que articulo deseas eliminar (numero de identificador)");
        int identificador = pediridentificador(articulos);
        Iterator<Articulo> buscarPorIdentificador = articulos.iterator();
        while (buscarPorIdentificador.hasNext()) {
            if (buscarPorIdentificador.next().getArticuloIdentificador() == (identificador)) {
                buscarPorIdentificador.remove();
            }
        }
    }

    private static void editarArticulo(ArrayList<Articulo> articulos) {
        System.out.println("Que articulo deseas editar (numero de identificador)");
        int identificador = pediridentificador(articulos);

        System.out.println("Dame el precio de venta al publico:");
        double precioV = pedirPrecio();
        System.out.println("Dame el precio de compra al proovedor:");
        double precioC = pedirPrecio();
        System.out.println("Dame el stock actual del articulo:");
        int stock = pedirCantidad();
        // Buscamos por identificador
        Iterator<Articulo> buscarPorIdentificador = articulos.iterator();

        while (buscarPorIdentificador.hasNext()) {
            Articulo articuloTemp = buscarPorIdentificador.next();
            if (articuloTemp.getArticuloIdentificador() == (identificador)) {
                articuloTemp.setArticuloPrecioCompraProovedor(precioC);
                articuloTemp.setArticuloPrecioVenta(precioV);
                articuloTemp.setArticuloStock(stock);
            }
        }

        // Opcion no viable porque se crea un nuvo id y nombre y son final y para
        // mantener los anteriores pues no se puede
        // Articulo articulo = new Articulo(nombre, precioV, precioC, stock);
        // articulos.set((identificador), articulo);

    }

    private static void añadirArticulo(ArrayList<Articulo> articulos) {
        System.out.println("Dame el nombre del articulo:");
        String nombre = scanner.nextLine();
        System.out.println("Dame el precio de venta al publico:");
        double precioV = pedirPrecio();
        System.out.println("Dame el precio de compra al proovedor:");
        double precioC = pedirPrecio();
        System.out.println("Dame el stock actual del articulo:");
        int stock = pedirCantidad();

        Articulo articulo = new Articulo(nombre, precioV, precioC, stock);
        articulos.add(articulo);
    }

    private static String submenu() {
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
        System.out.println("Nombre del proveedor:");
        String nombreProveedor = scanner.nextLine();
        System.out.println("Cuantos articulos quieres comprar a " + nombreProveedor + " ?:");
        int numeroArt = pedirCantidad();
        int identificador = 0;
        int cantidad = 0;
        double precioFinal = 0;
        ArrayList<Integer> identificadores = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();

        for (int i = 1; i <= numeroArt; i++) {

            System.out.println("Articulo " + i);
            System.out.println("identificador:");
            identificador = pediridentificador(articulos);
            System.out.println("Cantidad:");
            cantidad = pedirCantidad();

            Iterator<Articulo> buscarPorIdentificador = articulos.iterator();

            while (buscarPorIdentificador.hasNext()) {
                Articulo articuloTemp = buscarPorIdentificador.next();
                if (articuloTemp.getArticuloIdentificador() == (identificador)) {
                    precioFinal += cantidad * (articuloTemp.getArticuloPrecioCompraProovedor() * (Articulo.IVA + 1));
                }
            }

            identificadores.add(identificador);
            cantidades.add(cantidad);

        }

        System.out.printf("""
                El precio final sera: %.2f
                Desea realizar esta compra?:
                """, precioFinal);

        String opcion = scanner.nextLine();

        if (opcion.equalsIgnoreCase("si")) {

            for (int i = 0; i < identificadores.size(); i++) {

                Iterator<Articulo> buscarPorIdentificador = articulos.iterator();

                while (buscarPorIdentificador.hasNext()) {
                    Articulo articuloTemp = buscarPorIdentificador.next();
                    if (articuloTemp.getArticuloIdentificador() == (identificadores.get(i))) {
                        int cantidadSumarStock = cantidades.get(i);
                        Articulo articulo = articuloTemp;
                        articulo.comprar(cantidadSumarStock);

                    }
                }

            }

            System.out.println("Venta realizada con exito");

        } else {

            System.out.println("Venta cancelada");

        }
    }

    // ------------------------------------------------------------------------//
    private static void realizarVenta(ArrayList<Articulo> articulos) {

        System.out.println("Nombre del cliente:");
        String nombreCliente = scanner.nextLine();
        System.out.println("Cuantos articulos quieres comprar " + nombreCliente + " ?:");
        int numeroArt = pedirCantidad();
        int identificador = 0;
        int cantidad = 0;
        double precioFinal = 0;
        ArrayList<Integer> identificadores = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();

        for (int i = 1; i <= numeroArt; i++) {

            System.out.println("Articulo " + i);
            System.out.println("identificador:");
            identificador = pediridentificador(articulos);
            System.out.println("Cantidad:");
            cantidad = pedirCantidad();

            Iterator<Articulo> buscarPorIdentificador = articulos.iterator();

            while (buscarPorIdentificador.hasNext()) {
                Articulo articuloTemp = buscarPorIdentificador.next();
                if (articuloTemp.getArticuloIdentificador() == (identificador)) {
                    precioFinal += cantidad * (articuloTemp.getArticuloPrecioVenta() * (Articulo.IVA + 1));
                }
            }

            identificadores.add(identificador);
            cantidades.add(cantidad);

        }

        System.out.printf("""
                El precio final sera: %.2f
                Desea realizar esta compra?:
                """, precioFinal);

        String opcion = scanner.nextLine();

        if (opcion.equalsIgnoreCase("si")) {

            for (int i = 0; i < identificadores.size(); i++) {

                Iterator<Articulo> buscarPorIdentificador = articulos.iterator();

                while (buscarPorIdentificador.hasNext()) {
                    Articulo articuloTemp = buscarPorIdentificador.next();
                    if (articuloTemp.getArticuloIdentificador() == (identificadores.get(i))) {
                        int cantidadRestarStock = cantidades.get(i);
                        // Articulo articulo = articulos.get(identificadores.get(i));
                        Articulo articulo = articuloTemp;
                        articulo.vender(cantidadRestarStock);

                    }
                }
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

    public static double pedirPrecio() {
        String precio;
        System.out.println("Formato numero decimal (puede o no tener comas)");
        do {
            precio = scanner.nextLine();
        } while (!precio.matches("\\d+([,]\\d+)?"));
        precio = precio.replace(',', '.');
        return Double.parseDouble(precio);
    }

    public static int pedirCantidad() {
        String cantidad;
        System.out.println("Formato numero entero");
        do {
            cantidad = scanner.nextLine();
        } while (!cantidad.matches("\\d+"));
        return Integer.parseInt(cantidad);
    }

    public static int pediridentificador(ArrayList<Articulo> articulos) {
        String identificador;
        System.out.println("Escribe el identificador del articulo (seguire preguntando si no es valido)");
        do {
            identificador = scanner.nextLine();
        } while (!identificador.matches("\\d+") || (Integer.parseInt(identificador)) < 0
                || (Integer.parseInt(identificador)) > (articulos.size() + 1));
        return Integer.parseInt(identificador);
    }
}
