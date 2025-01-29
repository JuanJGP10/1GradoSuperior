package programacion.tema8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListEjercicio8 {

}

class Articulo {
    // Variables de la clase
    private static int contadorIdentificadores = 0;

    // Atirbutos del objeto
    private final int identificador;
    private final String nombre;
    private double precioCliente;
    private double precioProveedor;
    private int stock;
    private final int IVA = 21;// No lo pongo estático porque en una parte del enunciado se le menciona como
                               // 'información sobre dicho artículo'

    public Articulo(String nombre, double precioCliente, double precioProveedor, int stock) {
        // Comprobaciones:
        if (nombre == null || nombre.isEmpty()) {
            System.err.println("El nombre no puede ser un valor nulo o vació. Se le asignara 'Anonimo' por defecto");
            nombre = "Anonimo";
        }
        if (precioCliente <= 0) {
            System.err.println("El precio del cliente debe ser mayor a 0. Se le asignara '1' por defecto");
            precioCliente = 1.0;
        }
        if (precioProveedor <= 0 || precioProveedor >= precioCliente) {
            System.err.println(
                    "El precio del proveedor debe ser mayor a 0 y mayor al precio del cliente. Se le asignara '-1' al precio del cliente");
            precioProveedor = precioCliente - 1.0;
        }
        if (stock < 0) {
            System.err.println("El stock debe ser mayor o igual a 0. Se le asignara '0' por defecto");
            stock = 0;
        }
        // Asignaciones
        this.identificador = ++contadorIdentificadores;
        this.nombre = nombre;
        this.precioCliente = precioCliente;
        this.precioProveedor = precioProveedor;
        this.stock = stock;
    }
    // Getters y Setters con sus comprobaciones

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIVA() {
        return IVA;
    }

    public double getPrecioCliente() {
        return precioCliente;
    }

    public void setPrecioCliente(double precioCliente) {
        if (precioCliente > 0 && precioCliente > this.precioProveedor) {
            this.precioCliente = precioCliente;
        } else
            System.err.println("Debes escribir un precio mayor a 0 y menor al precio del proveedor");
    }

    public double getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(double precioProveedor) {
        if (precioProveedor > 0 && this.precioCliente > precioProveedor) {
            this.precioProveedor = precioProveedor;
        } else
            System.err.println("Debes escribir un precio mayor a 0 y menor al precio del cliente");
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else
            System.err.println("El stock debe ser mayor o igual a 0. Se le asignara '0' por defecto");

    }

    /**
     * Deberá tener al menos dos métodos públicos, uno para vender (a cliente) y
     * otro
     * para comprar (a proveedor). En ambos casos deberá pasarse un único argumento
     * con la cantidad de unidades a vender o comprar, y se devolverá un valor
     * indicando
     * si fue posible realizar la operación o no. Si la operación se puede realizar,
     * se
     * deberá modificar el stock del artículo.
     */
    public boolean vender(int cantidad) {
        if (this.stock >= cantidad) {
            this.stock -= cantidad;
            return true;
        } else
            return false;
    }

    public boolean comprar(int cantidad) {
        if (cantidad > 0) {
            this.stock += cantidad;
            return true;
        } else
            return false;
    }

    /**
     * Deberá tener un método público que devuelva una cadena de texto de una sola
     * línea con la información sobre dicho artículo: id, nombre, precios, IVA y
     * stock.
     */

    @Override
    public String toString() {
        return "ID " + identificador + " -> Nombre=" + nombre + ", precioCliente=" + precioCliente
                + ", precioProveedor=" + precioProveedor + ", stock=" + stock + ", IVA=" + IVA;
    }
    // Pueden implementarse otros métodos si se considera necesario. (No lo
    // considero)
}

class Tienda {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Articulo> articulos = new ArrayList<>();
        char opcion = 'x';
        do {
            System.out.println("""
                    1. Mostrar artículos.
                    2. Venta a cliente.
                    3. Compra a proveedor.
                    4. Gestionar artículos.
                    5. Salir.""");
            opcion = teclado.nextLine().charAt(0);
            switch (opcion) {
                case '1':
                    for (Articulo articulo : articulos) {
                        System.out.println(articulo);
                    }
                    break;
                case '2':// sin el break se hará el caso 3
                case '3':
                    // pido los datos
                    ArrayList<Object> datos = pedirDatos(articulos);
                    // muestro transaccion
                    muestroTransaccion(opcion, datos, articulos);

                    System.out.println("Desea continuar? pulse 1 delo contrario pulse lo que sea menos 1");
                    String continuar = teclado.nextLine();
                    if (continuar.equals("1")) {
                        articulos = realizoTransaccion(opcion, datos, articulos);
                    } else
                        System.out.println("Se fini");
                    break;
                case '4':
                    char opcion2 = 'x';
                    do {
                        System.out.println("""
                                1. Añadir artículo
                                2.Editar artículo
                                3. Eliminar artículo
                                4. Volver""");
                        opcion2 = teclado.nextLine().charAt(0);
                        switch (opcion2) {
                            case '1':
                                System.out.println("Nombre de tu articulo");
                                String nombre = teclado.nextLine();
                                System.out.println("Precio para los clientes");
                                double precioCliente = pedirPrecio();
                                System.out.println("Dime el precio para del proveedor (Formato número)");
                                System.out.println("Precio para el proveedor");
                                double precioProveedor = pedirPrecio();
                                String stock;
                                do {
                                    System.out.println("Dime el stock (Formato número)");
                                    stock = teclado.nextLine();
                                } while (!stock.matches("\\d+"));
                                articulos.add(
                                        new Articulo(nombre, precioCliente, precioProveedor, Integer.parseInt(stock)));
                                break;
                            case '2':
                                int id3;
                                char opcion3 = 'x';
                                do {
                                    System.out.println("""
                                            1.Editar precioCliente
                                            2.Editar precioProveedor
                                            3.Editar stock
                                            4.Volver""");
                                    opcion3 = teclado.nextLine().charAt(0);
                                    switch (opcion3) {
                                        case '1':
                                            id3 = pedirId(articulos);
                                            double precio = pedirPrecio();
                                            articulos.get(id3).setPrecioCliente(precio);
                                            break;
                                        case '2':
                                            id3 = pedirId(articulos);
                                            double precio2 = pedirPrecio();
                                            articulos.get(id3).setPrecioProveedor(precio2);
                                            break;
                                        case '3':
                                            id3 = pedirId(articulos);
                                            articulos.remove(id3);
                                            break;
                                        case '4':
                                            System.out.println("volviendo");
                                            break;
                                        default:
                                            System.err.println("Tu imprimes folios en blanco para tener mas");
                                            break;
                                    }
                                } while (opcion3 != 4);
                                break;
                            case '3':
                                System.out.println("Dime que el id del articulo que quieres eliminar");
                                String eliminacion = teclado.nextLine();
                                boolean encontrado = false;
                                if (eliminacion.matches("\\d+")) {
                                    Iterator<Articulo> buscarPorId = articulos.iterator();
                                    while (buscarPorId.hasNext()) {
                                        if (buscarPorId.next().getIdentificador() == Integer.parseInt(eliminacion)) {
                                            buscarPorId.remove();////////////////// IMPORTANTE///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                            encontrado = true;
                                        }
                                    }
                                    if (encontrado)
                                        System.out.println("Eliminado correctamente");
                                    else
                                        System.out.println(
                                                "No esta esa id entre los artículos, compruébelo viendo la lista");
                                } else
                                    System.out.println("Escribe el número en formato número");
                            case '4':
                                System.out.println("Saliendo");
                                break;
                            default:
                                System.out.println("opciones validas 1-4");
                                break;
                        }
                    } while (opcion2 != '4');
                    break;
                case '5':
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("opciones validas 1-5");
                    break;
            }
        } while (opcion != '5');
    }

    public static void muestroTransaccion(int opcion, ArrayList<Object> datos, ArrayList<Articulo> articulos) {
        double transaccion = 0;
        if (opcion == 2) {
            ArrayList<Integer> ids = (ArrayList<Integer>) datos.get(1);
            ArrayList<Integer> cantidad = (ArrayList<Integer>) datos.get(2);
            System.out.println("Usuario :" + (String) datos.get(0) + " la suma de la transacción asciende a: ");
            int contadorCantidades = 0;
            Iterator<Integer> valorIds = ids.iterator();
            while (valorIds.hasNext()) {
                transaccion += articulos.get(valorIds.next()).getPrecioCliente() * cantidad.get(contadorCantidades++);
            }
            System.out.println(transaccion + "€");

        } else {// solo cambio getPrecioProveedor()
            ArrayList<Integer> ids = (ArrayList<Integer>) datos.get(1);
            ArrayList<Integer> cantidad = (ArrayList<Integer>) datos.get(2);
            System.out.println("Usuario :" + (String) datos.get(0) + " la suma de la transacción asciende a: ");
            int contadorCantidades = 0;
            Iterator<Integer> valorIds = ids.iterator();
            while (valorIds.hasNext()) {
                transaccion += articulos.get(valorIds.next()).getPrecioProveedor() * cantidad.get(contadorCantidades++);
            }
            System.out.println(transaccion + "euros");
        }
    }

    public static ArrayList<Articulo> realizoTransaccion(int opcion, ArrayList<Object> datos,
            ArrayList<Articulo> articulos) {
        int transaccionCorrecta = 0, transaccionIncorrecta = 0;
        ArrayList<Integer> ids = (ArrayList<Integer>) datos.get(1);
        ArrayList<Integer> cantidad = (ArrayList<Integer>) datos.get(2);

        for (int i = 0; i < ids.size(); i++) {
            int cantidadArticulo = cantidad.get(i);
            Articulo articulo = null;
            for (Articulo art : articulos) {// Busco si esa id existe
                if (art.getIdentificador() == ids.get(i))
                    articulo = art;
            }
            if (articulo != null) {// si existe vendo o compro segun la opción introducida.
                boolean operacionExitosa = (opcion == '2') ? articulo.vender(cantidadArticulo)
                        : articulo.comprar(cantidadArticulo);
                if (operacionExitosa) {
                    transaccionCorrecta++;
                } else {
                    transaccionIncorrecta++;
                }
            }
        }

        System.out.println("Transacciones correctas: " + transaccionCorrecta);
        System.out.println("Transacciones incorrectas: " + transaccionIncorrecta);

        return articulos;
    }

    public static int pedirId(ArrayList<Articulo> articulos) {
        String idStr;
        do {
            System.out.println(
                    "Escriba el id del articulo, longitud: del 1 al " + articulos.size() + " Formato numérico");
            idStr = teclado.nextLine();
        } while (!idStr.matches("\\d+") || (Integer.parseInt(idStr) - 1) < 0
                || (Integer.parseInt(idStr) - 1) > articulos.size());
        return Integer.parseInt(idStr) - 1;
    }

    public static int pedirCantidad(ArrayList<Articulo> articulos) {
        String cantidad;
        do {
            System.out.println("Escriba la cantidad que quiere comprar. Formato númerico");
            cantidad = teclado.nextLine();
        } while (!cantidad.matches("\\d+"));
        return Integer.parseInt(cantidad);
    }

    public static ArrayList<Object> pedirDatos(ArrayList<Articulo> articulos) {
        ArrayList prime = new ArrayList<>();
        System.out.println("Introduce el nombre");
        String nombre = teclado.nextLine();
        prime.add(nombre);
        char opcion4 = 'x';
        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<Integer> cantiades = new ArrayList<>();

        do {
            System.out.println("""
                    1. Introducir nuevo producto
                    2. Volver""");
            opcion4 = teclado.nextLine().charAt(0);
            switch (opcion4) {
                case '1':
                    ids.add(pedirId(articulos));
                    cantiades.add(pedirCantidad(articulos));
                    break;
                case '2':
                    System.out.println("Volviendo..");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion4 != '2');
        prime.add(ids);
        prime.add(cantiades);
        return prime;

    }

    public static double pedirPrecio() {
        String precio;
        do {
            System.out.println("Dime un numero(puede ser decimal)");
            precio = teclado.nextLine();
        } while (!precio.matches("\\d+([,]\\d+)?"));
        precio = precio.replace(',', '.');
        return Double.parseDouble(precio);
    }
}