package programacion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        if (saldoInicial < 0)
            throw new IllegalArgumentException("saldo cannot be negative");
        this.saldo = saldoInicial;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
        }
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    public boolean transferir(CuentaBancaria cuentaOtra, double cantidad) {
        if (cantidad <= saldo) {
            retirar(cantidad);
            cuentaOtra.depositar(cantidad);
            return true;
        } else
            return false;

    }

    public double getSaldo() {
        return saldo;
    }
}

public class CuentaBancariaTest {
    private CuentaBancaria cuenta1;
    private CuentaBancaria cuenta2;

    @BeforeEach
    void setUp() {
        cuenta1 = new CuentaBancaria(50);
        cuenta2 = new CuentaBancaria(25);
    }

    @Test
    void testDeposito() {
        cuenta1.depositar(50);
        assertEquals(100, cuenta1.getSaldo());
    }

    @Test
    void testRetiro() {
        assertTrue(cuenta1.retirar(50));
        assertEquals(0, cuenta1.getSaldo());
    }

    @Test
    void testRetiroInsuficiente() {
        assertFalse(cuenta1.retirar(200));
        assertEquals(50, cuenta1.getSaldo());
    }

    @Test
    void testSaldoNuncaNegativo() {
        cuenta1.retirar(200);
        assertTrue(cuenta1.getSaldo() >= 0);

        cuenta1.transferir(cuenta2, 200);
        assertTrue(cuenta1.getSaldo() >= 0);
    }

    @Test
    void testTransferencia() {
        assertTrue(cuenta1.transferir(cuenta2, 50));
        assertEquals(0, cuenta1.getSaldo());
        assertEquals(75, cuenta2.getSaldo());
    }

}
