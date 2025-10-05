/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.solucionesprueba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class SolucionSistemasEcuaciones extends JFrame {
    private JSpinner spinnerTamano;
    private JButton btnCrearMatriz, btnResolver, btnLimpiar;
    private JComboBox<String> comboMetodo;
    private JPanel panelMatriz;
    private JTextField[][] camposMatriz;
    private JTextArea areaResultados;
    private int tamanoActual = 0;
    
    public SolucionSistemasEcuaciones() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Solucion de Sistemas de Ecuaciones");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(200, 200, 210));
        
        // Panel superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(200, 200, 210));
        panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        JLabel lblTamano = new JLabel("Tamaño del sistema (n):");
        lblTamano.setFont(new Font("Arial", Font.BOLD, 14));
        
        spinnerTamano = new JSpinner(new SpinnerNumberModel(2, 2, 10, 1));
        spinnerTamano.setPreferredSize(new Dimension(80, 30));
        spinnerTamano.setFont(new Font("Arial", Font.PLAIN, 14));
        
        btnCrearMatriz = new JButton("Crear Matriz");
        btnCrearMatriz.setFont(new Font("Arial", Font.BOLD, 12));
        btnCrearMatriz.setPreferredSize(new Dimension(130, 35));
        btnCrearMatriz.addActionListener(e -> crearMatriz());
        
        panelSuperior.add(lblTamano);
        panelSuperior.add(spinnerTamano);
        panelSuperior.add(btnCrearMatriz);
        
        // Panel central para la matriz
        panelMatriz = new JPanel();
        panelMatriz.setBackground(new Color(200, 200, 210));
        JScrollPane scrollMatriz = new JScrollPane(panelMatriz);
        scrollMatriz.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel de método y botones
        JPanel panelMetodo = new JPanel();
        panelMetodo.setBackground(new Color(200, 200, 210));
        panelMetodo.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        JLabel lblMetodo = new JLabel("Seleccione el metodo:");
        lblMetodo.setFont(new Font("Arial", Font.BOLD, 14));
        
        comboMetodo = new JComboBox<>(new String[]{"Eliminacion de Gauss", "Gauss-Jordan"});
        comboMetodo.setFont(new Font("Arial", Font.PLAIN, 12));
        comboMetodo.setPreferredSize(new Dimension(200, 30));
        
        btnResolver = new JButton("Resolver Sistema");
        btnResolver.setFont(new Font("Arial", Font.BOLD, 12));
        btnResolver.setPreferredSize(new Dimension(150, 35));
        btnResolver.addActionListener(e -> resolverSistema());
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setFont(new Font("Arial", Font.BOLD, 12));
        btnLimpiar.setPreferredSize(new Dimension(100, 35));
        btnLimpiar.addActionListener(e -> limpiar());
        
        panelMetodo.add(lblMetodo);
        panelMetodo.add(comboMetodo);
        panelMetodo.add(btnResolver);
        panelMetodo.add(btnLimpiar);
        
        // Área de resultados
        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        areaResultados.setFont(new Font("Monospaced", Font.PLAIN, 12));
        areaResultados.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scrollResultados = new JScrollPane(areaResultados);
        scrollResultados.setPreferredSize(new Dimension(800, 200));
        scrollResultados.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Agregar componentes al frame
        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.add(panelSuperior, BorderLayout.NORTH);
        panelTop.setBackground(new Color(200, 200, 210));
        
        add(panelTop, BorderLayout.NORTH);
        add(scrollMatriz, BorderLayout.CENTER);
        
        JPanel panelBottom = new JPanel(new BorderLayout());
        panelBottom.add(panelMetodo, BorderLayout.NORTH);
        panelBottom.add(scrollResultados, BorderLayout.CENTER);
        panelBottom.setBackground(new Color(200, 200, 210));
        add(panelBottom, BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);
    }
    
    private void crearMatriz() {
        int n = (int) spinnerTamano.getValue();
        tamanoActual = n;
        
        panelMatriz.removeAll();
        panelMatriz.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        
        camposMatriz = new JTextField[n][n + 1];
        
        for (int i = 0; i < n; i++) {
            gbc.gridy = i;
            for (int j = 0; j < n + 1; j++) {
                gbc.gridx = j;
                
                if (j == n) {
                    // Separador antes de la columna de términos independientes
                    JLabel separador = new JLabel("|");
                    separador.setFont(new Font("Arial", Font.BOLD, 20));
                    panelMatriz.add(separador, gbc);
                    gbc.gridx = j + 1;
                }
                
                camposMatriz[i][j] = new JTextField("0.0", 5);
                camposMatriz[i][j].setFont(new Font("Arial", Font.PLAIN, 12));
                camposMatriz[i][j].setHorizontalAlignment(JTextField.CENTER);
                panelMatriz.add(camposMatriz[i][j], gbc);
            }
        }
        
        areaResultados.setText("Matriz de " + n + "x" + n + " creada\nIngrese los coeficientes del sistema");
        
        panelMatriz.revalidate();
        panelMatriz.repaint();
    }
    
    private void resolverSistema() {
        if (tamanoActual == 0) {
            JOptionPane.showMessageDialog(this, "Primero debe crear la matriz", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int n = tamanoActual;
            double[][] matriz = new double[n][n + 1];
            
            // Leer valores de la matriz
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n; j++) {
                    String texto = camposMatriz[i][j].getText().trim();
                    matriz[i][j] = Double.parseDouble(texto);
                }
            }
            
            // Aplicar el método seleccionado
            String metodoSeleccionado = (String) comboMetodo.getSelectedItem();
            double[] soluciones;
            
            if (metodoSeleccionado.equals("Gauss-Jordan")) {
                soluciones = gaussJordan(matriz, n);
            } else {
                soluciones = eliminacionGauss(matriz, n);
            }
            
            if (soluciones == null) {
                areaResultados.setText("El sistema no tiene solución única o es inconsistente");
                return;
            }
            
            // Mostrar resultados
            StringBuilder resultado = new StringBuilder();
            DecimalFormat df = new DecimalFormat("#.####");
            
            resultado.append("=== ").append(metodoSeleccionado.toUpperCase()).append(" ===\n\n");
            resultado.append("Sistema resuelto exitosamente\n\n");
            resultado.append("Soluciones:\n");
            
            for (int i = 0; i < n; i++) {
                resultado.append("x").append(i + 1).append(" = ")
                        .append(df.format(soluciones[i])).append("\n");
            }
            
            resultado.append("\n\nVerificación:\n");
            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    suma += matriz[i][j] * soluciones[j];
                }
                resultado.append("Ecuación ").append(i + 1).append(": ")
                        .append(df.format(suma)).append(" ≈ ")
                        .append(df.format(matriz[i][n])).append("\n");
            }
            
            areaResultados.setText(resultado.toString());
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Por favor ingrese valores numéricos válidos", 
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private double[] eliminacionGauss(double[][] matriz, int n) {
        // Crear copia de la matriz para no modificar la original
        double[][] m = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matriz[i], 0, m[i], 0, n + 1);
        }
        
        // Eliminación hacia adelante
        for (int k = 0; k < n - 1; k++) {
            // Pivoteo parcial
            int maxFila = k;
            for (int i = k + 1; i < n; i++) {
                if (Math.abs(m[i][k]) > Math.abs(m[maxFila][k])) {
                    maxFila = i;
                }
            }
            
            // Intercambiar filas
            if (maxFila != k) {
                double[] temp = m[k];
                m[k] = m[maxFila];
                m[maxFila] = temp;
            }
            
            // Verificar pivote cero
            if (Math.abs(m[k][k]) < 1e-10) {
                return null;
            }
            
            // Eliminación
            for (int i = k + 1; i < n; i++) {
                double factor = m[i][k] / m[k][k];
                for (int j = k; j <= n; j++) {
                    m[i][j] -= factor * m[k][j];
                }
            }
        }
        
        // Sustitución hacia atrás
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double suma = 0;
            for (int j = i + 1; j < n; j++) {
                suma += m[i][j] * x[j];
            }
            x[i] = (m[i][n] - suma) / m[i][i];
        }
        
        return x;
    }
    
    private double[] gaussJordan(double[][] matriz, int n) {
        // Crear copia de la matriz para no modificar la original
        double[][] m = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matriz[i], 0, m[i], 0, n + 1);
        }
        
        // Proceso de eliminación Gauss-Jordan
        for (int k = 0; k < n; k++) {
            // Pivoteo parcial
            int maxFila = k;
            for (int i = k + 1; i < n; i++) {
                if (Math.abs(m[i][k]) > Math.abs(m[maxFila][k])) {
                    maxFila = i;
                }
            }
            
            // Intercambiar filas
            if (maxFila != k) {
                double[] temp = m[k];
                m[k] = m[maxFila];
                m[maxFila] = temp;
            }
            
            // Verificar pivote cero
            if (Math.abs(m[k][k]) < 1e-10) {
                return null;
            }
            
            // Normalizar la fila k (hacer que el pivote sea 1)
            double pivote = m[k][k];
            for (int j = k; j <= n; j++) {
                m[k][j] /= pivote;
            }
            
            // Eliminación hacia adelante y hacia atrás
            for (int i = 0; i < n; i++) {
                if (i != k) {
                    double factor = m[i][k];
                    for (int j = k; j <= n; j++) {
                        m[i][j] -= factor * m[k][j];
                    }
                }
            }
        }
        
        // Las soluciones están en la última columna
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = m[i][n];
        }
        
        return x;
    }
    
    private void limpiar() {
        if (tamanoActual > 0) {
            for (int i = 0; i < tamanoActual; i++) {
                for (int j = 0; j <= tamanoActual; j++) {
                    camposMatriz[i][j].setText("0.0");
                }
            }
        }
        areaResultados.setText("");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SolucionSistemasEcuaciones frame = new SolucionSistemasEcuaciones();
            frame.setVisible(true);
        });
    }
}
