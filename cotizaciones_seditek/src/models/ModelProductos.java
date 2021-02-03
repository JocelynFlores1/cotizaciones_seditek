package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ModelProductos {

    private final ModelDataBase model_database;
    private PreparedStatement pst;
    private ResultSet resut;
    private String sql;
    
    private String id_producto;
    private String codigo_producto;
    private String nombre_producto;
    private String marca;
    private String modelo;
    private String descripcion_usuario;
    private String descripcion_cliente;
    private String accesorios;
    private Float precio_unitario;
    private int stock;
    private String id_proveedor;
    
    
    public ModelProductos(ModelDataBase model_database){
        this.model_database = model_database;
    }
    
    public String getId_producto() {
        return id_producto;
    }


    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }


    public String getCodigo_producto() {
        return codigo_producto;
    }

 
    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

  
    public String getNombre_producto() {
        return nombre_producto;
    }


    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    
    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getDescripcion_usuario() {
        return descripcion_usuario;
    }


    public void setDescripcion_usuario(String descripcion_usuario) {
        this.descripcion_usuario = descripcion_usuario;
    }


    public String getDescripcion_cliente() {
        return descripcion_cliente;
    }

    public void setDescripcion_cliente(String descripcion_cliente) {
        this.descripcion_cliente = descripcion_cliente;
    }


    public String getAccesorios() {
        return accesorios;
    }


    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }


    public Float getPrecio_unitario() {
        return precio_unitario;
    }


    public void setPrecio_unitario(Float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }


    public int getStock() {
        return stock;
    }


    public void setStock(int stock) {
        this.stock = stock;
    }


    public String getId_proveedor() {
        return id_proveedor;
    }


    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    

    
     public void insertarProductos(/*String nombre,String telefono,String email,String direccion*/){
        try{
            
            sql="INSERT into Productos(codigo_producto,nombre_producto,marca,modelo,"
                    + "descripcion_usuario,descripcion_cliente,accesorios,precio_unitario,stock,id_proveedor) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?);";
            
            pst = model_database.getConexion().prepareStatement(sql);
            
            pst.setString(1,id_producto);
            pst.setString(2,codigo_producto);
            pst.setString(3,nombre_producto);
            pst.setString(4,marca);
            pst.setString(5,modelo);
            pst.setString(6,descripcion_usuario);
            pst.setString(7,descripcion_cliente);
            pst.setString(8,accesorios);
            pst.setFloat(9,precio_unitario);
            pst.setInt(10,stock);
            pst.setString(11,id_proveedor);
                        
            pst.executeUpdate();
            
            System.out.println("insertando datos cliente ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 108 insertar datos "+ex.getMessage());
        }
     }// insertando datos
    
    public void eliminar(/*int id_cliente*/){
        try{
            sql="DELETE FROM Productos WHERE id_producto= ?;";
            
            pst = model_database.getConexion().prepareStatement(sql);
            
            pst.setString(1,id_producto);
            pst.executeUpdate();
 
            System.out.println("dato borrado clientes ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 109 Borrar datos "+ ex.getMessage());
        }
    }//borrar datos
    
    public void actualizar(/*String nombre,String telefono,String email,String direccion,int id_cliente*/){
        try{
            sql="UPDATE clientes SET nombre=?,telefono=?, email=?, direccion=? WHERE id_cliente=?;";
            pst = model_database.getConexion().prepareStatement(sql);
            
            pst.setString(1,id_producto);
            pst.setString(2,codigo_producto);
            pst.setString(3,nombre_producto);
            pst.setString(4,marca);
            pst.setString(5,modelo);
            pst.setString(6,descripcion_usuario);
            pst.setString(7,descripcion_cliente);
            pst.setString(8,accesorios);
            pst.setFloat(9,precio_unitario);
            pst.setInt(10,stock);
            pst.setString(11,id_proveedor);
            
            pst.executeUpdate();

            System.out.println("datos actualizados clientes ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 110 Actualizar datos "+ ex.getMessage());
        }
    }//actualizar datos
    
}
