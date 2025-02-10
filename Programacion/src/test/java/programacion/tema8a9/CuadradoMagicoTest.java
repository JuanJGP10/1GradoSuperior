package programacion.tema8a9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CuadradoMagicoTest {

    @Test
    void testEsCuadradoMagico() {

        int[][] cuadradoMagicoValido = {
                { 2, 7, 6 },
                { 9, 5, 1 },
                { 4, 3, 8 }
        };
        assertTrue(CuadradoMagico.esCuadradoMagico(cuadradoMagicoValido));

        int[][] noCuadradoMagico = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        assertFalse(CuadradoMagico.esCuadradoMagico(noCuadradoMagico));

        int[][] matrizNoCuadrada = {
                { 1, 2, 3 },
                { 4, 5 }
        };
        assertFalse(CuadradoMagico.esCuadradoMagico(matrizNoCuadrada));

        int[][] cuadradoMagicoTamaño1 = { { 5 } };
        assertTrue(CuadradoMagico.esCuadradoMagico(cuadradoMagicoTamaño1));

        int[][] cuadradoMagicoTamaño4 = {
                { 16, 3, 2, 13 },
                { 5, 10, 11, 8 },
                { 9, 6, 7, 12 },
                { 4, 15, 14, 1 }
        };
        assertTrue(CuadradoMagico.esCuadradoMagico(cuadradoMagicoTamaño4));
    }
}
