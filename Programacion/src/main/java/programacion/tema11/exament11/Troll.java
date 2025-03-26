package programacion.tema11.exament11;

public class Troll extends Personaje {

    private static int contadorTrolls = 1;

    public Troll() {
        super("Troll_" + contadorTrolls++);
        setFuerzaAleatoria();
    }

    @Override
    public boolean retirarse() throws Exception {
        throw new Exception("Un troll no puede retirarse");
    }

}
