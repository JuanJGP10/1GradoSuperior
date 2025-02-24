package programacion.tema9.MaratonEjercicios.ej920;

import java.time.LocalDate;

public class VehiculosGeneral {
    private String matricula;
    private LocalDate fechaEntrada;

    public VehiculosGeneral(String matricula) {
        this.matricula = matricula;
        this.fechaEntrada = fechaEntrada.now();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula + " FechaEntrada: " + fechaEntrada;
    }

}
