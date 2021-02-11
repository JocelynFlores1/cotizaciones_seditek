package controllers;

import models.ModelProveedores;
import views.ViewProveedores;

public class ControllerProveedores {
    
    ModelProveedores model_proveedores;
    ViewProveedores view_proveedores;
    
    public ControllerProveedores(ModelProveedores model_proveedores,ViewProveedores view_proveedores  ){
        this.model_proveedores = model_proveedores;
        this. view_proveedores = view_proveedores;
        
        view_proveedores.jBActualizarProveedores.addActionListener(event -> jBActualizarProveedores_click());
        view_proveedores.jBAgregarProveedores.addActionListener(event -> jBAgregarProveedores_click());
        view_proveedores.jBEliminarProveedores.addActionListener(event -> jBEliminarProveedores_click());
        view_proveedores.jBLimpiarProveedores.addActionListener(event -> jBLimpiarProveedores_click());
        
    }
    
       
       
       
    
    public void jBLimpiarProveedores_click(){
        view_proveedores.jTIdProveedores.setText(" ");
        view_proveedores.jTNombreProveedores.setText(" ");
        view_proveedores.jTTelefonoProveedores.setText(" ");
        view_proveedores.jTTelefonoCProveedores.setText(" ");
        view_proveedores.jTEmailProveedores.setText(" ");
        view_proveedores.jTEmailCProveedores.setText(" ");
        view_proveedores.jTCalleProveedores.setText(" ");
        view_proveedores.jTColoniaProveedores.setText(" ");
        view_proveedores.jTMunicipioProveedores.setText(" ");
        view_proveedores.jTCPProveedores.setText(" ");
        view_proveedores.jTEmpresaProveedores.setText(" ");
        view_proveedores.jTRFC.setText(" ");
    }// boton nuevo
    
    
        
    public void jBAgregarProveedores_click(){
        setValores();
        model_proveedores.insertarProveedores();
        getValores();
        
    }// boton insertar
    
    public void jBActualizarProveedores_click(){
        setValores();
        model_proveedores.actualizarProveedores();
        getValores();
    }//boton actualizar
    
    public void jBEliminarProveedores_click(){
        setValores();
        model_proveedores.eliminarProveedores();
        getValores();
    }//boton borrar
    
    
    public void getValores(){
        view_proveedores.jTIdProveedores.setText(""+model_proveedores.getId_proveedor());
        view_proveedores.jTNombreProveedores.setText(""+model_proveedores.getNombre_proveedor());
        view_proveedores.jTTelefonoProveedores.setText(""+model_proveedores.getTelefono_proveedor());
        view_proveedores.jTTelefonoCProveedores.setText(""+model_proveedores.getTelefono_contacto());
        view_proveedores.jTEmailProveedores.setText(""+model_proveedores.getEmail_proveedor());
        view_proveedores.jTEmailCProveedores.setText(""+model_proveedores.getEmail_contacto());
        view_proveedores.jTCalleProveedores.setText(""+model_proveedores.getCalle_proveedor());
        view_proveedores.jTColoniaProveedores.setText(""+model_proveedores.getColonia_proveedor());
        view_proveedores.jTMunicipioProveedores.setText(""+model_proveedores.getMunicipio_proveedor());
        view_proveedores.jTCPProveedores.setText(""+model_proveedores.getCp_proveedor());
        view_proveedores.jTEmpresaProveedores.setText(""+model_proveedores.getEmpresa_proveedor());
        view_proveedores.jTRFC.setText(""+model_proveedores.getRfc_proveedor());
        
           
    } 
    
       
     public void setValores(){
        
        System.out.print(model_proveedores);
        model_proveedores.setId_proveedor(view_proveedores.jTIdProveedores.getText());
        model_proveedores.setNombre_proveedor(view_proveedores.jTNombreProveedores.getText());
        
        if(!view_proveedores.jTTelefonoProveedores.getText().equals(" ")){
            model_proveedores.setTelefono_proveedor(Integer.parseInt(view_proveedores.jTTelefonoProveedores.getText()));
        }
        if(!view_proveedores.jTTelefonoCProveedores.getText().equals(" ")){
            model_proveedores.setTelefono_contacto(Integer.parseInt(view_proveedores.jTTelefonoCProveedores.getText()));
        }       
        model_proveedores.setEmail_proveedor(view_proveedores.jTEmailProveedores.getText());
        model_proveedores.setEmail_contacto(view_proveedores.jTEmailCProveedores.getText());
        model_proveedores.setCalle_proveedor(view_proveedores.jTCalleProveedores.getText());
        model_proveedores.setColonia_proveedor(view_proveedores.jTColoniaProveedores.getText());
        model_proveedores.setMunicipio_proveedor(view_proveedores.jTMunicipioProveedores.getText());
        model_proveedores.setEmpresa_proveedor(view_proveedores.jTEmpresaProveedores.getText());
        model_proveedores.setRfc_proveedor(view_proveedores.jTRFC.getText());
        if(!view_proveedores.jTCPProveedores.getText().equals(" ")){
        model_proveedores.setCp_proveedor(Integer.parseInt(view_proveedores.jTCPProveedores.getText()));
        }
        
   }
    
}