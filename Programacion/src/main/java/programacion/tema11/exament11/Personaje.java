package programacion.tema11.exament11;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Personaje {
    private final String nombre;
    protected int fuerza;
    private boolean herido = false, muerto = false;

    public static final int FUERZA_PORDEFECTO = 5;

    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    abstract public boolean retirarse() throws Exception;

    /**
     * Comprueba si un valor es correcto para el atributo fuerza >=1 y <=10
     * 
     * @param f fuerza a establecer
     * @return
     */
    public static boolean comprobarFuerza(int f) {
        return f <= 10 && f >= 1;
    }

    /**
     * Establece un valor aleatorio para el atributo fuerza
     */
    protected void setFuerzaAleatoria() {
        this.fuerza = ThreadLocalRandom.current().nextInt(1, 11);
    }

    // Getters y Setters
    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public boolean isHerido() {
        return herido;
    }

    // Modifico el setHerido para que si se se hiere compuruebe q no este muerto
    public void setHerido(boolean herido) {
        if (isMuerto())
            this.herido = false;
        else
            this.herido = herido;
    }

    public boolean isMuerto() {
        return muerto;
    }

    // Modifico el setMuerto para que si se muere no pueda estar herido
    public void setMuerto(boolean muerto) {
        if (muerto)
            this.herido = false;
        this.muerto = muerto;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        Personaje other = (Personaje) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equalsIgnoreCase(other.nombre))
            return false;
        return true;
    }

}
