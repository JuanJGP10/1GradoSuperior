package programacion.tema11.Ejercicios.ejercicio10;

import java.time.LocalDate;

public class Persona_v2 {
    private String nombre;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    public Persona_v2(String nombre, String telefono, String email, LocalDate fechaNac) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        // Hay que modificar el hashCode tambien para este caso para identificar
        // duplicados
        result = prime * result + ((nombre == null) ? 0 : nombre.toLowerCase().hashCode());
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
        Persona_v2 other = (Persona_v2) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
            // EqualsIgnoreCase
        } else if (!nombre.equalsIgnoreCase(other.nombre))
            return false;
        return true;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

}
