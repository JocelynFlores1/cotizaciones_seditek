package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModelServicios {

    private final ModelConexion model_conexion;
    private PreparedStatement pst;
    private ResultSet resut;
    private String sql;
    
    private String id_servicio;
    private String tipo_servicio;
    private String descripcion_servicio;
    private Float costo_servicio;
    
    public ModelServicios(ModelConexion model_conexion){
        this.model_conexion = model_conexion;
    }
    
    public String getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(String id_servivio) {
        this.id_servicio = id_servivio;
    }


    public String getTipo_servicio() {
        return tipo_servicio;
    }


    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }


    public String getDescripcion_servicio() {
        return descripcion_servicio;
    }


    public void setDescripcion_servicio(String descripcion_servicio) {
        this.descripcion_servicio = descripcion_servicio;
    }


    public Float getCosto_servicio() {
        return costo_servicio;
    }


    public void setCosto_servicio(Float costo_servicio) {
        this.costo_servicio = costo_servicio;
    }
    

    public void insertarServicio(){
        try{
            
            sql="INSERT into Servicios(id_servicio,tipo_servicio,descripcion_servicio,costo_servicio) "
                    + "values(?,?,?,?);";
            
            pst = model_conexion.getConexion().prepareStatement(sql);
            
            pst.setString(1,id_servicio);
            pst.setString(2,tipo_servicio);
            pst.setString(3,descripcion_servicio);
            pst.setFloat(4,costo_servicio);
                        
            pst.executeUpdate();
            
            System.out.println("insertando datos servicio ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 108 insertar datos "+ex.getMessage());
        }
     }// insertando datos
    
    
    public void eliminarServicio(){
        try{
            sql="DELETE FROM Servicios WHERE id_servicio= ?;";
            
            pst = model_conexion.getConexion().prepareStatement(sql);
            
            pst.setString(1,id_servicio);
            pst.executeUpdate();
 
            System.out.println("dato borrado servicio ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 109 Borrar datos "+ ex.getMessage());
        }
    }//borrar datos
    
    public void actualizarServicio(){
        try{
            sql="UPDATE Servicios SET tip_servicio=?, descripcion_servicio=?, costo_servicio=? WHERE id_servicio=?;";
            pst = model_conexion.getConexion().prepareStatement(sql);
            
            pst.setString(1,id_servicio);
            pst.setString(2,tipo_servicio);
            pst.setString(3,descripcion_servicio);
            pst.setFloat(4,costo_servicio);
            
            
            pst.executeUpdate();

            System.out.println("datos actualizado servicio ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 110 Actualizar datos "+ ex.getMessage());
        }
    }//actualizar datos
    
    
}
