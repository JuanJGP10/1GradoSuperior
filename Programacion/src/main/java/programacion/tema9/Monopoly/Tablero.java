package programacion.tema9.Monopoly;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Casilla> casillas;

    public Tablero() {
        casillas.add(new Terreno("Terreno 1", 250, 200, ColorTerreno.VERDE, 50));
        casillas.add(new Terreno("Terreno 2", 250, 200, ColorTerreno.VERDE, 50));
        casillas.add(new Estaciones("Norte"));
        casillas.add(new Terreno("Terreno 3", 300, 350, ColorTerreno.ROJO, 100));
        casillas.add(new Estaciones("Sur"));
    }

    public void mostrarTablero() {
        for (Casilla casilla : casillas) {
            System.out.println(casilla);
        }
    }
}
