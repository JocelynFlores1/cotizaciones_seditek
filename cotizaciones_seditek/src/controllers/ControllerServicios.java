package controllers;

import models.ModelServicios;
import views.ViewServicios;

public class ControllerServicios {
    ModelServicios model_servicios;
    ViewServicios view_servicios;
    
    
    
    public ControllerServicios(ModelServicios model_servicos, ViewServicios view_servicios){
        
        this.model_servicios = model_servicios;
        this.view_servicios = view_servicios;
        
        view_servicios.jBActualizarServicio.addActionListener(event -> jBActualizarServicios_click());
        view_servicios.jBAgregarServicio.addActionListener(event -> jBAgregarServicios_click());
        view_servicios.jBEliminarServicio.addActionListener(event -> jBEliminarServicios_click());
        view_servicios.jBLimpiarServicio.addActionListener(event -> jBLimpiarServicios_click());
        
    }
    
    
    public void jBLimpiarServicios_click(){
        view_servicios.jTIdServicio.setText(" ");
        view_servicios.jTTipoServicio.setText(" ");
        view_servicios.jTDescripcionServicio.setText(" ");
        view_servicios.jTCostoServicio.setText(" ");
        
    }// boton nuevo
    
    public void jBAgregarServicios_click(){
        setValores();
        model_servicios.insertarServicio();
        getValores();
        
    }// boton insertar
    
    public void jBActualizarServicios_click(){
        setValores();
        model_servicios.actualizarServicio();
        getValores();
    }//boton actualizar
    
    public void jBEliminarServicios_click(){
        setValores();
        model_servicios.eliminarServicio();
        getValores();
    }//boton borrar
    
    
     public void getValores(){
        view_servicios.jTIdServicio.setText(""+model_servicios.getId_servicio());
        view_servicios.jTTipoServicio.setText(""+model_servicios.getTipo_servicio());
        view_servicios.jTDescripcionServicio.setText(""+model_servicios.getDescripcion_servicio());
        view_servicios.jTCostoServicio.setText(""+model_servicios.getCosto_servicio());
       
    }
     
     public void setValores(){
        
        System.out.print(model_servicios);
        model_servicios.setId_servicio(view_servicios.jTIdServicio.getText());
        model_servicios.setTipo_servicio(view_servicios.jTTipoServicio.getText());
        model_servicios.setDescripcion_servicio(view_servicios.jTDescripcionServicio.getText());
        if(!view_servicios.jTCostoServicio.getText().equals(" ")){
            model_servicios.setCosto_servicio(Float.parseFloat(view_servicios.jTCostoServicio.getText()));
        } 
     }
     
}
