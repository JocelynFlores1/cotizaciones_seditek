/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author flore
 */
public class ModelMain {
    private String nombre_usuario;
    private String tipo_usuario;
    private String password;


    public String getUsuario() {
        return nombre_usuario;
    }

    public void setUsuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    
    
    public String getTipoUsuario() {
        return tipo_usuario;
    }

    public void setTipoUsuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
