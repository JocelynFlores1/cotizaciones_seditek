
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.ModelAgProd;
import models.ModelConexion;
import views.AgProd;
import views.ViewCotizaciones;


/**
 *
 * @author Carina
 */
public class ControllerAgProd {
    public ModelAgProd model_agregar_producto;
    public AgProd view_agregar_producto;
    public ViewCotizaciones view_cotizaciones;
    
    DefaultTableModel m;
    static double total;//total
    double sub_total;//sub total
    double igv; //igv


ModelConexion productoConexion = new ModelConexion();
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //if (e.getSource() == view_agregar_producto.jBSalir) {
              // Salir_actionPerformed();
            //}else
            if (e.getSource() == view_agregar_producto.jBAgregar){ 
                 Agregar_producto_actionPerformed();
            }
        }
    };

    public ControllerAgProd(ModelAgProd model_agregar_producto, AgProd view_agregar_producto) {
            this.model_agregar_producto = model_agregar_producto;
            this.view_agregar_producto = view_agregar_producto;
            
            total = 0;
            sub_total = 0.0;
            igv = 0.0;
        
            initComponents();
            setActionListener();
        }
    
        private void initComponents() {
        view_agregar_producto.setVisible(true);
        model_agregar_producto.conectarDB(productoConexion);
        tablaConsulta();
        
    }
        
        /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
       view_agregar_producto.jBAgregar.addActionListener(actionListener);
//       view_agregar_producto.jBSalir.addActionListener(actionListener);

    }
    
    public void tablaConsulta() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            view_agregar_producto.jTAgProd.setModel(modelo);
            view_agregar_producto.jTAgProd.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            model_agregar_producto.consultajTableProducto(productoConexion);
            
            ResultSetMetaData rsMd = model_agregar_producto.getRs().getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            
            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Marca");
            modelo.addColumn("Precio Unitario");
            
            
            
            
     
            while (model_agregar_producto.getRs().next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    filas[i] = model_agregar_producto.getRs().getObject(i + 1);
                }

                modelo.addRow(filas);

            }
            
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }
    
    public void insertarCamposTabla() {
        try {
            if (view_agregar_producto.jTAgProd.getSelectedRow() != -1) {
                int fila = view_agregar_producto.jTAgProd.getSelectedRow();
                

                
                view_agregar_producto.jTAgProd.getValueAt(fila, 0).toString();
                view_agregar_producto.jTAgProd.getValueAt(fila, 1).toString();
                view_agregar_producto.jTAgProd.getValueAt(fila, 2).toString();
                view_agregar_producto.jTAgProd.getValueAt(fila, 3).toString();
                 
                
                
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error:\nSelecciona un registro");
        }
        
    }
  
     public void Agregar_producto_actionPerformed() {
         
              int fsel = view_agregar_producto.jTAgProd.getSelectedRow();
                try {
                    String codigo, nombre, marca, precio, cant, importe;
                    double calcula = 0.0 , x = 0.0, igvs = 0.0;
                    int canti = 0;

                    if(fsel==-1){
                        JOptionPane.showMessageDialog(null, "Debe seleccionar un producto", "Advertencia", JOptionPane.WARNING_MESSAGE);

                    } else {
                        m = (DefaultTableModel) view_agregar_producto.jTAgProd.getModel();
                        System.out.println(m);
                        codigo = view_agregar_producto.jTAgProd.getValueAt(fsel, 0).toString();
                        System.out.println(codigo);
                        nombre = view_agregar_producto.jTAgProd.getValueAt(fsel, 1).toString();
                        System.out.println(nombre);
                        marca = view_agregar_producto.jTAgProd.getValueAt(fsel, 2).toString();
                        System.out.println(marca);
                        precio = view_agregar_producto.jTAgProd.getValueAt(fsel, 3).toString();
                        System.out.println(precio);
                        //cant = view_agregar_producto.jTFCantidad.getText();
                        //System.out.println(cant);
                        
                        //x = (Double.parseDouble(precio) *  Integer.parseInt(cant));
                        //importe = String.valueOf(x);
                        
                        //m = (DefaultTableModel) view_cotizaciones.jTDetalleCoti.getModel();
                        //String filaelemento[] = {cant,nombre,marca,precio,importe};
                        //m.addRow(filaelemento);
                        
                    }

                } catch (Exception e) {
                }             
    }
    
    public void Salir_actionPerformed() {
        this.view_agregar_producto.setVisible(false);
        this.view_cotizaciones.setVisible(true);
    }
    
    /*public void insertarProductos(ControllerAgProd cotizacion) {
        try {
            if (view_agregar_producto.jTAgregados.getSelectedRow() != -1) {
                int fila = view_agregar_producto.jTAgregados.getSelectedRow();
                

                
                view_agregar_producto.jTAgregados.getValueAt(fila, 0).toString();
                view_agregar_producto.jTAgregados.getValueAt(fila, 1).toString();
                view_agregar_producto.jTAgregados.getValueAt(fila, 2).toString();
                view_agregar_producto.jTAgregados.getValueAt(fila, 3).toString();
                 
                
                
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error:\nSelecciona un registro");
        }
    }*/
    
    /*public void tablaConsultaProductosAg() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            view_agregar_producto.jTAgregados.setModel(modelo);
            view_agregar_producto.jTAgregados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            model_agregar_producto.consultajTableProducto(productoConexion);
            
            ResultSetMetaData rsMd = model_agregar_producto.getRs().getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            
            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Marca");
            modelo.addColumn("Precio Unitario");
            
            
            
            
     
            while (model_agregar_producto.getRs().next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    filas[i] = model_agregar_producto.getRs().getObject(i + 1);
                }

                modelo.addRow(filas);

            }
            
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }*/

}
