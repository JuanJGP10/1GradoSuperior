package prog.thiar.grieta;
/**
 * Clase equipo que nos servira para formar los equipos de la grieta del invocador para dar inicio a la batalla
 */
public class Equipo {
    private Personajes[] equipo= new Personajes[5];
    private final String nombreEquipo;

    /**
     * Constructor de quipos que si campeon es verdadero, generara un equipo de campeones y si es falso lo hara de criaturas del vacio
     * @param nombreEquipo nombre del equipo
     * @param esCampeon si el equipo es de campeones o no
     */
    public Equipo(String nombreEquipo, boolean esCampeon) {
        this.nombreEquipo = nombreEquipo;
        if(esCampeon){
            
            equipo[0] = new Campeon("Campeon1");
            equipo[1] = new Campeon("Cmapeon2");
            equipo[2] = new Campeon("Campeon3");
            equipo[3] = new Campeon("Campeon4");
            equipo[4] = new Campeon("Campeon5");
            nombreEquipo = "Defensores de la grieta";
        } else if(!esCampeon){
            equipo[0] = new CriaturaDelVacio();
            equipo[1] = new CriaturaDelVacio();
            equipo[2] = new CriaturaDelVacio();
            equipo[3] = new CriaturaDelVacio();
            equipo[4] = new CriaturaDelVacio();
            nombreEquipo = "Horrores del vacio";
        } 
        
        
    }
    /**
     * Metodo para recibir daño del otro equipo
     * @param indice Un personaje en la posición indice del equipo recibe un ataque con esa cantidad de daño.
     * @param daño cantidad de daño
     * Si la posición es inválida o el personaje ya está muerto, no ocurre nada.
     */
    public void recibirDaño(int indice, int daño){
        if(comprobarPosicion(indice) && equipo[indice].vida>0){
            if(equipo[indice] instanceof Campeon c){
                c.RecibirHabilidad(daño);
            }
            if(equipo[indice] instanceof CriaturaDelVacio vac){
                vac.RecibirHabilidad(daño);
            }
            
        }
    }
    /**
     * Metodo que genera una habilidad y se la lanza al otro equipo
     * @param indice Un personaje en la posición indice ataca
     * @return devolverá el daño que genera ese luchador. 
     */
    public int lanzarHabilidad(int indice){
        if(comprobarPosicion(indice) && equipo[indice].vida>0){
            if(equipo[indice] instanceof Campeon c){
                return c.lanzarHabilidad();
            }
            if(equipo[indice] instanceof CriaturaDelVacio vac){
                return vac.lanzarHabilidad();
            }
            return 0;
            
        } else {
            return 0;
        }
    }
    /**
     * Metodo para saber cauntos personajes quedan vivos 
     * @return cantidad de vivos
     */
    public int cuantosVivos(){
        int vivos = 0;
        for (int i = 0; i < equipo.length; i++) {
            if(equipo[i].estoyVivo()){
                vivos++;
            }
        }

        return vivos;
    }
    /**
     * Metodo para saber si la posicion esta dentro del equipo o no
     * @param i
     * @return
     */
    public boolean comprobarPosicion(int i){
        if(i>=0 && i <=4)return true;
        else return false;
    }
   
    
}
