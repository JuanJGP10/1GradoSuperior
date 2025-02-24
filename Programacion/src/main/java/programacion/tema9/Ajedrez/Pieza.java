package programacion.tema9.Ajedrez;

import java.awt.Point;

public abstract class Pieza {

    protected ColorPieza color;
    protected Point posicion;
    protected boolean comida;

    public Pieza(ColorPieza color, int x, int y) {
        this.color = color;
        this.posicion = new Point(x, y);
        if (!comprobarPosicion(x) || !comprobarPosicion(y)) {
            comida = true;
        } else
            comida = false;
    }

    public Pieza() {
        this(ColorPieza.BLANCO, 10, 10);
    }

    public Pieza(Pieza pieza) {
        this(pieza.color, pieza.getPosicion().x, pieza.getPosicion().y);
    }

    public abstract void mover(int x, int y);

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + (comida ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pieza other = (Pieza) obj;
        if (color != other.color)
            return false;
        if (comida != other.comida)
            return false;
        return true;
    }

    protected static boolean comprobarPosicion(int p) {
        if (p > 7 || p < 0)
            return false;
        else
            return true;
    }

    public ColorPieza getColor() {
        return color;
    }

    public void setColor(ColorPieza color) {
        this.color = color;
    }

    public Point getPosicion() {
        return posicion;
    }

    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

}
