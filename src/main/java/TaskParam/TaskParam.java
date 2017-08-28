package TaskParam;

import java.awt.Component;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexa
 */
public abstract class TaskParam {
    protected Boolean obligatorio = false;
    protected String mensage_error = "ERROR_CAMPO_OBLIGATORIO";
    
    public abstract List<Component> mostrar();
    public abstract String ejecutar();

    public Boolean isObligatorio() {
        return obligatorio;
    }
    
    public String MensageError() {
        return mensage_error;
    }
}
