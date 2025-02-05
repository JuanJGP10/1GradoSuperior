package programacion.tema8.ExamenArrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumerosLotoTest {

    private int[] combinacion;

    @BeforeEach
    void inicializar() {
        combinacion = NumerosLoto.generarCombinacion();
    }

    @Test
    void testGenerarCombinacion() {
        assertEquals(6, combinacion.length);
    }

    @Test
    void testOrdenMenorMayor() {
        for (int i = 0; i < combinacion.length; i++) {
            if (i + 1 != combinacion.length)
                assertTrue(combinacion[i] < combinacion[i + 1]);

        }

    }

    @Test
    void testRango() {
        for (int i = 0; i < combinacion.length; i++) {
            assertTrue(combinacion[i] >= 1 && combinacion[i] <= 49);

        }
    }

    @Test
    void testUnicos() {
        for (int i = 0; i < combinacion.length; i++) {
            if (i + 1 != combinacion.length)
                assertTrue(combinacion[i] != combinacion[i + 1]);

        }
    }

    @Test
    void testNulo() {
        assertNotNull(combinacion);
    }
}