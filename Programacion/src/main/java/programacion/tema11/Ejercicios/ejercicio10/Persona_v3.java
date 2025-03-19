package programacion.tema11.Ejercicios.ejercicio10;

import java.time.LocalDate;

public class Persona_v3 /** implements Comparable<Persona_v3> **/
{
    private String nombre;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    public Persona_v3(String nombre, String telefono, String email, LocalDate fechaNac) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNac;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", fechaNacimiento="
                + fechaNacimiento + "]";
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    // @Override
    // public int compareTo(Persona_v3 o) {
    // return nombre.compareToIgnoreCase(o.nombre);
    // }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

}
