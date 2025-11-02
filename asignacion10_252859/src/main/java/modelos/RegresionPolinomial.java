/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;


public class RegresionPolinomial {
    
    public static double[] calcular(double[] x, double[] y, int grado) {
        int n = x.length;
        int m = grado + 1;
        
        double[][] A = new double[m][m];
        double[] b = new double[m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    A[i][j] += Math.pow(x[k], i + j);
                }
            }
            
            b[i] = 0;
            for (int k = 0; k < n; k++) {
                b[i] += y[k] * Math.pow(x[k], i);
            }
        }
        
        return MatrizUtil.resolverSistema(A, b);
    }
    
    public static double calcularR2(double[] x, double[] y, double[] coeficientes) {
        double mediaY = 0;
        for (double yi : y) {
            mediaY += yi;
        }
        mediaY /= y.length;
        
        double ssTotal = 0;
        double ssRes = 0;
        
        for (int i = 0; i < x.length; i++) {
            double yPred = evaluarPolinomio(x[i], coeficientes);
            ssTotal += Math.pow(y[i] - mediaY, 2);
            ssRes += Math.pow(y[i] - yPred, 2);
        }
        
        return 1 - (ssRes / ssTotal);
    }
    
    public static double evaluarPolinomio(double x, double[] coeficientes) {
        double resultado = 0;
        for (int i = 0; i < coeficientes.length; i++) {
            resultado += coeficientes[i] * Math.pow(x, i);
        }
        return resultado;
    }
    
    public static String obtenerEcuacion(double[] coeficientes) {
        StringBuilder ecuacion = new StringBuilder("y = ");
        int grado = coeficientes.length - 1;
        
        for (int i = grado; i >= 0; i--) {
            if (i == grado) {
                ecuacion.append(String.format("%.6f", coeficientes[i]));
            } else {
                if (coeficientes[i] >= 0) {
                    ecuacion.append(" + ").append(String.format("%.6f", coeficientes[i]));
                } else {
                    ecuacion.append(" - ").append(String.format("%.6f", Math.abs(coeficientes[i])));
                }
            }
            
            if (i > 1) {
                ecuacion.append("x^").append(i);
            } else if (i == 1) {
                ecuacion.append("x");
            }
        }
        
        return ecuacion.toString();
    }
}