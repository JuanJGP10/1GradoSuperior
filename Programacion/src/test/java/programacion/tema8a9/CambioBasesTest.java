package programacion.tema8a9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CambioBasesTest {
    @BeforeEach

    @Test
    void testBinarioDecimal() {
        assertEquals(10, CambioBases.binarioDecimal("1010"));
        assertEquals(-1, CambioBases.binarioDecimal(""));
        assertEquals(-1, CambioBases.binarioDecimal(null));
        assertEquals(-1, CambioBases.binarioDecimal("-23"));
        assertEquals(-1, CambioBases.binarioDecimal("10,5"));
        assertEquals(-1, CambioBases.binarioDecimal("2010"));
        assertEquals(-1, CambioBases.binarioDecimal("2FA3"));

    }

    @Test
    void testDecimalBinario() {
        assertEquals("1010", CambioBases.decimalBinario(10));
        assertEquals("-1", CambioBases.decimalBinario(-23));
        assertEquals("11111011010", CambioBases.decimalBinario(2010));
        assertEquals("11000", CambioBases.decimalBinario(24));

    }

    @Test
    void testDecimalHexadecimal() {
        assertEquals("A", CambioBases.decimalHexadecimal(10));
        assertEquals("-1", CambioBases.decimalHexadecimal(-23));
        assertEquals("7DA", CambioBases.decimalHexadecimal(2010));
        assertEquals("18", CambioBases.decimalHexadecimal(24));
    }

    @Test
    void testDecimalOctal() {
        assertEquals("12", CambioBases.decimalOctal(10));
        assertEquals("-1", CambioBases.decimalOctal(-23));
        assertEquals("3732", CambioBases.decimalOctal(2010));
        assertEquals("30", CambioBases.decimalOctal(24));
    }

    @Test
    void testHexadecimalDecimal() {
        assertEquals(419, CambioBases.hexadecimalDecimal("1a3"));
        assertEquals(-1, CambioBases.hexadecimalDecimal(""));
        assertEquals(-1, CambioBases.hexadecimalDecimal(null));
        assertEquals(-1, CambioBases.hexadecimalDecimal("-23"));
        assertEquals(-1, CambioBases.hexadecimalDecimal("10,5"));
        assertEquals(-1, CambioBases.hexadecimalDecimal("1ña"));
    }

    @Test
    void testOctalDecimal() {
        assertEquals(2257, CambioBases.octalDecimal("4321"));
        assertEquals(-1, CambioBases.octalDecimal(""));
        assertEquals(-1, CambioBases.octalDecimal(null));
        assertEquals(-1, CambioBases.octalDecimal("-23"));
        assertEquals(-1, CambioBases.octalDecimal("10,5"));
        assertEquals(-1, CambioBases.octalDecimal("89"));
    }
}
