/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskParam;

import java.awt.Component;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author alexa
 */
public class FileParam extends TaskParam {
    private JLabel jLabel;
    private JTextField jTextField;
    private JButton jButton;
    
    public FileParam(String label){
        jButton.setText("Buscar");
        jLabel.setText(label);
        
    }

    @Override
    public List<Component> mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
