package GUI;


import Utilities.WindowsInstances;
import TreeNodes.CustomMutableTreeNode;
import TreeNodes.TaskNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexa
 */
public class Console {
    String command;
    String resultado = "";
    
    public Console(String comando){
        command = comando;
    }
    
    public String ejecutarComando() throws IOException{
        Process process = Runtime.getRuntime().exec(command);                    
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));  
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String s; 
        Boolean errors = false;
        while ((s = reader.readLine()) != null) { 
            resultado = resultado+"\n"+ s; 
            CustomMutableTreeNode nodeSelected = (CustomMutableTreeNode) WindowsInstances.mainGUI.ultimoNodoeleccionado();
            TaskNode taskNode = (TaskNode) nodeSelected.getNodeType();
            try {
                taskNode.icono = new ImageIcon(getClass().getResource("/assets/treeIcons/TaskIconCorrecto.png"));
            } catch (NullPointerException e) {
                taskNode.icono = new ImageIcon("assets/treeIcons/TaskIconCorrecto.png");
            }
            WindowsInstances.mainGUI.renderer.setLeafIcon(taskNode.getIcon());
            WindowsInstances.mainGUI.getProyectosTree().repaint();
            WindowsInstances.mainGUI.expandAllNodes(WindowsInstances.mainGUI.getProyectosTree(), nodeSelected.getParent().getChildCount(), 0);

        }
        while ((s = stdError.readLine()) != null) { 
            errors = true;
            resultado = resultado+"\n"+ s; 
            CustomMutableTreeNode nodeSelected = (CustomMutableTreeNode) WindowsInstances.mainGUI.ultimoNodoeleccionado();
            TaskNode taskNode= (TaskNode) nodeSelected.getNodeType();
            try {
                taskNode.icono = new ImageIcon(getClass().getResource("/assets/treeIcons/TaskIconIncorrecto.png"));
            } catch (NullPointerException e) {
                taskNode.icono = new ImageIcon("assets/treeIcons/TaskIconIncorrecto.png");
            }
            WindowsInstances.mainGUI.renderer.setLeafIcon(taskNode.getIcon());
            WindowsInstances.mainGUI.getProyectosTree().repaint();
            WindowsInstances.mainGUI.expandAllNodes(WindowsInstances.mainGUI.getProyectosTree(), nodeSelected.getParent().getChildCount(), 0);
            
        }
        if(errors == false){
            CustomMutableTreeNode nodeSelected = (CustomMutableTreeNode) WindowsInstances.mainGUI.ultimoNodoeleccionado();
            TaskNode taskNode= (TaskNode) nodeSelected.getNodeType();
            try {
                taskNode.icono = new ImageIcon(getClass().getResource("/assets/treeIcons/TaskIconCorrecto.png"));
            } catch (NullPointerException e) {
                taskNode.icono = new ImageIcon("assets/treeIcons/TaskIconCorrecto.png");
            }
            WindowsInstances.mainGUI.renderer.setLeafIcon(taskNode.getIcon());
            WindowsInstances.mainGUI.getProyectosTree().repaint();
            WindowsInstances.mainGUI.expandAllNodes(WindowsInstances.mainGUI.getProyectosTree(), nodeSelected.getParent().getChildCount(), 0);
        }
        return resultado;
    }
    
}
