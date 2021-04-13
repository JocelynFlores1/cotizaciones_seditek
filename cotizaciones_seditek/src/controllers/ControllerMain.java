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

    private ControllerUsuarios controllerUsuario;
    private ControllerClientes controller_clientes;
    private ControllerProveedores controller_proveedores;
    private ControllerProductos controller_productos;
    private ControllerServicios controller_servicios;
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
     * @param nombre_usuario
     * @param tipo_usuario
     * @param password
     */

    public ControllerMain(ModelMain modelMain, ViewMenu viewMenu, String nombre_usuario, String tipo_usuario, String password) {
        this.modelMain = modelMain;
        this.viewMenu = viewMenu;
        this.nombre_usuario = nombre_usuario;
        this.tipo_usuario = tipo_usuario;
        this.password = password;
        setActionListener();
        setMouseListener();
        initComponents();    }
    /**
     * Separa cada uno de los controlladores almacendados en controllers, de
     * esta forma se puede acceder a todas las variables y métodos publicos de
     * cada uno.
     */

    /**
     * Muestra la vista principal del ViewMain
     */
    
    private void initComponents(){
        viewMenu.setTitle("S E D I T E K");
        viewMenu.setLocationRelativeTo(null);
        viewMenu.setVisible(true);
        viewMenu.jmUsuarioSesion.setText("Usuario: " + nombre_usuario);
        jmi_inicio_actionPerformed();
        
    }
    
    private void setActionListener(){
        viewMenu.jmUsuarios.addActionListener(actionListener);
        viewMenu.jmClientes.addActionListener(actionListener);
        viewMenu.jmProveedores.addActionListener(actionListener);
        viewMenu.jmProductos.addActionListener(actionListener);
        viewMenu.jmServicios.addActionListener(actionListener);
        viewMenu.jmRespaldos.addActionListener(actionListener);
        viewMenu.jmCerrarSesion.addActionListener(actionListener);
    }
    
    private void setMouseListener() {
       viewMenu.jmInicio.addMouseListener(mouseListener);
    }
    
    private final MouseListener mouseListener = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource () == viewMenu.jmInicio){
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
    
    private final ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewMenu.jmUsuarios){
                jmi_usuarios_actionPerformed();
            }else if(e.getSource() ==viewMenu.jmClientes){
                jmi_clientes_actionPerformed();
                
            }else if(e.getSource() ==viewMenu.jmProveedores){
                jmi_proveedores_actionPerformed();
                
            }else if(e.getSource() ==viewMenu.jmProductos){
                jmi_productos_actionPerformed();
                
            }else if(e.getSource() ==viewMenu.jmServicios){
                jmi_servicios_actionPerformed();
                
            }else if(e.getSource() ==viewMenu.jmRespaldos){
                jmi_respaldos_actionPerformed();
                
            }else if (e.getSource() == viewMenu.jmCerrarSesion){
                jmi_cerrarSesion_actionPerformed();
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

        //viewMenu.setContentPane(controllerInicio.viewInicio);
        viewMenu.revalidate();
        viewMenu.repaint();
        System.out.println("Inicio");
    }
    
    

    private void jmi_usuarios_actionPerformed() {
        models.ModelUsuarios modelUsuarios = new models.ModelUsuarios();
        views.ViewUsuarios viewUsuarios = new views.ViewUsuarios();
        controllers.ControllerUsuarios controllerUsuarios = new controllers.ControllerUsuarios(modelUsuarios, viewUsuarios);
        //viewMenu.setContentPane(controllerUsuarios.viewUsuarios);
        viewMenu.revalidate();
        viewMenu.repaint();
        System.out.println("Usuarios");
    }
    
    
    private void jmi_clientes_actionPerformed() {
        models.ModelClientes model_clientes = new models.ModelClientes();
        views.ViewClientes view_clientes = new views.ViewClientes();
        controllers.ControllerClientes controller_clientes = new controllers.ControllerClientes(model_clientes, view_clientes);
        //viewMenu.setContentPane(controller_clientes.view_clientes);
        viewMenu.revalidate();
        viewMenu.repaint();
        System.out.println("Clientes");
    }
    
    private void jmi_proveedores_actionPerformed() {
        models.ModelProveedores model_proveedores = new models.ModelProveedores();
        views.ViewProveedores view_proveedores = new views.ViewProveedores();
        controllers.ControllerProveedores controller_proveedores = new controllers.ControllerProveedores(model_proveedores, view_proveedores);
        //viewMenu.setContentPane(controller_proveedores.view_proveedores);
        viewMenu.revalidate();
        viewMenu.repaint();
        System.out.println("Proveedores");
    }
    
    private void jmi_productos_actionPerformed() {
        models.ModelProductos model_productos = new models.ModelProductos();
        views.ViewProductos view_productos = new views.ViewProductos();
        controllers.ControllerProductos controller_productos = new controllers.ControllerProductos(model_productos, view_productos);
        //viewMenu.setContentPane(controller_productos.view_productos);
        viewMenu.revalidate();
        viewMenu.repaint();
        System.out.println("Productos");
    }
    
    private void jmi_servicios_actionPerformed() {
        models.ModelServicios model_servicios = new models.ModelServicios();
        views.ViewServicios view_servicios = new views.ViewServicios();
        controllers.ControllerServicios controller_servicios = new controllers.ControllerServicios(model_servicios, view_servicios);
        //viewMenu.setContentPane(controller_servicios.view_servicios);
        viewMenu.revalidate();
        viewMenu.repaint();
        System.out.println("Servicios");
    }
    
    
    public void jmi_respaldos_actionPerformed() {
        models.ModelRespaldos respaldosBD = new models.ModelRespaldos();
        controllers.ControllerRespaldos controllerRespaldos = new controllers.ControllerRespaldos(respaldosBD);
        controllerRespaldos.respaldo();
        System.out.println("Respaldo de base de datos");
    }

    public void jmi_cerrarSesion_actionPerformed() {
        viewMenu.dispose();

        ModelLogin modelLogin = new ModelLogin();
        ViewLogin viewLogin = new ViewLogin();
        ControllerLogin controllerLogin = new ControllerLogin(modelLogin, viewLogin);
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
