/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg;

import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author sandra
 */
public class ExperimentNode implements INodeType {

    /**
     * Crear Clasificador
     */
    @Override
    public void crearHijo(){
        CreateClasificadorGUI creador = new CreateClasificadorGUI(this); //NECESITO METER EL NODO PADRE
        creador.setVisible(true);
    }
    
    /**
     * Ejecutar todas las tareas del experimento
     */
    @Override
    public void ejecutar(){

    }
    
    /**
     * Elimina Experimento
     */
    @Override
    public void eliminar() {

    }
    
    /**
     * Menu PopUp de Experimento
     */
    @Override
    public void popupMenu() {
        JPopupMenu menu = new JPopupMenu();
                
        JMenuItem jMenuItemCreaClasificador;
        JMenuItem jMenuItemEjecutar;
        JMenuItem jMenuItemEliminar;

        jMenuItemCreaClasificador = new JMenuItem("Crear Clasificador");
        jMenuItemCreaClasificador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                crearHijo();
            }
        });
        
        jMenuItemEjecutar = new JMenuItem("Ejecutar Experimento");
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
                eliminar();
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
