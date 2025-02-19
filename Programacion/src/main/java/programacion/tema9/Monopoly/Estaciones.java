package programacion.tema9.Monopoly;

public class Estaciones extends Propiedad {
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
}