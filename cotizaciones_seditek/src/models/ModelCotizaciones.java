
package models;

/**
 *
 * @author Carina
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelCotizaciones {
    
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    
    private String id_cotizacion;
    private String numero_cotizacion;
    private String id_usuario;
    private String id_cliente;
    private int telefono;
    private String validez_oferta;
    private String promocion_especial;
    private String condiciones_comerciles;
    private Float fecha_cotizacion;
    
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
     


    public String getId_cotizacion() {
        return id_cotizacion;
    }

    public void setId_cotizacion(String id_cotizacion) {
        this.id_cotizacion = id_cotizacion;
    }

    public String getNumero_cotizacion() {
        return numero_cotizacion;
    }

    public void setNumero_cotizacion(String numero_cotizacion) {
        this.numero_cotizacion = numero_cotizacion;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getValidez_oferta() {
        return validez_oferta;
    }

    public void setValidez_oferta(String validez_oferta) {
        this.validez_oferta = validez_oferta;
    }

    public String getPromocion_especial() {
        return promocion_especial;
    }

    public void setPromocion_especial(String promocion_especial) {
        this.promocion_especial = promocion_especial;
    }

    public String getCondiciones_comerciles() {
        return condiciones_comerciles;
    }

    public void setCondiciones_comerciles(String condiciones_comerciles) {
        this.condiciones_comerciles = condiciones_comerciles;
    }

    public Float getFecha_cotizacion() {
        return fecha_cotizacion;
    }

    public void setFecha_cotizacion(Float fecha_cotizacion) {
        this.fecha_cotizacion = fecha_cotizacion;
    }
    
    // Metodos para mostrar los productos a seleccionar
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
    
    
    /**
     * Método que realiza las siguietnes acciones: 
     * 1.- Conecta con la base 
     * 2.- Consulta todo los registros .
     **/
    public void conectarDB(ModelConexion productoConexion) {
        try {
            System.out.println("Conexion exitosa");
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
            System.out.println("Error 000000: tabla producto" + e);
        }
    }
    
        
        
        

}
