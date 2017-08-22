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
   
    private INodeType nodeType;

    public INodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(INodeType nodeType) {
        this.nodeType = nodeType;
    }

    CustomMutableTreeNode() {}
    
    CustomMutableTreeNode(String text) {super(text);}
}
