/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionListener;
import models.ModelLogin;
import models.ModelMain;
import views.ViewLogin;
import views.ViewMenu;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author flore
 */
public class ControllerLogin implements ActionListener {

    models.ModelLogin modelLogin;
    views.ViewLogin viewLogin;

    public ControllerLogin(ModelLogin modelLogin, ViewLogin viewLogin) {
        this.modelLogin = modelLogin;
        this.viewLogin = viewLogin;
        initComponents();
        viewLogin.jb_iniciar.addActionListener(this);
    }

    private void initComponents() {
        viewLogin.setVisible(true);
        viewLogin.setLocationRelativeTo(null);
        viewLogin.setTitle("Inicio de sesión Seditek");

        ImageIcon imagenUno = new ImageIcon(getClass().getResource("/img/login.jpg"));
        Image fondoUno = imagenUno.getImage().getScaledInstance(viewLogin.jl_Login.getWidth(), viewLogin.jl_Login.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(fondoUno);
        viewLogin.jl_Login.setIcon(iconoEscalado);
        viewLogin.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewLogin.jb_iniciar) {
            iniciarSesion();
        }
    }

    private void iniciarSesion() {
        String pass = new String(viewLogin.jp_password.getPassword());

        if (!viewLogin.jtf_usuario.getText().equals("") && !pass.equals("")) {
            modelLogin.setUsuario(viewLogin.jtf_usuario.getText());
            modelLogin.setPassword(pass);

            if (modelLogin.login()) {
                String nombre_usuario = modelLogin.getUsuario();
                String tipo_usuario = modelLogin.getTipoUsuario();
                String password = modelLogin.getPassword();
                
                ModelMain modelMain = new ModelMain();
                ViewMenu viewMenu = new ViewMenu();
                ControllerMain controllerMain = new ControllerMain(modelMain, viewMenu, nombre_usuario, tipo_usuario, password);
                
                viewLogin.dispose();
            } else {
                JOptionPane.showMessageDialog(null,"Datos incorrectos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar sus datos");
        }

    }

}
