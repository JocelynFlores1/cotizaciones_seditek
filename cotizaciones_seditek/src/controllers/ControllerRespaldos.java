/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.DriverManager;
import javax.swing.JOptionPane;
import models.ModelRespaldos;

/**
 *
 * @author flore
 */
public class ControllerRespaldos {
    
    ModelRespaldos modelRespaldos;

    public ControllerRespaldos(ModelRespaldos modelRespaldos) {
        this.modelRespaldos = modelRespaldos;
    }

    public void respaldo() {
        String BD = "zs24at5q2gx9egvg";
        String user = "um09y46w14qyg6w2";
        String password = "mqio1vovph8f7gir";
        String host = "jdbc:mysql://z5zm8hebixwywy9d.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/zs24at5q2gx9egvg";
        String puert = "3306";
        modelRespaldos.respaldosDB(host, puert, user, password, BD);
        JOptionPane.showMessageDialog(null, "La base de datos: CotizacionesSeditek\n ha sido respaldada");
    }
    
}
