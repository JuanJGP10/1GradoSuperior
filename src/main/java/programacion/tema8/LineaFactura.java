package programacion.tema8;

public class LineaFactura {
    private String descripcion;
    private double precioUnitario;
    private int unidades;
    private double descuento;
    private double importeTotalLinea;

    /**
     * Constructor LineaFactura
     * 
     * @param descripcion
     * @param precioUnitario
     * @param unidades
     * @param descuento
     */
    public LineaFactura(String descripcion, double precioUnitario, int unidades, double descuento) {
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.unidades = unidades;
        this.descuento = descuento;
        this.importeTotalLinea = (unidades * precioUnitario) - ((unidades * precioUnitario) * descuento);

    }

    public double getImporteTotalLinea() {
        return importeTotalLinea;
    }

    @Override
    public String toString() {
        return "[descripcion=" + descripcion + " precioUnitario=" + precioUnitario + " unidades="
                + unidades + " descuento=" + descuento + " importeTotalLinea=" + importeTotalLinea + "]\n";
    }

}