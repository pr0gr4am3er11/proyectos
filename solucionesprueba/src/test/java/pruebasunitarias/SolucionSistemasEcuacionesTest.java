package pruebasunitarias;

import com.mycompany.solucionesprueba.SolucionSistemasEcuaciones;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Tests de Solución de Sistemas de Ecuaciones")
public class SolucionSistemasEcuacionesTest {
    
    private SolucionSistemasEcuaciones sistema;
    private static final double DELTA = 0.0001;
    
    @BeforeEach
    public void setUp() {
        sistema = new SolucionSistemasEcuaciones();
    }
    
   
    
    @Nested
    @DisplayName("Tests de Eliminación de Gauss")
    class TestsEliminacionGauss {
        
        @Test
        @DisplayName("Sistema 2x2 Simple")
        public void testGauss_Sistema2x2Simple() {
            // 2x + y = 5, x + y = 3 → x=2, y=1
            double[][] matriz = {{2, 1, 5}, {1, 1, 3}};
            double[] resultado = invocarEliminacionGauss(matriz, 2);
            
            assertNotNull(resultado, "Debe tener solución");
            assertEquals(2.0, resultado[0], DELTA, "x debe ser 2");
            assertEquals(1.0, resultado[1], DELTA, "y debe ser 1");
        }
        
        @Test
        @DisplayName("Sistema 3x3 Completo")
        public void testGauss_Sistema3x3() {
            // 2x+y-z=8, -3x-y+2z=-11, -2x+y+2z=-3 → x=2, y=3, z=-1
            double[][] matriz = {
                {2, 1, -1, 8},
                {-3, -1, 2, -11},
                {-2, 1, 2, -3}
            };
            double[] resultado = invocarEliminacionGauss(matriz, 3);
            
            assertAll("Verificar todas las soluciones",
                () -> assertNotNull(resultado),
                () -> assertEquals(2.0, resultado[0], DELTA, "x debe ser 2"),
                () -> assertEquals(3.0, resultado[1], DELTA, "y debe ser 3"),
                () -> assertEquals(-1.0, resultado[2], DELTA, "z debe ser -1")
            );
        }
        
        @Test
        @DisplayName("Sistema 4x4")
        public void testGauss_Sistema4x4() {
            double[][] matriz = {
                {1, 2, -1, 1, 6},
                {2, 1, 1, -1, 3},
                {-1, 1, 2, 2, 6},
                {1, -1, 1, 2, 5}
            };
            double[] resultado = invocarEliminacionGauss(matriz, 4);
            
            assertNotNull(resultado);
            assertEquals(4, resultado.length);
            verificarSolucion(matriz, resultado, 4);
        }
        
        @Test
        @DisplayName("Matriz Identidad 3x3")
        public void testGauss_MatrizIdentidad() {
            double[][] matriz = {
                {1, 0, 0, 5},
                {0, 1, 0, 3},
                {0, 0, 1, 7}
            };
            double[] resultado = invocarEliminacionGauss(matriz, 3);
            
            assertAll("Soluciones triviales",
                () -> assertNotNull(resultado),
                () -> assertEquals(5.0, resultado[0], DELTA),
                () -> assertEquals(3.0, resultado[1], DELTA),
                () -> assertEquals(7.0, resultado[2], DELTA)
            );
        }
        
        @Test
        @DisplayName("Valores Negativos")
        public void testGauss_ValoresNegativos() {
            double[][] matriz = {
                {-2, 3, -8},
                {4, -1, 15}
            };
            double[] resultado = invocarEliminacionGauss(matriz, 2);
            
            assertNotNull(resultado);
            verificarSolucion(matriz, resultado, 2);
        }
        
        @Test
        @DisplayName("Valores Decimales")
        public void testGauss_Decimales() {
            double[][] matriz = {
                {1.5, 2.5, 8.5},
                {3.2, -1.8, 4.6}
            };
            double[] resultado = invocarEliminacionGauss(matriz, 2);
            
            assertNotNull(resultado);
            verificarSolucion(matriz, resultado, 2);
        }
        
        
        
        
        @Test
        @DisplayName("Sistema 5x5")
        public void testGauss_Sistema5x5() {
            double[][] matriz = {
                {2, 1, -1, 0, 3, 8},
                {1, 3, 2, 1, -2, 14},
                {-1, 2, 1, -1, 1, 6},
                {3, -1, 0, 2, 1, 10},
                {1, 1, 1, 1, 1, 10}
            };
            double[] resultado = invocarEliminacionGauss(matriz, 5);
            
            assertNotNull(resultado);
            assertEquals(5, resultado.length);
            verificarSolucion(matriz, resultado, 5);
        }
        
        @Test
        @DisplayName("Coeficientes Grandes")
        public void testGauss_CoeficientesGrandes() {
            double[][] matriz = {
                {100, 200, 500},
                {300, 150, 750}
            };
            double[] resultado = invocarEliminacionGauss(matriz, 2);
            
            assertNotNull(resultado);
            verificarSolucion(matriz, resultado, 2);
        }
    }
    
    
    @Nested
    @DisplayName("Tests de Gauss-Jordan")
    class TestsGaussJordan {
        
        @Test
        @DisplayName("Sistema 2x2 Simple")
        public void testJordan_Sistema2x2Simple() {
            // 2x + y = 5, x + y = 3 → x=2, y=1
            double[][] matriz = {{2, 1, 5}, {1, 1, 3}};
            double[] resultado = invocarGaussJordan(matriz, 2);
            
            assertNotNull(resultado, "Debe tener solución");
            assertEquals(2.0, resultado[0], DELTA, "x debe ser 2");
            assertEquals(1.0, resultado[1], DELTA, "y debe ser 1");
        }
        
        @Test
        @DisplayName("Sistema 3x3 Completo")
        public void testJordan_Sistema3x3() {
            // 2x+y-z=8, -3x-y+2z=-11, -2x+y+2z=-3 → x=2, y=3, z=-1
            double[][] matriz = {
                {2, 1, -1, 8},
                {-3, -1, 2, -11},
                {-2, 1, 2, -3}
            };
            double[] resultado = invocarGaussJordan(matriz, 3);
            
            assertAll("Verificar todas las soluciones",
                () -> assertNotNull(resultado),
                () -> assertEquals(2.0, resultado[0], DELTA, "x debe ser 2"),
                () -> assertEquals(3.0, resultado[1], DELTA, "y debe ser 3"),
                () -> assertEquals(-1.0, resultado[2], DELTA, "z debe ser -1")
            );
        }
        
        @Test
        @DisplayName("Sistema 4x4")
        public void testJordan_Sistema4x4() {
            double[][] matriz = {
                {1, 2, -1, 1, 6},
                {2, 1, 1, -1, 3},
                {-1, 1, 2, 2, 6},
                {1, -1, 1, 2, 5}
            };
            double[] resultado = invocarGaussJordan(matriz, 4);
            
            assertNotNull(resultado);
            assertEquals(4, resultado.length);
            verificarSolucion(matriz, resultado, 4);
        }
        
        @Test
        @DisplayName("Matriz Identidad 3x3")
        public void testJordan_MatrizIdentidad() {
            double[][] matriz = {
                {1, 0, 0, 5},
                {0, 1, 0, 3},
                {0, 0, 1, 7}
            };
            double[] resultado = invocarGaussJordan(matriz, 3);
            
            assertAll("Soluciones triviales",
                () -> assertNotNull(resultado),
                () -> assertEquals(5.0, resultado[0], DELTA),
                () -> assertEquals(3.0, resultado[1], DELTA),
                () -> assertEquals(7.0, resultado[2], DELTA)
            );
        }
        
        @Test
        @DisplayName("Valores Negativos")
        public void testJordan_ValoresNegativos() {
            double[][] matriz = {
                {-2, 3, -8},
                {4, -1, 15}
            };
            double[] resultado = invocarGaussJordan(matriz, 2);
            
            assertNotNull(resultado);
            verificarSolucion(matriz, resultado, 2);
        }
        
        @Test
        @DisplayName("Valores Decimales")
        public void testJordan_Decimales() {
            double[][] matriz = {
                {1.5, 2.5, 8.5},
                {3.2, -1.8, 4.6}
            };
            double[] resultado = invocarGaussJordan(matriz, 2);
            
            assertNotNull(resultado);
            verificarSolucion(matriz, resultado, 2);
        }
        
        @Test
        @DisplayName("Sistema Singular - Sin Solución Única")
        public void testJordan_SistemaSingular() {
            double[][] matriz = {
                {2, 1, 1},
                {4, 2, 3}
            };
            double[] resultado = invocarGaussJordan(matriz, 2);
            
            assertNull(resultado, "Sistema singular debe retornar null");
        }
        
        @Test
        @DisplayName("Sistema 5x5")
        public void testJordan_Sistema5x5() {
            double[][] matriz = {
                {2, 1, -1, 0, 3, 8},
                {1, 3, 2, 1, -2, 14},
                {-1, 2, 1, -1, 1, 6},
                {3, -1, 0, 2, 1, 10},
                {1, 1, 1, 1, 1, 10}
            };
            double[] resultado = invocarGaussJordan(matriz, 5);
            
            assertNotNull(resultado);
            assertEquals(5, resultado.length);
            verificarSolucion(matriz, resultado, 5);
        }
        
        @Test
        @DisplayName("Coeficientes Grandes")
        public void testJordan_CoeficientesGrandes() {
            double[][] matriz = {
                {100, 200, 500},
                {300, 150, 750}
            };
            double[] resultado = invocarGaussJordan(matriz, 2);
            
            assertNotNull(resultado);
            verificarSolucion(matriz, resultado, 2);
        }
    }
    

    
    private double[] invocarEliminacionGauss(double[][] matriz, int n) {
        try {
            java.lang.reflect.Method metodo = SolucionSistemasEcuaciones.class
                .getDeclaredMethod("eliminacionGauss", double[][].class, int.class);
            metodo.setAccessible(true);
            return (double[]) metodo.invoke(sistema, matriz, n);
        } catch (Exception e) {
            fail("Error al invocar eliminacionGauss: " + e.getMessage());
            return null;
        }
    }
    
    private double[] invocarGaussJordan(double[][] matriz, int n) {
        try {
            java.lang.reflect.Method metodo = SolucionSistemasEcuaciones.class
                .getDeclaredMethod("gaussJordan", double[][].class, int.class);
            metodo.setAccessible(true);
            return (double[]) metodo.invoke(sistema, matriz, n);
        } catch (Exception e) {
            fail("Error al invocar gaussJordan: " + e.getMessage());
            return null;
        }
    }
    
    private void verificarSolucion(double[][] matriz, double[] solucion, int n) {
        for (int i = 0; i < n; i++) {
            double suma = 0;
            for (int j = 0; j < n; j++) {
                suma += matriz[i][j] * solucion[j];
            }
            assertEquals(matriz[i][n], suma, DELTA,
                "Ecuación " + (i+1) + " debe satisfacerse");
        }
    }
}
