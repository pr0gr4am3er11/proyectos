
package implementaciones;

public class Interpolacion {
    
   
    public void despliegaPuntos(double puntos[][], int n) {
        System.out.println("\n+--------+----------+----------+");
        System.out.println("|  Punto |    x     |    y     |");
        System.out.println("+--------+----------+----------+");
        
       
        for (int i = 0; i <= n; i++) {
            System.out.printf("|   %2d   | %8.6f | %8.6f |\n", 
                            i, puntos[0][i], puntos[1][i]);
        }
        
        System.out.println("+--------+----------+----------+");
    }
    
    
    public double interpolacionLagrange(double puntos[][], int n, double x) {
        double resultado = 0.0;
        
      
        for (int i = 0; i <= n; i++) {
            
            double yi = puntos[1][i];
            
            
            double Li = multiplicatoria(i, puntos, n, x);
            
            
            resultado += yi * Li;
        }
        
        return resultado;
    }
    
   
    
    public double multiplicatoria(int i, double puntos[][], int n, double x) {
        double producto = 1.0;
        
        
        for (int j = 0; j <= n; j++) {
            if (j != i) {
                // Obtener x_i y x_j
                double xi = puntos[0][i];
                double xj = puntos[0][j];
                
                
                producto *= (x - xj) / (xi - xj);
            }
        }
        
        return producto;
    }
}