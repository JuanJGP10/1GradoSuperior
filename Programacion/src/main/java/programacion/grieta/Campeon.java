package programacion.grieta;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase Campeon que representa a uno de los quipos de la grieta del invocador
 */
public class Campeon extends Personajes {

    private final String nombre;
    public static int contador = 1;
    public static final int VIDA_ININCIAL = 50;

    /**
     * Constructor de campeon, se le asignara un nombre y el id empezara en 1 y se
     * ira incrementando conforme vayamos creando mas
     * 
     * @param nombre nombre del campeon
     */
    public Campeon(String nombre) {
        super(contador, VIDA_ININCIAL);
        this.nombre = nombre;
        contador++;
    }

    /**
     * Metodo lanzar habilidad que devolvera la cantidad de daño que hagamos
     */
    @Override
    public int lanzarHabilidad() {
        if (estoyVivo()) {
            return ThreadLocalRandom.current().nextInt(10, 31);
        } else {
            return 0;
        }

    }

    /**
     * Metodo esquivar que determinara si el personaje esquiva o no el ataque que
     * recibe
     */
    @Override
    public boolean esquivar() {

        int random = ThreadLocalRandom.current().nextInt(1, 11);
        if (random == 1 || random == 2) {
            return true;
        }

        return false;
    }

    /**
     * Metodo recibir habilidad que determinara si el personaje recibe el daño o no
     */
    @Override
    public void RecibirHabilidad(int daño) {
        if (!esquivar()) {
            if (daño > vida)
                vida = 0;
            else
                vida = vida - daño;

            System.out.println("Soy el campeon " + id + " y he recibido " + daño + " puntos de daño, me quedan " + vida
                    + " puntos de vida");
        } else {
            System.out.println(
                    "Soy el campeon " + id + " y he esquivado el ataque, me quedan " + vida + " puntos de vida");
        }

    }

    /**
     * Metodo estoy vivo que devolvera si el personaje esta vivo o no
     */
    @Override
    public boolean estoyVivo() {
        if (vida > 0)
            return true;
        else
            return false;
    }

}
