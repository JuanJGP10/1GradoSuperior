package programacion.tema9.Monopoly;

public class Terreno extends Propiedad {
    private ColorTerreno color;
    private double precioAlquiler;

    public Terreno(String nombre, int precio, int hipoteca, int propietario, ColorTerreno color,
            double precioAlquiler) {
        super(nombre, precio, hipoteca, propietario);
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

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    @Override
    public int getAlquiler(int modificador) {

        return 0;
    }

}
