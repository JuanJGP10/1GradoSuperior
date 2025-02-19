package programacion.tema9.Monopoly;

public class Casilla {
    private final String nombre;
    private int codigo;
    public static int contador = 1;

    public Casilla(String nombre) {
        this.nombre = nombre;
        this.codigo = contador;
        contador++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
