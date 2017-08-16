/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg;

import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author sandra
 */
public class ExperimentNode implements INodeType {
    Icon icono = new ImageIcon("src/recursos/ExperimIcon.png");
    String rutaCarpeta;

    public String getRutaCarpeta() {
        return rutaCarpeta;
    }

    public void setRutaCarpeta(String rutaCarpeta) {
        this.rutaCarpeta = rutaCarpeta;
    }
    /**
     * Crear Clasificador
     */
    @Override
    public void crearHijo(CustomMutableTreeNode padre , int i){
        WindowsInstances.createClasificadorGUI.setPadre(padre.toString());
        WindowsInstances.createClasificadorGUI.setVisible(true);
        WindowsInstances.createClasificadorGUI.ocultarCampos();
        WindowsInstances.mainGUI.expandAllNodes(WindowsInstances.mainGUI.getProyectosTree(),  0, WindowsInstances.mainGUI.getProyectosTree().getRowCount());
        
    }
    
    /**
     * Ejecutar todas las tareas del experimento
     */
    @Override
    public void ejecutar(){

    }
    
    /**
     * Elimina Experimento
     * @param padre
     */
    @Override
    public void eliminar(CustomMutableTreeNode padre) {
        int i = 0;
        //Eliminar de la tabla de pares
        if(!WindowsInstances.createClasificadorGUI.paresExCL.isEmpty()){
            while(i < WindowsInstances.createClasificadorGUI.paresExCL.size()){
                if(WindowsInstances.createClasificadorGUI.paresExCL.get(i).Experimento.equals(padre.toString())){
                    WindowsInstances.createClasificadorGUI.paresExCL.remove(i);
                }
                i++;
            }
        }
        //Hay que aliminar loe los combobox
        if(!padre.isLeaf()){
            elimHijos(padre);
        }
        WindowsInstances.createClasificadorGUI.eliminarExpYCla(padre.toString());
        //Eliminar del arbol
        padre.removeAllChildren();  //Elimino los hijos del nodo padre
        WindowsInstances.mainGUI.modelo.nodeStructureChanged(padre); //Se debe notificar al arbol
        WindowsInstances.mainGUI.modelo.removeNodeFromParent(padre); //Se elimina el nodo padre
        WindowsInstances.mainGUI.modelo.reload();
        WindowsInstances.mainGUI.expandAllNodes(WindowsInstances.mainGUI.getProyectosTree(),  0, WindowsInstances.mainGUI.getProyectosTree().getRowCount());
    }
    
    /**
     * Menu PopUp de Experimento
     */
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
                crearHijo(padre, 0);
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
    
    public void elimHijos(CustomMutableTreeNode padre){
        int i = 0;
        ArrayList<CustomMutableTreeNode> hijos = Collections.list(padre.children());
        for(i = 0; i < hijos.size(); i++){
            if(hijos.get(i).isLeaf()){
                WindowsInstances.createClasificadorGUI.eliminarExpYCla(hijos.get(i).toString());
                WindowsInstances.createTareaGUI.eliminarExpYCla(padre.toString()); //NUEVO
                if(i+1 == hijos.size() ){
                    padre.removeAllChildren();
                    //WindowsInstances.mainGUI.modelo.removeNodeFromParent(padre);
                    //elimHijos(padre);   //Si es el ultimo hijo que se va a eliminar volvemos al padre para talarlo
                    
                }
            }
            else{
                elimHijos(hijos.get(i));
                WindowsInstances.createClasificadorGUI.eliminarExpYCla(hijos.get(i).toString());
            }    
        }
        
        
    }

    @Override
    public Icon getIcon() {
        return icono;
    }
    
}
