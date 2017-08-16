/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg;

import javax.swing.Icon;

/**
 *
 * @author sandra
 */
public interface INodeType {
    
    public void crearHijo(CustomMutableTreeNode padre, int i);
    
    public void ejecutar();
    
    public void eliminar(CustomMutableTreeNode padre);
    
    public void popupMenu(CustomMutableTreeNode padre);
    
    public Icon getIcon();
    
}
