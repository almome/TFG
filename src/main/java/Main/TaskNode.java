package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import TaskParam.TaskParam;
import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


import org.w3c.dom.Document;

/**
 *
 * @author alexa
 */
public class TaskNode implements INodeType{
    Icon icono = new ImageIcon("assets/TaskIcon.png");
    String rutaPlantilla;
    Document plantXML;
    List<TaskParam> parametros; 
    
    public List<Component> mostrar() {
        List<Component> componentes = new ArrayList<Component>();
        for(TaskParam parametro : parametros) {
            componentes.addAll(parametro.mostrar());
        }
        return componentes;
    }

    public List<TaskParam> getParametros() {
        return parametros;
    }

    public void setParametros(List<TaskParam> parametros) {
        this.parametros = parametros;
    }
    
    
    public TaskNode (String rutaPlantilla, Document plantXML){
        this.plantXML = plantXML;
        this.rutaPlantilla = rutaPlantilla;
        parametros = new ArrayList<TaskParam>();
    }
    
    public Document getPlantXML() {
        return plantXML;
    }

    public void setPlantXML(Document plantXML) {
        this.plantXML = plantXML;
    }

    public String getRutaPlantilla() {
        return rutaPlantilla;
    }

    public void setRutaPlantilla(String rutaPlantilla) {
        this.rutaPlantilla = rutaPlantilla;
    }
    
    @Override
    public void crearHijo(CustomMutableTreeNode padre, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ejecutar() {
        try {
            WindowsInstances.mainGUI.ejecutar(this);
        } catch (IOException ex) {
            Logger.getLogger(TaskNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PrinterException ex) {
            Logger.getLogger(TaskNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(CustomMutableTreeNode padre) {
        padre.removeAllChildren();
        WindowsInstances.mainGUI.modelo.nodeStructureChanged(padre); //Se debe notificar al arbol
        WindowsInstances.mainGUI.modelo.removeNodeFromParent(padre); //Se elimina el nodo padre
        WindowsInstances.mainGUI.modelo.reload();
        WindowsInstances.mainGUI.expandAllNodes(WindowsInstances.mainGUI.getProyectosTree(),  0, WindowsInstances.mainGUI.getProyectosTree().getRowCount());
    }

    @Override
    public void popupMenu(CustomMutableTreeNode padre) {
        JPopupMenu menu = new JPopupMenu();
                
        JMenuItem jMenuItemEjecutar;
        JMenuItem jMenuItemEliminar;

        
        
        jMenuItemEjecutar = new JMenuItem("Ejecutar Tarea");
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
        
        menu.add (jMenuItemEjecutar);
        menu.add (jMenuItemEliminar);
        
        int mouseX = MouseInfo.getPointerInfo().getLocation().x;
        int mouseY = MouseInfo.getPointerInfo().getLocation().y;
        menu.show (WindowsInstances.mainGUI, mouseX, mouseY);
    }

    @Override
    public Icon getIcon() {
        return icono;
    }


    @Override
    public String getTipo() {
        return "Tarea";
    }
    
}
