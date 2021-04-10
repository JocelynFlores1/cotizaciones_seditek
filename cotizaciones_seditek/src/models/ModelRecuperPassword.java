/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author flore
 */
public class ModelRecuperPassword {
    
    private String id_usuario;
    private String nombre_usuario;
    private String tipo_usuario;
    private String pregunta;
    private String respuesta;
    private String password;

    
    private java.sql.Connection conexion;
    private Statement st;
    private ResultSet rs;
    private java.sql.PreparedStatement ps;
    
    public String getId(){
        return id_usuario;
    }
    public void setId(String id_usuario){
       this.id_usuario = id_usuario;
    }
    
    public String getUsuario(){
        return nombre_usuario;
    }
    public void setUsuario(String nombre_usuario){
        this.nombre_usuario = nombre_usuario;
    }
     public String getTipoUsuario() {
        return tipo_usuario;
    }

    public void setTipoUsuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getPregunta(){
        return pregunta;
    }
    public void setPregunta(String pregunta){
        this.pregunta = pregunta;
    }
    public String getPassword(){
        return respuesta;
    }
    public void setPassword(String respuesta){
        this.respuesta = respuesta;
    }
     public String getRespuesta() {
        return password;
    }

    public void setRespuesta(String password) {
        this.password = password;
    }
    
    public java.sql.Connection getConexion() {
        return conexion;
    }

    public void setConexion(java.sql.Connection conexion) {
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

    public java.sql.PreparedStatement getPs() {
        return ps;
    }

    public void setPs(java.sql.PreparedStatement ps) {
        this.ps = ps;
    }
    
    public boolean confirmar(){
        ModelConexion ConfirmarConexion = new ModelConexion();
        ConfirmarConexion.getConexion();

         String sql = "SELECT id_usuario,nombre_usuario,tipo_usuario,pregunta,respuesta, password FROM usuarios WHERE nombre_usuario  = ?";
        try {

            ps = (PreparedStatement) ConfirmarConexion.getConexion().prepareStatement(sql);

            ps.setString(1, getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (getPassword().equals(rs.getString(5))) {
                    setId(rs.getString(1));
                    setUsuario(rs.getString(2));
                    setTipoUsuario(rs.getString(3));
                    setPregunta(rs.getString(4));
                    setRespuesta(rs.getString(6));
                    return true;
                } else {
                    return false;
                }
            }
            return false;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 01: Pregunta de seguridad" + ex);
            return false;
        }
    }
}
