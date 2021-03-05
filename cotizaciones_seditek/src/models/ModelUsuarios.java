/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author flore
 */
public class ModelUsuarios {
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    
    private String id_usuario;
    private String nombre_usuario;
    private String tipo_usuario;
    private String password;
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

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void modificarDatos() {
        try {
            System.out.println("modificar datos variables 1 usuarios");
            setId_usuario(rs.getString(1));
            setNombre_usuario(rs.getString(2));
            setTipo_usuario(rs.getString(3));
            setPassword(rs.getString(4));
            
        } catch (SQLException e) {
            System.out.println("Error 01: modificar datos" + e);
        }
    }

    /**
     * Método que realiza las siguietnes acciones: 1.- Conecta con la base 2.-
     * Consulta todo los registros .
     */
    public void conectarDB(ModelConexion usuarioConexion) {
        try {
            System.out.println("consulta 2 usuarios");
            String consultaString = "select * from Usuarios";
            ps = (PreparedStatement) usuarioConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();

            if (rs.next()) {
                modificarDatos();
            } else {
                System.out.println("Error de consulta");
            }
        } catch (SQLException e) {
            System.out.println("Error 02: tabla usuarios" + e);
        }
    }

    /**
     * *
     * Metodo que realiza la insercción de un nuevo usuario en la base de datos,
     * obteniendo las variables que se guardaron en el controller
     *
     */
    public void insertarNuevoUsuario(ModelConexion usuarioConexion) {
        System.out.println("nuevo  3 usuarios");
        String sqlInsertarUsuario = "INSERT into usuarios(id_usuario,nombre_usuario,tipo_usuario,password) VALUES(?,?,?,?)";
        try {
            ps = (PreparedStatement) usuarioConexion.getConexion().prepareStatement(sqlInsertarUsuario); //con este comando se podra hacer la modificacion a la tabla en la base de datos
            System.out.println(getId_usuario());
            ps.setString(1, getId_usuario());
            ps.setString(2, getNombre_usuario());
            ps.setString(3, getTipo_usuario());
            ps.setString(4, getPassword());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 03: Insertar nuevo usuario" + ex);
        }
    }

    /**
     * *
     * Metodo que modifica los datos del usuario usando como referencia el
     * id_usuario para guardar los cambios
     */
    public void modificarDatosUsuario(ModelConexion usuarioConexion) {
        System.out.println("modificar 4 usuarios");
        String sqlModificarUsuario = "UPDATE usuarios SET "
                + "nombre_usuario=?, tipo_usuario=?, Password=? WHERE id_usuario = ?";
        try {

            ps = (PreparedStatement) usuarioConexion.getConexion().prepareStatement(sqlModificarUsuario);

            System.out.println(getId_usuario());

            ps.setString(1, getNombre_usuario());
            ps.setString(2, getTipo_usuario());
            ps.setString(3, getPassword());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error 04: Modificar datos usuario" + ex);
        }
    }

    public void borrarDatosUsuario(ModelConexion usuarioConexion) {
        System.out.println("eliminar 5 usuarios");
        String sqlBorrarUsuario = "DELETE from usuarios WHERE id_usuario = ?";
        try {

            ps = (PreparedStatement) usuarioConexion.getConexion().prepareStatement(sqlBorrarUsuario);
            //Este proceso permite establecer la conexion del objeto creado y enlazar la consulta con la base de datos para poder borrar el usuario.
            ps.setString(1, getId_usuario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error 05: Borrar datos usuario" + ex);
        }
    }

    /**
     * *
     * Metodo que permite insertar los datos de la tabla de la base de datos en
     * un jTable en java
     */
    public void consultajTableUsuarios(ModelConexion usuarioConexion) {
        try {
            System.out.println("tabla 6 usuarios");
            String consultaString = "select * from usuarios";
            ps = (PreparedStatement) usuarioConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error 000000: tabla usuarios" + e);
        }
    }

    public void consultaGenerarCodigos(ModelConexion usuarioConexion) {
        System.out.println("codigos 7 usuarios");
        String SQL = "select max(id_usuario) from usuarios";

        try {
            ps = (PreparedStatement) usuarioConexion.getConexion().prepareStatement(SQL);
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
