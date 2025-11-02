
package pruebas;

import modelos.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class VentanaPrincipal extends JFrame {
    
    public VentanaPrincipal() {
        setTitle("Calculador de Regresiones");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 13));
        
        tabbedPane.addTab("Regresión Lineal Simple", crearPanelLinealSimple());
        tabbedPane.addTab("Regresión Polinomial", crearPanelPolinomial());
        tabbedPane.addTab("Regresión Lineal Múltiple", crearPanelLinealMultiple());
        
        add(tabbedPane);
    }
    
    private JPanel crearPanelLinealSimple() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        JLabel label = new JLabel("Puntos (x, y):");
        label.setFont(new Font("Arial", Font.BOLD, 12));
        topPanel.add(label, BorderLayout.NORTH);
        
        JTextArea puntosArea = new JTextArea(5, 40);
        puntosArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        puntosArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPuntos = new JScrollPane(puntosArea);
        topPanel.add(scrollPuntos, BorderLayout.CENTER);
        panel.add(topPanel, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton calcularBtn = new JButton("Calcular Regresión");
        JButton limpiarBtn = new JButton("Limpiar");
        JButton ejemploBtn = new JButton("Cargar Ejemplo");
        calcularBtn.setFont(new Font("Arial", Font.BOLD, 12));
        
        DefaultTableModel modeloTabla = new DefaultTableModel(new String[]{"X", "Y"}, 0);
        JTable tablaPuntos = new JTable(modeloTabla);
        JTextArea resultadoArea = new JTextArea(6, 40);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        calcularBtn.addActionListener(e -> {
            try {
                String[] lineas = puntosArea.getText().trim().split("\n");
                if (lineas.length == 0 || lineas[0].isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Ingrese los puntos");
                    return;
                }
                
                ArrayList<Double> xList = new ArrayList<>();
                ArrayList<Double> yList = new ArrayList<>();
                modeloTabla.setRowCount(0);
                
                for (String linea : lineas) {
                    linea = linea.trim();
                    if (linea.isEmpty()) continue;
                    String[] partes = linea.split("[,\\s]+");
                    if (partes.length >= 2) {
                        double x = Double.parseDouble(partes[0]);
                        double y = Double.parseDouble(partes[1]);
                        xList.add(x);
                        yList.add(y);
                        modeloTabla.addRow(new Object[]{x, y});
                    }
                }
                
                if (xList.size() < 2) {
                    JOptionPane.showMessageDialog(panel, "Se necesitan al menos 2 puntos");
                    return;
                }
                
                double[] x = xList.stream().mapToDouble(Double::doubleValue).toArray();
                double[] y = yList.stream().mapToDouble(Double::doubleValue).toArray();
                
                double[] coef = RegresionLinealSimple.calcular(x, y);
                double r2 = RegresionLinealSimple.calcularR2(x, y, coef);
                double r = RegresionLinealSimple.calcularCorrelacion(x, y);
                
                StringBuilder resultado = new StringBuilder();
                resultado.append("Ecuación de regresión lineal simple:\n\n");
                resultado.append(RegresionLinealSimple.obtenerEcuacion(coef));
                resultado.append("\n\nCoeficientes:\n");
                resultado.append(String.format("  Intercepto (b0): %.6f\n", coef[0]));
                resultado.append(String.format("  Pendiente (b1): %.6f\n", coef[1]));
                resultado.append(String.format("\nCoeficiente de correlación (r): %.6f", r));
                resultado.append(String.format("\nCoeficiente de determinación (R²): %.6f", r2));
                
                resultadoArea.setText(resultado.toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });
        
        limpiarBtn.addActionListener(e -> {
            puntosArea.setText("");
            modeloTabla.setRowCount(0);
            resultadoArea.setText("");
        });
        
        ejemploBtn.addActionListener(e -> {
            puntosArea.setText("1 2\n2 4\n3 6\n4 8\n5 10\n6 12\n7 14\n8 16");
        });
        
        buttonPanel.add(calcularBtn);
        buttonPanel.add(limpiarBtn);
        buttonPanel.add(ejemploBtn);
        panel.add(buttonPanel, BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        
        JPanel tablaPanel = new JPanel(new BorderLayout());
        tablaPanel.setBorder(BorderFactory.createTitledBorder("Tabla de Puntos:"));
        tablaPuntos.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scrollTabla = new JScrollPane(tablaPuntos);
        scrollTabla.setPreferredSize(new Dimension(400, 150));
        tablaPanel.add(scrollTabla, BorderLayout.CENTER);
        
        JPanel resultadoPanel = new JPanel(new BorderLayout());
        resultadoPanel.setBorder(BorderFactory.createTitledBorder("Resultado:"));
        JScrollPane scrollResultado = new JScrollPane(resultadoArea);
        resultadoPanel.add(scrollResultado, BorderLayout.CENTER);
        
        bottomPanel.add(tablaPanel);
        bottomPanel.add(resultadoPanel);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel crearPanelPolinomial() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel gradoLabel = new JLabel("Grado del polinomio (n):");
        gradoLabel.setFont(new Font("Arial", Font.BOLD, 12));
        topPanel.add(gradoLabel, gbc);
        
        gbc.gridx = 1;
        JTextField gradoField = new JTextField(10);
        topPanel.add(gradoField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel puntosLabel = new JLabel("Puntos (x, y):");
        puntosLabel.setFont(new Font("Arial", Font.BOLD, 12));
        topPanel.add(puntosLabel, gbc);
        
        gbc.gridx = 1; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        JTextArea puntosArea = new JTextArea(5, 30);
        puntosArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        puntosArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPuntos = new JScrollPane(puntosArea);
        topPanel.add(scrollPuntos, gbc);
        panel.add(topPanel, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton calcularBtn = new JButton("Calcular Polinomio");
        JButton limpiarBtn = new JButton("Limpiar");
        JButton ejemplo1Btn = new JButton("Ejemplo: Línea");
        JButton ejemplo2Btn = new JButton("Ejemplo: Parábola");
        calcularBtn.setFont(new Font("Arial", Font.BOLD, 12));
        
        DefaultTableModel modeloTabla = new DefaultTableModel(new String[]{"X", "Y"}, 0);
        JTable tablaPuntos = new JTable(modeloTabla);
        JTextArea resultadoArea = new JTextArea(6, 40);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        calcularBtn.addActionListener(e -> {
            try {
                int grado = Integer.parseInt(gradoField.getText().trim());
                String[] lineas = puntosArea.getText().trim().split("\n");
                
                if (lineas.length == 0 || lineas[0].isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Ingrese los puntos");
                    return;
                }
                
                ArrayList<Double> xList = new ArrayList<>();
                ArrayList<Double> yList = new ArrayList<>();
                modeloTabla.setRowCount(0);
                
                for (String linea : lineas) {
                    linea = linea.trim();
                    if (linea.isEmpty()) continue;
                    String[] partes = linea.split("[,\\s]+");
                    if (partes.length >= 2) {
                        double x = Double.parseDouble(partes[0]);
                        double y = Double.parseDouble(partes[1]);
                        xList.add(x);
                        yList.add(y);
                        modeloTabla.addRow(new Object[]{x, y});
                    }
                }
                
                if (xList.size() < grado + 1) {
                    JOptionPane.showMessageDialog(panel, 
                        "Se necesitan al menos " + (grado + 1) + " puntos");
                    return;
                }
                
                double[] x = xList.stream().mapToDouble(Double::doubleValue).toArray();
                double[] y = yList.stream().mapToDouble(Double::doubleValue).toArray();
                
                double[] coef = RegresionPolinomial.calcular(x, y, grado);
                double r2 = RegresionPolinomial.calcularR2(x, y, coef);
                
                StringBuilder resultado = new StringBuilder();
                resultado.append("Ecuación del polinomio:\n\n");
                resultado.append(RegresionPolinomial.obtenerEcuacion(coef));
                resultado.append("\n\nCoeficiente de determinación (R²): ");
                resultado.append(String.format("%.6f", r2));
                
                resultadoArea.setText(resultado.toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });
        
        limpiarBtn.addActionListener(e -> {
            gradoField.setText("");
            puntosArea.setText("");
            modeloTabla.setRowCount(0);
            resultadoArea.setText("");
        });
        
        ejemplo1Btn.addActionListener(e -> {
            gradoField.setText("1");
            puntosArea.setText("1 2\n2 4\n3 6\n4 8\n5 10");
        });
        
        ejemplo2Btn.addActionListener(e -> {
            gradoField.setText("2");
            puntosArea.setText("1 3\n2 8\n3 15\n4 24\n5 35");
        });
        
        buttonPanel.add(calcularBtn);
        buttonPanel.add(limpiarBtn);
        buttonPanel.add(ejemplo1Btn);
        buttonPanel.add(ejemplo2Btn);
        panel.add(buttonPanel, BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        
        JPanel tablaPanel = new JPanel(new BorderLayout());
        tablaPanel.setBorder(BorderFactory.createTitledBorder("Tabla de Puntos:"));
        tablaPuntos.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scrollTabla = new JScrollPane(tablaPuntos);
        scrollTabla.setPreferredSize(new Dimension(400, 150));
        tablaPanel.add(scrollTabla, BorderLayout.CENTER);
        
        JPanel resultadoPanel = new JPanel(new BorderLayout());
        resultadoPanel.setBorder(BorderFactory.createTitledBorder("Resultado:"));
        JScrollPane scrollResultado = new JScrollPane(resultadoArea);
        resultadoPanel.add(scrollResultado, BorderLayout.CENTER);
        
        bottomPanel.add(tablaPanel);
        bottomPanel.add(resultadoPanel);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel crearPanelLinealMultiple() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel numVarLabel = new JLabel("Número de variables independientes:");
        numVarLabel.setFont(new Font("Arial", Font.BOLD, 12));
        topPanel.add(numVarLabel, gbc);
        
        gbc.gridx = 1;
        JTextField numVarField = new JTextField(10);
        topPanel.add(numVarField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel datosLabel = new JLabel("Datos (x1, x2, ..., xn, y):");
        datosLabel.setFont(new Font("Arial", Font.BOLD, 12));
        topPanel.add(datosLabel, gbc);
        
        gbc.gridx = 1; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        JTextArea datosArea = new JTextArea(6, 40);
        datosArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        datosArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollDatos = new JScrollPane(datosArea);
        topPanel.add(scrollDatos, gbc);
        panel.add(topPanel, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton calcularBtn = new JButton("Calcular Regresión");
        JButton limpiarBtn = new JButton("Limpiar");
        JButton ejemploBtn = new JButton("Cargar Ejemplo");
        calcularBtn.setFont(new Font("Arial", Font.BOLD, 12));
        
        DefaultTableModel modeloTabla = new DefaultTableModel();
        JTable tablaDatos = new JTable(modeloTabla);
        JTextArea resultadoArea = new JTextArea(6, 40);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        calcularBtn.addActionListener(e -> {
            try {
                int numVars = Integer.parseInt(numVarField.getText().trim());
                String[] lineas = datosArea.getText().trim().split("\n");
                
                if (lineas.length == 0 || lineas[0].isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Ingrese los datos");
                    return;
                }
                
                ArrayList<double[]> datos = new ArrayList<>();
                
                for (String linea : lineas) {
                    linea = linea.trim();
                    if (linea.isEmpty()) continue;
                    String[] partes = linea.split("[,\\s]+");
                    if (partes.length >= numVars + 1) {
                        double[] fila = new double[numVars + 1];
                        for (int i = 0; i <= numVars; i++) {
                            fila[i] = Double.parseDouble(partes[i]);
                        }
                        datos.add(fila);
                    }
                }
                
                modeloTabla.setRowCount(0);
                modeloTabla.setColumnCount(0);
                for (int i = 1; i <= numVars; i++) {
                    modeloTabla.addColumn("X" + i);
                }
                modeloTabla.addColumn("Y");
                
                for (double[] fila : datos) {
                    Object[] filaDatos = new Object[fila.length];
                    for (int i = 0; i < fila.length; i++) {
                        filaDatos[i] = String.format("%.4f", fila[i]);
                    }
                    modeloTabla.addRow(filaDatos);
                }
                
                if (datos.size() < numVars + 1) {
                    JOptionPane.showMessageDialog(panel, 
                        "Se necesitan al menos " + (numVars + 1) + " observaciones");
                    return;
                }
                
                double[] coef = RegresionLinealMultiple.calcular(datos, numVars);
                double r2 = RegresionLinealMultiple.calcularR2(datos, coef, numVars);
                double r2Ajustado = RegresionLinealMultiple.calcularR2Ajustado(datos, coef, numVars);
                
                StringBuilder resultado = new StringBuilder();
                resultado.append("Ecuación de regresión lineal múltiple:\n\n");
                resultado.append(RegresionLinealMultiple.obtenerEcuacion(coef));
                resultado.append("\n\nCoeficiente de determinación (R²): ");
                resultado.append(String.format("%.6f", r2));
                resultado.append("\nCoeficiente de determinación ajustado (R² ajustado): ");
                resultado.append(String.format("%.6f", r2Ajustado));
                
                resultadoArea.setText(resultado.toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        });
        
        limpiarBtn.addActionListener(e -> {
            numVarField.setText("");
            datosArea.setText("");
            modeloTabla.setRowCount(0);
            modeloTabla.setColumnCount(0);
            resultadoArea.setText("");
        });
        
        ejemploBtn.addActionListener(e -> {
            numVarField.setText("2");
            datosArea.setText("1 2 5\n2 3 8\n3 4 11\n4 5 14\n5 6 17");
        });
        
        buttonPanel.add(calcularBtn);
        buttonPanel.add(limpiarBtn);
        buttonPanel.add(ejemploBtn);
        panel.add(buttonPanel, BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        
        JPanel tablaPanel = new JPanel(new BorderLayout());
        tablaPanel.setBorder(BorderFactory.createTitledBorder("Tabla de Datos:"));
        tablaDatos.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scrollTabla = new JScrollPane(tablaDatos);
        scrollTabla.setPreferredSize(new Dimension(400, 150));
        tablaPanel.add(scrollTabla, BorderLayout.CENTER);
        
        JPanel resultadoPanel = new JPanel(new BorderLayout());
        resultadoPanel.setBorder(BorderFactory.createTitledBorder("Resultado:"));
        JScrollPane scrollResultado = new JScrollPane(resultadoArea);
        resultadoPanel.add(scrollResultado, BorderLayout.CENTER);
        
        bottomPanel.add(tablaPanel);
        bottomPanel.add(resultadoPanel);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}