package programacion.tema9.Ejercicio5;

public class VehiculoAcuatico extends Vehiculo {
    private final double eslora;

    public VehiculoAcuatico(String matricula, String modelo, double eslora) {
        super(matricula, modelo);
        this.eslora = eslora;
    }

    public double getEslora() {
        return eslora;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Matricula: %s Modelo: %s eslora: %.2f
                """, getMatricula(), getModelo(), eslora);

    }

}
