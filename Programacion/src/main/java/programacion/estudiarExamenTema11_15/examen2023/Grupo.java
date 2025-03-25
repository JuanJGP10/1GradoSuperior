package programacion.estudiarExamenTema11_15.examen2023;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Grupo {
    private HashSet<Personaje> grupo = new HashSet<>();

    public boolean incluirPersonajes(Personaje p) {
        if (grupo.contains(p))
            return false;

        grupo.add(p);
        return true;
    }

    public /* Optional< */Personaje/* > */ getMiembro(String nombre) {

        for (Personaje personaje : grupo) {
            if (personaje.getNombre().equals(nombre))
                return personaje;
        }
        return null;
        // return grupo.stream().filter(s1 ->
        // s1.getNombre().equalsIgnoreCase(nombre)).findFirst();
    }

    public List<Mago> dameMagos() {

        List<Mago> lista;
        lista = grupo.stream().filter(s -> (s instanceof Mago)).map(s1 -> (Mago) s1).collect(Collectors.toList());
        return lista;
    }

    public void retirada() {

        for (Personaje personaje : grupo) {
            try {
                System.out.println("Entidad: " + personaje.getNombre() + " Se retira?: " + personaje.retirada());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        // grupo.stream()
        // .forEach(s1 -> {
        // try {
        // System.out.println("Entidad: " + s1.getNombre() + " Se retira?: " +
        // s1.retirada());
        // } catch (Exception e) {
        // e.getMessage();
        // }

        // });
    }

    public void mostrar() {
        grupo.stream().forEach(System.out::println);

        System.out.println("Fuerza del grupo:  " + grupo.stream().mapToDouble(Personaje::getFuerza).sum());
    }

    public int limpiarGrupo() {

        int trollsMuertos = (int) grupo.stream().filter(s -> s.isMuerto() && s instanceof Troll).count();
        // grupo.forEach(s1 -> {
        // if ((s1.isMuerto()) && (s1 instanceof Troll))
        // grupo.remove(s1);
        // });

        Iterator<Personaje> it = grupo.iterator();
        while (it.hasNext()) {
            Personaje p = it.next();
            if (p.isMuerto() && p instanceof Troll)
                it.remove();
        }

        return trollsMuertos;

    }

    public void mostrarGrupo() {
        grupo.stream().sorted(Comparator.comparing(Personaje::getNombre)).forEach(System.out::println);
    }

    public void mostrarGrupoPorFuerza() {
        grupo.stream().sorted(Comparator.comparing(Personaje::getFuerza).reversed()).forEach(System.out::println);
    }

    public HashSet<Personaje> getGrupo() {
        return grupo;
    }
}
