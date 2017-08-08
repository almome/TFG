/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author sandra
 */
public class CustomMutableTreeNode extends DefaultMutableTreeNode {
    private int tipo = 1;
    private INodeType nodeType;

    CustomMutableTreeNode() {

    }
    
    CustomMutableTreeNode(String text) {
        super(text);
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
}
