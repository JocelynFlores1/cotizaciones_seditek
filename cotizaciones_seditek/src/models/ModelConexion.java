/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author flore
 */
public class ModelConexion {
    
    public Connection con;
    public Statement st ;
    public ResultSet rs;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://	jhdjjtqo9w5bzq2t.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/v495puqjjm0nnzem", "pfeu8xqeoutm8fbw", "fvdfsz5knf9973u5");
            System.out.println("Conexion Exitosa");

        } catch (SQLException ex) {
            System.err.println(ex);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;

    }
    
}
