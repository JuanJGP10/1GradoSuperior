package programacion.tema8;

import java.util.ArrayList;

public class Receta {
    private String nombre;
    private String elaboracion;
    private int duracion;
    private ArrayList<Ingrediente> ingredientes;

    public Receta(String nombre, String elaboracion, int duracion, ArrayList<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.elaboracion = elaboracion;
        this.duracion = duracion;
        this.ingredientes = ingredientes;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getelaboracion() {
        return elaboracion;
    }

    public void setelaboracion(String elaboracion) {
        this.elaboracion = elaboracion;
    }

    public int getduracion() {
        return duracion;
    }

    public void setduracion(int duracion) {
        this.duracion = duracion;
    }

    public void imprimirReceta() {
        System.out.printf("""
                Nombre de la receta: %s
                Elaboracion de la receta: %s
                Duracion de la receta: %d
                Ingredientes de la receta:
                """, nombre, elaboracion, duracion);
        System.out.println(ingredientes);
    }

}
