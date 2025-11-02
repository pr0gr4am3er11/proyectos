/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelos;

import java.util.ArrayList;

public class RegresionLinealMultiple {
    
    public static double[] calcular(ArrayList<double[]> datos, int numVariables) {
        int n = datos.size();
        int m = numVariables + 1;
        
        double[][] X = new double[n][m];
        double[] y = new double[n];
        
        for (int i = 0; i < n; i++) {
            X[i][0] = 1;
            for (int j = 0; j < numVariables; j++) {
                X[i][j + 1] = datos.get(i)[j];
            }
            y[i] = datos.get(i)[numVariables];
        }
        
        double[][] Xt = MatrizUtil.transponer(X);
        double[][] XtX = MatrizUtil.multiplicar(Xt, X);
        double[] Xty = MatrizUtil.multiplicarVector(Xt, y);
        
        return MatrizUtil.resolverSistema(XtX, Xty);
    }
    
    public static double calcularR2(ArrayList<double[]> datos, double[] coeficientes, int numVariables) {
        double mediaY = 0;
        for (double[] fila : datos) {
            mediaY += fila[numVariables];
        }
        mediaY /= datos.size();
        
        double ssTotal = 0;
        double ssRes = 0;
        
        for (double[] fila : datos) {
            double yPred = predecir(fila, coeficientes, numVariables);
            ssTotal += Math.pow(fila[numVariables] - mediaY, 2);
            ssRes += Math.pow(fila[numVariables] - yPred, 2);
        }
        
        return 1 - (ssRes / ssTotal);
    }
    
    public static double calcularR2Ajustado(ArrayList<double[]> datos, double[] coeficientes, int numVariables) {
        double r2 = calcularR2(datos, coeficientes, numVariables);
        int n = datos.size();
        int k = numVariables;
        
        return 1 - ((1 - r2) * (n - 1)) / (n - k - 1);
    }
    
    public static double predecir(double[] valores, double[] coeficientes, int numVariables) {
        double resultado = coeficientes[0];
        for (int i = 0; i < numVariables; i++) {
            resultado += coeficientes[i + 1] * valores[i];
        }
        return resultado;
    }
    
    public static String obtenerEcuacion(double[] coeficientes) {
        StringBuilder ecuacion = new StringBuilder("y = ");
        ecuacion.append(String.format("%.6f", coeficientes[0]));
        
        for (int i = 1; i < coeficientes.length; i++) {
            if (coeficientes[i] >= 0) {
                ecuacion.append(" + ").append(String.format("%.6f", coeficientes[i]));
            } else {
                ecuacion.append(" - ").append(String.format("%.6f", Math.abs(coeficientes[i])));
            }
            ecuacion.append("x").append(i);
        }
        
        return ecuacion.toString();
    }
}
