package programacion.tema9.MaratonEjercicios.ej920;

public class Furgonetas extends VehiculosGeneral {
    private double longitud;

    public Furgonetas(String matricula, double longitud) {
        super(matricula);
        this.longitud = longitud;

    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return super.toString() + " Longitud: " + longitud;
    }

}
