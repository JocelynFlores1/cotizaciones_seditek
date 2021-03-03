package controllers;

import models.ModelServicios;
import models.ModelConexion;
import models.ModelGenerarCodigos;
import views.ViewServicios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ControllerServicios {
    public ModelServicios model_servicios;
    public ViewServicios view_servicios;
    ModelConexion servicioConexion = new ModelConexion();
    
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view_servicios.jBInsertarServicio) {
                Insertar_servicio_actionPerformed();
            } else if (e.getSource() == view_servicios.jBModificarServicio) {
                Modificar_servicio_actionPerformed();
            } else if (e.getSource() == view_servicios.jBEliminarServicio) {
                Borrar_servicio_actionListener();
            } else if (e.getSource() == view_servicios.jBNuevoServicio) {
                Nuevo_servicio_actionPerformed();
            }
        }
    };
    
    
    public ControllerServicios(ModelServicios model_servicios, ViewServicios view_servicios){
        
        this.model_servicios = model_servicios;
        this.view_servicios = view_servicios;
        initComponents();
        setActionListener();
        
    }
    
    public void initComponents() {
        view_servicios.setVisible(true);
        model_servicios.conectarDB(servicioConexion);
        CambiarCampos();
        tablaConsulta();
        System.out.println("Solo se inicia si se abre servicios");
    }
    
    
    
    /**
     * *
     * Metodo que cambia los campos de los jTextField en ViewServicios
     */
    public void CambiarCampos() {
        
        view_servicios.jTIdServicio.setText(""+model_servicios.getId_servicio());
        view_servicios.jTTipoServicio.setText(""+model_servicios.getTipo_servicio());
        view_servicios.jTDescripcionServicio.setText(""+model_servicios.getDescripcion_servicio());
        view_servicios.jTCostoServicio.setText(""+model_servicios.getCosto_servicio());
    }
    
     /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        view_servicios.jBNuevoServicio.addActionListener(actionListener);
        view_servicios.jBInsertarServicio.addActionListener(actionListener);
        view_servicios.jBModificarServicio.addActionListener(actionListener);
        view_servicios.jBEliminarServicio.addActionListener(actionListener);
        view_servicios.jTableServicios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                insertarCamposTabla();
            }
        });
    }
    
    
    
    
    /**
     * *
     * Modelo que permite insertar el texto obenido en los jTextField de
     * ViewServicios e inserta los valores en las variables de ModelServicios
     */
    public void Insertar_servicio_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Vas a guardar un nuevo servicio?", "Guardar servicio", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
        
            System.out.print(model_servicios);
            model_servicios.setId_servicio(view_servicios.jTIdServicio.getText());
            model_servicios.setTipo_servicio(view_servicios.jTTipoServicio.getText());
            model_servicios.setDescripcion_servicio(view_servicios.jTDescripcionServicio.getText());
            if(!view_servicios.jTCostoServicio.getText().equals(" ")){
                model_servicios.setCosto_servicio(Float.parseFloat(view_servicios.jTCostoServicio.getText()));
            }
           

            model_servicios.insertarNuevoServicio(servicioConexion);
            tablaConsulta();
            JOptionPane.showMessageDialog(null, "Registro almacenado correctamente");
        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun servicio");
        }
    }
    
    
        public void Modificar_servicio_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea actualizar los datos del servicio?", "Guardar cambios", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
                        
            System.out.print(model_servicios);
            //model_servicios.setId_servicio(view_servicios.jTIdServicio.getText());
            model_servicios.setTipo_servicio(view_servicios.jTTipoServicio.getText());
            model_servicios.setDescripcion_servicio(view_servicios.jTDescripcionServicio.getText());
            if(!view_servicios.jTCostoServicio.getText().equals(" ")){
                model_servicios.setCosto_servicio(Float.parseFloat(view_servicios.jTCostoServicio.getText()));
            }

            
            
            
            model_servicios.modificarDatosServicio(servicioConexion);
            //Este comando realiza la accion de utlilzar el metodo de modificarDatosUsuario usando el objeto construido en de modelServicios
            JOptionPane.showMessageDialog(null, "Datos del servicio modificados correctamente");
            tablaConsulta();
            //Se usa el metodo tablaConsulta para actualizar los registros en jTableServicios

        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun cambio");
        }
    }
    
    public void Borrar_servicio_actionListener() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea borrar los datos del servicio?", "Borrar servicio", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            model_servicios.setId_servicio(view_servicios.jTIdServicio.getText());
            model_servicios.borrarDatosServicio(servicioConexion);
            tablaConsulta();
            JOptionPane.showMessageDialog(null, "Los datos del servicio han sido eliminados");
        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se borro ningun registro");
        }
    }
    
    
    public void tablaConsulta() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            view_servicios.jTableServicios.setModel(modelo);
            view_servicios.jTableServicios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            model_servicios.consultajTableServicio(servicioConexion);
            
            ResultSetMetaData rsMd = model_servicios.getRs().getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Tipo de Servicio");
            modelo.addColumn("Descripción del Servicio");
            modelo.addColumn("Costo");
                        
     
            while (model_servicios.getRs().next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    filas[i] = model_servicios.getRs().getObject(i + 1);
                }

                modelo.addRow(filas);

            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }
    
    
    public void insertarCamposTabla() {
        try {
            if (view_servicios.jTableServicios.getSelectedRow() != -1) {
                int fila = view_servicios.jTableServicios.getSelectedRow();

                view_servicios.jTIdServicio.setText(view_servicios.jTableServicios.getValueAt(fila, 0).toString());
                view_servicios.jTTipoServicio.setText(view_servicios.jTableServicios.getValueAt(fila, 1).toString());
                view_servicios.jTDescripcionServicio.setText(view_servicios.jTableServicios.getValueAt(fila, 2).toString());
                view_servicios.jTCostoServicio.setText(view_servicios.jTableServicios.getValueAt(fila, 3).toString());            
               
                
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error:\nSelecciona un registro");
        }
    }
    
    
    public void Nuevo_servicio_actionPerformed() {
        
               
        //view_servicios.jTIdServicio.setText("");
        view_servicios.jTTipoServicio.setText("");
        view_servicios.jTDescripcionServicio.setText("");
        view_servicios.jTCostoServicio.setText("");
        codigos();
    }
    
    
    /**
     * Este metodo permite generar codigos automaticamente con una consulta en
     * la base de datos desde models.ModelServicios.GenerarCodigos
     */
    public void codigos() {

        int j;
        int cont = 1;
        String num = "";
        model_servicios.consultaGenerarCodigos(servicioConexion);

        if (model_servicios.getU() == null) {
            view_servicios.jTIdServicio.setText("SEDITEK-S0000001");
        } else {
            char r1 = model_servicios.getU().charAt(6);
            char r2 = model_servicios.getU().charAt(7);
            char r3 = model_servicios.getU().charAt(8);
            char r4 = model_servicios.getU().charAt(9);
            char r5 = model_servicios.getU().charAt(10);
            char r6 = model_servicios.getU().charAt(11);
            char r7 = model_servicios.getU().charAt(12);

            String r = "";
            r = "" + r1 + r2 + r3 + r4 + r5 + r6 + r7;
            j = Integer.parseInt(r);
            System.out.println(j);
            ModelGenerarCodigos gen = new ModelGenerarCodigos();
            gen.generar(j);
            view_servicios.jTIdServicio.setText("SEDITEK-S" + gen.serie());
            System.out.println("SEDITEK-S" + gen.serie());

        }
    }
    
    
    
}