/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pruebas;

import implementaciones.errores.CalculosError;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PruebaErroresTest {

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void testErrorAbsoluto() {
        assertEquals(2.0, CalculosError.errorAbsoluto(5, 3));
        assertEquals(2.0, CalculosError.errorAbsoluto(3, 5));
        assertEquals(0.0, CalculosError.errorAbsoluto(4, 4));
        assertEquals(5.0, CalculosError.errorAbsoluto(-5, 0));
    }

    @Test
    void testErrorRelativo() {
        assertEquals(0.5, CalculosError.errorRelativo(4, 2));
        assertEquals(0.5, CalculosError.errorRelativo(4, 6));
        assertEquals(1.0, CalculosError.errorRelativo(-5, 0));
    }
}
