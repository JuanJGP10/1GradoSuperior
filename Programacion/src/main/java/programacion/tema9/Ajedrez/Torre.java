package programacion.tema9.Ajedrez;

public class Torre extends Pieza {

    public Torre(ColorPieza color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public void mover(int x, int y) {
        if (!comida) {
            if (comprobarPosicion(x) && comprobarPosicion(y)) {
                if (x != posicion.getX()) {
                    if (y != posicion.getY()) {
                        System.out.println("No puede moverse en esa direccion");
                    } else {
                        posicion.setLocation(x, y);
                    }

                } else if (y != posicion.getY()) {
                    if (x != posicion.getX()) {
                        System.out.println("No puede moverse en esa direccion");
                    } else {
                        posicion.setLocation(x, y);
                    }
                }
            }
        }

    }
}
