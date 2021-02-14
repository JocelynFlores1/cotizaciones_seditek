package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ModelProductos {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    
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
    private String u = "";
    
    
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
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
    

    public void modificarDatos() {
        try {
            System.out.println("modificar datos variables 1 productos");
            setId_producto(rs.getString(1));
            setCodigo_producto(rs.getString(2));
            setNombre_producto(rs.getString(3));
            setMarca(rs.getString(4));
            setModelo(rs.getString(5));
            setDescripcion_usuario(rs.getString(6));
            setDescripcion_cliente(rs.getString(7));
            setAccesorios(rs.getString(8));
            setPrecio_unitario(rs.getFloat(9));
            setStock(rs.getInt(10));
            setId_proveedor(rs.getString(11));
            
            
        } catch (SQLException e) {
            System.out.println("Error 01: modificar datos" + e);
        }
    }
    
    
    /**
     * Método que realiza las siguietnes acciones: 
     * 1.- Conecta con la base 
     * 2.- Consulta todo los registros .
     **/
    public void conectarDB(ModelConexion productoConexion) {
        try {
            System.out.println("consulta 2 productos");
            String consultaString = "select * from Productos";
            ps = (PreparedStatement) productoConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();

            if (rs.next()) {
                modificarDatos();
            } else {
                System.out.println("Error de consulta");
            }
        } catch (SQLException e) {
            System.out.println("Error 02: tabla productos" + e);
        }
    }
    
    
    /**
     * *
     * Metodo que realiza la insercción de un nuevo usuario en la base de datos,
     * obteniendo las variables que se guardaron en el controller
     *
     */
    public void insertarNuevoProducto(ModelConexion productoConexion) {
        System.out.println("nuevo  3 productos");
        String sqlInsertarProducto = "INSERT into Productos(id_producto,codigo_producto,nombre_producto,marca,modelo,"
                    + "descripcion_usuario,descripcion_cliente,accesorios,precio_unitario,stock,id_proveedor) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?);";
        try {
            ps = (PreparedStatement) productoConexion.getConexion().prepareStatement(sqlInsertarProducto); //con este comando se podra hacer la modificacion a la tabla en la base de datos
            System.out.println(getId_producto());
            ps.setString(1, getId_producto());
            ps.setString(2, getCodigo_producto());
            ps.setString(3, getNombre_producto());
            ps.setString(4, getMarca());
            ps.setString(5, getModelo());
            ps.setString(6, getDescripcion_usuario());
            ps.setString(7, getDescripcion_cliente());
            ps.setString(8, getAccesorios());
            ps.setFloat(9, getPrecio_unitario());
            ps.setInt(10, getStock());
            ps.setString(11, getId_proveedor());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 03: Insertar nuevo producto" + ex);
        }
    }
    
    
        public void modificarDatosProducto(ModelConexion productoConexion) {
        System.out.println("modificar 4 producto");
        String sqlModificarProducto = "UPDATE Productos SET codigo_producto=?,nombre_producto=?, marca=?, modelo=?, descripcion_usuario=?, "
                    + "descripcion_cliente, accesorios=?, precio_unitario=?, stock=?, id_proveedor=? WHERE id_producto=?;";
        try {

            ps = (PreparedStatement) productoConexion.getConexion().prepareStatement(sqlModificarProducto);

            System.out.println(getId_producto());

            //ps.setString(1, getId_producto());
            ps.setString(2, getCodigo_producto());
            ps.setString(3, getNombre_producto());
            ps.setString(4, getMarca());
            ps.setString(5, getModelo());
            ps.setString(6, getDescripcion_usuario());
            ps.setString(7, getDescripcion_cliente());
            ps.setString(8, getAccesorios());
            ps.setFloat(9, getPrecio_unitario());
            ps.setInt(10, getStock());
            ps.setString(11, getId_proveedor());
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error 04: Modificar datos producto" + ex);
        }
    }
        
        
    public void borrarDatosProducto(ModelConexion productoConexion) {
        System.out.println("eliminar 5 producto");
        String sqlBorrarProducto = "DELETE FROM Productos WHERE id_producto= ?;";
        try {

            ps = (PreparedStatement) productoConexion.getConexion().prepareStatement(sqlBorrarProducto);
            //Este proceso permite establecer la conexion del objeto creado y enlazar la consulta con la base de datos para poder borrar el producto.
            ps.setString(1, getId_producto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 05: Borrar datos producto" + ex);
        }
    }
    
   
    /**
     * *
     * Metodo que permite insertar los datos de la tabla de la base de datos en
     * un jTable en java
     */
    public void consultajTableProducto(ModelConexion productoConexion) {
        try {
            System.out.println("tabla 6 productos");
            String consultaString = "select * from Productos";
            ps = (PreparedStatement) productoConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error 000000: tabla proveedor" + e);
        }
    }

    public void consultaGenerarCodigos(ModelConexion productoConexion) {
        System.out.println("codigos 7 productos");
        String SQL = "select max(id_producto) from Productos";

        try {
            ps = (PreparedStatement) productoConexion.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();

            if (rs.next()) {
                u = rs.getString(1);
                System.out.println("madx" + rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }

    }

    public String getU() {
        return u;
    }

    public void setU(String c) {
        this.u= u;
    }
    
    
}
