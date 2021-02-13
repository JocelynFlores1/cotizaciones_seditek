package controllers;

import models.ModelProductos;
import models.ModelConexion;
import models.ModelGenerarCodigos;
import views.ViewProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ControllerProductos {
    
    public ModelProductos model_productos;
    public ViewProductos view_productos;
    ModelConexion productoConexion = new ModelConexion();
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view_productos.jBInsertarProducto) {
                Insertar_producto_actionPerformed();
            } else if (e.getSource() == view_productos.jBModificarProducto) {
                Modificar_producto_actionPerformed();
            } else if (e.getSource() == view_productos.jBEliminarProducto) {
                Borrar_producto_actionListener();
            } else if (e.getSource() == view_productos.jBNuevoProducto) {
                Nuevo_producto_actionPerformed();
            }
        }
    };
    
    
    public ControllerProductos(ModelProductos model_productos,ViewProductos views_productos){
        this.model_productos = model_productos;
        this.view_productos = views_productos;
        initComponents();
        setActionListener();
    }
    
    public void initComponents() {
        view_productos.setVisible(true);
        model_productos.conectarDB(productoConexion);
        CambiarCampos();
        tablaConsulta();
        System.out.println("Solo se inicia si se abre usuarios");
    }
    
    /**
     * *
     * Metodo que cambia los campos de los jTextField en ViewProductos
     */
    public void CambiarCampos() {
        
        view_productos.jTIdProducto.setText(""+model_productos.getId_producto());
        view_productos.jTCodigoProducto.setText(""+model_productos.getCodigo_producto());
        view_productos.jTNombreProducto.setText(""+model_productos.getNombre_producto());
        view_productos.jTMarcaProducto.setText(""+model_productos.getMarca());
        view_productos.jTModeloProducto.setText(""+model_productos.getModelo());
        view_productos.jTDescripcionUsuarioProducto.setText(""+model_productos.getDescripcion_usuario());
        view_productos.jTDescripcionClienteProducto.setText(""+model_productos.getDescripcion_cliente());
        view_productos.jTAccesoriosProducto.setText(""+model_productos.getAccesorios());
        view_productos.jTPrecioProducto.setText(""+model_productos.getPrecio_unitario());
        view_productos.jTStockProducto.setText(""+model_productos.getStock());
        view_productos.jTProveedorProducto.setText(""+model_productos.getId_proveedor());
    }
    

        /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        view_productos.jBNuevoProducto.addActionListener(actionListener);
        view_productos.jBInsertarProducto.addActionListener(actionListener);
        view_productos.jBModificarProducto.addActionListener(actionListener);
        view_productos.jBEliminarProducto.addActionListener(actionListener);
        view_productos.jTableProductos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
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
    public void Insertar_producto_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Vas a guardar un nuevo producto?", "Guardar producto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
        
            model_productos.setId_producto(view_productos.jTIdProducto.getText());
            model_productos.setCodigo_producto(view_productos.jTCodigoProducto.getText());
            model_productos.setNombre_producto(view_productos.jTNombreProducto.getText());
            model_productos.setMarca(view_productos.jTCodigoProducto.getText());
            model_productos.setModelo(view_productos.jTNombreProducto.getText());
            model_productos.setDescripcion_usuario(view_productos.jTCodigoProducto.getText());
            model_productos.setDescripcion_cliente(view_productos.jTNombreProducto.getText());
            model_productos.setAccesorios(view_productos.jTCodigoProducto.getText());
            if(!view_productos.jTPrecioProducto.getText().equals(" ")){
            model_productos.setPrecio_unitario(Float.parseFloat(view_productos.jTPrecioProducto.getText()));
            } 
            if(!view_productos.jTStockProducto.getText().equals(" ")){
            model_productos.setStock(Integer.parseInt(view_productos.jTStockProducto.getText()));
            }
            model_productos.setId_proveedor(view_productos.jTProveedorProducto.getText());
           

            model_productos.insertarNuevoProducto(productoConexion);
            tablaConsulta();
            JOptionPane.showMessageDialog(null, "Registro almacenado correctamente");
        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun producto");
        }
    }
    
    
    
    public void Modificar_producto_actionPerformed() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea actualizar los datos del producto?", "Guardar cambios", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
                        
            model_productos.setId_producto(view_productos.jTIdProducto.getText());
            model_productos.setCodigo_producto(view_productos.jTCodigoProducto.getText());
            model_productos.setNombre_producto(view_productos.jTNombreProducto.getText());
            model_productos.setMarca(view_productos.jTCodigoProducto.getText());
            model_productos.setModelo(view_productos.jTNombreProducto.getText());
            model_productos.setDescripcion_usuario(view_productos.jTCodigoProducto.getText());
            model_productos.setDescripcion_cliente(view_productos.jTNombreProducto.getText());
            model_productos.setAccesorios(view_productos.jTCodigoProducto.getText());
            if(!view_productos.jTPrecioProducto.getText().equals(" ")){
            model_productos.setPrecio_unitario(Float.parseFloat(view_productos.jTPrecioProducto.getText()));
            } 
            if(!view_productos.jTStockProducto.getText().equals(" ")){
            model_productos.setStock(Integer.parseInt(view_productos.jTStockProducto.getText()));
            }
            model_productos.setId_proveedor(view_productos.jTProveedorProducto.getText());

            
            
            
            model_productos.insertarNuevoProducto(productoConexion);
            //Este comando realiza la accion de utlilzar el metodo de modificarDatosUsuario usando el objeto construido en de modelClientes
            JOptionPane.showMessageDialog(null, "Datos modificados correctamente");
            tablaConsulta();
            //Se usa el metodo tablaConsulta para actualizar los registros en jTableProducto

        } else {
            ///Respuesta que se obtiene cuando se cancela la accion del boton elegido
            JOptionPane.showMessageDialog(null, "No se guardo ningun cambio");
        }
    }
    
    public void Borrar_producto_actionListener() {
        //JOptionPane.showConfirmDialog permite al usuario elegir si realizar la accion del boton solicitado o simplemente cancelarlo
        int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea borrar los datos del producto?", "Borrar producto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cancelar == 0) {
            model_productos.setId_producto(view_productos.jTIdProducto.getText());
            model_productos.borrarDatosProducto(productoConexion);
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
            view_productos.jTableProductos.setModel(modelo);
            view_productos.jTableProductos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            model_productos.consultajTableProducto(productoConexion);
            
            ResultSetMetaData rsMd = model_productos.getRs().getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Marca");
            modelo.addColumn("Modelo");
            modelo.addColumn("Descripción Usuario");
            modelo.addColumn("Stock");
            modelo.addColumn("Accesorios");
            modelo.addColumn("Precio Unitario");
            modelo.addColumn("Proveedor");
            modelo.addColumn("Descripción Cliente");
            
     
            while (model_productos.getRs().next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    filas[i] = model_productos.getRs().getObject(i + 1);
                }

                modelo.addRow(filas);

            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }
    
    
    public void insertarCamposTabla() {
        try {
            if (view_productos.jTableProductos.getSelectedRow() != -1) {
                int fila = view_productos.jTableProductos.getSelectedRow();

                view_productos.jTIdProducto.setText(view_productos.jTableProductos.getValueAt(fila, 0).toString());
                view_productos.jTCodigoProducto.setText(view_productos.jTableProductos.getValueAt(fila, 1).toString());
                view_productos.jTNombreProducto.setText(view_productos.jTableProductos.getValueAt(fila, 2).toString());
                view_productos.jTMarcaProducto.setText(view_productos.jTableProductos.getValueAt(fila, 3).toString());
                view_productos.jTModeloProducto.setText(view_productos.jTableProductos.getValueAt(fila, 4).toString());
                view_productos.jTDescripcionUsuarioProducto.setText(view_productos.jTableProductos.getValueAt(fila, 5).toString());
                view_productos.jTStockProducto.setText(view_productos.jTableProductos.getValueAt(fila, 6).toString());
                view_productos.jTAccesoriosProducto.setText(view_productos.jTableProductos.getValueAt(fila, 7).toString());
                view_productos.jTPrecioProducto.setText(view_productos.jTableProductos.getValueAt(fila, 8).toString());
                view_productos.jTProveedorProducto.setText(view_productos.jTableProductos.getValueAt(fila, 9).toString());
                view_productos.jTDescripcionClienteProducto.setText(view_productos.jTableProductos.getValueAt(fila, 10).toString());
                
               
                
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error:\nSelecciona un registro");
        }
    }
    
    
    public void Nuevo_producto_actionPerformed() {
        codigos();
               
        view_productos.jTIdProducto.setText(" ");
        view_productos.jTCodigoProducto.setText(" ");
        view_productos.jTNombreProducto.setText(" ");
        view_productos.jTMarcaProducto.setText(" ");
        view_productos.jTModeloProducto.setText(" ");
        view_productos.jTDescripcionUsuarioProducto.setText(" ");
        view_productos.jTDescripcionClienteProducto.setText(" ");
        view_productos.jTAccesoriosProducto.setText(" ");
        view_productos.jTPrecioProducto.setText(" ");
        view_productos.jTStockProducto.setText(" ");
        view_productos.jTProveedorProducto.setText(" ");
        
    }
    
    
    
    /**
     * Este metodo permite generar codigos automaticamente con una consulta en
     * la base de datos desde models.ModelUsuario.GenerarCodigos
     */
    public void codigos() {

        int j;
        int cont = 1;
        String num = "";
        model_productos.consultaGenerarCodigos(productoConexion);

        if (model_productos.getU() == null) {
            view_productos.jTIdProducto.setText("SEDITEK-P0000001");
        } else {
            char r1 = model_productos.getU().charAt(6);
            char r2 = model_productos.getU().charAt(7);
            char r3 = model_productos.getU().charAt(8);
            char r4 = model_productos.getU().charAt(9);
            char r5 = model_productos.getU().charAt(10);
            char r6 = model_productos.getU().charAt(11);
            char r7 = model_productos.getU().charAt(12);

            String r = "";
            r = "" + r1 + r2 + r3 + r4 + r5 + r6 + r7;
            j = Integer.parseInt(r);
            System.out.println(j);
            ModelGenerarCodigos gen = new ModelGenerarCodigos();
            gen.generar(j);
            view_productos.jTIdProducto.setText("SEDITEK-U" + gen.serie());
            System.out.println("SEDITEK-U" + gen.serie());

        }
    }
    
        
}
