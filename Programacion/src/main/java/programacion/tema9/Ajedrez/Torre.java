package programacion.tema9.Ajedrez;

/**
 * Clase Torre que hereda de pieza donde podremos crear objetos torre
 */
public class Torre extends Pieza {

    /**
     * Constructor que creara los objetos torre a partir de los siguientes 3
     * parametros:
     * 
     * @param color ColorPieza color de la pieza
     * @param x     Coordenada X donde aparecera la pieza
     * @param y     Coordenada Y donde aparecera la pieza
     */
    public Torre(ColorPieza color, int x, int y) {
        super(color, x, y);
    }

    /**
     * Sobreescribimos el metodo mover para la torre
     */
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
