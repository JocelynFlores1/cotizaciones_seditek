/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelCambioClave;
import models.ModelMain;
import models.ModelRecuperPassword;
import views.ViewCambioClave;
import views.ViewMenu;
import views.ViewRecuperPassword;

/**
 *
 * @author flore
 */
public class ControllerRecuperPassword implements ActionListener {
    
    models.ModelRecuperPassword modelRecuperPassword;
    views.ViewRecuperPassword viewRecuperPassword;

    public ControllerRecuperPassword(ModelRecuperPassword modelRecuperPassword, ViewRecuperPassword viewRecuperPassword) {
        this.modelRecuperPassword = modelRecuperPassword;
        this.viewRecuperPassword = viewRecuperPassword;
        initComponents();
        viewRecuperPassword.jb_confirmar.addActionListener(this);
    }

    private void initComponents() {
        viewRecuperPassword.setVisible(true);
        viewRecuperPassword.setLocationRelativeTo(null);
        viewRecuperPassword.setTitle("Recuperación de contraseña");
        viewRecuperPassword.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewRecuperPassword.jb_confirmar) {
            confirmar();
        }
    }

    private void confirmar() {
        String resp = new String(viewRecuperPassword.jp_respuesta.getPassword());

        if (!viewRecuperPassword.jt_user.getText().equals("") && !resp.equals("")) {
            modelRecuperPassword.setUsuario(viewRecuperPassword.jt_user.getText());
            modelRecuperPassword.setPassword(resp);

            if (modelRecuperPassword.confirmar()) {
                String nombre_usuario = modelRecuperPassword.getUsuario();
                String tipo_usuario = modelRecuperPassword.getTipoUsuario();
                String pregunta = modelRecuperPassword.getPregunta();
                String respuesta = modelRecuperPassword.getPassword();
                String password = modelRecuperPassword.getRespuesta();
                
                ModelCambioClave modelCambioClave = new ModelCambioClave();
                ViewCambioClave viewCambioClave = new ViewCambioClave();
                ControllerCambioClave controllerCambioClave = new ControllerCambioClave(modelCambioClave, viewCambioClave, nombre_usuario, pregunta, respuesta);
                
                viewRecuperPassword.dispose();
            } else {
                JOptionPane.showMessageDialog(null,"Datos incorrectos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar sus datos");
        }

    }
}
