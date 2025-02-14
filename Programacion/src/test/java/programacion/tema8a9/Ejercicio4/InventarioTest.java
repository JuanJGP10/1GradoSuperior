package programacion.tema8a9.Ejercicio4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventarioTest {

    public static Producto p1;
    public static Producto p2;
    public static Producto p3;
    public static Producto p4;
    public static Producto p5;

    @BeforeEach
    void setUp() {
        p1 = new Producto("manzana", CategoriaProducto.ALIMENTACION, 2);
        p2 = new Producto("movil", CategoriaProducto.ELECTRONICA, 250);
        p3 = new Producto("camiseta", CategoriaProducto.ROPA, 10);
        p4 = new Producto("harry pottah", CategoriaProducto.LIBROS, 20);
        p5 = new Producto(null, null, 0);
        Inventario.getProductos().clear();
    }

    @Test
    void testAddProducto() {
        assertTrue(Inventario.addProducto(p1));
        assertTrue(Inventario.addProducto(p2));
        assertTrue(Inventario.addProducto(p3));
        assertFalse(Inventario.addProducto(null));
        assertFalse(Inventario.addProducto(p5));

    }

    @Test
    void testlimiteProducto() {
        assertTrue(Inventario.addProducto(p1));
        assertTrue(Inventario.addProducto(p2));
        assertTrue(Inventario.addProducto(p3));
        assertFalse(Inventario.addProducto(p4));
    }

    @Test
    void testDeleteProducto() {
        assertEquals(-1, Inventario.deleteProducto(null));
        assertEquals(-1, Inventario.deleteProducto("    "));
        assertEquals(-1, Inventario.deleteProducto(""));
        assertTrue(Inventario.addProducto(p1));
        assertTrue(Inventario.addProducto(p3));
        assertTrue(Inventario.addProducto(p3));

        assertEquals(1, Inventario.deleteProducto("manzana"));
        assertEquals(-1, Inventario.deleteProducto("movil"));
        assertEquals(2, Inventario.deleteProducto("camiseta"));
    }

    @Test
    void testProductosCategoria() {
        assertEquals(0, Inventario.getProductos().size());
        assertTrue(Inventario.addProducto(p1));
        assertTrue(Inventario.addProducto(p3));
        assertTrue(Inventario.addProducto(p3));
        assertEquals(2, Inventario.productosCategoria(CategoriaProducto.ROPA).size());
        assertEquals(1, Inventario.productosCategoria(CategoriaProducto.ALIMENTACION).size());
    }

    @Test
    void testValorCategoria() {
        assertTrue(Inventario.addProducto(p2));
        assertTrue(Inventario.addProducto(p2));
        assertTrue(Inventario.addProducto(p2));
        assertEquals(750, Inventario.valorCategoria(CategoriaProducto.ELECTRONICA));
        assertEquals(-1, Inventario.valorCategoria(null));
    }
}
