/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.ModelMain;
import models.ModelLogin;
import views.ViewLogin;
import views.ViewMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import models.ModelUsuarios;

/**
 *
 * @author flore
 */
public class ControllerMain {
    
      private final ModelMain modelMain;
    private final ViewMenu viewMenu;

    /**
     * Esta variable almacena los controladores controllerAgenda y
     * controllerDetalleContacto para poder utilizarlos dentro del mismo JFrame.
     */
    private Object controllers[];

    private ControllerUsuario controllerUsuario;
    private ControllerInicio controllerInicio;
    private final String nombre_usuario;
    private final String tipo_usuario;
    private final String password;

    /**
     * Controlador principal del proyecto que un el modelMain y viewMain, ademas
     * recibe los controladores controllerAgenda y controllerDetalleContacto
     * dentro del arreglo controllers, con esto se puede tener acceso a toda la
     * programación desarrollada dentro de cada controller.
     *
     * @param modelMain
     * @param viewMenu
     * @param tipo_usuario
     * @param nombre_usuario
     * @param password
     */
    public ControllerMain(ModelMain modelMain, ViewMenu viewMenu, String tipo_usuario, String nombre_usuario, String password) {
        this.modelMain = modelMain;
        this.viewMenu = viewMenu;
        this.nombre_usuario = nombre_usuario;
        this.tipo_usuario = tipo_usuario;
        this.password = password;
        setActionListener();
        setMouseListener();
        initComponets();
    }

    ControllerMain(ModelMain modelMain, String nombre_usuario, String tipo_usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Separa cada uno de los controlladores almacendados en controllers, de
     * esta forma se puede acceder a todas las variables y métodos publicos de
     * cada uno.
     */
    /**
     * Muesta la vista principal ViewMain.
     */
    private void initComponets() {
        viewMenu.setTitle("Ferreteria   A C M E");
        viewMenu.setLocationRelativeTo(null);
        viewMenu.setVisible(true);
        viewMenu.jmUsuarioSesion.setText("Usuario: " + nombre_usuario);
        jmi_inicio_actionPerformed();
    }

    /**
     * Asigna el actionListener a cada uno de los JMenuItems de la vista
     * ViewMain.
     */
    private void setActionListener() {
        viewMenu.jmUsuarios.addActionListener(actionListener);

    }

    private void setMouseListener() {
        viewMenu.jmInicio.addMouseListener(mouseListener);
    }

    private final MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewMenu.jmInicio) {
                jmi_inicio_actionPerformed();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };

    /**
     * Evalua el componente que genero el evento y llama a un método en
     * particular.
     */
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewMenu.jmUsuarios) {
                jmi_usuarios_actionPerformed();
            } 
        }
    };

    /**
     * 1.- Obtiene los valores de nombre y email del modelAgenda y
     * posteriormente los asigna a las variables nombre y email del
     * modelDetalleContacto,
     *
     * 2.- Muestra en la vista viewDetalleContacto el nombre y email almacenados
     * en el modelDetalleContacto,
     *
     * 3.- Muestra el JPanel ViewDetalleContacto dentro del JFrame ViewMain
     * (incluido todo el funcionamiento programado).
     */
    public void jmi_inicio_actionPerformed() {

        models.ModelInicio modelInicio = new models.ModelInicio();
        views.ViewInicio viewFondo = new views.ViewInicio();
        controllers.ControllerInicio controllerInicio = new controllers.ControllerInicio(modelInicio, viewFondo);

        viewMenu.setContentPane(controllerInicio.viewInicio);
        viewMenu.revalidate();
        viewMenu.repaint();
        System.out.println("Inicio");
    }


    private void jmi_usuarios_actionPerformed() {
        models.ModelUsuarios modelUsuarios = new models.ModelUsuarios();
        views.viewUsuarios viewUsuarios = new views.viewUsuarios();
        controllers.ControllerUsuario controllerUsuario = new controllers.ControllerUsuario(modelUsuarios, viewUsuarios);

        viewMenu.setContentPane(controllerUsuario.viewUsuarios);
        viewMenu.revalidate();
        viewMenu.repaint();
        System.out.println("Usuarios");
    }



    /**
     * Muestra el JPanel ViewAgenda dentro del JFrame ViewMain, (incluido todo
     * el funcionamiendo programado).
     */
    /**
     * Cierra la aplicacion.
     */
    private void jmi_salir_actionPerformed() {
        System.exit(0);
    }
    
}
