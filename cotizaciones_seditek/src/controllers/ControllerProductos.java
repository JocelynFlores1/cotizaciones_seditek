package controllers;

import models.ModelProductos;
import views.ViewProductos;


public class ControllerProductos {
    
    ModelProductos model_productos;
    ViewProductos view_productos;
    
    
    public ControllerProductos(ModelProductos model_productos,ViewProductos views_productos){
        this.model_productos = model_productos;
        this.view_productos = views_productos;
        
        view_productos.jBActualizarProductos.addActionListener(event -> jBActualizarProductos_click());
        view_productos.jBAgregarProductos.addActionListener(event -> jBAgregarProductos_click());
        view_productos.jBEliminarProductos.addActionListener(event -> jBEliminarProductos_click());
        view_productos.jBLimpiarProductos.addActionListener(event -> jBLimpiarProductos_click());
        
    }
    
    public void jBLimpiarProductos_click(){
        view_productos.jTIdProductos.setText(" ");
        view_productos.jTCodigoProductos.setText(" ");
        view_productos.jTNombreProductos.setText(" ");
        view_productos.jTMarcaProductos.setText(" ");
        view_productos.jTModeloProductos.setText(" ");
        view_productos.jTDescripcionUsuarioProductos.setText(" ");
        view_productos.jTDescripcionClienteProductos.setText(" ");
        view_productos.jTAccesoriosProductos.setText(" ");
        view_productos.jTPrecioProductos.setText(" ");
        view_productos.jTStockProductos.setText(" ");
        view_productos.jTProveedorProductos.setText(" ");
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
        view_productos.jTIdProductos.setText(""+model_productos.getId_producto());
        view_productos.jTCodigoProductos.setText(""+model_productos.getCodigo_producto());
        view_productos.jTNombreProductos.setText(""+model_productos.getNombre_producto());
        view_productos.jTMarcaProductos.setText(""+model_productos.getMarca());
        view_productos.jTModeloProductos.setText(""+model_productos.getModelo());
        view_productos.jTDescripcionUsuarioProductos.setText(""+model_productos.getDescripcion_usuario());
        view_productos.jTDescripcionClienteProductos.setText(""+model_productos.getDescripcion_cliente());
        view_productos.jTAccesoriosProductos.setText(""+model_productos.getAccesorios());
        view_productos.jTPrecioProductos.setText(""+model_productos.getPrecio_unitario());
        view_productos.jTStockProductos.setText(""+model_productos.getStock());
        view_productos.jTProveedorProductos.setText(""+model_productos.getId_proveedor());
        
        
        

    }
    
    public void setValores(){
        
        System.out.print(model_productos);
        model_productos.setId_producto(view_productos.jTIdProductos.getText());
        model_productos.setCodigo_producto(view_productos.jTCodigoProductos.getText());
        model_productos.setNombre_producto(view_productos.jTNombreProductos.getText());
        model_productos.setMarca(view_productos.jTCodigoProductos.getText());
        model_productos.setModelo(view_productos.jTNombreProductos.getText());
        model_productos.setDescripcion_usuario(view_productos.jTCodigoProductos.getText());
        model_productos.setDescripcion_cliente(view_productos.jTNombreProductos.getText());
        model_productos.setAccesorios(view_productos.jTCodigoProductos.getText());
        if(!view_productos.jTPrecioProductos.getText().equals(" ")){
            model_productos.setPrecio_unitario(Float.parseFloat(view_productos.jTPrecioProductos.getText()));
        } 
        if(!view_productos.jTStockProductos.getText().equals(" ")){
            model_productos.setStock(Integer.parseInt(view_productos.jTStockProductos.getText()));
        }
        model_productos.setId_proveedor(view_productos.jTProveedorProductos.getText());
    }
    
    
}
