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
import models.ModelRecuperPassword;
import views.ViewRecuperPassword;
        

/**
 *
 * @author flore
 */
public class ModelCambioClave {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String id_usuario;
    private String nombre_usuario;
    private String tipo_usuario;
    private String pregunta;
    private String respuesta;
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
    public String getPregunta() {
        return tipo_usuario;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    
     public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void modificarDatosClave() {
        try {
            System.out.println("modificar dato variables 1 usuarios password");
            setNombre_usuario(rs.getString(2));
            setPassword(rs.getString(6));
            
        } catch (SQLException e) {
            System.out.println("Error 01: modificar datos" + e);
        }
    }

    public void conectarDB(ModelConexion CambioClaveConexion) {
        try {
            System.out.println("consulta 2 usuarios");
            String consultaString = "select * from Usuarios";
            ps = (PreparedStatement) CambioClaveConexion.getConexion().prepareStatement(consultaString);
            rs = ps.executeQuery();

            if (rs.next()) {
                modificarDatosClave();
            } else {
                System.out.println("Error de consulta");
            }
        } catch (SQLException e) {
            System.out.println("Error 02: tabla usuarios" + e);
        }
    }
    
    
    public void modificarDatosClave(ModelConexion usuarioConexion) {
    System.out.println("modificar 4 usuarios");
        String sqlModificarUsuario = "UPDATE usuarios SET password=? WHERE nombre_usuario=?";
        try {

            ps = (PreparedStatement) usuarioConexion.getConexion().prepareStatement(sqlModificarUsuario);

            System.out.println(getPassword());

            ps.setString(1, getPassword());
            ps.setString(2, getNombre_usuario());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error 04: Modificar datos usuario" + ex);
        }
    
}}
