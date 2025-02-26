package programacion.tema9.MaratonEjercicios.ej924;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class PiezaAjedrezTest {
    private PiezaAlfil alfil;

    @BeforeEach
    void setUp() {
        alfil = new PiezaAlfil(4, 4); // Posición inicial en el centro
    }

    // ==========================
    // PRUEBAS DE MOVIMIENTOS VÁLIDOS
    // ==========================

    @Test
    void testMovimientoDiagonalArribaDerecha() {
        assertTrue(alfil.mover(6, 6)); // (4,4) → (6,6)
        assertEquals(6, alfil.getFila());
        assertEquals(6, alfil.getColumna());
    }

    @Test
    void testMovimientoDiagonalAbajoIzquierda() {
        assertTrue(alfil.mover(2, 2)); // (4,4) → (2,2)
        assertEquals(2, alfil.getFila());
        assertEquals(2, alfil.getColumna());
    }

    @Test
    void testMovimientoDiagonalArribaIzquierda() {
        assertTrue(alfil.mover(6, 2)); // (4,4) → (6,2)
        assertEquals(6, alfil.getFila());
        assertEquals(2, alfil.getColumna());
    }

    @Test
    void testMovimientoDiagonalAbajoDerecha() {
        assertTrue(alfil.mover(2, 6)); // (4,4) → (2,6)
        assertEquals(2, alfil.getFila());
        assertEquals(6, alfil.getColumna());
    }

    // ==========================
    // PRUEBAS DE MOVIMIENTOS INVÁLIDOS
    // ==========================

    @Test
    void testMovimientoHorizontalInvalido() {
        assertFalse(alfil.mover(4, 6)); // Moverse en línea recta horizontalmente
    }

    @Test
    void testMovimientoVerticalInvalido() {
        assertFalse(alfil.mover(6, 4)); // Moverse en línea recta verticalmente
    }

    @Test
    void testMovimientoAleatorioInvalido() {
        assertFalse(alfil.mover(5, 7)); // Movimiento no diagonal
    }

    // ==========================
    // PRUEBAS DE LÍMITES DEL TABLERO
    // ==========================

    @Test
    void testMovimientoFueraDelTablero() {
        assertFalse(alfil.mover(-1, -1)); // Fuera del tablero (negativos)
        assertFalse(alfil.mover(8, 8)); // Fuera del tablero (más allá del límite)
    }

    // ==========================
    // PRUEBAS DE MOVIMIENTOS MÚLTIPLES SEGUIDOS
    // ==========================

    @Test
    void testMovimientosEncadenadosValidos() {
        assertTrue(alfil.mover(6, 6)); // Primer movimiento válido
        assertEquals(6, alfil.getFila());
        assertEquals(6, alfil.getColumna());

        assertTrue(alfil.mover(4, 4)); // Volver a la posición original
        assertEquals(4, alfil.getFila());
        assertEquals(4, alfil.getColumna());

        assertTrue(alfil.mover(2, 6)); // Otro movimiento diagonal
        assertEquals(2, alfil.getFila());
        assertEquals(6, alfil.getColumna());
    }

    @Test
    void testMovimientosEncadenadosInvalidos() {
        assertTrue(alfil.mover(6, 6)); // Primer movimiento válido
        assertEquals(6, alfil.getFila());
        assertEquals(6, alfil.getColumna());

        assertFalse(alfil.mover(6, 4)); // Intentar mover en línea recta (inválido)
        assertEquals(6, alfil.getFila()); // No debe cambiar
        assertEquals(6, alfil.getColumna());

        assertFalse(alfil.mover(5, 7)); // Movimiento inválido
        assertEquals(6, alfil.getFila()); // No debe cambiar
        assertEquals(6, alfil.getColumna());
    }
}