/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.ModelCambioClave;
import models.ModelConexion;
import views.ViewCambioClave;

/**
 *
 * @author flore
 */

public class ControllerCambioClave {
        private final String nombre_usuario; 
        public models.ModelCambioClave modelCambioClave;
        public views.ViewCambioClave viewCambioClave;
        ModelConexion CambioClaveConexion = new ModelConexion();
        
        
        
        ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewCambioClave.jb_aceptar) {
                jmi_modificarC_actionPerformed();
            } 
        }
    };
    ControllerCambioClave(ModelCambioClave modelCambioClave, ViewCambioClave viewCambioClave, String nombre_usuario, String pregunta, String respuesta) {
        this.modelCambioClave = modelCambioClave;
        this.viewCambioClave = viewCambioClave;
        this.nombre_usuario = nombre_usuario;
        initComponents();
        setActionListener();
    }
    
    
    public void initComponents() {
        
        viewCambioClave.setVisible(true);
        modelCambioClave.conectarDB(CambioClaveConexion);
        viewCambioClave.jt_usuario.setText(""+nombre_usuario);
        System.out.println("Solo se inicia si se abre cambiar clave");
    }
    
    
    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewCambioClave.jb_aceptar.addActionListener(actionListener);
    }
    
    public void jmi_modificarC_actionPerformed() {

        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea actualizar los datos del usuario?", "Guardar cambios", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            modelCambioClave.setPassword(viewCambioClave.jt_confirmar.getText());

            modelCambioClave.modificarDatosClave(CambioClaveConexion);
            JOptionPane.showMessageDialog(null, "Datos del usuario modificados correctamente");
            //Se usa el metodo tablaConsulta para actualizar los registros en jTableProducto

        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun cambio");
        }
    }
    
}
