/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg;

import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author alexa
 */
public class ClassifierNode implements INodeType{

    @Override
    public void crearHijo(CustomMutableTreeNode padre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(CustomMutableTreeNode padre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popupMenu(CustomMutableTreeNode padre) {
        JPopupMenu menu = new JPopupMenu();
                
        JMenuItem jMenuItemCreaClasificador;
        JMenuItem jMenuItemEjecutar;
        JMenuItem jMenuItemEliminar;

        jMenuItemCreaClasificador = new JMenuItem("Crear Clasificador");
        jMenuItemCreaClasificador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                crearHijo(padre);
            }
        });
        
        jMenuItemCreaClasificador = new JMenuItem("Crear Tarea");
        jMenuItemCreaClasificador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                crearHijo(padre);
            }
        });
        
        jMenuItemEjecutar = new JMenuItem("Ejecutar Clasificador");
        jMenuItemEjecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ejecutar();
            }
        });
        
        jMenuItemEliminar = new JMenuItem("Eliminar");
        jMenuItemEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                eliminar(padre);
            }
        });
        
        menu.add (jMenuItemCreaClasificador);
        menu.add (jMenuItemEjecutar);
        menu.add (jMenuItemEliminar);
        
        int mouseX = MouseInfo.getPointerInfo().getLocation().x;
        int mouseY = MouseInfo.getPointerInfo().getLocation().y;
        menu.show (WindowsInstances.mainGUI, mouseX, mouseY);
    }
    
}
