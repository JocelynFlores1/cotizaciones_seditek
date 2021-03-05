/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelUsuarios;
import models.ModelConexion;
import models.ModelGenerarCodigos;
import views.ViewUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author flore
 */
public class ControllerUsuarios {
    public models.ModelUsuarios modelUsuarios;
    public views.ViewUsuarios viewUsuarios;
    ModelConexion usuarioConexion = new ModelConexion();

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewUsuarios.jb_insertar) {
                jmi_insertarU_actionPerformed();
            } else if (e.getSource() == viewUsuarios.jb_modificar) {
                jmi_modificarU_actionPerformed();
            } else if (e.getSource() == viewUsuarios.jb_eliminar) {
                jmi_borrarU_actionListener();
            } else if (e.getSource() == viewUsuarios.jb_nuevo) {
                jmi_nuevoU_actionPerformed();
            }
        }
    };

    /**
     * Constructor de Controlador
     *
     * @param modelUsuarios objeto de tipo ModelUsuarios
     * @param viewUsuarios objeto de tipo ViewUsuarios
     */
    public ControllerUsuarios(ModelUsuarios modelUsuarios, ViewUsuarios viewUsuarios) {
        this.modelUsuarios = modelUsuarios;
        this.viewUsuarios= viewUsuarios;
        initComponents();
        setActionListener();
    }

    public void initComponents() {
        viewUsuarios.setVisible(true);
        modelUsuarios.conectarDB(usuarioConexion);
        jtfCambiarCampos();
        tablaConsulta();
        System.out.println("Solo se inicia si se abre usuarios");
    }

    /**
     * *
     * Metodo que cambia los campos de los jTextField en ViewUsuarios
     */
    public void jtfCambiarCampos() {
        viewUsuarios.jtf_id_usuario.setText(modelUsuarios.getId_usuario());
        viewUsuarios.jtf_nombre_usuario.setText(modelUsuarios.getNombre_usuario());
        viewUsuarios.jtf_tipo_usuario.setText(modelUsuarios.getTipo_usuario());
        viewUsuarios.jtf_password.setText(modelUsuarios.getPassword());
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewUsuarios.jb_nuevo.addActionListener(actionListener);
        viewUsuarios.jb_insertar.addActionListener(actionListener);
        viewUsuarios.jb_modificar.addActionListener(actionListener);
        viewUsuarios.jb_eliminar.addActionListener(actionListener);
        viewUsuarios.jt_usuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                insertarCamposTabla();
            }
        });
    }

    /**
     * *
     * Modelo que permite insertar el texto obenido en los jTextField de
     * ViewClientes e inserta los valores en las variables de ModelUsuarios
     */
    public void jmi_insertarU_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Vas a guardar un nuevo usuario?", "Guardar usuario", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            modelUsuarios.setId_usuario(viewUsuarios.jtf_id_usuario.getText());
            modelUsuarios.setNombre_usuario(viewUsuarios.jtf_nombre_usuario.getText());
            modelUsuarios.setTipo_usuario(viewUsuarios.jtf_tipo_usuario.getText());
            modelUsuarios.setPassword(viewUsuarios.jtf_password.getText());
           

            modelUsuarios.insertarNuevoUsuario(usuarioConexion);
            tablaConsulta();
            JOptionPane.showMessageDialog(null, "Registro almacenado correctamente");
        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun usuario");
        }
    }

    public void jmi_modificarU_actionPerformed() {

        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea actualizar los datos del usuario?", "Guardar cambios", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            modelUsuarios.setNombre_usuario(viewUsuarios.jtf_nombre_usuario.getText());
            modelUsuarios.setTipo_usuario(viewUsuarios.jtf_tipo_usuario.getText());
            modelUsuarios.setPassword(viewUsuarios.jtf_password.getText());
            modelUsuarios.setId_usuario(viewUsuarios.jtf_id_usuario.getText());

            modelUsuarios.modificarDatosUsuario(usuarioConexion);
            JOptionPane.showMessageDialog(null, "Datos del usuario modificados correctamente");
            tablaConsulta();
            //Se usa el metodo tablaConsulta para actualizar los registros en jTableProducto

        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun cambio");
        }
    }

    public void jmi_borrarU_actionListener() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea borrar los datos del usuario?", "Borrar usuario", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            modelUsuarios.setId_usuario(viewUsuarios.jtf_id_usuario.getText());
            modelUsuarios.borrarDatosUsuario(usuarioConexion);
            tablaConsulta();
            JOptionPane.showMessageDialog(null, "Los datos del usuario han sido eliminados");
        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se borro ningun registro");
        }
    }

    public void tablaConsulta() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            viewUsuarios.jt_usuarios.setModel(modelo);
            viewUsuarios.jt_usuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            modelUsuarios.consultajTableUsuarios(usuarioConexion);

            ResultSetMetaData rsMd = modelUsuarios.getRs().getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Tipo usuario");
            modelo.addColumn("Contraseña");
     
            while (modelUsuarios.getRs().next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    filas[i] = modelUsuarios.getRs().getObject(i + 1);
                }

                modelo.addRow(filas);

            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }

    //Metodo que permite insertar todos los datos de la tabla en 
    public void insertarCamposTabla() {
        try {
            if (viewUsuarios.jt_usuarios.getSelectedRow() != -1) {
                int fila = viewUsuarios.jt_usuarios.getSelectedRow();

                viewUsuarios.jtf_id_usuario.setText(viewUsuarios.jt_usuarios.getValueAt(fila, 0).toString());
                viewUsuarios.jtf_nombre_usuario.setText(viewUsuarios.jt_usuarios.getValueAt(fila, 1).toString());
                viewUsuarios.jtf_tipo_usuario.setText(viewUsuarios.jt_usuarios.getValueAt(fila, 2).toString());
                viewUsuarios.jtf_password.setText(viewUsuarios.jt_usuarios.getValueAt(fila, 3).toString());
                
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error:\nSelecciona un registro");
        }
    }

    public void jmi_nuevoU_actionPerformed() {
        viewUsuarios.jtf_id_usuario.setText("");
        viewUsuarios.jtf_nombre_usuario.setText("");
        viewUsuarios.jtf_tipo_usuario.setText("");
        viewUsuarios.jtf_password.setText("");
        
    }

    /**
     * Este metodo permite generar codigos automaticamente con una consulta en
     * la base de datos desde models.ModelUsuario.GenerarCodigos
     */
    public void codigos() {

        int j;
        int cont = 1;
        String num = "";
        modelUsuarios.consultaGenerarCodigos(usuarioConexion);

        if (modelUsuarios.getU() == null) {
            viewUsuarios.jtf_id_usuario.setText("SEDITEK-U0000001");
        } else {
            char r1 = modelUsuarios.getU().charAt(6);
            char r2 = modelUsuarios.getU().charAt(7);
            char r3 = modelUsuarios.getU().charAt(8);
            char r4 = modelUsuarios.getU().charAt(9);
            char r5 = modelUsuarios.getU().charAt(10);
            char r6 = modelUsuarios.getU().charAt(11);
            char r7 = modelUsuarios.getU().charAt(12);

            String r = "";
            r = "" + r1 + r2 + r3 + r4 + r5 + r6 + r7;
            j = Integer.parseInt(r);
            System.out.println(j);
            ModelGenerarCodigos gen = new ModelGenerarCodigos();
            gen.generar(j);
            viewUsuarios.jtf_id_usuario.setText("SEDITEK-U" + gen.serie());
            System.out.println("SEDITEK-U" + gen.serie());

        }
    }
    
}
