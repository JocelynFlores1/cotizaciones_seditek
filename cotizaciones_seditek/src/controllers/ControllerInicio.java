package controllers;

import models.ModelInicio;
import views.ViewInicio;

/**
 *
 * @author flore
 */
public class ControllerInicio {
    models.ModelInicio modelInicio;
    views.ViewInicio viewInicio;

    public ControllerInicio(ModelInicio modelInicio, ViewInicio viewInicio) {
        this.modelInicio = modelInicio;
        this.viewInicio = viewInicio;
    }
}
