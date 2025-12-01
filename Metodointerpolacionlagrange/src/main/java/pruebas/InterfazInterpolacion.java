/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import implementaciones.Interpolacion;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class InterfazInterpolacion extends JFrame {
    
    private JSpinner spinnerGrado;
    private JTable tablaPuntos;
    private DefaultTableModel modeloTabla;
    private JTextField txtXInterpolar;
    private JTextArea txtResultado;
    private Interpolacion interpolacion;
    
    public InterfazInterpolacion() {
        interpolacion = new Interpolacion();
        inicializarComponentes();
    }
    
    private void inicializarComponentes() {
        
        setTitle("Interpolación de Lagrange");
        setSize(750, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(63, 81, 181));
        panelTitulo.setPreferredSize(new Dimension(750, 80));
        
        JLabel lblTitulo = new JLabel("INTERPOLACIÓN DE LAGRANGE");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo);
        
       
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        
        JPanel panelGrado = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelGrado.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY), "1. Configuración"));
        
        JLabel lblGrado = new JLabel("Grado del polinomio (n):");
        lblGrado.setFont(new Font("Arial", Font.BOLD, 14));
        
        spinnerGrado = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        spinnerGrado.setFont(new Font("Arial", Font.PLAIN, 14));
        ((JSpinner.DefaultEditor) spinnerGrado.getEditor()).getTextField().setEditable(false);
        spinnerGrado.addChangeListener(e -> actualizarTabla());
        
        JLabel lblInfo = new JLabel("(Se necesitan n+1 puntos)");
        lblInfo.setFont(new Font("Arial", Font.ITALIC, 12));
        lblInfo.setForeground(Color.GRAY);
        
        panelGrado.add(lblGrado);
        panelGrado.add(spinnerGrado);
        panelGrado.add(lblInfo);
        
     
        JPanel panelTabla = new JPanel(new BorderLayout(10, 10));
        panelTabla.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY), "2. Ingrese los Puntos"));
        panelTabla.setPreferredSize(new Dimension(700, 280));
        
        String[] columnas = {"Punto", "x", "y"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };
        
        tablaPuntos = new JTable(modeloTabla);
        tablaPuntos.setFont(new Font("Arial", Font.PLAIN, 13));
        tablaPuntos.setRowHeight(30);
        tablaPuntos.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        tablaPuntos.getTableHeader().setBackground(new Color(200, 200, 200));
        
        JScrollPane scrollTabla = new JScrollPane(tablaPuntos);
        panelTabla.add(scrollTabla, BorderLayout.CENTER);
        
        
        JPanel panelX = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelX.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY), "3. Valor a Interpolar"));
        
        JLabel lblX = new JLabel("Ingrese el valor de x:");
        lblX.setFont(new Font("Arial", Font.BOLD, 14));
        
        txtXInterpolar = new JTextField(15);
        txtXInterpolar.setFont(new Font("Arial", Font.PLAIN, 14));
        
        panelX.add(lblX);
        panelX.add(txtXInterpolar);
        
        
        JPanel panelEjemplos = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelEjemplos.setBorder(BorderFactory.createTitledBorder("Ejemplos Rápidos"));
        
        JButton btnEjemplo1 = new JButton("📊 Ejemplo 1: Lineal (n=1)");
        btnEjemplo1.setFont(new Font("Arial", Font.PLAIN, 13));
        btnEjemplo1.addActionListener(e -> cargarEjemplo1());
        
        JButton btnEjemplo2 = new JButton("📈 Ejemplo 2: Cuadrático (n=2)");
        btnEjemplo2.setFont(new Font("Arial", Font.PLAIN, 13));
        btnEjemplo2.addActionListener(e -> cargarEjemplo2());
        
        panelEjemplos.add(btnEjemplo1);
        panelEjemplos.add(btnEjemplo2);
        
        
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        
        JButton btnCalcular = new JButton("✓ CALCULAR INTERPOLACIÓN");
        btnCalcular.setFont(new Font("Arial", Font.BOLD, 16));
        btnCalcular.setBackground(new Color(76, 175, 80));
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFocusPainted(false);
        btnCalcular.setPreferredSize(new Dimension(280, 45));
        btnCalcular.addActionListener(e -> calcularInterpolacion());
        
        JButton btnLimpiar = new JButton("⟲ Limpiar");
        btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnLimpiar.setPreferredSize(new Dimension(120, 45));
        btnLimpiar.addActionListener(e -> limpiarFormulario());
        
        panelBotones.add(btnCalcular);
        panelBotones.add(btnLimpiar);
        
        
        JPanel panelResultados = new JPanel(new BorderLayout());
        panelResultados.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY), "4. Resultados"));
        panelResultados.setPreferredSize(new Dimension(700, 220));
        
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtResultado.setBackground(new Color(245, 245, 245));
        txtResultado.setText("Presione 'CALCULAR INTERPOLACIÓN' para ver los resultados...");
        
        JScrollPane scrollResultado = new JScrollPane(txtResultado);
        panelResultados.add(scrollResultado, BorderLayout.CENTER);
        
       
        panelCentral.add(panelGrado);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(panelTabla);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(panelX);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(panelEjemplos);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(panelBotones);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(panelResultados);
        
        
        add(panelTitulo, BorderLayout.NORTH);
        add(new JScrollPane(panelCentral), BorderLayout.CENTER);
        
        
        actualizarTabla();
    }
    
    private void actualizarTabla() {
        int n = (int) spinnerGrado.getValue();
        modeloTabla.setRowCount(0);
        
        for (int i = 0; i <= n; i++) {
            modeloTabla.addRow(new Object[]{i, "0.0", "0.0"});
        }
    }
    
    private void calcularInterpolacion() {
        try {
            if (txtXInterpolar.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Por favor, ingrese el valor de x a interpolar.", 
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int n = (int) spinnerGrado.getValue();
            double x = Double.parseDouble(txtXInterpolar.getText().trim());
            double[][] puntos = new double[2][n + 1];
            
            for (int i = 0; i <= n; i++) {
                puntos[0][i] = Double.parseDouble(modeloTabla.getValueAt(i, 1).toString());
                puntos[1][i] = Double.parseDouble(modeloTabla.getValueAt(i, 2).toString());
            }
            
            
            for (int i = 0; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (Math.abs(puntos[0][i] - puntos[0][j]) < 0.000001) {
                        JOptionPane.showMessageDialog(this, 
                            "Error: Los valores de x deben ser distintos.\n" +
                            "Puntos " + i + " y " + j + " tienen el mismo valor.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            
            double y = interpolacion.interpolacionLagrange(puntos, n, x);
            mostrarResultados(puntos, n, x, y);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error: Ingrese solo valores numéricos válidos.", 
                "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void mostrarResultados(double[][] puntos, int n, double x, double y) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("═══════════════════════════════════════════════════════════════\n");
        sb.append("            RESULTADO DE LA INTERPOLACIÓN DE LAGRANGE\n");
        sb.append("═══════════════════════════════════════════════════════════════\n\n");
        
        sb.append("Grado del polinomio: n = ").append(n).append("\n");
        sb.append("Número de puntos empleados: ").append(n + 1).append("\n\n");
        
        sb.append("Puntos utilizados:\n");
        sb.append("+--------+-------------+-------------+\n");
        sb.append("| Punto  |      x      |      y      |\n");
        sb.append("+--------+-------------+-------------+\n");
        
        for (int i = 0; i <= n; i++) {
            sb.append(String.format("|   %2d   | %11.6f | %11.6f |\n", 
                i, puntos[0][i], puntos[1][i]));
        }
        
        sb.append("+--------+-------------+-------------+\n\n");
        
        sb.append("═══════════════════════════════════════════════════════════════\n");
        sb.append("                      PUNTO INTERPOLADO\n");
        sb.append("═══════════════════════════════════════════════════════════════\n");
        sb.append(String.format("\n    x = %.6f\n", x));
        sb.append(String.format("    y = %.6f\n\n", y));
        sb.append(String.format("    P(%.6f) = %.6f\n\n", x, y));
        sb.append("═══════════════════════════════════════════════════════════════\n");
        
        txtResultado.setText(sb.toString());
        txtResultado.setCaretPosition(0);
    }
    
    private void limpiarFormulario() {
        spinnerGrado.setValue(1);
        txtXInterpolar.setText("");
        txtResultado.setText("Presione 'CALCULAR INTERPOLACIÓN' para ver los resultados...");
        actualizarTabla();
    }
    
    private void cargarEjemplo1() {
        spinnerGrado.setValue(1);
        modeloTabla.setValueAt("3.0", 0, 1);
        modeloTabla.setValueAt("5.25", 0, 2);
        modeloTabla.setValueAt("5.0", 1, 1);
        modeloTabla.setValueAt("19.75", 1, 2);
        txtXInterpolar.setText("3.5");
        
        JOptionPane.showMessageDialog(this, 
            "✓ Ejemplo 1 Cargado:\n\n" +
            "Interpolación Lineal (n=1)\n" +
            "Puntos: (3, 5.25), (5, 19.75)\n" +
            "Valor a interpolar: x = 3.5\n\n" +
            "Presione 'CALCULAR' para ver el resultado.", 
            "Ejemplo Cargado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void cargarEjemplo2() {
        spinnerGrado.setValue(2);
        modeloTabla.setValueAt("2.0", 0, 1);
        modeloTabla.setValueAt("4.0", 0, 2);
        modeloTabla.setValueAt("3.0", 1, 1);
        modeloTabla.setValueAt("5.25", 1, 2);
        modeloTabla.setValueAt("5.0", 2, 1);
        modeloTabla.setValueAt("19.75", 2, 2);
        txtXInterpolar.setText("3.5");
        
        JOptionPane.showMessageDialog(this, 
            "✓ Ejemplo 2 Cargado:\n\n" +
            "Interpolación Cuadrática (n=2)\n" +
            "Puntos: (2, 4), (3, 5.25), (5, 19.75)\n" +
            "Valor a interpolar: x = 3.5\n\n" +
            "Presione 'CALCULAR' para ver el resultado.", 
            "Ejemplo Cargado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            InterfazInterpolacion frame = new InterfazInterpolacion();
            frame.setVisible(true);
        });
    }
}
