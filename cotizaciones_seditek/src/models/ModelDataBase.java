package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelDataBase {
    
    private Connection conexion;
    private Statement st;

    
    public Connection getConexion(){
        return conexion;
    }
    
    
    public void ConectarDB(){ //conectar con la base de datos
        try{
            conexion=DriverManager.getConnection("jdbc:mysql://ubicacion/base de datos","usuario","password");                     
            st=conexion.createStatement(); 
            System.out.println("Conexion correcta a la BASE DE DATOS ");
        }
        
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 101 conexion a BD  "+ex.getMessage());
        }
    }// termina conectar

}
