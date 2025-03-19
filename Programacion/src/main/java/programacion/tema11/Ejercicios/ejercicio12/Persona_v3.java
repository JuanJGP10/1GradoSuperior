package programacion.tema11.Ejercicios.ejercicio12;

import java.time.LocalDate;

public class Persona_v3/* implements Comparable<Persona_v3> */ {
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    // @Override
    // public int compareTo(Persona_v3 o) {
    // return email.compareTo(o.email);
    // }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona_v3 other = (Persona_v3) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    // @Override
    // public int compareTo(Persona_v3 o) {
    // return nombre.compareTo(o.nombre);
    // }

}
