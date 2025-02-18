package programacion.tema9.Ejercicio5;

public class VehiculoTerrestre extends Vehiculo {
    private final int numeroRuedas;

    public VehiculoTerrestre(String matricula, String modelo, int numeroRuedas) {
        super(matricula, modelo);
        this.numeroRuedas = numeroRuedas;

        if (!matricula.matches("\\d{4}[A-Z]{3}")) {
            return;
        }

    }

    public int getNumeroRuedas() {
        return numeroRuedas;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Matricula: %s Modelo: %s Numero de ruedas: %d
                """, getMatricula(), getModelo(), getNumeroRuedas());

    }

}
