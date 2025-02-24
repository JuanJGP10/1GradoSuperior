package programacion.tema9.MaratonEjercicios.ej920;

public class Autobuses extends VehiculosGeneral {
    private int asientos;

    public Autobuses(String matricula, int asientos) {
        super(matricula);
        this.asientos = asientos;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    @Override
    public String toString() {
        return super.toString() + " Numero de asientos: " + asientos;
    }

}
