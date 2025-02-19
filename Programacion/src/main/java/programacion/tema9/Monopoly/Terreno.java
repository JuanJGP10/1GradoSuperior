package programacion.tema9.Monopoly;

public class Terreno extends Propiedad implements Comprable {
    private ColorTerreno color;
    private int precioAlquiler;

    public Terreno(String nombre, int precio, int hipoteca, ColorTerreno color,
            int precioAlquiler) {
        super(nombre, precio, hipoteca);
        this.color = color;
        this.precioAlquiler = precioAlquiler;
    }

    public ColorTerreno getColor() {
        return color;
    }

    public void setColor(ColorTerreno color) {
        this.color = color;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    @Override
    public int getAlquiler(int modificador) {
        int suplemento = 1;
        if (modificador > 4) {
            return precioAlquiler * 10;
        } else {
            suplemento = modificador * precioAlquiler;
            return precioAlquiler + suplemento;
        }

    }

    @Override
    public String toString() {
        return String.format(
                "Terreno {Nombre: %s, Código: %s, Color: %s, Precio: %d, Precio Alquiler: %d, Hipoteca: %d}",
                getNombre(), getCodigo(), getColor(), precio, precioAlquiler, hipoteca);
    }

    @Override
    public void comprar(int i) {
        if (this.getPropietario() == -1) {
            setPropietario(i);
        }
    }

}
