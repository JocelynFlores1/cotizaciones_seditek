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
        
        /**models.ModelUsuarios modelUsuarios = new models.ModelUsuarios();
        views.ViewUsuarios viewUsuarios = new views.ViewUsuarios();
        controllers.ControllerUsuarios controllerUsuarios = new controllers.ControllerUsuarios(modelUsuarios, viewUsuarios);**/
        
        
    }
    
}
