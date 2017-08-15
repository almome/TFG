/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg;

import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Alexandra Morón Méndez
 */
public class MainGUI extends javax.swing.JFrame {
    public ArrayList<TreeNode> experimentos;
    public DefaultTreeModel modelo;
    public DefaultMutableTreeNode root;
    
    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProyectosTree = new javax.swing.JTree();
        DatosLayeredPane = new javax.swing.JLayeredPane();
        BarrajMenu = new javax.swing.JMenuBar();
        archivosjMenu = new javax.swing.JMenu();
        nuevojMenu = new javax.swing.JMenu();
        experjMenu = new javax.swing.JMenuItem();
        clasificajMenu = new javax.swing.JMenuItem();
        tareajMenu = new javax.swing.JMenuItem();
        runjMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        ProyectosTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        ProyectosTree.setRootVisible(false);
        ProyectosTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ProyectosTreeMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(ProyectosTree);

        jTabbedPane1.addTab("Experimentos", jScrollPane1);

        java.awt.GridBagLayout jLayeredPane1Layout = new java.awt.GridBagLayout();
        jLayeredPane1Layout.columnWidths = new int[] {2};
        DatosLayeredPane.setLayout(jLayeredPane1Layout);

        archivosjMenu.setText("Archivos");

        nuevojMenu.setText("Nuevo");

        experjMenu.setText("Experimento");
        experjMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                experjMenuActionPerformed(evt);
            }
        });
        nuevojMenu.add(experjMenu);

        clasificajMenu.setText("Clasificador");
        clasificajMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clasificajMenuActionPerformed(evt);
            }
        });
        nuevojMenu.add(clasificajMenu);

        tareajMenu.setText("Tarea");
        tareajMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tareajMenuActionPerformed(evt);
            }
        });
        nuevojMenu.add(tareajMenu);

        archivosjMenu.add(nuevojMenu);

        BarrajMenu.add(archivosjMenu);

        runjMenu.setText("Run");
        BarrajMenu.add(runjMenu);

        setJMenuBar(BarrajMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DatosLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(819, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(DatosLayeredPane)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*BOTONES PRINCIPALES DE LA BARRA DE MENU*/
    /**
     * Método que llama a la ventana de crear experimento.
     * @param evt 
     */
    private void experjMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_experjMenuActionPerformed

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WindowsInstances.createDirectoryGUI.setVisible(true);
            }
        });
    }//GEN-LAST:event_experjMenuActionPerformed
    /**
     * Método que llama a la ventana de crear clasificador
     * @param evt 
     */
    private void clasificajMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clasificajMenuActionPerformed
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WindowsInstances.createClasificadorGUI.mostrarCampos();
                WindowsInstances.createClasificadorGUI.setVisible(true);
                
            }
        });
    }//GEN-LAST:event_clasificajMenuActionPerformed
    /**
     * Método que llama a la ventana de crear tarea
     * @param evt 
     */
    private void tareajMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tareajMenuActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WindowsInstances.createTareaGUI.mostrarCampos();
                WindowsInstances.createTareaGUI.setVisible(true);
            }
        });
    }//GEN-LAST:event_tareajMenuActionPerformed
    
    /*ACCIONES CUANDO SE ABRA LA VENTANA*/  
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.modelo = (DefaultTreeModel) this.ProyectosTree.getModel();
        this.root = (DefaultMutableTreeNode) this.modelo.getRoot();
    }//GEN-LAST:event_formWindowOpened
    /**
     * Método de acción cuando se hace click con el botón derecho del ratón en un nodo del arbol
     * @param evt 
     */
    private void ProyectosTreeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProyectosTreeMousePressed
        if(SwingUtilities.isRightMouseButton(evt))
        {
            TreePath path = ProyectosTree.getPathForLocation(evt.getX(), evt.getY());
            Rectangle pathBounds = ProyectosTree.getUI().getPathBounds(ProyectosTree, path);
            if(pathBounds != null && pathBounds.contains(evt.getX (), evt.getY ()))
            {
                CustomMutableTreeNode hijo = (CustomMutableTreeNode) path.getLastPathComponent();
                hijo.getNodeType().popupMenu(hijo);
            }
        }
        else{
            if(SwingUtilities.isLeftMouseButton(evt)){
                DatosLayeredPane.removeAll();
                DatosLayeredPane.repaint();
            }
        }
    }//GEN-LAST:event_ProyectosTreeMousePressed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }
    /*METODOS DE GESTIÓN DEL ARBOL DE PROYECTOS*/
    /**
     * Set del arbol del proyectos.
     * @return 
     */
    public JTree getProyectosTree() {
        return ProyectosTree;
    }
    /**
     * Introduce un nodo experimento
     * @param nodo 
     */
    public void setProyectosTree(CustomMutableTreeNode nodo){
        this.root.add(nodo);    
        this.modelo.reload();
    }
    /**
     * Introduce un nodo clasificador o tarea
     * @param nodo
     * @param PadreNodo 
     */
    public void setProyectosTree(CustomMutableTreeNode nodo, Object PadreNodo) {
        Boolean flag = false;
        CustomMutableTreeNode nodec = new CustomMutableTreeNode();
        Enumeration<CustomMutableTreeNode> e = this.root.depthFirstEnumeration();
        while (e.hasMoreElements()&& flag != true) {
            nodec = (CustomMutableTreeNode)e.nextElement();
            if (nodec.toString().equalsIgnoreCase(PadreNodo.toString()) ) {
                 flag = true;
            }
        }
        //PARA PONER ICONO EN CASA NODO
        /////////////////////////////////////////////////////////////////////////////
        ProyectosTree.setCellRenderer(new DefaultTreeCellRenderer() {
            
            @Override
            public Component getTreeCellRendererComponent(JTree tree,
                    Object value, boolean selected, boolean expanded,
                    boolean isLeaf, int row, boolean focused) {
                Component c = super.getTreeCellRendererComponent(tree, value,
                        selected, expanded, isLeaf, row, focused);
                setIcon(WindowsInstances.createClasificadorGUI.getIcono());
                return c;
            }
        });
        ///////////////////////////////////////////////////////////////////////////////
        nodec.add(nodo);
        this.modelo.reload();
    }
    
    public void expandAllNodes(JTree tree, int startingIndex, int rowCount){
    for(int i=startingIndex;i<rowCount;++i){
        tree.expandRow(i);
    }

    if(tree.getRowCount()!=rowCount){
        expandAllNodes(tree, rowCount, tree.getRowCount());
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarrajMenu;
    private javax.swing.JLayeredPane DatosLayeredPane;
    private javax.swing.JTree ProyectosTree;
    private javax.swing.JMenu archivosjMenu;
    private javax.swing.JMenuItem clasificajMenu;
    private javax.swing.JMenuItem experjMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenu nuevojMenu;
    private javax.swing.JMenu runjMenu;
    private javax.swing.JMenuItem tareajMenu;
    // End of variables declaration//GEN-END:variables
}
