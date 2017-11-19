package TreeNodes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author sandra
 */
public class CustomMutableTreeNode extends DefaultMutableTreeNode {
   public String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private INodeType nodeType;

    public INodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(INodeType nodeType) {
        this.nodeType = nodeType;
    }

    public CustomMutableTreeNode() {}
    
    public CustomMutableTreeNode(String text) {super(text);}
}
