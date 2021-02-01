/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author flore
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        models.ModelLogin modelLogin = new models.ModelLogin();
        views.ViewLogin viewLogin = new views.ViewLogin();
        controllers.ControllerLogin controllerLogin = new controllers.ControllerLogin(modelLogin, viewLogin);
    }
    
}
