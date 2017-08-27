/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskParam;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author alexa
 */
public class StringParam extends TaskParam {
    private JLabel jLabel;
    private JTextField jTextField;
    
    public StringParam(String label, int locY, Boolean obl){
        //Estableciendo label
        jLabel = new JLabel();
        jLabel.setLocation(60, locY);
        jLabel.setSize(100, 25);
        jLabel.setText(label);
        //Estableciendo textfield
        jTextField =new JTextField();
        jTextField.setSize(300, 25);
        jTextField.setLocation(200, locY);
        obligatorio = obl;
        
        
    }

    @Override
    public List<Component> mostrar() {
        List<Component> componentes = new ArrayList<Component>();
        componentes.add(jLabel);
        componentes.add(jTextField);
        return componentes;
    }

    @Override
    public String ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
