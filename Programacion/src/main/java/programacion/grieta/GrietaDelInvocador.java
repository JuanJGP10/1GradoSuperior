package programacion.grieta;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * Mientras haya al menos un personaje vivo en cada equipo, los personajes
 * atacan en turnos.
 * Se elige un personaje aleatorio de cada equipo para atacar al enemigo, se
 * irán alternando los equipos en atacar primero, también es aleatorio al
 * personaje que se ataca. Si se te ocurre otra forma de combate puedes
 * especfificarla. Si necesitas algún método nuevo, especifícalo.
 * Si un equipo pierde a todos sus miembros, la batalla termina y el otro equipo
 * es declarado ganador.
 * 
 */
public class GrietaDelInvocador {

    public static void iniciarBatalla(Equipo equipoCamp, Equipo equipoVacio) {

        while (equipoCamp.cuantosVivos() != 0 && equipoVacio.cuantosVivos() != 0) {

            boolean turno = ThreadLocalRandom.current().nextBoolean();

            if (turno && equipoCamp.cuantosVivos() != 0 && equipoVacio.cuantosVivos() != 0) {

                int random1 = ThreadLocalRandom.current().nextInt(0, 5);
                int atk = equipoCamp.lanzarHabilidad(random1);
                equipoVacio.recibirDaño(ThreadLocalRandom.current().nextInt(0, 5), atk);

                int random2 = ThreadLocalRandom.current().nextInt(0, 5);
                int atk2 = equipoVacio.lanzarHabilidad(random2);

                equipoCamp.recibirDaño(ThreadLocalRandom.current().nextInt(0, 5), atk2);

            } else if (!turno && equipoCamp.cuantosVivos() != 0 && equipoVacio.cuantosVivos() != 0) {

                int random1 = ThreadLocalRandom.current().nextInt(0, 5);
                int atk = equipoVacio.lanzarHabilidad(random1);
                equipoCamp.recibirDaño(ThreadLocalRandom.current().nextInt(0, 5), atk);

                int random2 = ThreadLocalRandom.current().nextInt(0, 5);
                int atk2 = equipoCamp.lanzarHabilidad(random2);

                equipoVacio.recibirDaño(ThreadLocalRandom.current().nextInt(0, 5), atk2);

            }

        }

        if (equipoCamp.cuantosVivos() == 0) {
            System.out.println("Gana el equipo de las criaturas del vacio");
        } else {
            System.out.println("Gana el equipo de los campeones");
        }
    }

    /**
     * Main donde pruebo el programa
     * 
     * @param args
     */
    public static void main(String[] args) {
        Equipo equipoCamp = new Equipo("campeones", true);
        Equipo equipoVacio = new Equipo("Criaturas del vacio", false);
        iniciarBatalla(equipoCamp, equipoVacio);

    }
}
