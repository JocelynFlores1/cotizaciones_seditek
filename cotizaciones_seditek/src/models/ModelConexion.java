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
            con = DriverManager.getConnection("jdbc:mysql://um09y46w14qyg6w2:mqio1vovph8f7gir@z5zm8hebixwywy9d.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/zs24at5q2gx9egvg", "pfeu8xqeoutm8fbw", "a6ojgbiubxjcnj39");
            System.out.println("Conexion Exitosa");

        } catch (SQLException ex) {
            System.err.println(ex);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;

    }
    
}
