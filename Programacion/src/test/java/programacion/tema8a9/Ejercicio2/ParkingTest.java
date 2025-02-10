package programacion.tema8a9.Ejercicio2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingTest {

    private static Vehiculo v1;
    private static Vehiculo v2;
    private static Vehiculo v3;
    private static Vehiculo v4;

    @BeforeEach
    void setUp() {
        v1 = new Vehiculo("1010GBD", TipoVehiculo.COCHE, "Juan");
        v2 = new Vehiculo("2323XZY", TipoVehiculo.MOTO, "Melody");
        v3 = new Vehiculo("1212JHY", TipoVehiculo.MOTO, "Ismael");
        v4 = new Vehiculo("1414HUT", TipoVehiculo.COCHE, "Lui");
        Parking.getParking().clear();
    }

    @Test
    void testAgregarVehiculo() {
        assertTrue(Parking.agregarVehiculo(v1));
        assertFalse(Parking.agregarVehiculo(null));

    }

    @Test
    void testRetirarVehiculo() {
        Parking.agregarVehiculo(v1);
        assertFalse(Parking.retirarVehiculo("         "), "cadena vacia");
        assertFalse(Parking.retirarVehiculo(null), "cadena nula");
        assertFalse(Parking.retirarVehiculo("1010 GBD"), "formato de matricula incorrecto");
        assertTrue(Parking.retirarVehiculo("1010GBD"), "matricula no encontrada");
    }

    @Test
    void testSobrepasarCapacidad() {
        assertTrue(Parking.agregarVehiculo(v1));
        assertTrue(Parking.agregarVehiculo(v2));
        assertTrue(Parking.agregarVehiculo(v3));
        assertFalse(Parking.agregarVehiculo(v4));

    }
}
