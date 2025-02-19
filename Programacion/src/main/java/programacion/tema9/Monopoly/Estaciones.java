package programacion.tema9.Monopoly;

public class Estaciones extends Propiedad implements Comprable {
    private static int VALOR_ESTACION = 100;

    public Estaciones(String nombre) {
        super(nombre, VALOR_ESTACION, VALOR_ESTACION);
    }

    @Override
    public int getAlquiler(int modificador) {
        return precio / modificador;
    }

    @Override
    public String toString() {
        return String.format(
                "Terreno {Nombre: %s, Código: %s, Precio: %d, Hipoteca: %d}",
                getNombre(), getCodigo(), precio, hipoteca);
    }

    @Override
    public void comprar(int i) {
        if (this.getPropietario() == -1) {
            setPropietario(i);
        }
    }
}