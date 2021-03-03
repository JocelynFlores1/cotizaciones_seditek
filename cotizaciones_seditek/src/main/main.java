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
        
        
       /** 
        * Vista del Login
        models.ModelLogin modelLogin = new models.ModelLogin();
        views.ViewLogin viewLogin = new views.ViewLogin();
        controllers.ControllerLogin controllerLogin = new controllers.ControllerLogin(modelLogin, viewLogin);
        **/
       
        /**
         * Vista de Productos
        models.ModelProductos model_productos = new models.ModelProductos();
        views.ViewProductos view_productos = new views.ViewProductos();
        controllers.ControllerProductos controller_productos = new controllers.ControllerProductos(model_productos, view_productos);
        * */
        
        
        
         //* Vista del Proveedor
        models.ModelProveedores model_proveedores = new models.ModelProveedores();
        views.ViewProveedores view_proveedores = new views.ViewProveedores();
        controllers.ControllerProveedores controller_proveedores = new controllers.ControllerProveedores(model_proveedores, view_proveedores);
        
        
        
        /**
         * Vista de Servicios
         
        models.ModelServicios model_servicios = new models.ModelServicios();
        views.ViewServicios view_servicios = new views.ViewServicios();
        controllers.ControllerServicios controller_servicios = new controllers.ControllerServicios(model_servicios, view_servicios);
        * */
    }
    
}
