/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

public class MatrizUtil {
    
    public static double[] resolverSistema(double[][] A, double[] b) {
        int n = b.length;
        double[][] Ab = new double[n][n + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Ab[i][j] = A[i][j];
            }
            Ab[i][n] = b[i];
        }
        
        for (int i = 0; i < n; i++) {
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(Ab[k][i]) > Math.abs(Ab[maxRow][i])) {
                    maxRow = k;
                }
            }
            
            double[] temp = Ab[i];
            Ab[i] = Ab[maxRow];
            Ab[maxRow] = temp;
            
            for (int k = i + 1; k < n; k++) {
                double factor = Ab[k][i] / Ab[i][i];
                for (int j = i; j <= n; j++) {
                    Ab[k][j] -= factor * Ab[i][j];
                }
            }
        }
        
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            x[i] = Ab[i][n];
            for (int j = i + 1; j < n; j++) {
                x[i] -= Ab[i][j] * x[j];
            }
            x[i] /= Ab[i][i];
        }
        
        return x;
    }
    
    public static double[][] transponer(double[][] A) {
        int m = A.length;
        int n = A[0].length;
        double[][] At = new double[n][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                At[j][i] = A[i][j];
            }
        }
        return At;
    }
    
    public static double[][] multiplicar(double[][] A, double[][] B) {
        int m = A.length;
        int n = B[0].length;
        int p = B.length;
        double[][] C = new double[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0;
                for (int k = 0; k < p; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
    
    public static double[] multiplicarVector(double[][] A, double[] b) {
        int m = A.length;
        double[] c = new double[m];
        
        for (int i = 0; i < m; i++) {
            c[i] = 0;
            for (int j = 0; j < b.length; j++) {
                c[i] += A[i][j] * b[j];
            }
        }
        return c;
    }
}