/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author flore
 */
public class ViewMenu extends javax.swing.JFrame {

    /**
     * Creates new form ViewMenu
     */
    public ViewMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jmInicio = new javax.swing.JMenu();
        jmVentanas = new javax.swing.JMenu();
        jmUsuarios = new javax.swing.JMenuItem();
        jmClientes = new javax.swing.JMenuItem();
        jmProveedores = new javax.swing.JMenuItem();
        jmProductos = new javax.swing.JMenuItem();
        jmServicios = new javax.swing.JMenuItem();
        jmSesion = new javax.swing.JMenu();
        jmUsuarioSesion = new javax.swing.JMenuItem();
        jmCerrarSesion = new javax.swing.JMenuItem();
        jmBD = new javax.swing.JMenu();
        jmRespaldos = new javax.swing.JMenuItem();
        jmInicio1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jmInicio.setText("Inicio");
        jMenuBar1.add(jmInicio);

        jmVentanas.setText("Ventanas");

        jmUsuarios.setText("Usuarios");
        jmUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmUsuariosActionPerformed(evt);
            }
        });
        jmVentanas.add(jmUsuarios);

        jmClientes.setText("Clientes");
        jmVentanas.add(jmClientes);

        jmProveedores.setText("Proveedores");
        jmVentanas.add(jmProveedores);

        jmProductos.setText("Productos");
        jmVentanas.add(jmProductos);

        jmServicios.setText("Servicios");
        jmVentanas.add(jmServicios);

        jMenuBar1.add(jmVentanas);

        jmSesion.setText("Sesión");

        jmUsuarioSesion.setText("Usuario");
        jmSesion.add(jmUsuarioSesion);

        jmCerrarSesion.setText("Cerrar sesión");
        jmSesion.add(jmCerrarSesion);

        jMenuBar1.add(jmSesion);

        jmBD.setText("Base de datos");

        jmRespaldos.setText("Respaldos");
        jmRespaldos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRespaldosActionPerformed(evt);
            }
        });
        jmBD.add(jmRespaldos);

        jMenuBar1.add(jmBD);

        jmInicio1.setText("Inicio");
        jMenuBar1.add(jmInicio1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmUsuariosActionPerformed

    private void jmRespaldosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRespaldosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmRespaldosActionPerformed

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
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenu jmBD;
    public javax.swing.JMenuItem jmCerrarSesion;
    public javax.swing.JMenuItem jmClientes;
    public javax.swing.JMenu jmInicio;
    public javax.swing.JMenu jmInicio1;
    public javax.swing.JMenuItem jmProductos;
    public javax.swing.JMenuItem jmProveedores;
    public javax.swing.JMenuItem jmRespaldos;
    public javax.swing.JMenuItem jmServicios;
    private javax.swing.JMenu jmSesion;
    public javax.swing.JMenuItem jmUsuarioSesion;
    public javax.swing.JMenuItem jmUsuarios;
    private javax.swing.JMenu jmVentanas;
    // End of variables declaration//GEN-END:variables
}
