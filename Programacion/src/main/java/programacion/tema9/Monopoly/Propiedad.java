package programacion.tema9.Monopoly;

public abstract class Propiedad extends Casilla {
    protected final int precio;
    protected final int hipoteca;
    private int propietario;

    public Propiedad(String nombre, int precio, int hipoteca) {
        super(nombre);
        this.precio = precio;
        this.hipoteca = hipoteca;
        this.propietario = -1;
    }

    public int getPropietario() {
        return propietario;
    }

    public abstract int getAlquiler(int modificador);

    public void setPropietario(int propietario) {
        this.propietario = propietario;
    }
}
