package programacion.tema10.Ejercicio9;

public abstract class Publicacion {
    final int id;

    public static int contador = 0;

    public Publicacion() {
        this.id = contador;
        contador++;
    }

    public abstract void mostrarEnLinea();

}
