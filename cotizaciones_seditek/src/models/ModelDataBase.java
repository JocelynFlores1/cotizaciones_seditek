package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelDataBase {
    
    private Connection conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;
    private String sql;
    
    
    
    
    public void Conectar(){ //conectar con la base de datos
        try{
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/peliculas_mvc","root","151617");                     
            st=conexion.createStatement(); 
            System.out.println("Conexion correcta a la BASE DE DATOS ");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 101 conexion a BD  "+ex.getMessage());
        }
    }// termina conectar

}
