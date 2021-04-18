/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author flore
 */
public class ModelRespaldos {
     public void respaldosDB(String host, String puert, String usuar, String password, String BD) {
        try {

            //Generar fecha y hora para nombre del backup
            //Fecha actual en formato completo:
            //Tue Sep 23 01:18:48 CEST 2014
            Date fechaActual = new Date();
            //Formateando la fecha:
            DateFormat formatoHora = new SimpleDateFormat("HH-mm-ss");
            DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            String nombreDocumento = "Backup_CotizacionSeditek_" + formatoHora.format(fechaActual) + "__"+ formatoFecha.format(fechaActual) + ".sql";
            System.out.println(nombreDocumento);

            Process p = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump --host=jdbc:mysql://z5zm8hebixwywy9d.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/zs24at5q2gx9egvg -P3306 -uum09y46w14qyg6w2 -pmqio1vovph8f7gir -B zs24at5q2gx9egvg");
            //C:\\xampp\\mysql\\bin\\mysqldump ->(Ruta donde se encuentra mysqldump dependiendo de la ruta de instalacion) 
            InputStream is = p.getInputStream();//Pedimos la entrada
            try (FileOutputStream fos = new FileOutputStream("src/bd/"+ nombreDocumento) //creamos el archivo para le respaldo
            ) {
                byte[] buffer = new byte[1000]; //Creamos una variable de tipo byte para el buffer
                int leido = is.read(buffer); //Devuelve el número de bytes leídos o -1 si se alcanzó el final del stream.
                while (leido > 0) {
                    fos.write(buffer, 0, leido);//Buffer de caracteres, Desplazamiento de partida para empezar a escribir caracteres, Número de caracteres para escribir
                    leido = is.read(buffer);
                }
                //Cierra respaldo
            } //Creamos una variable de tipo byte para el buffer
        } catch (IOException ex) {
            System.out.println("error respaldo: " + ex);
        }
    }
}
