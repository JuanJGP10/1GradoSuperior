package programacion.tema11.Ejercicios.ejercicio3;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String telefono, String email, LocalDate fechaNac) {
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
        Persona other = (Persona) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }



    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    
}
