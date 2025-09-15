
package pruebas;

import implementaciones.Tabula;
import implementaciones.Tabula.Punto;
import java.text.DecimalFormat;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import javax.swing.table.DefaultTableModel;

public class frtabula extends javax.swing.JFrame {

    public frtabula() {
        initComponents();
     
    }


 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblinf = new javax.swing.JLabel();
        txtXi = new javax.swing.JTextField();
        lblsup = new javax.swing.JLabel();
        txtXf = new javax.swing.JTextField();
        lblincr = new javax.swing.JLabel();
        txtIncX = new javax.swing.JTextField();
        funcionbox = new javax.swing.JComboBox<>();
        tabbt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lblmin = new javax.swing.JLabel();
        lblmax = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        jLabel1.setText("Tabulacion de Funciones");

        lblinf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblinf.setText("Limite inferior :");

        lblsup.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblsup.setText("Limite superior :");

        txtXf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXfActionPerformed(evt);
            }
        });

        lblincr.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblincr.setText("Incremento :");

        funcionbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "f(x) = 4x³ - 6x² + 7x - 2.3", "g(x) = x * |cos(x)| - 5" }));
        funcionbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionboxActionPerformed(evt);
            }
        });

        tabbt.setText("Tabular");
        tabbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabbtActionPerformed(evt);
            }
        });

        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        tabla.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "x", "y"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        lblmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblmin.setText("Minimo:");

        lblmax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblmax.setText("Maximo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblmax, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(funcionbox, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tabbt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(72, 72, 72))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblsup)
                        .addGap(18, 18, 18)
                        .addComponent(txtXi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblinf)
                            .addComponent(lblincr))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtXf, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIncX, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblsup)
                    .addComponent(txtXi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblinf)
                    .addComponent(txtXf, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblincr)
                    .addComponent(txtIncX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(funcionbox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tabbt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblmax)
                        .addGap(70, 70, 70)
                        .addComponent(lblmin)
                        .addGap(128, 128, 128))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void funcionboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_funcionboxActionPerformed

    private void tabbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabbtActionPerformed
         try {
            double xi = Double.parseDouble(txtXi.getText());
            double xf = Double.parseDouble(txtXf.getText());
            double incx = Double.parseDouble(txtIncX.getText());

            DoubleUnaryOperator funcion;
            if (funcionbox.getSelectedIndex() == 0) {
                funcion = (x) -> 4*Math.pow(x, 3) - 6*Math.pow(x, 2) + 7*x - 2.3;
            } else {
                funcion = (x) -> x * Math.abs(Math.cos(x)) - 5;
            }

            List<Punto> resultados = Tabula.tabula(funcion, xi, xf, incx);

            
            DecimalFormat df = new DecimalFormat("0.000000");

           
            DefaultTableModel model = new DefaultTableModel(new Object[]{"x", "y"}, 0);
            for (int i = 0; i < resultados.size() - 2; i++) {
                Punto p = resultados.get(i);
                model.addRow(new Object[]{
                    df.format(p.x),
                    df.format(p.y)
                });
            }
            tabla.setModel(model);

            Punto max = resultados.get(resultados.size() - 2);
            Punto min = resultados.get(resultados.size() - 1);
            lblmax.setText("Máximo: x=" + df.format(max.x) + ", y=" + df.format(max.y));
            lblmin.setText("Mínimo: x=" + df.format(min.x) + ", y=" + df.format(min.y));

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: Verifique los valores ingresados");
        }
    
    
    }//GEN-LAST:event_tabbtActionPerformed

    private void txtXfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXfActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frtabula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frtabula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frtabula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frtabula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frtabula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> funcionbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblincr;
    private javax.swing.JLabel lblinf;
    private javax.swing.JLabel lblmax;
    private javax.swing.JLabel lblmin;
    private javax.swing.JLabel lblsup;
    private javax.swing.JButton tabbt;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtIncX;
    private javax.swing.JTextField txtXf;
    private javax.swing.JTextField txtXi;
    // End of variables declaration//GEN-END:variables
}
