package prog.thiar.grieta;

/**
 * Clase abstracta Personajes que representan a todos las entidades que lucharan en la grieta del invocador
 */
public abstract class Personajes implements Luchador{
    protected final int id;
    protected int vida;

    /**
     * Constructor padre que nos ayudara a instanciar los objetos de otras clases
     * @param id identificador del personaje
     * @param vida vida del personaje
     */
    public Personajes(int id, int vida) {
        this.id = id;
        this.vida = vida;
    }

    /**
     * Metodo que devuelve  la id de los personajes
     * @return
     */
    public int getId() {
        return id;
    }


    @Override
    public boolean estoyVivo() {
        if(vida>0) return true;
        else return false;
    }


}
