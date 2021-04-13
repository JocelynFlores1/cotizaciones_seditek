/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.ModelImagen;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 *
 * @author flore
 */
public class ViewLogin extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public ViewLogin() {
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

        jPanelLogin = new javax.swing.JPanel();
        jl_Login = new javax.swing.JLabel();
        jtf_usuario = new javax.swing.JTextField();
        jp_password = new javax.swing.JPasswordField();
        jb_iniciar = new javax.swing.JButton();
        jl_usuario = new javax.swing.JLabel();
        jl_password = new javax.swing.JLabel();
        jb_registrar = new javax.swing.JButton();
        jb_newcontra = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jl_titulo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelLogin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelLoginPropertyChange(evt);
            }
        });

        jl_Login.setBackground(new java.awt.Color(0, 153, 204));

        jtf_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_usuarioActionPerformed(evt);
            }
        });
        jtf_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_usuarioKeyTyped(evt);
            }
        });

        jp_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jp_passwordActionPerformed(evt);
            }
        });

        jb_iniciar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jb_iniciar.setText("Acceder");

        jl_usuario.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jl_usuario.setText("Usuario");

        jl_password.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jl_password.setText("Contraseña");

        jb_registrar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jb_registrar.setText("Registrar usuario");
        jb_registrar.setMaximumSize(new java.awt.Dimension(122, 36));
        jb_registrar.setMinimumSize(new java.awt.Dimension(122, 36));
        jb_registrar.setPreferredSize(new java.awt.Dimension(122, 36));
        jb_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_registrarActionPerformed(evt);
            }
        });

        jb_newcontra.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jb_newcontra.setText("Recuperar contraseña");
        jb_newcontra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_newcontraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jl_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addComponent(jb_newcontra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_registrar, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                    .addComponent(jb_iniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_password)
                    .addComponent(jl_usuario)
                    .addComponent(jl_password)
                    .addComponent(jtf_usuario))
                .addContainerGap(260, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jl_usuario)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jl_password)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jb_iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jl_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_newcontra, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jl_titulo.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jl_titulo.setText("S E D I T E K");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jl_titulo)
                .addGap(562, 562, 562))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jl_titulo)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_usuarioActionPerformed

    }//GEN-LAST:event_jtf_usuarioActionPerformed

    private void jPanelLoginPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelLoginPropertyChange
        ModelImagen imagenLogin = new ModelImagen();
        jPanelLogin.add(imagenLogin);
        jPanelLogin.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelLoginPropertyChange

    private void jb_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_registrarActionPerformed
        models.ModelUsuarios modelUsuarios = new models.ModelUsuarios();
        views.ViewUsuarios viewUsuarios = new views.ViewUsuarios();
        controllers.ControllerUsuarios controllerUsuarios = new controllers.ControllerUsuarios(modelUsuarios, viewUsuarios);
        System.out.println("Usuarios");
    }//GEN-LAST:event_jb_registrarActionPerformed

    private void jb_newcontraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_newcontraActionPerformed
        models.ModelRecuperPassword modelRecuperPassword = new models.ModelRecuperPassword();
        views.ViewRecuperPassword viewRecuperPassword = new views.ViewRecuperPassword();
        controllers.ControllerRecuperPassword controllerRecuperPassword = new controllers.ControllerRecuperPassword(modelRecuperPassword, viewRecuperPassword);
        System.out.println("Recuperar contraseña");
    }//GEN-LAST:event_jb_newcontraActionPerformed

    private void jp_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jp_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jp_passwordActionPerformed

    private void jtf_usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_usuarioKeyTyped
                char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_jtf_usuarioKeyTyped

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
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelLogin;
    public javax.swing.JButton jb_iniciar;
    public javax.swing.JButton jb_newcontra;
    public javax.swing.JButton jb_registrar;
    public javax.swing.JLabel jl_Login;
    public javax.swing.JLabel jl_password;
    public javax.swing.JLabel jl_titulo;
    public javax.swing.JLabel jl_usuario;
    public javax.swing.JPasswordField jp_password;
    public javax.swing.JTextField jtf_usuario;
    // End of variables declaration//GEN-END:variables
}
