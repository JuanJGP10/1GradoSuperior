package prog.thiar.grieta;

import java.util.concurrent.ThreadLocalRandom;
/**
 * Clase Criatura del vacio que representa a uno de los quipos de la grieta del invocador
 */
public final class CriaturaDelVacio extends Personajes{
    public static int contador = 1;
    public static final int VIDA_ININCIAL = 50;
    /**
     * Constructor de Criatura del vacio que recibe como parametro la vida de la criatura y el id empezara en 1 y se ira incrementando conforme vayamos creando mas
     * @param vida
     */
    public CriaturaDelVacio(int vida){
        super(contador, vida);
        contador++;
    }
    /**
     * Constructor de criatura del vacio que no se le pasan parametreos y se le asignara una variable constante de vida
     */
    public CriaturaDelVacio(){
        super(contador, VIDA_ININCIAL);
        contador++;
    }
    /**
     * Metodo lanzar habilidad que devolvera la cantidad de daño que hagamos
     */
    @Override
    public int lanzarHabilidad() {
        if(estoyVivo()){
            return ThreadLocalRandom.current().nextInt(15,21);
        } else {
            return 0;
        }
    }
    /**
     * Metodo esquivar que determinara si el personaje esquiva o no el ataque que recibe
     */
    @Override
    public boolean esquivar() {
        for (int i = 0; i < 10; i++) {
            int random = ThreadLocalRandom.current().nextInt(1,11);
            if(random == 1){
                return true;
            } 
        }

        return false;
    }

    /**
     * Metodo recibir habilidad que determinara si el personaje recibe el daño o no
     */
    @Override
    public void RecibirHabilidad(int daño) {
        if(!esquivar()){
            if(daño>vida) vida = 0;
            else vida = vida-daño; 
            System.out.println("Soy la criatura del vacio "+id+" y he recibido "+daño+" puntos de daño, me quedan "+vida+" puntos de vida");
        } else {
            System.out.println("Soy la criatura del vacio "+id+ " y he esquivado el ataque, me quedan "+vida+" puntos de vida");
        }

    }

    
}

    

