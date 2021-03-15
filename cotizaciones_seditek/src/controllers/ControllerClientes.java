package controllers;

import models.ModelClientes;
import models.ModelConexion;
import models.ModelGenerarCodigos;
import views.ViewClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



public class ControllerClientes {
    
    public ModelClientes model_clientes;
    public ViewClientes view_clientes;
    ModelConexion clienteConexion = new ModelConexion();
    
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view_clientes.jBInsertarCliente) {
                Insertar_cliente_actionPerformed();
            } else if (e.getSource() == view_clientes.jBModificarCliente) {
                Modificar_cliente_actionPerformed();
            } else if (e.getSource() == view_clientes.jBEliminarCliente) {
                Borrar_cliente_actionListener();
            } else if (e.getSource() == view_clientes.jBNuevoCliente) {
                Nuevo_cliente_actionPerformed();
            }
        }
    };
    
    
    public ControllerClientes(ModelClientes model_clientes,ViewClientes views_clientes){
        this.model_clientes = model_clientes;
        this.view_clientes = views_clientes;
        initComponents();
        setActionListener();
    }
    
    public void initComponents() {
        view_clientes.setVisible(true);
        model_clientes.conectarDB(clienteConexion);
        CambiarCampos();
        tablaConsulta();
        System.out.println("Solo se inicia si se abre clientes");
    }
    
    
    /**
     * *
     * Metodo que cambia los campos de los jTextField en ViewProductos
     */
    public void CambiarCampos() {
        
        view_clientes.jTIdCliente.setText(model_clientes.getId_cliente());
        view_clientes.jTNombreCliente.setText(model_clientes.getNombre_cliente());
        view_clientes.jTApellidoPaterno.setText(model_clientes.getApellido_paterno());
        view_clientes.jTApellidoMaterno.setText(model_clientes.getApellido_materno());
        view_clientes.jTTelefonoCliente.setText(""+model_clientes.getTelefono_cliente());
        view_clientes.jTTelefonoEmpresa.setText(""+model_clientes.getTelefono_empresa());
        view_clientes.jTEmailCliente.setText(model_clientes.getEmail_cliente());
        view_clientes.jTRfcCliente.setText(model_clientes.getRfc_cliente());
        view_clientes.jTCalleCliente.setText(model_clientes.getCalle_cliente());
        view_clientes.jTColoniaCliente.setText(model_clientes.getColonia_cliente());
        view_clientes.jTMunicipioCliente.setText(model_clientes.getMunicipio_cliente());
        view_clientes.jTEmpresaCliente.setText(model_clientes.getEmpresa_cliente());
        view_clientes.jTCpCliente.setText(""+model_clientes.getCp_cliente());
        
        
        
    }
    
    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        view_clientes.jBNuevoCliente.addActionListener(actionListener);
        view_clientes.jBInsertarCliente.addActionListener(actionListener);
        view_clientes.jBModificarCliente.addActionListener(actionListener);
        view_clientes.jBEliminarCliente.addActionListener(actionListener);
        view_clientes.jTableClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
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
    public void Insertar_cliente_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Vas a guardar un nuevo cliente?", "Guardar cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(view_clientes.jTIdCliente.getText().equals("") || view_clientes.jTNombreCliente.getText().equals("") ||
                view_clientes.jTApellidoPaterno.getText().equals("") || view_clientes.jTApellidoMaterno.getText().equals("")||
                view_clientes.jTTelefonoCliente.getText().equals("") || view_clientes.jTTelefonoEmpresa.getText().equals("") ||
                view_clientes.jTEmailCliente.getText().equals("") || view_clientes.jTRfcCliente.getText().equals("") ||
                view_clientes.jTCalleCliente.getText().equals("") || view_clientes.jTColoniaCliente.getText().equals("") ||
                view_clientes.jTMunicipioCliente.getText().equals("") || view_clientes.jTEmpresaCliente.getText().equals("") ||
                view_clientes.jTCpCliente.getText().equals("")){
                
        JOptionPane.showMessageDialog(null,"Debes llenar todos los campos");
        }else{
        
        if (cancelar == 0) {
        
            model_clientes.setId_cliente(view_clientes.jTIdCliente.getText());
            model_clientes.setNombre_cliente(view_clientes.jTNombreCliente.getText());
            model_clientes.setApellido_paterno(view_clientes.jTApellidoPaterno.getText());
            model_clientes.setApellido_materno(view_clientes.jTApellidoMaterno.getText());
            
            if(!view_clientes.jTTelefonoCliente.getText().equals(" ")){
            model_clientes.setTelefono_cliente(Integer.parseInt(view_clientes.jTTelefonoCliente.getText()));
            } 
            if(!view_clientes.jTTelefonoEmpresa.getText().equals(" ")){
            model_clientes.setTelefono_empresa(Integer.parseInt(view_clientes.jTTelefonoEmpresa.getText()));
            }
            
            model_clientes.setEmail_cliente(view_clientes.jTEmailCliente.getText());
            model_clientes.setRfc_cliente(view_clientes.jTRfcCliente.getText());
            model_clientes.setCalle_cliente(view_clientes.jTCalleCliente.getText());
            model_clientes.setColonia_cliente(view_clientes.jTColoniaCliente.getText());
            model_clientes.setMunicipio_cliente(view_clientes.jTMunicipioCliente.getText());
            model_clientes.setEmpresa_cliente(view_clientes.jTEmpresaCliente.getText());
            
            if(!view_clientes.jTCpCliente.getText().equals(" ")){
            model_clientes.setCp_cliente(Integer.parseInt(view_clientes.jTCpCliente.getText()));
            }
            
           

            model_clientes.insertarNuevoCliente(clienteConexion);
            tablaConsulta();
            JOptionPane.showMessageDialog(null, "Registro almacenado correctamente");
        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun producto");
        }
    }
    }
    
    
    
    public void Modificar_cliente_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea actualizar los datos del cliente?", "Guardar cambios", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            
            //model_clientes.setId_cliente(view_clientes.jTIdCliente.getText());
            model_clientes.setNombre_cliente(view_clientes.jTNombreCliente.getText());
            model_clientes.setApellido_paterno(view_clientes.jTApellidoPaterno.getText());
            model_clientes.setApellido_materno(view_clientes.jTApellidoMaterno.getText());
            if(!view_clientes.jTTelefonoCliente.getText().equals(" ")){
            model_clientes.setTelefono_cliente(Integer.parseInt(view_clientes.jTTelefonoCliente.getText()));
            } 
            if(!view_clientes.jTTelefonoEmpresa.getText().equals(" ")){
            model_clientes.setTelefono_empresa(Integer.parseInt(view_clientes.jTTelefonoEmpresa.getText()));
            }
            model_clientes.setEmail_cliente(view_clientes.jTEmailCliente.getText());
            model_clientes.setRfc_cliente(view_clientes.jTRfcCliente.getText());
            model_clientes.setCalle_cliente(view_clientes.jTCalleCliente.getText());
            model_clientes.setColonia_cliente(view_clientes.jTColoniaCliente.getText());
            model_clientes.setMunicipio_cliente(view_clientes.jTMunicipioCliente.getText());
            model_clientes.setEmpresa_cliente(view_clientes.jTEmpresaCliente.getText());
            if(!view_clientes.jTCpCliente.getText().equals(" ")){
            model_clientes.setCp_cliente(Integer.parseInt(view_clientes.jTCpCliente.getText()));
            }
                        
            
            model_clientes.modificarDatosCliente(clienteConexion);
            //Este comando realiza la accion de utlilzar el metodo de modificarDatosUsuario usando el objeto construido en de modelClientes
            JOptionPane.showMessageDialog(null, "Datos del cliente modificados correctamente");
            tablaConsulta();
            //Se usa el metodo tablaConsulta para actualizar los registros en jTableProducto

        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun cambio");
        }
    }
    
    
    public void Borrar_cliente_actionListener() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea borrar los datos del cliente?", "Borrar cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            model_clientes.setId_cliente(view_clientes.jTIdCliente.getText());
            model_clientes.borrarDatosCliente(clienteConexion);
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
            view_clientes.jTableClientes.setModel(modelo);
            view_clientes.jTableClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            model_clientes.consultajTableCliente(clienteConexion);
            
            ResultSetMetaData rsMd = model_clientes.getRs().getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            modelo.addColumn("Teléfono Cliente");
            modelo.addColumn("Teléfono Empresa");
            modelo.addColumn("Email");
            modelo.addColumn("RFC");
            modelo.addColumn("Calle");
            modelo.addColumn("Colonia");
            modelo.addColumn("Municipio");
            modelo.addColumn("Empresa");
            modelo.addColumn("CP");
            
            
     
            while (model_clientes.getRs().next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    filas[i] = model_clientes.getRs().getObject(i + 1);
                }

                modelo.addRow(filas);

            }
            
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }
    
    
    
    public void insertarCamposTabla() {
        try {
            if (view_clientes.jTableClientes.getSelectedRow() != -1) {
                int fila = view_clientes.jTableClientes.getSelectedRow();

                view_clientes.jTIdCliente.setText(view_clientes.jTableClientes.getValueAt(fila, 0).toString());
                view_clientes.jTNombreCliente.setText(view_clientes.jTableClientes.getValueAt(fila, 1).toString());
                view_clientes.jTApellidoPaterno.setText(view_clientes.jTableClientes.getValueAt(fila, 2).toString());
                view_clientes.jTApellidoMaterno.setText(view_clientes.jTableClientes.getValueAt(fila, 3).toString());
                view_clientes.jTTelefonoCliente.setText(view_clientes.jTableClientes.getValueAt(fila, 4).toString());
                view_clientes.jTTelefonoEmpresa.setText(view_clientes.jTableClientes.getValueAt(fila, 5).toString());
                view_clientes.jTEmailCliente.setText(view_clientes.jTableClientes.getValueAt(fila, 6).toString());
                view_clientes.jTRfcCliente.setText(view_clientes.jTableClientes.getValueAt(fila, 7).toString());
                view_clientes.jTCalleCliente.setText(view_clientes.jTableClientes.getValueAt(fila, 8).toString());
                view_clientes.jTColoniaCliente.setText(view_clientes.jTableClientes.getValueAt(fila, 9).toString());
                view_clientes.jTMunicipioCliente.setText(view_clientes.jTableClientes.getValueAt(fila, 10).toString());
                view_clientes.jTEmpresaCliente.setText(view_clientes.jTableClientes.getValueAt(fila, 11).toString());
                view_clientes.jTCpCliente.setText(view_clientes.jTableClientes.getValueAt(fila, 12).toString());
                
                
               
                
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error:\nSelecciona un registro");
        }
    }
    
    
    public void Nuevo_cliente_actionPerformed() {
        
               
        //view_clientes.jTIdCliente.setText("");
        view_clientes.jTNombreCliente.setText("");
        view_clientes.jTApellidoPaterno.setText("");
        view_clientes.jTApellidoMaterno.setText("");
        view_clientes.jTTelefonoCliente.setText("");
        view_clientes.jTTelefonoEmpresa.setText("");
        view_clientes.jTEmailCliente.setText("");
        view_clientes.jTRfcCliente.setText("");
        view_clientes.jTCalleCliente.setText("");
        view_clientes.jTColoniaCliente.setText("");
        view_clientes.jTMunicipioCliente.setText("");
        view_clientes.jTEmpresaCliente.setText("");
        view_clientes.jTCpCliente.setText("");
        codigos();
        
    }
    
    
    
    
    
    /**
     * Este metodo permite generar codigos automaticamente con una consulta en
     * la base de datos desde models.ModelProductos.GenerarCodigos
     */
    public void codigos() {

        int j;
        int cont = 1;
        String num = "";
        model_clientes.consultaGenerarCodigos(clienteConexion);

        if (model_clientes.getU() == null) {
            view_clientes.jTIdCliente.setText("SEDITEK-C0000001");
        } else {
            char r1 = model_clientes.getU().charAt(6);
            char r2 = model_clientes.getU().charAt(7);
            char r3 = model_clientes.getU().charAt(8);
            char r4 = model_clientes.getU().charAt(9);
            char r5 = model_clientes.getU().charAt(10);
            char r6 = model_clientes.getU().charAt(11);
            char r7 = model_clientes.getU().charAt(12);

            String r = "";
            r = "" + r1 + r2 + r3 + r4 + r5 + r6 + r7;
            j = Integer.parseInt(r);
            System.out.println(j);
            ModelGenerarCodigos gen = new ModelGenerarCodigos();
            gen.generar(j);
            view_clientes.jTIdCliente.setText("SEDITEK-C" + gen.serie());
            System.out.println("SEDITEK-C" + gen.serie());

        }
    }
    
    
}
