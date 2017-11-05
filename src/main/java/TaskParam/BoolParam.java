/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskParam;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

/**
 *
 * @author javosuher
 */
public class BoolParam extends TaskParam {
    private JLabel jLabel;
    private JCheckBox jCheckBox;
    
    public BoolParam(String label, int locY){
        this(label, "Incluir", locY);
    }
    
    public BoolParam(String label, String checkboxLabel, int locY) {
        //Estableciendo label
        jLabel = new JLabel();
        jLabel.setLocation(60, locY);
        jLabel.setSize(100, 25);
        jLabel.setText(label);
        
        //Estableciendo checkbox
        jCheckBox = new JCheckBox(checkboxLabel);
        jCheckBox.setSize(20, 20);
        jCheckBox.setLocation(200, locY);
        
        obligatorio = false;
    }

    @Override
    public List<Component> mostrar() {
        List<Component> componentes = new ArrayList<Component>();
        componentes.add(jLabel);
        componentes.add(jCheckBox);
        return componentes;
    }

    @Override
    public String ejecutar() {
        return " " + jLabel.getText() + " ";
    }  
}
