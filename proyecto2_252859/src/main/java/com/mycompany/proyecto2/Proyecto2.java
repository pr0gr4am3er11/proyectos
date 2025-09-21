/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto2;

import MetodosNumericos.MetodosNumericos;
import javax.swing.SwingUtilities;
import static javax.swing.SwingUtilities.invokeLater;

/**
 *
 * @author migue
 */
public class Proyecto2 {

    public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
            MetodosNumericos app = new MetodosNumericos();
            app.setVisible(true);
        });
    }
}

    
