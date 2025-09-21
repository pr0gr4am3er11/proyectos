/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MetodosNumericos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.function.Function;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;


/**
 *
 * @author migue
 */

public class MetodosNumericos extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JComboBox<String> comboMetodos;
    private JComboBox<String> comboFunciones;
    private JButton btnEjecutar;

    private ArrayList<Function<Double, Double>> funciones = new ArrayList<>();
    private ArrayList<Function<Double, Double>> derivadas = new ArrayList<>();

    private DecimalFormat df = new DecimalFormat("#.#####");

    public MetodosNumericos() {
        setTitle("Métodos Numéricos para encontrar raíces");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inicializarFunciones();

        JPanel panelSuperior = new JPanel(new FlowLayout());
        comboMetodos = new JComboBox<>(new String[]{"Bisección", "Regla Falsa", "Newton-Raphson", "Secante"});
        panelSuperior.add(new JLabel("Método:"));
        panelSuperior.add(comboMetodos);

        comboFunciones = new JComboBox<>(new String[]{
            "x^3 - x - 2",
            "x^2 - 4",
            "sin(x) - 0.5",
            "e^-x - x",
            "ln(x + 2) - 1"
        });
        panelSuperior.add(new JLabel("Función:"));
        panelSuperior.add(comboFunciones);

        btnEjecutar = new JButton("Ejecutar");
        panelSuperior.add(btnEjecutar);

        add(panelSuperior, BorderLayout.NORTH);

        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        btnEjecutar.addActionListener(e -> ejecutarSeleccion());
    }

    private void inicializarFunciones() {
        funciones.add(x -> Math.pow(x, 3) - x - 2);
        funciones.add(x -> Math.pow(x, 2) - 4);
        funciones.add(x -> Math.sin(x) - 0.5);
        funciones.add(x -> Math.exp(-x) - x);
        funciones.add(x -> Math.log(x + 2) - 1);

        derivadas.add(x -> 3 * Math.pow(x, 2) - 1);
        derivadas.add(x -> 2 * x);
        derivadas.add(x -> Math.cos(x));
        derivadas.add(x -> -Math.exp(-x) - 1);
        derivadas.add(x -> 1 / (x + 2));
    }

    private void ejecutarSeleccion() {
        int indiceFuncion = comboFunciones.getSelectedIndex();
        int indiceMetodo = comboMetodos.getSelectedIndex();

        Function<Double, Double> f = funciones.get(indiceFuncion);
        Function<Double, Double> dfFunc = derivadas.get(indiceFuncion);
        int maxIter = 30;
        double tol = 1e-5;

        ArrayList<Object[]> resultados;
        String[] columnas;

        try {
            switch (indiceMetodo) {
                case 0: // Bisección
                    resultados = biseccion(f, 1, 2, tol, maxIter);
                    columnas = new String[]{"Iteracion", "xi", "xf", "xr", "f(xi)", "f(xr)", "f(xi)*f(xr)", "ea"};
                    break;
                case 1: // Regla Falsa
                    resultados = reglaFalsa(f, 1, 2, tol, maxIter);
                    columnas = new String[]{"Iteracion", "xi", "xf", "xr", "f(xi)", "f(xr)", "f(xi)*f(xr)", "ea"};
                    break;
                case 2: // Newton-Raphson
                    resultados = newtonRaphson(f, dfFunc, 1.5, tol, maxIter);
                    columnas = new String[]{"Iteraciones", "x", "f(x)", "f(x)", "xi+1", "Error"};
                    break;
                case 3: // Secante
                    resultados = secante(f, 1, 2, tol, maxIter);
                    columnas = new String[]{"Iteraciones", "xi-1", "xi", "f(xi-1)", "f(xi)", "xi+1", "Error"};
                    break;
                default:
                    resultados = new ArrayList<>();
                    columnas = new String[0];
            }
            mostrarDatos(columnas, resultados);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error durante la ejecución: " + ex.getMessage());
        }
    }

public ArrayList<Object[]> biseccion(Function<Double, Double> f, double xi, double xf, double tol, int maxIter) {
    ArrayList<Object[]> datos = new ArrayList<>();
    double fxi = f.apply(xi);
    double fxf = f.apply(xf);
    if (fxi * fxf >= 0) {
        JOptionPane.showMessageDialog(this, "Error: f(xi) y f(xf) deben tener signos opuestos");
        return datos;
    }
    double xr = xi;
    double ea = Double.MAX_VALUE; // error aproximado inicial grande
    for (int i = 1; i <= maxIter && ea > tol; i++) {
        xr = (xi + xf) / 2;
        double fxr = f.apply(xr);
        double producto = fxi * fxr;
        if (i > 1) {
            String xrAnteriorStr = (String) datos.get(datos.size() - 1)[2];
            double xrAnterior = Double.parseDouble(xrAnteriorStr);
            ea = Math.abs((xr - xrAnterior) / xr) * 100; // error porcentual relativo
        }
        datos.add(new Object[]{
            i,
            formatear(xi),
            formatear(xf),
            formatear(xr),
            formatear(fxi),
            formatear(fxr),
            formatear(producto),
            i == 1 ? "N/A" : formatear(ea)
        });
        if (fxr == 0) break;
        if (producto < 0) {
            xf = xr;
            fxf = fxr;
        } else {
            xi = xr;
            fxi = fxr;
        }
    }
    return datos;
}

    public ArrayList<Object[]> reglaFalsa(Function<Double, Double> f, double xi, double xf, double tol, int maxIter) {
    ArrayList<Object[]> datos = new ArrayList<>();
    double fxi = f.apply(xi);
    double fxf = f.apply(xf);
    if (fxi * fxf >= 0) {
        JOptionPane.showMessageDialog(this, "Error: f(xi) y f(xf) deben tener signos opuestos");
        return datos;
    }
    double xr = xi;
    double ea = Double.MAX_VALUE; // error aproximado inicial grande
    for (int i = 1; i <= maxIter && ea > tol; i++) {
        xr = (xi * fxf - xf * fxi) / (fxf - fxi);
        double fxr = f.apply(xr);
        double producto = fxi * fxr;
        if (i > 1) {
    String xrAnteriorStr = (String) datos.get(datos.size() - 1)[2];
    double xrAnterior = Double.parseDouble(xrAnteriorStr);
    ea = Math.abs((xr - xrAnterior) / xr) * 100; 
}
        datos.add(new Object[]{
            i,
            formatear(xi),
            formatear(xf),
            formatear(xr),
            formatear(fxi),
            formatear(fxr),
            formatear(producto),
            i == 1 ? "N/A" : formatear(ea)
        });
        if (fxr == 0) break;
        if (producto < 0) {
            xf = xr;
            fxf = fxr;
        } else {
            xi = xr;
            fxi = fxr;
        }
    }
    return datos;
}

    public ArrayList<Object[]> newtonRaphson(Function<Double, Double> f, Function<Double, Double> df, double x0, double tol, int maxIter) {
        ArrayList<Object[]> datos = new ArrayList<>();
        double x = x0;
        for (int i = 1; i <= maxIter; i++) {
            double fx = f.apply(x);
            double dfx = df.apply(x);
            if (dfx == 0) {
                JOptionPane.showMessageDialog(this, "Error: derivada cero, división por cero");
                break;
            }
            double x1 = x - fx / dfx;
            double error = Math.abs(x1 - x);
            datos.add(new Object[]{i, formatear(x), formatear(fx), formatear(dfx), formatear(x1), formatear(error)});
            if (error < tol) break;
            x = x1;
        }
        return datos;
    }

    public ArrayList<Object[]> secante(Function<Double, Double> f, double x0, double x1, double tol, int maxIter) {
        ArrayList<Object[]> datos = new ArrayList<>();
        for (int i = 1; i <= maxIter; i++) {
            double fx0 = f.apply(x0);
            double fx1 = f.apply(x1);
            if ((fx1 - fx0) == 0) {
                JOptionPane.showMessageDialog(this, "Error: división entre cero en secante");
                break;
            }
            double x2 = x1 - fx1 * (x1 - x0) / (fx1 - fx0);
            double error = Math.abs(x2 - x1);
            datos.add(new Object[]{i, formatear(x0), formatear(x1), formatear(fx0), formatear(fx1), formatear(x2), formatear(error)});
            if (error < tol) break;
            x0 = x1;
            x1 = x2;
        }
        return datos;
    }

    private String formatear(double valor) {
        return df.format(valor);
    }

    private void mostrarDatos(String[] columnas, ArrayList<Object[]> filas) {
        model.setColumnIdentifiers(columnas);
        model.setRowCount(0);
        for (Object[] fila : filas) {
            model.addRow(fila);
        }
    }
}