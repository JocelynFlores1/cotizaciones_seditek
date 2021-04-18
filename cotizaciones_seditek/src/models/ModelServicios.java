package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;;

public class ModelServicios {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    
    private String id_servicio;
    private String tipo_servicio;
    private String descripcion_servicio;
    private Float costo_servicio;
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
    

    public void modificarDatos() {
        try {
            System.out.println("modificar datos variables 1 servicios");
            setId_servicio(rs.getString(1));
            setTipo_servicio(rs.getString(2));
            setDescripcion_servicio(rs.getString(3));
            setCosto_servicio(rs.getFloat(4));
                 
            
        } catch (SQLException e) {
            System.out.println("Error 01: modificar datos" + e);
        }
    }
    
    
    /**
     * Método que realiza las siguietnes acciones: 
     * 1.- Conecta con la base 
     * 2.- Consulta todo los registros .
     **/
    public void conectarDB(ModelConexion servicioConexion) {
        try {
            System.out.println("consulta 2 servicios");
            String consultaString = "select * from Servicios";
            ps = (PreparedStatement) servicioConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();

            if (rs.next()) {
                modificarDatos();
            } else {
                System.out.println("Error de consulta");
            }
        } catch (SQLException e) {
            System.out.println("Error 02: tabla servicios" + e);
        }
    }
    
    
    /**
     * *
     * Metodo que realiza la insercción de un nuevo usuario en la base de datos,
     * obteniendo las variables que se guardaron en el controller
     *
     */
    public void insertarNuevoServicio(ModelConexion servicioConexion) {
        System.out.println("nuevo  3 servicio");
        String sqlInsertarServicio = "INSERT into Servicios(tipo_servicio,descripcion_servicio,costo_servicio) "
                    + "values(?,?,?);";
        try {
            ps = (PreparedStatement) servicioConexion.getConexion().prepareStatement(sqlInsertarServicio); //con este comando se podra hacer la modificacion a la tabla en la base de datos
            System.out.println(getId_servicio());
                      
            //ps.setString(1,getId_servicio());
            ps.setString(1,getTipo_servicio());
            ps.setString(2,getDescripcion_servicio());
            ps.setFloat(3,getCosto_servicio());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 03: Insertar nuevo servicio" + ex);
        }
    }
    
    
    public void modificarDatosServicio(ModelConexion servicioConexion) {
        System.out.println("modificar 4 servicio");
        String sqlModificarServicio = "UPDATE Servicios SET tipo_servicio=?, descripcion_servicio=?, costo_servicio=? WHERE id_servicio=?;";
        try {

            ps = (PreparedStatement) servicioConexion.getConexion().prepareStatement(sqlModificarServicio);

            System.out.println(getId_servicio());

            
            ps.setString(1,getTipo_servicio());
            ps.setString(2,getDescripcion_servicio());
            ps.setFloat(3,getCosto_servicio());
            ps.setString(4,getId_servicio());
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error 04: Modificar datos servicio" + ex);
        }
    }
    
       
    
    public void borrarDatosServicio(ModelConexion servicioConexion) {
        System.out.println("eliminar 5 servicio");
        String sqlBorrarServicio = "DELETE FROM Servicios WHERE id_servicio= ?;";
        try {

            ps = (PreparedStatement) servicioConexion.getConexion().prepareStatement(sqlBorrarServicio);
            //Este proceso permite establecer la conexion del objeto creado y enlazar la consulta con la base de datos para poder borrar el servicio.
            ps.setString(1, getId_servicio());
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
    public void consultajTableServicio(ModelConexion servicioConexion) {
        try {
            System.out.println("tabla 6 servicio");
            String consultaString = "select * from Servicios";
            ps = (PreparedStatement) servicioConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error 000000: tabla servicios" + e);
        }
    }
    
    
    public void consultaGenerarCodigos(ModelConexion servicioConexion) {
        System.out.println("codigos 7 servicios");
        String SQL = "select max(id_servicio) from Servicios";

        try {
            ps = (PreparedStatement) servicioConexion.getConexion().prepareStatement(SQL);
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
