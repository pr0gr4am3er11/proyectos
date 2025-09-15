package implementaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;


public class Tabula {

   
    public static class Punto {
        public double x, y;

        public Punto(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static List<Punto> tabula(DoubleUnaryOperator f, double xi, double xf, double incx) {
        List<Punto> resultados = new ArrayList<>();

        double x = xi;
        double maxY = Double.NEGATIVE_INFINITY;
        double minY = Double.POSITIVE_INFINITY;
        double maxX = xi, minX = xi;

        
        while (x <= xf + 1e-9) {
            double y = f.applyAsDouble(x);
            resultados.add(new Punto(x, y));

            
            if (y > maxY) {
                maxY = y;
                maxX = x;
            }
           
            if (y < minY) {
                minY = y;
                minX = x;
            }

            x += incx;
        }

        resultados.add(new Punto(maxX, maxY)); 
        resultados.add(new Punto(minX, minY)); 
        return resultados;
    }
}