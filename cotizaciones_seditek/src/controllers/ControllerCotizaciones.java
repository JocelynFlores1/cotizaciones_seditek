
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.ModelConexion;
import models.ModelCotizaciones;
import views.ViewCotizaciones;
import views.AgProd;
import models.ModelAgProd;

/**
 *
 * @author Carina
 */

public class ControllerCotizaciones {

    public ModelCotizaciones model_cotizaciones;
    public ViewCotizaciones view_cotizaciones;
    private final String nombre_usuario;
    public AgProd agregar_producto;
    public ModelAgProd model_ag_producto;
    
    ModelConexion productoConexion = new ModelConexion();
    
    models.ModelLogin modelLogin;
    views.ViewLogin viewLogin;

    private final ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view_cotizaciones.jBAgreProduct){
                Agregar_producto_actionPerformed();
            } //else if (e.getSource() == view_cotizaciones.jBAgrServ){
               // Agregar_servicio_actionPerformed();
            //}
        }
        
    };
    
    public ControllerCotizaciones(ModelCotizaciones model_cotizaciones, ViewCotizaciones view_cotizaciones, String nombre_usuario) {
        this.model_cotizaciones = model_cotizaciones;
        this.view_cotizaciones = view_cotizaciones;
        this.nombre_usuario = nombre_usuario;
        initComponents();
        setActionListener();
    }


    private void initComponents() {
        view_cotizaciones.setVisible(true);
        model_cotizaciones.conectarDB(productoConexion);
        view_cotizaciones.jTFAtencion.setText("" + nombre_usuario);
        
        //tablaConsulta();
    }
    
     private void setActionListener(){
        view_cotizaciones.jBAgreProduct.addActionListener(actionListener);
        view_cotizaciones.jBAgrServ.addActionListener(actionListener);
    }
    
      private void Agregar_producto_actionPerformed() {
        models.ModelAgProd model_agregar_producto = new models.ModelAgProd();
        views.AgProd view_agregar_producto = new views.AgProd();
        controllers.ControllerAgProd controlleragregarproducto = new controllers.ControllerAgProd(model_agregar_producto, view_agregar_producto);        
//        view_cotizaciones.setContentPane(controlleragregarproducto.view_agregar_producto);
        view_cotizaciones.revalidate();
        view_cotizaciones.repaint();
        System.out.println("Productos");
    }
      
     /* private void Agregar_servicio_actionPerformed() {
        models.ModelAgServ model_agregar_servicio = new models.ModelAgServ();
        views.AgServ view_agregar_servicio = new views.AgServ();
        controllers.ControllerAgServ controlleragregarservicio = new controllers.ControllerAgServ(model_agregar_servicio, view_agregar_servicio);        
//        view_cotizaciones.setContentPane(controlleragregarproducto.view_agregar_producto);
        view_cotizaciones.revalidate();
        view_cotizaciones.repaint();
        System.out.println("Productos");
    }*/
         
      /*   public void tablaConsulta() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            agregar_producto.jTAgProd.setModel(modelo);
            agregar_producto.jTAgProd.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            model_ag_producto.consultajTableProducto(productoConexion);
            
            ResultSetMetaData rsMd = model_cotizaciones.getRs().getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Marca");
            modelo.addColumn("Modelo");
            modelo.addColumn("Descripción Usuario");
            modelo.addColumn("Descripción Cliente");
            modelo.addColumn("Accesorios");
            modelo.addColumn("Precio Unitario");
            modelo.addColumn("Stock");
            modelo.addColumn("Proveedor");
            
            
            
     
            while (model_ag_producto.getRs().next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    filas[i] = model_ag_producto.getRs().getObject(i + 1);
                }

                modelo.addRow(filas);

            }
            
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }*/
         
       /* public void insertarCamposTabla() {
        try {
            if (view_cotizaciones.jTAgProd.getSelectedRow() != -1) {
                int fila = view_cotizaciones.jTAgProd.getSelectedRow();

                view_cotizaciones.jTAgProd.getValueAt(fila, 0).toString();
                view_cotizaciones.jTAgProd.getValueAt(fila, 1).toString();
                view_cotizaciones.jTAgProd.getValueAt(fila, 2).toString();
                view_cotizaciones.jTAgProd.getValueAt(fila, 3).toString();
                view_cotizaciones.jTAgProd.getValueAt(fila, 4).toString();
                view_cotizaciones.jTAgProd.getValueAt(fila, 5).toString();
                view_cotizaciones.jTAgProd.getValueAt(fila, 6).toString();
                view_cotizaciones.jTAgProd.getValueAt(fila, 7).toString();
                view_cotizaciones.jTAgProd.getValueAt(fila, 8).toString();
                view_cotizaciones.jTAgProd.getValueAt(fila, 9).toString();
                view_cotizaciones.jTAgProd.getValueAt(fila, 10).toString();
                
                
               
                
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error:\nSelecciona un registro");
        }
    }*/
}



