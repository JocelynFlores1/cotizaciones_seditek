package controllers;

import models.ModelProductos;
import views.ViewProductos;


public class ControllerProductos {
    
    ModelProductos model_productos;
    ViewProductos views_productos;
    
    
    public ControllerProductos(ModelProductos model_productos,ViewProductos views_productos){
        this.model_productos = model_productos;
        this.views_productos = views_productos;
        
        views_productos.jBActualizarProductos.addActionListener(event -> jBActualizarProductos_click());
        views_productos.jBAgregarProductos.addActionListener(event -> jBAgregarProductos_click());
        views_productos.jBEliminarProductos.addActionListener(event -> jBEliminarProductos_click());
        views_productos.jBLimpiarProductos.addActionListener(event -> jBLimpiarProductos_click());
        
    }
    
        public void jBLimpiarProductos_click(){
        views_productos.jTIdProductos.setText(" ");
        views_productos.jTCodigoProductos.setText(" ");
        views_productos.jTNombreProductos.setText(" ");
        views_productos.jTMarcaProductos.setText(" ");
        views_productos.jTModeloProductos.setText(" ");
        views_productos.jTDescripcionUsuarioProductos.setText(" ");
        views_productos.jTDescripcionClienteProductos.setText(" ");
        views_productos.jTAccesoriosProductos.setText(" ");
        views_productos.jTPrecioProductos.setText(" ");
        views_productos.jTStockProductos.setText(" ");
        views_productos.jTProveedorProductos.setText(" ");
    }// boton nuevo
    
    public void jBAgregarProductos_click(){
        setValores();
        model_productos.insertarProductos();
        getValores();
        
    }// boton insertar
    
    public void jBActualizarProductos_click(){
        setValores();
        model_productos.actualizarProductos();
        getValores();
    }//boton actualizar
    
    public void jBEliminarProductos_click(){
        setValores();
        model_productos.eliminarProductos();
        getValores();
    }//boton borrar
    
    
        public void getValores(){
        views_productos.jTIdProductos.setText(""+model_productos.getId_producto());
        views_productos.jTCodigoProductos.setText(""+model_productos.getCodigo_producto());
        views_productos.jTNombreProductos.setText(""+model_productos.getNombre_producto());
        views_productos.jTMarcaProductos.setText(""+model_productos.getMarca());
        views_productos.jTModeloProductos.setText(""+model_productos.getModelo());
        views_productos.jTDescripcionUsuarioProductos.setText(""+model_productos.getDescripcion_usuario());
        views_productos.jTDescripcionClienteProductos.setText(""+model_productos.getDescripcion_cliente());
        views_productos.jTAccesoriosProductos.setText(""+model_productos.getAccesorios());
        views_productos.jTPrecioProductos.setText(""+model_productos.getPrecio_unitario());
        views_productos.jTStockProductos.setText(""+model_productos.getStock());
        views_productos.jTProveedorProductos.setText(""+model_productos.getId_proveedor());
        
        
        

    }
    
    public void setValores(){
        
        System.out.print(model_productos);
        model_productos.setId_producto(views_productos.jTIdProductos.getText());
        model_productos.setCodigo_producto(views_productos.jTCodigoProductos.getText());
        model_productos.setNombre_producto(views_productos.jTNombreProductos.getText());
        model_productos.setMarca(views_productos.jTCodigoProductos.getText());
        model_productos.setModelo(views_productos.jTNombreProductos.getText());
        model_productos.setDescripcion_usuario(views_productos.jTCodigoProductos.getText());
        model_productos.setDescripcion_cliente(views_productos.jTNombreProductos.getText());
        model_productos.setAccesorios(views_productos.jTCodigoProductos.getText());
        if(!views_productos.jTPrecioProductos.getText().equals(" ")){
            model_productos.setPrecio_unitario(Float.parseFloat(views_productos.jTPrecioProductos.getText()));
        } 
        if(!views_productos.jTStockProductos.getText().equals(" ")){
            model_productos.setStock(Integer.parseInt(views_productos.jTStockProductos.getText()));
        }
        model_productos.setId_proveedor(views_productos.jTProveedorProductos.getText());
    }
    
    
}
