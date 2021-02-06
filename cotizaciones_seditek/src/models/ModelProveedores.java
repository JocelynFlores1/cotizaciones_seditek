package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ModelProveedores {
    
    private final ModelDataBase model_database;
    private PreparedStatement pst;
    private ResultSet resut;
    private String sql;
    
    private String id_proveedor;
    private String nombre_proveedor;
    private int telefono_proveedor;
    private int telefono_contacto;
    private String email_proveedor;
    private String email_contacto;
    private String calle_proveedor;
    private String colonia_proveedor;
    private String municipio_proveedor;
    private String empresa_proveedor;
    private String rfc_proveedor;
    private int cp_proveedor;
    

    public ModelProveedores(ModelDataBase model_database){
    this.model_database = model_database;
    }
    
    
    public String getId_proveedor() {
        return id_proveedor;
    }


    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }


    public String getNombre_proveedor() {
        return nombre_proveedor;
    }


    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public int getTelefono_proveedor() {
        return telefono_proveedor;
    }


    public void setTelefono_proveedor(int telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }


    public int getTelefono_contacto() {
        return telefono_contacto;
    }


    public void setTelefono_contacto(int telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }

    public String getEmail_proveedor() {
        return email_proveedor;
    }


    public void setEmail_proveedor(String email_proveedor) {
        this.email_proveedor = email_proveedor;
    }


    public String getEmail_contacto() {
        return email_contacto;
    }


    public void setEmail_contacto(String email_contacto) {
        this.email_contacto = email_contacto;
    }


    public String getCalle_proveedor() {
        return calle_proveedor;
    }


    public void setCalle_proveedor(String calle_proveedor) {
        this.calle_proveedor = calle_proveedor;
    }


    public String getColonia_proveedor() {
        return colonia_proveedor;
    }


    public void setColonia_proveedor(String colonia_proveedor) {
        this.colonia_proveedor = colonia_proveedor;
    }

    public String getMunicipio_proveedor() {
        return municipio_proveedor;
    }


    public void setMunicipio_proveedor(String municipio_proveedor) {
        this.municipio_proveedor = municipio_proveedor;
    }


    public String getEmpresa_proveedor() {
        return empresa_proveedor;
    }


    public void setEmpresa_proveedor(String empresa_proveedor) {
        this.empresa_proveedor = empresa_proveedor;
    }


    public String getRfc_proveedor() {
        return rfc_proveedor;
    }


    public void setRfc_proveedor(String rfc_proveedor) {
        this.rfc_proveedor = rfc_proveedor;
    }


    public int getCp_proveedor() {
        return cp_proveedor;
    }


    public void setCp_proveedor(int cp_proveedor) {
        this.cp_proveedor = cp_proveedor;
    }
    
    
    
    public void insertarProveedores(){
        try{
            
            sql="INSERT into Proveedores(id_proveedor,nombre_proveedor,telefono_proveedor,telefono_contacto,"
                    + "email_proveedor,email_contacto,calle_proveedor,colonia_proveedor,municipio_proveedor,"
                    + "empresa_proveedorr,rfc_proveedor,cp_proveedor) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?);";
            
            pst = model_database.getConexion().prepareStatement(sql);
            
            pst.setString(1,id_proveedor);
            pst.setString(2,nombre_proveedor);
            pst.setInt(3,telefono_proveedor);
            pst.setInt(4,telefono_contacto);
            pst.setString(5,email_proveedor);
            pst.setString(6,email_contacto);
            pst.setString(7,calle_proveedor);
            pst.setString(8,colonia_proveedor);
            pst.setString(9,municipio_proveedor);
            pst.setString(10,empresa_proveedor);
            pst.setString(11,rfc_proveedor);
            pst.setInt(12,cp_proveedor);
            
            pst.executeUpdate();
            
            System.out.println("insertando datos de proveedor ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 108 insertar datos "+ex.getMessage());
        }
     }// insertando datos
    
    public void eliminarProveedores(){
        try{
            sql="DELETE FROM Productos WHERE id_proveedor= ?;";
            
            pst = model_database.getConexion().prepareStatement(sql);
            
            pst.setString(1,id_proveedor);
            pst.executeUpdate();
 
            System.out.println("dato borrado proveedor ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 109 Borrar datos "+ ex.getMessage());
        }
    }//borrar datos
    
    public void actualizarProveedores(){
        try{
            sql="UPDATE clientes SET nombre=?,telefono=?, email=?, direccion=? WHERE id_cliente=?;";
            pst = model_database.getConexion().prepareStatement(sql);
            
            pst.setString(1,id_proveedor);
            pst.setString(2,nombre_proveedor);
            pst.setInt(3,telefono_proveedor);
            pst.setInt(4,telefono_contacto);
            pst.setString(5,email_proveedor);
            pst.setString(6,email_contacto);
            pst.setString(7,calle_proveedor);
            pst.setString(8,colonia_proveedor);
            pst.setString(9,municipio_proveedor);
            pst.setString(10,empresa_proveedor);
            pst.setString(11,rfc_proveedor);
            pst.setInt(12,cp_proveedor);
            
            pst.executeUpdate();

            System.out.println("datos actualizados de proveedor ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 110 Actualizar datos "+ ex.getMessage());
        }
    }//actualizar datos

    
    
    
    
    
    
    
    
    
    
    
    
    
}
