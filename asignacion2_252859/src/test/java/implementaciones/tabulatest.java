package implementaciones;

import implementaciones.Tabula.Punto;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.DoubleUnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class tabulatest {

    @Test
    void testCuadratica() {
        // f(x) = x^2
        DoubleUnaryOperator f = (x) -> x * x;

        List<Punto> resultados = Tabula.tabula(f, 0, 2, 1);

        // Deben generarse 3 puntos (0,1,2) + max + min = 5
        assertEquals(5, resultados.size());

        // Revisamos valores normales
        assertEquals(0.0, resultados.get(0).y, 1e-9);
        assertEquals(1.0, resultados.get(1).y, 1e-9);
        assertEquals(4.0, resultados.get(2).y, 1e-9);

        // Revisamos maximo (debe estar en x=2, y=4)
        Punto max = resultados.get(resultados.size() - 2);
        assertEquals(2.0, max.x, 1e-9);
        assertEquals(4.0, max.y, 1e-9);

        // Revisamos minimo (debe estar en x=0, y=0)
        Punto min = resultados.get(resultados.size() - 1);
        assertEquals(0.0, min.x, 1e-9);
        assertEquals(0.0, min.y, 1e-9);
    }

    @Test
    void testFuncionLineal() {
        // f(x) = 2x + 1
        DoubleUnaryOperator f = (x) -> 2 * x + 1;

        List<Punto> resultados = Tabula.tabula(f, -1, 1, 1);

        // Puntos: -1, 0, 1 => 3 puntos + max + min = 5
        assertEquals(5, resultados.size());

        // Revisar valores
        assertEquals(-1.0, resultados.get(0).x, 1e-9);
        assertEquals(-1.0, resultados.get(0).y, 1e-9);  // f(-1) = -1

        assertEquals(0.0, resultados.get(1).x, 1e-9);
        assertEquals(1.0, resultados.get(1).y, 1e-9);   // f(0) = 1

        assertEquals(1.0, resultados.get(2).x, 1e-9);
        assertEquals(3.0, resultados.get(2).y, 1e-9);   // f(1) = 3

        // Maximo en (1, 3)
        Punto max = resultados.get(resultados.size() - 2);
        assertEquals(1.0, max.x, 1e-9);
        assertEquals(3.0, max.y, 1e-9);

        // Minimo en (-1, -1)
        Punto min = resultados.get(resultados.size() - 1);
        assertEquals(-1.0, min.x, 1e-9);
        assertEquals(-1.0, min.y, 1e-9);
    }

    @Test
    void testFuncionCoseno() {
        // f(x) = cos(x)
        DoubleUnaryOperator f = Math::cos;

        List<Punto> resultados = Tabula.tabula(f, 0, Math.PI, Math.PI / 2);

        // Puntos: 0, pi/2, pi => 3 puntos + max + min = 5
        assertEquals(5, resultados.size());

        // Revisamos cos(0) = 1
        assertEquals(1.0, resultados.get(0).y, 1e-9);

        // Revisamos cos(pi/2) ~ 0
        assertEquals(0.0, resultados.get(1).y, 1e-9);

        // Revisamos cos(pi) = -1
        assertEquals(-1.0, resultados.get(2).y, 1e-9);

        // Maximo en (0, 1)
        Punto max = resultados.get(resultados.size() - 2);
        assertEquals(0.0, max.x, 1e-9);
        assertEquals(1.0, max.y, 1e-9);

        // Minimo en (pi, -1)
        Punto min = resultados.get(resultados.size() - 1);
        assertEquals(Math.PI, min.x, 1e-9);
        assertEquals(-1.0, min.y, 1e-9);
    }
}
