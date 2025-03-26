package programacion.tema11.exament11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Grupo {
    private HashSet<Personaje> grupo = new HashSet<>();

    public boolean incluirPersonaje(final Personaje p) {
        if (grupo.contains(p))
            return false;

        grupo.add(p);
        return true;
    }

    public Optional<Personaje> getMiembro(final String nombre) {
        return grupo.stream().filter(s -> s.getNombre().equals(nombre)).findFirst();
    }

    public void dañarPersonaje(String nombre, boolean matar) {
        if (!grupo.stream().anyMatch(s -> s.getNombre().equalsIgnoreCase(nombre)))
            throw new NullPointerException();
        grupo.stream().filter((s -> s.getNombre().equalsIgnoreCase(nombre))).forEach(s -> {
            if (matar)
                s.setMuerto(true);
            else
                s.setHerido(true);
        });
    }

    public List<Mago> dameMagos() {
        List<Mago> magos = grupo.stream().filter(s -> s instanceof Mago).map(s -> (Mago) s)
                .collect(Collectors.toList());
        return magos;
    }

    public void retirada() {
        grupo.forEach(s -> {
            try {
                System.out.println(s.retirarse());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }

    public int limpiarGrupo() {

        Iterator<Personaje> it = grupo.iterator();
        while (it.hasNext()) {
            Personaje p = it.next();
            if (p instanceof Troll t && t.isMuerto())
                it.remove();
        }
        int trollsMuertos = (int) grupo.stream().filter(s -> (s instanceof Troll && s.isMuerto())).count();
        /*
         * grupo.stream().filter(s -> (s instanceof Troll t && t.isMuerto())).forEach(s
         * -> {
         * Iterator<Personaje> it = grupo.iterator();
         * while (it.hasNext()) {
         * Personaje p = it.next();
         * it.remove();
         * }
         * });
         */
        return trollsMuertos;
    }

    public void mostrarGrupo() {
        List<Mago> magos = dameMagos();
        List<Troll> trolls = grupo.stream().filter(s -> s instanceof Troll).map(s -> (Troll) s)
                .sorted((s1, s2) -> s1.getNombre().compareTo(s2.getNombre())).toList();
        magos.sort((s1, s2) -> s1.getNombre().compareTo(s2.getNombre()));

        ArrayList<Personaje> lista = new ArrayList<>();
        magos.stream().forEach(s -> lista.add(s));
        trolls.stream().forEach(s -> lista.add(s));
        System.out.println("Miembros");
        lista.stream().forEach(s -> System.out.printf("%-10s Fuerza:%3d %10s \n", s.getNombre(), s.getFuerza(),
                s.isHerido() ? "Herido" : s.isMuerto() ? "Muerto" : ""));

        System.out.println("Fuerza del grupo: "
                + lista.stream().filter(s -> (!s.isMuerto())).mapToInt(Personaje::getFuerza).sum());
    }

    public List<Personaje> grupoXFuerza() {
        List<Personaje> personajesOrdenadosXFuerza = grupo.stream()
                .sorted(Comparator.comparing(Personaje::getFuerza).reversed()).toList();
        return personajesOrdenadosXFuerza;
    }
}
