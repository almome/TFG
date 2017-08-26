package Main;


import java.util.HashMap;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexa
 */
public class CustomDocumentListener implements DocumentListener {
    private final TaskNode taskNode;
    private final String key;
    private final JTextField jTextField;

    public CustomDocumentListener(TaskNode dataStruct, String key, JTextField jTextField) {
        this.taskNode = dataStruct;
        this.key = key;
        this.jTextField = jTextField;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        //taskNode.getDatosCom().put(key, jTextField.getText());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        //taskNode.getDatosCom().put(key, jTextField.getText());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        //taskNode.getDatosCom().put(key, jTextField.getText());
    }
}
