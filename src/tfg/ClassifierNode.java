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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author alexa
 */
public class ClassifierNode implements INodeType{
    String rutaCarpeta;
    Icon icono = new ImageIcon("src/recursos/ClassifIcon.png");  //No pilla la imagen

    

    public String getRutaCarpeta() {
        return rutaCarpeta;
    }

    public void setRutaCarpeta(String rutaCarpeta) {
        this.rutaCarpeta = rutaCarpeta;
    }
    @Override
    public void crearHijo(CustomMutableTreeNode padre, int i) {
        if(i == 0){
            WindowsInstances.createClasificadorGUI.setPadre(padre.toString());
            WindowsInstances.createClasificadorGUI.setVisible(true);
            WindowsInstances.createClasificadorGUI.ocultarCampos();
            WindowsInstances.mainGUI.expandAllNodes(WindowsInstances.mainGUI.getProyectosTree(),  0, WindowsInstances.mainGUI.getProyectosTree().getRowCount());
        }
        else{
             
            WindowsInstances.createTareaGUI.setPadre(padre.toString());
            WindowsInstances.createTareaGUI.setVisible(true);
            WindowsInstances.createTareaGUI.ocultarCampos();
            WindowsInstances.mainGUI.expandAllNodes(WindowsInstances.mainGUI.getProyectosTree(),  0, WindowsInstances.mainGUI.getProyectosTree().getRowCount());
        }
        
    }

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(CustomMutableTreeNode padre) {
        int i = 0;
        //Eliminar de la tabla de pares
        if(!WindowsInstances.createClasificadorGUI.paresExCL.isEmpty()){
            while(i < WindowsInstances.createClasificadorGUI.paresExCL.size()){
                ParClasificador parAux = WindowsInstances.createClasificadorGUI.paresExCL.get(i);
                CustomMutableTreeNode experimentoN = (CustomMutableTreeNode) padre.getParent();
                DefaultMutableTreeNode nAux = (DefaultMutableTreeNode) padre.getParent();
                while(nAux != WindowsInstances.mainGUI.root){
                    experimentoN = (CustomMutableTreeNode) nAux;
                    nAux = (DefaultMutableTreeNode) nAux.getParent();
                }
                if(parAux.Experimento.equals(experimentoN.toString()) && parAux.Clasificador.equals(padre.toString())){
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

    @Override
    public void popupMenu(CustomMutableTreeNode padre) {
        JPopupMenu menu = new JPopupMenu();
                
        JMenuItem jMenuItemCreaClasificador;
        JMenuItem jMenuItemCreaTarea;
        JMenuItem jMenuItemEjecutar;
        JMenuItem jMenuItemEliminar;

        jMenuItemCreaClasificador = new JMenuItem("Crear Clasificador");
        jMenuItemCreaClasificador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                crearHijo(padre, 0);
            }
        });
        
        jMenuItemCreaTarea = new JMenuItem("Crear Tarea");
        jMenuItemCreaTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                crearHijo(padre, 1);
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
        menu.add (jMenuItemCreaTarea);
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
    public JLayeredPane mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTipo() {
         return "Clasificador";
    }

    
}
