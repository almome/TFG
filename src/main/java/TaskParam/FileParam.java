/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskParam;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alexa
 */
public class FileParam extends TaskParam {
    private JLabel jLabel;
    private JTextField jTextField;
    private JButton jButton;
    
    public FileParam(String label, int locY, Boolean obl){
        //Estableciendo label
        jLabel = new JLabel();
        jLabel.setLocation(60, locY);
        jLabel.setSize(100, 25);
        jLabel.setText(label);
        //Estableciendo textfield
        jTextField =new JTextField();
        jTextField.setSize(300, 25);
        jTextField.setLocation(200, locY);
        //EstablecerBoton
        jButton = new JButton();
        jButton.setText("Examinar");
        jButton.setSize(90, 25);
        jButton.setLocation(520, locY);

        jButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser1 = new JFileChooser();
                jFileChooser1.setFileSelectionMode(jFileChooser1.FILES_AND_DIRECTORIES);
                //jFileChooser1.setFileFilter(new FileNameExtensionFilter("XML files (*.xml)", "xml"));
                int boton = jFileChooser1.showOpenDialog(jButton);
                if (boton == jFileChooser1.APPROVE_OPTION){ //Si el usuario ha pulsado la opción Aceptar
                    File fichero = jFileChooser1.getSelectedFile(); //Guardamos en la variable fichero el archivo seleccionado
                    try {
                      jTextField.setText(fichero.getAbsolutePath());
                    } catch (Exception ex) {
                      System.out.println("Hubo un problema al intentar acceder al fichero "+fichero.getAbsolutePath());
                    }
                }
            }
        } );
        
        obligatorio = obl;

        
    }

    @Override
    public List<Component> mostrar() {
        List<Component> componentes = new ArrayList<Component>();
        componentes.add(jLabel);
        componentes.add(jTextField);
        componentes.add(jButton);
        return componentes;
    }
    
    @Override
    public String ejecutar() {
        if(obligatorio == true && jTextField.getText().equals("")){
            return mensage_error;
        }
        else if(obligatorio == false && jTextField.getText().equals("")){
            return ""; 
        }
        else{
            return " "+jLabel.getText()+" "+jTextField.getText()+" ";
        }
        
    }
}
