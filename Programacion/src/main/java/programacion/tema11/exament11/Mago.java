package programacion.tema11.exament11;

public class Mago extends Personaje {
    public Mago(String nombre, int fuerza) {
        super(nombre);
        if (comprobarFuerza(fuerza))
            setFuerza(fuerza);
        else
            setFuerza(FUERZA_PORDEFECTO);
    }

    @Override
    public boolean retirarse() throws Exception {
        if (isMuerto())
            throw new Exception("El mago esta muerto");
        if (!isHerido())
            throw new Exception("El mago no esta herido");
        System.out.println(getNombre() + " se ha retirado");
        return true;
    }
}
