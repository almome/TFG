/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import TreeNodes.CustomMutableTreeNode;
import TreeNodes.ClassifierNode;
import TreeNodes.ExperimentNode;
import TreeNodes.TaskNode;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class TreeTransferHandler extends TransferHandler {

    DataFlavor nodesFlavor;
    DataFlavor[] flavors = new DataFlavor[1];
    DefaultMutableTreeNode[] nodesToRemove;

    public TreeTransferHandler() {
        try {
            String mimeType = DataFlavor.javaJVMLocalObjectMimeType + ";class=\"" + javax.swing.tree.DefaultMutableTreeNode[].class.getName() + "\"";
            nodesFlavor = new DataFlavor(mimeType);
            flavors[0] = nodesFlavor;
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound: " + e.getMessage());
        }
    }

    public boolean canImport(TransferHandler.TransferSupport support) {
        if (!support.isDrop()) {
            return false;
        }
        support.setShowDropLocation(true);
        if (!support.isDataFlavorSupported(nodesFlavor)) {
            return false;
        }
        // get target, origin node and useful data
        JTree tree = (JTree) support.getComponent();
        JTree.DropLocation dl = (JTree.DropLocation) support.getDropLocation();
        TreePath dest = dl.getPath();
        int dropRow = tree.getRowForPath(dest);
        int[] selRows = tree.getSelectionRows();
        DefaultMutableTreeNode target = (DefaultMutableTreeNode) dest.getLastPathComponent();
        TreePath path = tree.getPathForRow(selRows[0]);
        DefaultMutableTreeNode origin = (DefaultMutableTreeNode) path.getLastPathComponent();
        // Do not allow a drop on the drag source selections.
        for (int i = 0; i < selRows.length; i++) {
            if (selRows[i] == dropRow) {
                return false;
            }
        }
        // Check custom mutable tree node rectrictions
        CustomMutableTreeNode originNode = (CustomMutableTreeNode) origin;
        // Experiments rectrictions
        if (originNode.getNodeType() instanceof ExperimentNode) {
            // Experiments only can be orderer
            if (target instanceof CustomMutableTreeNode) {
                return false;
            }
        // Other custom nodes restrictions
        } else if (target instanceof CustomMutableTreeNode) {
            // Check if target node is inside origin node
            if (targetInsideOrigin(target, origin) > 0) {
                return false;
            }
            CustomMutableTreeNode targetNode = (CustomMutableTreeNode) target;
            // Task restrictions
            if (originNode.getNodeType() instanceof TaskNode) {
                // Tasks must be child of an classifier
                if (!(targetNode.getNodeType() instanceof ClassifierNode)) {
                    return false;
                }
            }
            // Target must not be a task
            if (targetNode.getNodeType() instanceof TaskNode) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
    private int targetInsideOrigin(DefaultMutableTreeNode target, DefaultMutableTreeNode descendant) {
        if (descendant == target) {
            return 1;
        } else {
            int isInside = 0;
            for (int index = 0; index < descendant.getChildCount(); ++index) {
                isInside += targetInsideOrigin(target, (DefaultMutableTreeNode) descendant.getChildAt(index));
            }
            return isInside;
        }
    }

    protected Transferable createTransferable(JComponent c) {
        JTree tree = (JTree) c;
        TreePath[] paths = tree.getSelectionPaths();
        if (paths != null) {
            // Make up a node array of copies for transfer and
            // another for/of the nodes that will be removed in
            // exportDone after a successful drop.
            List<TreeNodeContainer> copies = new ArrayList<TreeNodeContainer>();
            List<DefaultMutableTreeNode> toRemove = new ArrayList<DefaultMutableTreeNode>();
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) paths[0].getLastPathComponent();
            addSelectedNodes(copies, toRemove, node, null, -1);
            TreeNodeContainer[] nodes = copies.toArray(new TreeNodeContainer[copies.size()]);
            nodesToRemove = toRemove.toArray(new DefaultMutableTreeNode[toRemove.size()]);
            return new NodesTransferable(nodes);
        }
        return null;
    }
    private void addSelectedNodes(List<TreeNodeContainer> copies, List<DefaultMutableTreeNode> toRemove, DefaultMutableTreeNode node, DefaultMutableTreeNode parent, int nodeIndex) {
        DefaultMutableTreeNode nodeCopied = copy(node);
        copies.add(new TreeNodeContainer(nodeCopied, parent, nodeIndex));
        toRemove.add(node);
        for(int index = 0; index < node.getChildCount(); ++index) {
            DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(index);
            addSelectedNodes(copies, toRemove, childNode, nodeCopied, index);
        }
    }
    public DefaultMutableTreeNode copy(TreeNode node) {
        DefaultMutableTreeNode n = (DefaultMutableTreeNode) node;
        return (DefaultMutableTreeNode) n.clone();
    }

    protected void exportDone(JComponent source, Transferable data, int action) {
        if ((action & MOVE) == MOVE) {
            JTree tree = (JTree) source;
            DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
            // Remove nodes saved in nodesToRemove in createTransferable.
            for (int i = 0; i < nodesToRemove.length; i++) {
                model.removeNodeFromParent(nodesToRemove[i]);
            }
        }
    }

    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }

    public boolean importData(TransferHandler.TransferSupport support) {
        if (!canImport(support)) {
            return false;
        }
        // Extract transfer data.
        TreeNodeContainer[] nodes = null;
        try {
            Transferable t = support.getTransferable();
            nodes = (TreeNodeContainer[]) t.getTransferData(nodesFlavor);
        } catch (UnsupportedFlavorException ufe) {
            System.out.println("UnsupportedFlavor: " + ufe.getMessage());
        } catch (java.io.IOException ioe) {
            System.out.println("I/O error: " + ioe.getMessage());
        }
        // Get drop location info.
        JTree.DropLocation dl = (JTree.DropLocation) support.getDropLocation();
        int childIndex = dl.getChildIndex();
        TreePath dest = dl.getPath();
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) dest.getLastPathComponent();
        JTree tree = (JTree) support.getComponent();
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        // Configure for drop mode.
        int index = childIndex;    // DropMode.INSERT
        if (childIndex == -1) {     // DropMode.ON
            index = parent.getChildCount();
        }
        // Add data to model.
        // Add root node from the selection
        if(nodes.length > 0) {
            model.insertNodeInto(nodes[0].getNode(), parent, index);
        }
        // Add children
        for (int i = 1; i < nodes.length; i++) {
            model.insertNodeInto(nodes[i].getNode(), nodes[i].getParent(), nodes[i].getIndex());
        }
        return true;
    }

    public String toString() {
        return getClass().getName();
    }
    
    public class TreeNodeContainer {
        private DefaultMutableTreeNode node, parent;
        private int index;
        
        public TreeNodeContainer(DefaultMutableTreeNode node, DefaultMutableTreeNode parent, int index) {
            this.node = node;
            this.parent = parent;
            this.index = index;
        }

        public DefaultMutableTreeNode getNode() {
            return node;
        }
        public void setNode(DefaultMutableTreeNode node) {
            this.node = node;
        }
        public DefaultMutableTreeNode getParent() {
            return parent;
        }
        public void setParent(DefaultMutableTreeNode parent) {
            this.parent = parent;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
    }

    public class NodesTransferable implements Transferable {

        TreeNodeContainer[] nodes;

        public NodesTransferable(TreeNodeContainer[] nodes) {
            this.nodes = nodes;
        }

        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
            if (!isDataFlavorSupported(flavor)) {
                throw new UnsupportedFlavorException(flavor);
            }
            return nodes;
        }

        public DataFlavor[] getTransferDataFlavors() {
            return flavors;
        }

        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return nodesFlavor.equals(flavor);
        }
    }
}
