/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;


public class errores {

public class CalculosError {
    public static double errorAbsoluto(double exacto, double aproximado) {
        return Math.abs(exacto - aproximado);
    }

    public static double errorRelativo(double exacto, double aproximado) {
        double abs = errorAbsoluto(exacto, aproximado);
        return abs / Math.abs(exacto);
    }
}

    
}
