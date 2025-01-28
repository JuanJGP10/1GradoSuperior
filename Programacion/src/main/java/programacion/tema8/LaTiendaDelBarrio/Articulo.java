package programacion.tema8.LaTiendaDelBarrio;

public class Articulo {

    private final int articuloIdentificador;
    private final String articuloNombre;
    private double articuloPrecioVenta;
    private double articuloPrecioCompraProovedor;
    public static final double IVA = 0.21;
    private int articuloStock;
    public static int contadorIdent = 1;

    /**
     * Constructor de articulos
     * 
     * @param nombre       articulo
     * @param precioVenta  articulo
     * @param precioCompra articulo
     * @param stock        articulo
     */
    public Articulo(String nombre, double precioVenta, double precioCompra, int stock) {
        this.articuloIdentificador = contadorIdent;
        contadorIdent++;

        this.articuloNombre = nombre;
        setArticuloPrecioVenta(precioVenta);
        setArticuloPrecioCompraProovedor(precioCompra);
        setArticuloStock(stock);
    }

    public int getArticuloIdentificador() {
        return articuloIdentificador;
    }

    public String getArticuloNombre() {
        return articuloNombre;
    }

    public double getArticuloPrecioVenta() {
        return articuloPrecioVenta;
    }

    public void setArticuloPrecioVenta(double articuloPrecioVenta) {
        if (articuloPrecioVenta > articuloPrecioCompraProovedor && articuloPrecioVenta > 0)
            this.articuloPrecioVenta = articuloPrecioVenta;
        else
            System.err.println("Error al establecer el precio de venta");
    }

    public double getArticuloPrecioCompraProovedor() {
        return articuloPrecioCompraProovedor;
    }

    public void setArticuloPrecioCompraProovedor(double articuloPrecioCompraProovedor) {
        if (articuloPrecioCompraProovedor < articuloPrecioVenta && articuloPrecioCompraProovedor > 0)
            this.articuloPrecioCompraProovedor = articuloPrecioCompraProovedor;
        else
            System.err.println("Error al establecer el precio de compra");
    }

    public int getArticuloStock() {
        return articuloStock;
    }

    public void setArticuloStock(int articuloStock) {
        if (articuloStock >= 0)
            this.articuloStock = articuloStock;
        else
            System.err.println("Error al establecer el stock del articulo");
    }

    public int vender(int unidades) {
        if (unidades > 0 && unidades <= articuloStock) {
            this.articuloStock -= unidades;
            return 1;
        } else {
            System.err.println("No ha sido posible realizar la operacion");
            return 0;
        }
    }

    public int comprar(int unidades) {
        if (unidades > 0) {
            this.articuloStock += unidades;
            return 1;
        } else {
            System.err.println("No ha sido posible realizar la operacion");
            return 0;
        }

    }

    @Override
    public String toString() {

        return String
                .format("""
                        Identificador: %d | Nombre: %s | Precio de venta: %.2f | Precio de compra: %.2f | IVA: %.2f | Stock: %d
                        """,
                        articuloIdentificador, articuloNombre, articuloPrecioVenta, articuloPrecioCompraProovedor, IVA,
                        articuloStock);
    }

}
