package prog.thiar.grieta;
/**
 * Clase interfaz luchador que implementara estos metodos a las clases que implementen esta interfaz
 */
public interface Luchador {
    int lanzarHabilidad();

    boolean esquivar();

    void RecibirHabilidad(int daño);

    boolean estoyVivo();
}
