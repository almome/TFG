package TreeNodes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Utilities.WindowsInstances;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author sandra
 */
public class ExperimentNode implements INodeType {
    Icon icono;
    String rutaCarpeta;
    
    public ExperimentNode() {
        try {
            icono = new ImageIcon(getClass().getResource("/assets/treeIcons/ExperimIcon.png"));
        } catch (NullPointerException e) {
            icono = new ImageIcon("assets/treeIcons/ExperimIcon.png");
        }
    }

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

        jMenuItemCreaClasificador = new JMenuItem("Create Node");
        jMenuItemCreaClasificador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                crearHijo(padre, 0);
            }
        });
        
        jMenuItemEjecutar = new JMenuItem("Run Experiment");
        jMenuItemEjecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ejecutar_rec(padre);
            }
        });
        
        jMenuItemEliminar = new JMenuItem("Remove");
        jMenuItemEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                eliminar(padre);
            }
        });
        
        menu.add (jMenuItemCreaClasificador);
        menu.add (jMenuItemEjecutar);
        menu.add (jMenuItemEliminar);
        
        int mouseX =  MouseInfo.getPointerInfo().getLocation().x;
        int mouseY = MouseInfo.getPointerInfo().getLocation().y;
        
        final Point relativeLocation = WindowsInstances.mainGUI.getLocationOnScreen();

        final Rectangle currentScreenBounds = WindowsInstances.mainGUI.getGraphicsConfiguration().getBounds();

        relativeLocation.x -= currentScreenBounds.x;
        relativeLocation.y -= currentScreenBounds.y;
        
        menu.show (WindowsInstances.mainGUI, mouseX-relativeLocation.x, mouseY-relativeLocation.y);
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

   

    @Override
    public String getTipo() {
         return "Experimento";
    }

   public void ejecutar_rec (CustomMutableTreeNode nodo){
        for(int i = 0 ; i < nodo.getChildCount() ; i++)
        {
            CustomMutableTreeNode aux = (CustomMutableTreeNode) nodo.getChildAt(i);
            if(aux.getNodeType() instanceof TaskNode){
                TaskNode taskNode = (TaskNode) aux.getNodeType();
                taskNode.ejecutar();

            }
            else{
                ejecutar_rec(aux);

            }
        }
    }
    
}
