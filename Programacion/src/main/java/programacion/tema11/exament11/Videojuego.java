package programacion.tema11.exament11;

import java.util.concurrent.ThreadLocalRandom;

public class Videojuego {
    public static void main(String[] args) {
        Grupo grupo1 = new Grupo();

        String[] nombresMagos = { "Yennefer", "Geralt", "yeNNefer" };

        // Incluir personajes magos en el grupo
        grupo1.incluirPersonaje(new Mago(nombresMagos[0], ThreadLocalRandom.current().nextInt(1, 11)));
        grupo1.incluirPersonaje(new Mago(nombresMagos[1], ThreadLocalRandom.current().nextInt(1, 11)));
        grupo1.incluirPersonaje(new Mago(nombresMagos[2], ThreadLocalRandom.current().nextInt(1, 11)));

        // Incluir trolls en el grupo
        for (int i = 0; i < 5; i++) {
            grupo1.incluirPersonaje(new Troll());
        }

        // Mostrar el grupo
        grupo1.mostrarGrupo();

        // Dañar personajes específicos
        grupo1.dañarPersonaje("troll_1", true);
        grupo1.dañarPersonaje("yeNNefer", false);
        grupo1.limpiarGrupo();
        grupo1.dañarPersonaje("troll_3", false);
        grupo1.dañarPersonaje("troll_5", true);

        // Mostrar el grupo después de los daños
        grupo1.mostrarGrupo();

        // Retirar el grupo
        grupo1.retirada();
    }
}
