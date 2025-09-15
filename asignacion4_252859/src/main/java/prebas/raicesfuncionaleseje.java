
package prebas;

import javax.swing.JOptionPane;

public class raicesfuncionaleseje extends javax.swing.JFrame {

   
    public raicesfuncionaleseje() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbltitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btncalcular = new javax.swing.JButton();
        txtfieldxi = new javax.swing.JTextField();
        txtfieldxf = new javax.swing.JTextField();
        txtfieldeamax = new javax.swing.JTextField();
        cmobox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtsolucion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbltitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitulo.setText("Raices funcionales");
        lbltitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbltitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Metodo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("xi");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("xf");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("error max (ea)");

        btncalcular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btncalcular.setText("calcular");
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });

        txtfieldxi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldxiActionPerformed(evt);
            }
        });

        txtfieldxf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldxfActionPerformed(evt);
            }
        });

        txtfieldeamax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldeamaxActionPerformed(evt);
            }
        });

        cmobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biseccion", "Regla Falsa" }));
        cmobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmoboxActionPerformed(evt);
            }
        });

        txtsolucion.setColumns(20);
        txtsolucion.setRows(5);
        jScrollPane2.setViewportView(txtsolucion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncalcular)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfieldeamax, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfieldxf, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfieldxi, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtfieldxi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtfieldxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfieldeamax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btncalcular)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfieldxiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfieldxiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfieldxiActionPerformed

    private void txtfieldxfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfieldxfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfieldxfActionPerformed

    private void txtfieldeamaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfieldeamaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfieldeamaxActionPerformed

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
         try {
    // se leen los valores que el usuario escribio en las cajas de texto
    double xi = Double.parseDouble(txtfieldxi.getText());
    double xf = Double.parseDouble(txtfieldxf.getText());
    double eamax = Double.parseDouble(txtfieldeamax.getText());

    // se crea una instancia de la clase que tiene los metodos numericos
    implementaciones.raizfuncional rf = new implementaciones.raizfuncional();

    // se definen las funciones de la tarea
    // f(x) para el metodo de Biseccion
    java.util.function.DoubleUnaryOperator f = (x) -> 4*Math.pow(x,3) - 6*Math.pow(x,2) + 7*x - 2.3;
    // g(x) para el metodo de la Regla Falsa
    java.util.function.DoubleUnaryOperator g = (x) -> Math.pow(x,2) * Math.sqrt(Math.abs(Math.cos(x))) - 5;

    // se obtiene el metodo que el usuario selecciono en la lista
    String metodo = (String)cmobox.getSelectedItem();
    double raiz = 0;
    double valorFuncion = 0;

  
    // Metodo de Biseccion

    if (metodo.equals("Biseccion")) {
        double fxi = f.applyAsDouble(xi);
        double fxf = f.applyAsDouble(xf);

        // se valida que el intervalo sea correcto (cambian de signo)
        if (fxi * fxf > 0) {
            JOptionPane.showMessageDialog(this,
                "El intervalo no es valido: f(xi) y f(xf) tienen el mismo signo");
            return;
        }

        // se llama al metodo biseccion
        raiz = rf.biseccion(f, xi, xf, eamax);
        // se calcula el valor de la funcion en la raiz
        valorFuncion = f.applyAsDouble(raiz);
    } 

    // Metodo de la Regla Falsa

    else if (metodo.equals("Regla Falsa")) {
        double fxi = g.applyAsDouble(xi);
        double fxf = g.applyAsDouble(xf);
        

        // se valida que el intervalo sea correcto (cambian de signo)
        if (fxi * fxf > 0) {
            JOptionPane.showMessageDialog(this,
                "El intervalo no es valido: g(xi) y g(xf) tienen el mismo signo");
            return;
        }

        // se llama al metodo regla falsa
        raiz = rf.reglaFalsa(g, xi, xf, eamax);
        // se calcula el valor de la funcion en la raiz
        valorFuncion = g.applyAsDouble(raiz);
    }

    // se muestran los resultados en el cuadro de texto
    // los valores se imprimen con 6 decimales fijos
    txtsolucion.setText("");
    txtsolucion.setText(String.format(
        "Metodo: %s\nRaiz: %.6f\nf(raiz): %.6f\nIteraciones: %d",
        metodo, raiz, valorFuncion, rf.getIteraciones()
    ));

} catch (Exception ex) {
    // si ocurre un error al leer o calcular se muestra un mensaje
    JOptionPane.showMessageDialog(this, 
        "Error en los datos ingresados. Verifique que sean numeros validos.");
}

    }//GEN-LAST:event_btncalcularActionPerformed

    private void cmoboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmoboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmoboxActionPerformed

  
  
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
            java.util.logging.Logger.getLogger(raicesfuncionaleseje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(raicesfuncionaleseje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(raicesfuncionaleseje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(raicesfuncionaleseje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new raicesfuncionaleseje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncalcular;
    private javax.swing.JComboBox<String> cmobox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JTextField txtfieldeamax;
    private javax.swing.JTextField txtfieldxf;
    private javax.swing.JTextField txtfieldxi;
    private javax.swing.JTextArea txtsolucion;
    // End of variables declaration//GEN-END:variables

}