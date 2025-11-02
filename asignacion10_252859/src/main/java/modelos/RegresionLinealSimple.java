/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelos;

public class RegresionLinealSimple {
    
    public static double[] calcular(double[] x, double[] y) {
        int n = x.length;
        
        // Calcular medias
        double mediaX = 0, mediaY = 0;
        for (int i = 0; i < n; i++) {
            mediaX += x[i];
            mediaY += y[i];
        }
        mediaX /= n;
        mediaY /= n;
        
        // Calcular pendiente (b1) e intercepto (b0)
        double numerador = 0, denominador = 0;
        for (int i = 0; i < n; i++) {
            numerador += (x[i] - mediaX) * (y[i] - mediaY);
            denominador += (x[i] - mediaX) * (x[i] - mediaX);
        }
        
        double b1 = numerador / denominador;
        double b0 = mediaY - b1 * mediaX;
        
        return new double[]{b0, b1};
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
            double yPred = coeficientes[0] + coeficientes[1] * x[i];
            ssTotal += Math.pow(y[i] - mediaY, 2);
            ssRes += Math.pow(y[i] - yPred, 2);
        }
        
        return 1 - (ssRes / ssTotal);
    }
    
    public static double predecir(double x, double[] coeficientes) {
        return coeficientes[0] + coeficientes[1] * x;
    }
    
    public static String obtenerEcuacion(double[] coeficientes) {
        StringBuilder ecuacion = new StringBuilder("y = ");
        ecuacion.append(String.format("%.6f", coeficientes[0]));
        
        if (coeficientes[1] >= 0) {
            ecuacion.append(" + ").append(String.format("%.6f", coeficientes[1]));
        } else {
            ecuacion.append(" - ").append(String.format("%.6f", Math.abs(coeficientes[1])));
        }
        ecuacion.append("x");
        
        return ecuacion.toString();
    }
    
    public static double calcularCorrelacion(double[] x, double[] y) {
        int n = x.length;
        double mediaX = 0, mediaY = 0;
        
        for (int i = 0; i < n; i++) {
            mediaX += x[i];
            mediaY += y[i];
        }
        mediaX /= n;
        mediaY /= n;
        
        double numerador = 0, denominadorX = 0, denominadorY = 0;
        for (int i = 0; i < n; i++) {
            numerador += (x[i] - mediaX) * (y[i] - mediaY);
            denominadorX += Math.pow(x[i] - mediaX, 2);
            denominadorY += Math.pow(y[i] - mediaY, 2);
        }
        
        return numerador / Math.sqrt(denominadorX * denominadorY);
    }
}
