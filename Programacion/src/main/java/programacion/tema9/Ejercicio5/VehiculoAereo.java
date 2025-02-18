package programacion.tema9.Ejercicio5;

public class VehiculoAereo extends Vehiculo {
    private final int numAsientos;

    public VehiculoAereo(String matricula, String modelo, int numAsientos) {
        super(matricula, modelo);
        this.numAsientos = numAsientos;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Matricula: %s Modelo: %s Numero de asientos: %d
                """, getMatricula(), getModelo(), numAsientos);

    }

}
