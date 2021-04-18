package controllers;

import models.ModelProveedores;
import models.ModelConexion;
import models.ModelGenerarCodigos;
import views.ViewProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ControllerProveedores {
    
    public ModelProveedores model_proveedores;
    public ViewProveedores view_proveedores;
    ModelConexion proveedorConexion = new ModelConexion();
    
    
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view_proveedores.jBInsertarProveedor) {
                Insertar_proveedor_actionPerformed();
            } else if (e.getSource() == view_proveedores.jBModificarProveedor) {
                Modificar_proveedor_actionPerformed();
            } else if (e.getSource() == view_proveedores.jBEliminarProveedor) {
                Borrar_proveedor_actionListener();
            } else if (e.getSource() == view_proveedores.jBNuevoProveedor) {
                Nuevo_proveedor_actionPerformed();
            }
        }
    };
    
    
    public ControllerProveedores(ModelProveedores model_proveedores,ViewProveedores view_proveedores  ){
        this.model_proveedores = model_proveedores;
        this. view_proveedores = view_proveedores;
        initComponents();
        setActionListener();
        
    }
    
    
    public void initComponents() {
        view_proveedores.setVisible(true);
        model_proveedores.conectarDB(proveedorConexion);
        CambiarCampos();
        tablaConsulta();
        System.out.println("Solo se inicia si se abre proveedores");
    }
       
       
    /**
     * *
     * Metodo que cambia los campos de los jTextField en ViewProductos
     */
    public void CambiarCampos() {
        
        view_proveedores.jTIdProveedor.setText(model_proveedores.getId_proveedor());
        view_proveedores.jTNombreProveedor.setText(model_proveedores.getNombre_proveedor());
        view_proveedores.jTTelefonoProveedor.setText(model_proveedores.getTelefono_proveedor());
        view_proveedores.jTTelefonoContacto.setText(model_proveedores.getTelefono_contacto());
        view_proveedores.jTEmailProveedor.setText(model_proveedores.getEmail_proveedor());
        view_proveedores.jTEmailContacto.setText(model_proveedores.getEmail_contacto());
        view_proveedores.jTCalleProveedor.setText(model_proveedores.getCalle_proveedor());
        view_proveedores.jTColoniaProveedor.setText(model_proveedores.getColonia_proveedor());
        view_proveedores.jTMunicipioProveedor.setText(model_proveedores.getMunicipio_proveedor());
        view_proveedores.jTCpProveedor.setText(""+model_proveedores.getCp_proveedor());
        view_proveedores.jTEmpresaProveedor.setText(model_proveedores.getEmpresa_proveedor());
        view_proveedores.jTRfcProveedor.setText(model_proveedores.getRfc_proveedor());
    }
       
    
     /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        view_proveedores.jBNuevoProveedor.addActionListener(actionListener);
        view_proveedores.jBInsertarProveedor.addActionListener(actionListener);
        view_proveedores.jBModificarProveedor.addActionListener(actionListener);
        view_proveedores.jBEliminarProveedor.addActionListener(actionListener);
        view_proveedores.jTableProveedores.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                insertarCamposTabla();
            }
        });
    }
    
    
    /**
     * *
     * Modelo que permite insertar el texto obenido en los jTextField de
     * ViewProductos e inserta los valores en las variables de ModelProductos
     */
    public void Insertar_proveedor_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Vas a guardar un nuevo proveedor?", "Guardar proveedor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if( view_proveedores.jTNombreProveedor.getText().equals("") ||
                view_proveedores.jTTelefonoProveedor.getText().equals("") || view_proveedores.jTTelefonoContacto.getText().equals("")||
                view_proveedores.jTEmailProveedor.getText().equals("") || view_proveedores.jTEmailContacto.getText().equals("") ||
                view_proveedores.jTCalleProveedor.getText().equals("") || view_proveedores.jTColoniaProveedor.getText().equals("") ||
                view_proveedores.jTMunicipioProveedor.getText().equals("") || view_proveedores.jTEmpresaProveedor.getText().equals("") ||
                view_proveedores.jTRfcProveedor.equals("") ){
                
        JOptionPane.showMessageDialog(null,"Debes llenar todos los campos");
        }else{
        
        if (cancelar == 0) {
        
            System.out.print(model_proveedores);
            model_proveedores.setId_proveedor(view_proveedores.jTIdProveedor.getText());
            model_proveedores.setNombre_proveedor(view_proveedores.jTNombreProveedor.getText());

            
            model_proveedores.setTelefono_proveedor(view_proveedores.jTTelefonoProveedor.getText());
            model_proveedores.setTelefono_contacto(view_proveedores.jTTelefonoContacto.getText());     
            model_proveedores.setEmail_proveedor(view_proveedores.jTEmailProveedor.getText());
            model_proveedores.setEmail_contacto(view_proveedores.jTEmailContacto.getText());
            model_proveedores.setCalle_proveedor(view_proveedores.jTCalleProveedor.getText());
            model_proveedores.setColonia_proveedor(view_proveedores.jTColoniaProveedor.getText());
            model_proveedores.setMunicipio_proveedor(view_proveedores.jTMunicipioProveedor.getText());
            model_proveedores.setEmpresa_proveedor(view_proveedores.jTEmpresaProveedor.getText());
            model_proveedores.setRfc_proveedor(view_proveedores.jTRfcProveedor.getText());
            if(!view_proveedores.jTCpProveedor.getText().equals(" ")){
            model_proveedores.setCp_proveedor(Integer.parseInt(view_proveedores.jTCpProveedor.getText()));
            }
            
            model_proveedores.insertarNuevoProveedor(proveedorConexion);
            tablaConsulta();
            JOptionPane.showMessageDialog(null, "Registro almacenado correctamente");
        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun proveedor");
        }
    }
    }
        
    /**
     *
     */
    public void Modificar_proveedor_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea actualizar los datos del proveedor?", "Guardar cambios", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
                        
            //model_proveedores.setId_proveedor(view_proveedores.jTIdProveedor.getText());
            model_proveedores.setNombre_proveedor(view_proveedores.jTNombreProveedor.getText());

            model_proveedores.setTelefono_proveedor(view_proveedores.jTTelefonoProveedor.getText());

            model_proveedores.setTelefono_contacto(view_proveedores.jTTelefonoContacto.getText());
                   
            model_proveedores.setEmail_proveedor(view_proveedores.jTEmailProveedor.getText());
            model_proveedores.setEmail_contacto(view_proveedores.jTEmailContacto.getText());
            model_proveedores.setCalle_proveedor(view_proveedores.jTCalleProveedor.getText());
            model_proveedores.setColonia_proveedor(view_proveedores.jTColoniaProveedor.getText());
            model_proveedores.setMunicipio_proveedor(view_proveedores.jTMunicipioProveedor.getText());
            model_proveedores.setEmpresa_proveedor(view_proveedores.jTEmpresaProveedor.getText());
            model_proveedores.setRfc_proveedor(view_proveedores.jTRfcProveedor.getText());
            if(!view_proveedores.jTCpProveedor.getText().equals(" ")){
            model_proveedores.setCp_proveedor(Integer.parseInt(view_proveedores.jTCpProveedor.getText()));
            }
            
            
            model_proveedores.modificarDatosProveedor(proveedorConexion);
            //Este comando realiza la accion de utlilzar el metodo de modificarDatosUsuario usando el objeto construido en de modelClientes
            JOptionPane.showMessageDialog(null, "Datos modificados correctamente");
            tablaConsulta();
            //Se usa el metodo tablaConsulta para actualizar los registros en jTableProducto

        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun cambio");
        }
    }
    
        
       
    public void Borrar_proveedor_actionListener() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea borrar los datos del proveedor?", "Borrar proveedor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            model_proveedores.setId_proveedor(view_proveedores.jTIdProveedor.getText());
            model_proveedores.borrarDatosProveedor(proveedorConexion);
            tablaConsulta();
            JOptionPane.showMessageDialog(null, "Los datos del producto han sido eliminados");
        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se borro ningun registro");
        }
    }
        
        
    public void tablaConsulta() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            view_proveedores.jTableProveedores.setModel(modelo);
            view_proveedores.jTableProveedores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            model_proveedores.consultajTableProveedor(proveedorConexion);
            
            ResultSetMetaData rsMd = model_proveedores.getRs().getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Teléfono");
            modelo.addColumn("Teléfono Contacto");
            modelo.addColumn("Email");
            modelo.addColumn("Email Contacto");
            modelo.addColumn("Calle");
            modelo.addColumn("Colonia");
            modelo.addColumn("Municipio");
            modelo.addColumn("Empresa");
            modelo.addColumn("RFC");
            modelo.addColumn("C.P");
            
     
            while (model_proveedores.getRs().next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    filas[i] = model_proveedores.getRs().getObject(i + 1);
                }

                modelo.addRow(filas);

            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }
    
    
    public void insertarCamposTabla() {
        try {
            if (view_proveedores.jTableProveedores.getSelectedRow() != -1) {
                int fila = view_proveedores.jTableProveedores.getSelectedRow();

                view_proveedores.jTIdProveedor.setText(view_proveedores.jTableProveedores.getValueAt(fila, 0).toString());
                view_proveedores.jTNombreProveedor.setText(view_proveedores.jTableProveedores.getValueAt(fila, 1).toString());
                view_proveedores.jTTelefonoProveedor.setText(view_proveedores.jTableProveedores.getValueAt(fila, 2).toString());
                view_proveedores.jTTelefonoContacto.setText(view_proveedores.jTableProveedores.getValueAt(fila, 3).toString());
                view_proveedores.jTEmailProveedor.setText(view_proveedores.jTableProveedores.getValueAt(fila, 4).toString());
                view_proveedores.jTEmailContacto.setText(view_proveedores.jTableProveedores.getValueAt(fila, 5).toString());
                view_proveedores.jTCalleProveedor.setText(view_proveedores.jTableProveedores.getValueAt(fila, 6).toString());
                view_proveedores.jTColoniaProveedor.setText(view_proveedores.jTableProveedores.getValueAt(fila, 7).toString());
                view_proveedores.jTMunicipioProveedor.setText(view_proveedores.jTableProveedores.getValueAt(fila, 8).toString());
                view_proveedores.jTEmpresaProveedor.setText(view_proveedores.jTableProveedores.getValueAt(fila, 9).toString());
                view_proveedores.jTRfcProveedor.setText(view_proveedores.jTableProveedores.getValueAt(fila, 10).toString());
                view_proveedores.jTCpProveedor.setText(view_proveedores.jTableProveedores.getValueAt(fila, 11).toString());
                
               
                
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error:\nSelecciona un registro");
        }
    }
    
    

    public void Nuevo_proveedor_actionPerformed() {
        
               
        //view_proveedores.jTIdProveedor.setText("");
        view_proveedores.jTNombreProveedor.setText("");
        view_proveedores.jTTelefonoProveedor.setText("");
        view_proveedores.jTTelefonoContacto.setText("");
        view_proveedores.jTEmailProveedor.setText("");
        view_proveedores.jTEmailContacto.setText("");
        view_proveedores.jTCalleProveedor.setText("");
        view_proveedores.jTColoniaProveedor.setText("");
        view_proveedores.jTMunicipioProveedor.setText("");
        view_proveedores.jTCpProveedor.setText("");
        view_proveedores.jTEmpresaProveedor.setText("");
        view_proveedores.jTRfcProveedor.setText("");
        
 
    }


    
    public void codigos() {

        int j;
        int cont = 1;
        String num = "";
        model_proveedores.consultaGenerarCodigos(proveedorConexion);

        if (model_proveedores.getU() == null) {
            view_proveedores.jTIdProveedor.setText("SEDITEK-p000001");
        } else {
            char r1 = model_proveedores.getU().charAt(6);
            char r2 = model_proveedores.getU().charAt(7);
            char r3 = model_proveedores.getU().charAt(8);
            char r4 = model_proveedores.getU().charAt(9);
            char r5 = model_proveedores.getU().charAt(10);
            char r6 = model_proveedores.getU().charAt(11);
            char r7 = model_proveedores.getU().charAt(12);

            String r = "";
            r = "" + r1 + r2 + r3 + r4 + r5 + r6 + r7;
            j = Integer.parseInt(r);
            System.out.println(j);
            ModelGenerarCodigos gen = new ModelGenerarCodigos();
            gen.generar(j);
            view_proveedores.jTIdProveedor.setText("SEDITEK-p" + gen.serie());
            System.out.println("SEDITEK-p" + gen.serie());

        }
    }
    
}