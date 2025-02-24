package programacion.tema9.Ajedrez;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Point;

class PruebasTest {

    private Peon peonBlanco;
    private Peon peonNegro;
    private Torre torre;

    @BeforeEach
    void setUp() {
        peonBlanco = new Peon(ColorPieza.BLANCO, 4, 1); // Peón blanco en índice (4,1) -> e2
        peonNegro = new Peon(ColorPieza.NEGRO, 3, 6); // Peón negro en índice (3,6) -> d7
        torre = new Torre(ColorPieza.BLANCO, 0, 0); // Torre blanca en índice (0,0) -> a1
    }

    // ------------------------ PRUEBAS PARA PEÓN ------------------------

    @Test
    void testPeonBlancoMovimientoValido1Paso() {
        peonBlanco.mover(4, 2); // De (4,1) a (4,2) (E2 → E3)
        assertEquals(new Point(4, 2), peonBlanco.getPosicion());
    }

    @Test
    void testPeonBlancoMovimientoValido2Pasos() {
        peonBlanco.mover(4, 3); // De (4,1) a (4,3) (E2 → E4, primer movimiento)
        assertEquals(new Point(4, 3), peonBlanco.getPosicion());
    }

    @Test
    void testPeonBlancoMovimientoInvalidoMasDeDosCasillas() {
        peonBlanco.mover(4, 4); // De (4,1) a (4,4) (E2 → E5, no permitido)
        assertNotEquals(new Point(4, 4), peonBlanco.getPosicion());
    }

    @Test
    void testPeonBlancoMovimientoInvalidoLateral() {
        peonBlanco.mover(5, 1); // De (4,1) a (5,1) (E2 → F2, no permitido)
        assertNotEquals(new Point(5, 1), peonBlanco.getPosicion());
    }

    @Test
    void testPeonNegroMovimientoValido1Paso() {
        peonNegro.mover(3, 5); // De (3,6) a (3,5) (D7 → D6)
        assertEquals(new Point(3, 5), peonNegro.getPosicion());
    }

    @Test
    void testPeonNegroMovimientoValido2Pasos() {
        peonNegro.mover(3, 4); // De (3,6) a (3,4) (D7 → D5, primer movimiento)
        assertEquals(new Point(3, 4), peonNegro.getPosicion());
    }

    @Test
    void testPeonNegroMovimientoInvalidoHaciaAtras() {
        peonNegro.mover(3, 7); // De (3,6) a (3,7) (D7 → D8, no permitido)
        assertNotEquals(new Point(3, 7), peonNegro.getPosicion());
    }

    // ------------------------ PRUEBAS PARA TORRE ------------------------

    @Test
    void testTorreMovimientoValidoVertical() {
        torre.mover(0, 5); // De (0,0) a (0,5) (A1 → A6)
        assertEquals(new Point(0, 5), torre.getPosicion());
    }

    @Test
    void testTorreMovimientoValidoHorizontal() {
        torre.mover(7, 0); // De (0,0) a (7,0) (A1 → H1)
        assertEquals(new Point(7, 0), torre.getPosicion());
    }

    @Test
    void testTorreMovimientoInvalidoDiagonal() {
        torre.mover(3, 3); // De (0,0) a (3,3) (A1 → D4, no permitido)
        assertNotEquals(new Point(3, 3), torre.getPosicion());
    }

    @Test
    void testTorreMovimientoInvalidoCortoDiagonal() {
        torre.mover(1, 1); // De (0,0) a (1,1) (A1 → B2, no permitido)
        assertNotEquals(new Point(1, 1), torre.getPosicion());
    }
}