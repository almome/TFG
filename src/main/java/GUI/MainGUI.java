package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import TreeNodes.INodeType;
import Utilities.TreeTransferHandler;
import Utilities.WindowsInstances;
import XML.Validacion;
import XML.StructXML;
import Utilities.ParClasificador;
import TreeNodes.CustomMutableTreeNode;
import TreeNodes.ClassifierNode;
import TreeNodes.ExperimentNode;
import TreeNodes.TaskNode;
import TaskParam.FileParam;
import TaskParam.StringParam;
import java.awt.Component;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;

import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;




/**
 *
 * @author Alexandra Morón Méndez
 */
public class MainGUI extends javax.swing.JFrame {
    public ArrayList<String> etiquetas; //Provisional
    public ArrayList<Boolean> obligatorio; //Provisional
    public ArrayList<String> tipo; //Provisional
    public ArrayList<TreeNode> experimentos;
    public DefaultTreeModel modelo;
    public DefaultMutableTreeNode root;
    public String consolaText;
    DefaultTreeCellRenderer renderer;
    
    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
        renderer = (DefaultTreeCellRenderer) ProyectosTree.getCellRenderer();
       
        ProyectosTree.addTreeSelectionListener(new TreeSelectionListener(){
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                if(ProyectosTree.getSelectionPath() == null){
                    jButtonGuardar.setEnabled(false);
                    jButtonGuardarTodos.setEnabled(false);
                    jButtonLimpiar.setEnabled(false);
                    jButtonCambiarPlantilla.setEnabled(false);
                    
                    jButtonEjecutar.setEnabled(false);
                    if(!jTextAreaConsola.getText().equals("")){
                        jButtonGuardarSalida.setEnabled(true);
                        jButtonLimpiarSalida.setEnabled(true);
                    }else{
                        jButtonGuardarSalida.setEnabled(false);
                        jButtonLimpiarSalida.setEnabled(false);
                    }
                    
                }
                else{
                    jButtonGuardar.setEnabled(true);
                    jButtonGuardarTodos.setEnabled(true);
                    jButtonEjecutar.setEnabled(true);
                    TreePath nodoAuxPath = ProyectosTree.getSelectionPath();
                    CustomMutableTreeNode nodoAux = (CustomMutableTreeNode) nodoAuxPath.getLastPathComponent();
                    if(nodoAux.getNodeType()  instanceof TaskNode){
                        jButtonLimpiar.setEnabled(true);
                        jButtonCambiarPlantilla.setEnabled(true);
                        
                    }else{
                        jButtonLimpiar.setEnabled(false);
                        jButtonCambiarPlantilla.setEnabled(false);
                       
                    }
                    
                }
                
            }
            
        });

        ProyectosTree.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                jButtonGuardar.setEnabled(true);
                jButtonGuardarTodos.setEnabled(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                jButtonGuardar.setEnabled(false);
                jButtonGuardarTodos.setEnabled(false);
                TreePath nodoAuxPath = ProyectosTree.getSelectionPath();
                CustomMutableTreeNode nodoAux = (CustomMutableTreeNode) nodoAuxPath.getLastPathComponent();
                if(nodoAux.getNodeType()  instanceof TaskNode){
                    jButtonEjecutar.setEnabled(true);
                    jButtonCambiarPlantilla.setEnabled(true);
                    jButtonLimpiar.setEnabled(true);
                    
                }
                else{
                    jButtonEjecutar.setEnabled(false);
                    jButtonCambiarPlantilla.setEnabled(false);
                    jButtonLimpiar.setEnabled(false);
                    
                }
                if(!jTextAreaConsola.getText().equals("")){
                    jButtonGuardarSalida.setEnabled(true);
                    jButtonLimpiarSalida.setEnabled(true);
                }
                else{
                    jButtonGuardarSalida.setEnabled(false);
                    jButtonLimpiarSalida.setEnabled(false);
                }
            }
        });
        
        // Se definen el idioma en los modales emergentes
        JOptionPane.setDefaultLocale(Locale.ENGLISH);
        JFileChooser.setDefaultLocale(Locale.ENGLISH);
        
        SetDragDrop();
        SetIcons();
        SetApplicationIcon();
    }
    
    private void SetApplicationIcon() {
        Image image;
        try {
            image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/mainicon.png"));
        } catch(NullPointerException e) {
            image = Toolkit.getDefaultToolkit().getImage("assets/mainicon.png");
        }
        ImageIcon icon = new ImageIcon(image);
        setIconImage(icon.getImage());
    }
    
    private void SetIcons() {
        try {
            System.out.println(getClass().getResource("/assets/schemas/xmlschematarea.xsd").toString());
            jButtonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/stateBar/clean.png")));
            jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/stateBar/save.png")));
            jButtonGuardarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/stateBar/save-all.png")));
            jButtonLimpiarSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/stateBar/clean-console.png")));
            jButtonGuardarSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/stateBar/icon.png")));
            jButtonCambiarPlantilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/stateBar/folder.png")));
            jButtonEjecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/stateBar/play-button.png")));
        } catch(NullPointerException e) {
            System.out.println("assets/schemas/xmlschematarea.xsd");
            jButtonLimpiar.setIcon(new javax.swing.ImageIcon("assets/stateBar/clean.png"));
            jButtonGuardar.setIcon(new javax.swing.ImageIcon("assets/stateBar/save.png"));
            jButtonGuardarTodos.setIcon(new javax.swing.ImageIcon("assets/stateBar/save-all.png"));
            jButtonLimpiarSalida.setIcon(new javax.swing.ImageIcon("assets/stateBar/clean-console.png"));
            jButtonGuardarSalida.setIcon(new javax.swing.ImageIcon("assets/stateBar/icon.png"));
            jButtonCambiarPlantilla.setIcon(new javax.swing.ImageIcon("assets/stateBar/folder.png"));
            jButtonEjecutar.setIcon(new javax.swing.ImageIcon("assets/stateBar/play-button.png"));
        }
    }
    
    private void SetDragDrop() {
        ProyectosTree.setDragEnabled(true);
        ProyectosTree.setDropMode(DropMode.ON_OR_INSERT);
        ProyectosTree.setTransferHandler(new TreeTransferHandler());
        ProyectosTree.getSelectionModel().setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
        
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) ProyectosTree.getModel().getRoot();
        Enumeration e = root.breadthFirstEnumeration();
        while(e.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
            if(node.isLeaf()) {
                continue;
            }
            int row = ProyectosTree.getRowForPath(new TreePath(node.getPath()));
            ProyectosTree.expandRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaConsola = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProyectosTree = new javax.swing.JTree();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonGuardar = new javax.swing.JButton();
        jButtonGuardarTodos = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButtonLimpiarSalida = new javax.swing.JButton();
        jButtonGuardarSalida = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonCambiarPlantilla = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldRutaPlantilla = new javax.swing.JTextField();
        jButtonEjecutar = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        stateLabel = new javax.swing.JLabel();
        BarrajMenu = new javax.swing.JMenuBar();
        archivosjMenu = new javax.swing.JMenu();
        nuevojMenu = new javax.swing.JMenu();
        experjMenu = new javax.swing.JMenuItem();
        clasificajMenu = new javax.swing.JMenuItem();
        tareajMenu = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        runjMenu = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        herramientasjMenu = new javax.swing.JMenu();
        crearScriptjMenu = new javax.swing.JMenu();
        paraLinuxjMenuItem = new javax.swing.JMenuItem();
        paraWindowsjMenuItem = new javax.swing.JMenuItem();
        consolajMenu = new javax.swing.JMenu();
        guardarSalidajMenuItem = new javax.swing.JMenuItem();
        limpiarConsolajMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setModalExclusionType(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPane3.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jTextAreaConsola.setEditable(false);
        jTextAreaConsola.setBackground(new java.awt.Color(51, 51, 51));
        jTextAreaConsola.setColumns(20);
        jTextAreaConsola.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextAreaConsola.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaConsola.setRows(5);
        jScrollPane2.setViewportView(jTextAreaConsola);

        jTabbedPane3.addTab("Console", jScrollPane2);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        ProyectosTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        ProyectosTree.setEditable(true);
        ProyectosTree.setRootVisible(false);
        ProyectosTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ProyectosTreeMousePressed(evt);
            }
        });
        ProyectosTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ProyectosTreeValueChanged(evt);
            }
        });
        ProyectosTree.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ProyectosTreeKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(ProyectosTree);

        jTabbedPane1.addTab("Experiments", jScrollPane1);

        jToolBar1.setRollover(true);

        jButtonGuardar.setToolTipText("Save Experiment");
        jButtonGuardar.setBorderPainted(false);
        jButtonGuardar.setContentAreaFilled(false);
        jButtonGuardar.setEnabled(false);
        jButtonGuardar.setFocusable(false);
        jButtonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonGuardar);

        jButtonGuardarTodos.setToolTipText("Save All Experiments");
        jButtonGuardarTodos.setBorderPainted(false);
        jButtonGuardarTodos.setContentAreaFilled(false);
        jButtonGuardarTodos.setEnabled(false);
        jButtonGuardarTodos.setFocusable(false);
        jButtonGuardarTodos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGuardarTodos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGuardarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarTodosActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonGuardarTodos);
        jToolBar1.add(jSeparator1);

        jButtonLimpiarSalida.setToolTipText("Clean Console");
        jButtonLimpiarSalida.setBorderPainted(false);
        jButtonLimpiarSalida.setContentAreaFilled(false);
        jButtonLimpiarSalida.setEnabled(false);
        jButtonLimpiarSalida.setFocusable(false);
        jButtonLimpiarSalida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLimpiarSalida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonLimpiarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarSalidaActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonLimpiarSalida);

        jButtonGuardarSalida.setToolTipText("Save Console");
        jButtonGuardarSalida.setBorderPainted(false);
        jButtonGuardarSalida.setContentAreaFilled(false);
        jButtonGuardarSalida.setEnabled(false);
        jButtonGuardarSalida.setFocusable(false);
        jButtonGuardarSalida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGuardarSalida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGuardarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarSalidaActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonGuardarSalida);
        jToolBar1.add(jSeparator2);

        jButtonLimpiar.setToolTipText("Clean Task Parameters");
        jButtonLimpiar.setBorderPainted(false);
        jButtonLimpiar.setContentAreaFilled(false);
        jButtonLimpiar.setEnabled(false);
        jButtonLimpiar.setFocusable(false);
        jButtonLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonLimpiar);

        jButtonCambiarPlantilla.setToolTipText("Change Task Template");
        jButtonCambiarPlantilla.setBorderPainted(false);
        jButtonCambiarPlantilla.setContentAreaFilled(false);
        jButtonCambiarPlantilla.setEnabled(false);
        jButtonCambiarPlantilla.setFocusable(false);
        jButtonCambiarPlantilla.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCambiarPlantilla.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCambiarPlantilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCambiarPlantillaActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonCambiarPlantilla);

        jTextFieldRutaPlantilla.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRutaPlantilla.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldRutaPlantilla, javax.swing.GroupLayout.DEFAULT_SIZE, 1126, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jTextFieldRutaPlantilla, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jToolBar1.add(jPanel2);

        jButtonEjecutar.setToolTipText("Run");
        jButtonEjecutar.setBorderPainted(false);
        jButtonEjecutar.setContentAreaFilled(false);
        jButtonEjecutar.setEnabled(false);
        jButtonEjecutar.setFocusable(false);
        jButtonEjecutar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEjecutar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEjecutarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonEjecutar);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setAutoscrolls(true);

        jPanel1.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 998, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel1);

        jTabbedPane2.addTab("...", jScrollPane3);

        jToolBar2.setRollover(true);
        jToolBar2.add(stateLabel);
        stateLabel.getAccessibleContext().setAccessibleName("stateLabel");

        archivosjMenu.setText("File");

        nuevojMenu.setText("New");

        experjMenu.setText("Experiment");
        experjMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                experjMenuActionPerformed(evt);
            }
        });
        nuevojMenu.add(experjMenu);

        clasificajMenu.setText("Node");
        clasificajMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clasificajMenuActionPerformed(evt);
            }
        });
        nuevojMenu.add(clasificajMenu);

        tareajMenu.setText("Task");
        tareajMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tareajMenuActionPerformed(evt);
            }
        });
        nuevojMenu.add(tareajMenu);

        archivosjMenu.add(nuevojMenu);

        jMenuItem2.setText("Open Experiment");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        archivosjMenu.add(jMenuItem2);

        jMenuItem1.setText("Save All");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        archivosjMenu.add(jMenuItem1);

        BarrajMenu.add(archivosjMenu);

        runjMenu.setText("Run");

        jMenuItem3.setText("Run All");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        runjMenu.add(jMenuItem3);

        BarrajMenu.add(runjMenu);

        herramientasjMenu.setText("Tools");

        crearScriptjMenu.setText("Create Script");

        paraLinuxjMenuItem.setText("For Linux");
        paraLinuxjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paraLinuxjMenuItemActionPerformed(evt);
            }
        });
        crearScriptjMenu.add(paraLinuxjMenuItem);

        paraWindowsjMenuItem.setText("For Windows");
        paraWindowsjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paraWindowsjMenuItemActionPerformed(evt);
            }
        });
        crearScriptjMenu.add(paraWindowsjMenuItem);

        herramientasjMenu.add(crearScriptjMenu);

        BarrajMenu.add(herramientasjMenu);

        consolajMenu.setText("Console");

        guardarSalidajMenuItem.setText("Save Output");
        guardarSalidajMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarSalidajMenuItemActionPerformed(evt);
            }
        });
        consolajMenu.add(guardarSalidajMenuItem);

        limpiarConsolajMenuItem.setText("Clean Console");
        limpiarConsolajMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarConsolajMenuItemActionPerformed(evt);
            }
        });
        consolajMenu.add(limpiarConsolajMenuItem);

        BarrajMenu.add(consolajMenu);

        setJMenuBar(BarrajMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane3)
                            .addComponent(jTabbedPane2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.getAccessibleContext().setAccessibleName("");

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
    
    public TreeNode ultimoNodoeleccionado(){
        TreeNode aux =  (TreeNode) ProyectosTree.getLastSelectedPathComponent();
        return aux;
    }
            
    /*ACCIONES CUANDO SE ABRA LA VENTANA*/  
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.modelo = (DefaultTreeModel) this.ProyectosTree.getModel();
        modelo.addTreeModelListener(new TreeModelListener(){
            @Override
            public void treeNodesChanged(TreeModelEvent e) {
                CustomMutableTreeNode aux = (CustomMutableTreeNode) ProyectosTree.getLastSelectedPathComponent();
                String nombreAntiguo = aux.getNombre();
                aux.setNombre(aux.getUserObject().toString());
                if(aux.getNodeType() instanceof ExperimentNode){
                    /*WindowsInstances.createClasificadorGUI.paresExCL.remove(nombreAntiguo);
                    ParClasificador parAux = new ParClasificador();
                    parAux.Experimento = aux.getNombre();
                    WindowsInstances.createClasificadorGUI.paresExCL.add(parAux);*/
                    WindowsInstances.createClasificadorGUI.removeCombo(nombreAntiguo);
                     WindowsInstances.createTareaGUI.eliminarExpYCla(nombreAntiguo);
                    WindowsInstances.createClasificadorGUI.setCombo(aux.getNombre());
                    WindowsInstances.createTareaGUI.setExpCombo(aux.getNombre()); 
                    ExperimentNode expAux = (ExperimentNode) aux.getNodeType();
                    File dir = new File(expAux.getRutaCarpeta());
                    File newDir = new File(dir.getParent() + File.separator + aux.getNombre());
                    expAux.setRutaCarpeta(dir.getParent() + File.separator + aux.getNombre());
                    dir.renameTo(newDir);
                }
                else if(aux.getNodeType() instanceof ClassifierNode){
                    
                    WindowsInstances.createTareaGUI.eliminarExpYCla(nombreAntiguo);
                    ParClasificador parAux = new ParClasificador();
                    parAux.Clasificador = aux.getNombre();
                    while(aux.getParent()!=root){
                        if(aux.getParent() == root){
                            parAux.Experimento = aux.getNombre();
                        }
                        aux = (CustomMutableTreeNode) aux.getParent();
                    }
                    WindowsInstances.createClasificadorGUI.paresExCL.add(parAux);
                }
                
            }

            @Override
            public void treeNodesInserted(TreeModelEvent e) {
                
            }

            @Override
            public void treeNodesRemoved(TreeModelEvent e) {
                
            }

            @Override
            public void treeStructureChanged(TreeModelEvent e) {
                
            }
            
        });
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
            if(SwingUtilities.isLeftMouseButton(evt)){  //Si es nodo tarea muestra la ventana principal con los campos del xml
                jTabbedPane2.setTitleAt(0, "...");
                jTabbedPane2.revalidate();
                jTabbedPane2.repaint();
                jScrollPane3.setPreferredSize(jPanel1.getPreferredSize());
                jPanel1.removeAll();
                jTextFieldRutaPlantilla.setText("");
                TreePath path = ProyectosTree.getPathForLocation(evt.getX(), evt.getY());
                Rectangle pathBounds = ProyectosTree.getUI().getPathBounds(ProyectosTree, path);
                if(pathBounds != null && pathBounds.contains(evt.getX (), evt.getY ()))
                {
                    try{
                        CustomMutableTreeNode hijo = (CustomMutableTreeNode) path.getLastPathComponent();
                        jPanel1.setPreferredSize(jPanel1.getSize());
                        TaskNode aux = (TaskNode) hijo.getNodeType();
                        jTabbedPane2.setTitleAt(0, aux.getComandoPrincipal());
                        jTextFieldRutaPlantilla.setText(aux.rutaPlantilla);
                        
                        if(hijo.getNodeType() instanceof TaskNode){
                            TaskNode taskNode = (TaskNode) hijo.getNodeType();
                            /*JLabel comandoprincipal = new JLabel();
                            comandoprincipal.setText(taskNode.getComandoPrincipal());
                            comandoprincipal.setLocation(60, 1);
                            comandoprincipal.setSize(100, 25);
                            Component com = comandoprincipal;
                            jPanel1.add(com);*/
                            for(Component param : taskNode.mostrar()){
                                jPanel1.add(param);
                            }
                            jPanel1.revalidate();
                            jPanel1.repaint();
                            jTabbedPane2.revalidate();
                            jTabbedPane2.repaint();
                            
                            
                            
                        }
                        else{
                            jPanel1.removeAll();
                            jPanel1.repaint();

                        }
                    }
                    catch(Exception ex){
                        jPanel1.removeAll();
                        jPanel1.repaint();
                    }
                    
                }
                
            }
        }
    }//GEN-LAST:event_ProyectosTreeMousePressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        StructXML proyecto = new StructXML();
        for(int i = 0; i < root.getChildCount(); i++){
            CustomMutableTreeNode exp = (CustomMutableTreeNode) modelo.getChild(root, i);
            proyecto.guardarProyecto(modelo, exp);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        CustomMutableTreeNode nodo = (CustomMutableTreeNode) ProyectosTree.getLastSelectedPathComponent();
        TreePath path = ProyectosTree.getSelectionPath();
        Rectangle pathBounds = ProyectosTree.getUI().getPathBounds(ProyectosTree, path);
        if(pathBounds != null)
        {
            CustomMutableTreeNode hijo = (CustomMutableTreeNode) path.getLastPathComponent();
            if(hijo.getNodeType() instanceof TaskNode){
                TaskNode taskNode = (TaskNode) hijo.getNodeType();
                for(int i = 0; i < taskNode.parametros.size(); i++){
                    int compTam = taskNode.parametros.get(i).mostrar().size();
                    for(int j = 0; j < compTam; j++){
                        if(taskNode.parametros.get(i).mostrar().get(j) instanceof JTextField){
                            JTextField aux = (JTextField)taskNode.parametros.get(i).mostrar().get(j);
                            aux.setText("");
                        }      
                    }
                }
            }
        }
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        StructXML guardarExp = new StructXML();
        CustomMutableTreeNode exp = (CustomMutableTreeNode) ProyectosTree.getLastSelectedPathComponent();
        CustomMutableTreeNode exp_aux = (CustomMutableTreeNode) ProyectosTree.getLastSelectedPathComponent();
        while(exp_aux != root){
            if(exp_aux.getParent().equals(root)){
                exp = exp_aux;
                break;
            }
            else{
                exp_aux = (CustomMutableTreeNode) exp_aux.getParent();
            }
            
        }
        guardarExp.guardarProyecto(modelo, exp);
        JOptionPane.showMessageDialog(new JFrame(), "Experiment saved.", "Saved", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonCambiarPlantillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCambiarPlantillaActionPerformed
        String rutaEsquema = "assets/schemas/xmlschematarea.xsd";
        jPanel1.removeAll();
        jPanel1.revalidate();
        jPanel1.repaint();
        jTabbedPane2.setTitleAt(0, "");
        String nuevaRuta = "";
        
        
        CustomMutableTreeNode hijo = (CustomMutableTreeNode) ProyectosTree.getLastSelectedPathComponent();
        
        
        if(hijo.getNodeType() instanceof TaskNode){
            
            JFileChooser jFileChooser1 = new JFileChooser();
            jFileChooser1.setFileSelectionMode(jFileChooser1.FILES_ONLY);
            jFileChooser1.setFileFilter(new FileNameExtensionFilter("XML files (*.xml)", "xml"));
            int boton = jFileChooser1.showOpenDialog(jFileChooser1);
            
            if (boton == jFileChooser1.APPROVE_OPTION){ //Si el usuario ha pulsado la opción Aceptar
                File fichero = jFileChooser1.getSelectedFile(); //Guardamos en la variable fichero el archivo seleccionado
                try {
                  nuevaRuta = fichero.getAbsolutePath();
                } catch (Exception ex) {
                  System.out.println("There was a problem when trying to access the file "+fichero.getAbsolutePath());
                }
            }
            
            Boolean valido = false;
            Validacion v = new Validacion(rutaEsquema, nuevaRuta);
            valido = v.validar();

            if(valido){
                TaskNode aux = (TaskNode) hijo.getNodeType();
                aux.clearParametros();
                aux.setRutaPlantilla(nuevaRuta);
                StructXML cargar = new StructXML();
                aux.setPlantXML(cargar.CargarPlantillaXML(aux.getRutaPlantilla()));
                //Metemos los parametros de la plantilla
                StructXML xmlRead = new StructXML();
                ArrayList<String> etiquetas = new ArrayList<>();
                ArrayList<String> tipo = new ArrayList<>();
                ArrayList<Boolean> obligatorio = new ArrayList<>();
                ArrayList<String> comandoPrin = new ArrayList<>();
                xmlRead.leerEtiquetas(comandoPrin, aux.getPlantXML(), etiquetas, tipo, obligatorio, aux);
                aux.setComandoPrincipal(comandoPrin.get(0));
                for(int i = 0; i < etiquetas.size(); i++){  //Creamos los objetos de la clase de parámetro 
                    if(tipo.get(i).equals("fichero")){
                        FileParam parametro = new FileParam(etiquetas.get(i), (i+1)*50, obligatorio.get(i));
                        aux.parametros.add(parametro);
                    }
                    else if(tipo.get(i).equals("string")){
                        StringParam parametro = new StringParam(etiquetas.get(i), (i+1)*50, obligatorio.get(i));
                        aux.parametros.add(parametro);
                    }
                    /*lse if(tipo.get(i).equals("booleano")){
                        SParam parametro = new StringParam(etiquetas.get(i), (i+1)*50, obligatorio.get(i));
                        aux.parametros.add(parametro);
                    }*/
                }

                jPanel1.setLayout(null);
                jTextFieldRutaPlantilla.setText(aux.rutaPlantilla);
                TaskNode taskNode = (TaskNode) hijo.getNodeType();
                for(Component param : taskNode.mostrar()){
                        jPanel1.add(param);
                }
                jTabbedPane2.setTitleAt(0, aux.getComandoPrincipal());
                jTabbedPane2.validate();
                jTabbedPane2.repaint();
                jPanel1.validate();
                jPanel1.repaint();
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "The XML file structure is not correct.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
    }//GEN-LAST:event_jButtonCambiarPlantillaActionPerformed

    private void jButtonGuardarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarSalidaActionPerformed
        consolaText = "  "+jTextAreaConsola.getText();
        WindowsInstances.dialogoGuardarConsola.setVisible(true);
    }//GEN-LAST:event_jButtonGuardarSalidaActionPerformed

    private void jButtonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEjecutarActionPerformed
        //SOLO CUANDO ES UNA TAREA
        CustomMutableTreeNode hijo = (CustomMutableTreeNode) ProyectosTree.getLastSelectedPathComponent();
        if(hijo.getNodeType() instanceof TaskNode){
            TaskNode taskNode = (TaskNode) hijo.getNodeType();
            taskNode.ejecutar();
            if(!jTextAreaConsola.getText().equals("")){
                jButtonGuardarSalida.setEnabled(true);
                jButtonLimpiarSalida.setEnabled(true);
            }
        }
        
    }//GEN-LAST:event_jButtonEjecutarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        for(int i = 0; i < root.getChildCount(); i++){
            CustomMutableTreeNode nodo = (CustomMutableTreeNode) root.getChildAt(i);
            ExperimentNode aux = (ExperimentNode) nodo.getNodeType();
            aux.ejecutar_rec(nodo);
        }
        if (!jTextAreaConsola.getText().equals("")) {
            jButtonGuardarSalida.setEnabled(true);
            jButtonLimpiarSalida.setEnabled(true);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        String rutaProyecto = "";
        String rutaEsquema = "assets/schemas/xmlschemaproyecto.xsd";

        JFileChooser jFileChooser1 = new JFileChooser();
        jFileChooser1.setFileSelectionMode(jFileChooser1.FILES_ONLY);
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("XML files (*.xml)", "xml"));
        int boton = jFileChooser1.showOpenDialog(this);
        if (boton == jFileChooser1.APPROVE_OPTION) { //Si el usuario ha pulsado la opción Aceptar
            File fichero = jFileChooser1.getSelectedFile(); //Guardamos en la variable fichero el archivo seleccionado
            try {
                // What to do with the file, e.g. display it in a TextArea
                //CreateDirectoryGUI.LocalizacionTextField.setText.read( new FileReader( file.getAbsolutePath() ), null );
                rutaProyecto = fichero.getAbsolutePath();
            } catch (Exception ex) {
                System.out.println("problem accessing file" + fichero.getAbsolutePath());
            }

            Boolean valido = false;
            Validacion v = new Validacion(rutaEsquema, rutaProyecto);
            valido = v.validar();

            if (valido) {
                StructXML proyectoXML = new StructXML();
                Document proyecto = proyectoXML.CargarProyecto(rutaProyecto);
                String rutaNueva = proyecto.getElementsByTagName("proyecto").item(0).getAttributes().getNamedItem("ruta").getNodeValue();
                String nombreProyecto = proyecto.getElementsByTagName("proyecto").item(0).getAttributes().getNamedItem("nombre").getNodeValue();

                CustomJDialog jDialog = new CustomJDialog(rutaNueva);
                jDialog.setModal(true);
                jDialog.setVisible(true);

                File directorio = new File(jDialog.getRuta() + System.lineSeparator() + nombreProyecto);
                directorio.mkdir();

                Element nuevoNodo = (Element) proyecto.getElementsByTagName("nodo").item(0);
                metodoCrearNodos(root, nuevoNodo, proyecto, jDialog.getRuta() + System.lineSeparator() + nombreProyecto);
                this.modelo.reload();
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "The XML file structure is not correct.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void guardarSalidajMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarSalidajMenuItemActionPerformed
        consolaText = "  "+jTextAreaConsola.getText();
        WindowsInstances.dialogoGuardarConsola.setVisible(true);
    }//GEN-LAST:event_guardarSalidajMenuItemActionPerformed

    private void limpiarConsolajMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarConsolajMenuItemActionPerformed
        jTextAreaConsola.setText("");
        jTextAreaConsola.repaint();
        consolaText = "";
        jButtonGuardarSalida.setEnabled(false);
        jButtonLimpiarSalida.setEnabled(false);
    }//GEN-LAST:event_limpiarConsolajMenuItemActionPerformed

    private void paraLinuxjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paraLinuxjMenuItemActionPerformed
        String comando = "#!/bin/bash \n ";
        String mensajeError = "";
        CustomMutableTreeNode TaskAux = (CustomMutableTreeNode) ProyectosTree.getLastSelectedPathComponent();
        TaskNode taskNode = (TaskNode) TaskAux.getNodeType();
        comando = comando + taskNode.getComandoPrincipal() +" ";
        for(int i = 0; i < taskNode.parametros.size(); i++){
            JTextField jTextAux = (JTextField) taskNode.parametros.get(i).mostrar().get(1);
            JLabel jLabelAux = (JLabel) taskNode.parametros.get(i).mostrar().get(0);
            if(taskNode.parametros.get(i).isObligatorio() && jTextAux.getText().equals("")){
                mensajeError = mensajeError + jLabelAux.getText() + ", ";
            }else{
                comando = comando + taskNode.parametros.get(i).ejecutar();
            }
        }
        
        String file = "";
        JFileChooser jFileChooser1 = new JFileChooser();
        jFileChooser1.setFileSelectionMode(jFileChooser1.DIRECTORIES_ONLY);
        int boton = jFileChooser1.showOpenDialog(this);
        if (boton == jFileChooser1.APPROVE_OPTION){ //Si el usuario ha pulsado la opción Aceptar
            File fichero = jFileChooser1.getSelectedFile(); //Guardamos en la variable fichero el archivo seleccionado
            try {
              // What to do with the file, e.g. display it in a TextArea
              //CreateDirectoryGUI.LocalizacionTextField.setText.read( new FileReader( file.getAbsolutePath() ), null );
              file = fichero.getAbsolutePath();
            } catch (Exception ex) {
              System.out.println("problem accessing file"+fichero.getAbsolutePath());
            }
        }
        BufferedWriter bw = null;
        FileWriter fw = null;
        String sep = "/"; // File.separator;    //SEPARADOR
        comando = comando.replace("\\", Matcher.quoteReplacement(sep));
        try {
            String content = comando;
            fw = new FileWriter(file+File.separator+TaskAux.getNombre());
            bw = new BufferedWriter(fw);
            bw.write(content);
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {

                if (bw != null)
                        bw.close();

                if (fw != null)
                        fw.close();

            } catch (IOException ex) {

                    ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_paraLinuxjMenuItemActionPerformed

    private void paraWindowsjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paraWindowsjMenuItemActionPerformed
        CustomMutableTreeNode TaskAux = (CustomMutableTreeNode) ProyectosTree.getLastSelectedPathComponent();
        TaskNode taskNode = (TaskNode) TaskAux.getNodeType();
        String comando = taskNode.getComandoPrincipal();
        String mensajeError = "";
        for(int i = 0; i < taskNode.parametros.size(); i++){
            JTextField jTextAux = (JTextField) taskNode.parametros.get(i).mostrar().get(1);
            JLabel jLabelAux = (JLabel) taskNode.parametros.get(i).mostrar().get(0);
            if(taskNode.parametros.get(i).isObligatorio() && jTextAux.getText().equals("")){
                mensajeError = mensajeError + jLabelAux.getText() + ", ";
            }else{
                comando = comando + taskNode.parametros.get(i).ejecutar();
            }
        }
        
        String file = "";
        JFileChooser jFileChooser1 = new JFileChooser();
        jFileChooser1.setFileSelectionMode(jFileChooser1.DIRECTORIES_ONLY);
        int boton = jFileChooser1.showOpenDialog(this);
        if (boton == jFileChooser1.APPROVE_OPTION){ //Si el usuario ha pulsado la opción Aceptar
            File fichero = jFileChooser1.getSelectedFile(); //Guardamos en la variable fichero el archivo seleccionado
            try {
              // What to do with the file, e.g. display it in a TextArea
              //CreateDirectoryGUI.LocalizacionTextField.setText.read( new FileReader( file.getAbsolutePath() ), null );
              file = fichero.getAbsolutePath();
            } catch (Exception ex) {
              System.out.println("problem accessing file"+fichero.getAbsolutePath());
            }
        }
        BufferedWriter bw = null;
        FileWriter fw = null;
        String sep = "\\"; // File.separator;    //SEPARADOR
        comando = comando.replace("/", Matcher.quoteReplacement(sep));
        try {
            String content = comando;
            fw = new FileWriter(file+File.separator+TaskAux.getNombre());
            bw = new BufferedWriter(fw);
            bw.write(content);
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {

                if (bw != null)
                        bw.close();

                if (fw != null)
                        fw.close();

            } catch (IOException ex) {

                    ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_paraWindowsjMenuItemActionPerformed

    private void ProyectosTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ProyectosTreeValueChanged
        if(evt.getPath().getLastPathComponent() instanceof CustomMutableTreeNode) {
            CustomMutableTreeNode customMutableTreeNode =  (CustomMutableTreeNode) evt.getPath().getLastPathComponent();
            stateLabel.setText(customMutableTreeNode.getNombre() + " selected");
        }
        else {
            stateLabel.setText("");
        }
    }//GEN-LAST:event_ProyectosTreeValueChanged

    private void ProyectosTreeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProyectosTreeKeyReleased
        if(ProyectosTree.getSelectionPath().getLastPathComponent() instanceof CustomMutableTreeNode) {
            CustomMutableTreeNode customMutableTreeNode = (CustomMutableTreeNode) ProyectosTree.getSelectionPath().getLastPathComponent();
            stateLabel.setText(customMutableTreeNode.getNombre() + " selected");
        }
    }//GEN-LAST:event_ProyectosTreeKeyReleased

    private void jButtonGuardarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarTodosActionPerformed
        StructXML proyecto = new StructXML();
        for(int i = 0; i < root.getChildCount(); i++){
            CustomMutableTreeNode exp = (CustomMutableTreeNode) modelo.getChild(root, i);
            proyecto.guardarProyecto(modelo, exp);
        }
    }//GEN-LAST:event_jButtonGuardarTodosActionPerformed

    private void jButtonLimpiarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarSalidaActionPerformed
        jTextAreaConsola.setText("");
        jTextAreaConsola.repaint();
        consolaText = "";
        jButtonGuardarSalida.setEnabled(false);
        jButtonLimpiarSalida.setEnabled(false);
    }//GEN-LAST:event_jButtonLimpiarSalidaActionPerformed

    public void metodoCrearNodos(DefaultMutableTreeNode padre, Element nuevoNodo,Document proyecto, String rutaPr ){
        if(nuevoNodo.getAttributes().getNamedItem("tipo").getNodeValue().equals("experimento")){
            
            INodeType nodoExp = new ExperimentNode();  
            CustomMutableTreeNode nodo = new CustomMutableTreeNode(nuevoNodo.getAttributes().getNamedItem("nombre").getNodeValue());
            nodo.setNodeType(nodoExp);
            nodo.setNombre(nuevoNodo.getAttributes().getNamedItem("nombre").getNodeValue());
            ExperimentNode n = (ExperimentNode) nodo.getNodeType();
            n.setRutaCarpeta(rutaPr);
            WindowsInstances.mainGUI.setProyectosTree(nodo);
            String nombrenodo = nodo.getUserObject().toString();
            WindowsInstances.createClasificadorGUI.setCombo(nombrenodo);
            WindowsInstances.createTareaGUI.setExpCombo(nombrenodo);  
            
            Element nodosHijos = (Element)nuevoNodo.getElementsByTagName("nodos").item(0);
            NodeList listanodos = nodosHijos.getElementsByTagName("nodo");
            for(int i = 0; i < listanodos.getLength(); i++){  
                if(listanodos.item(i).getAttributes().getNamedItem("tipo").getNodeValue().equals("clasificador")){
                     Node nodoParametro = listanodos.item(i);
                    Element parametro = (Element)nodoParametro;
                    metodoCrearNodos((CustomMutableTreeNode)nodo, parametro, proyecto, rutaPr);
                }
               
            }
            
            /*
            expNod.setRutaCarpeta(rutaPr);
            nodo.setNodeType(expNod);
             ProyectosTree.setCellRenderer(new DefaultTreeCellRenderer() {
            
            @Override
            public Component getTreeCellRendererComponent(JTree tree,
                    Object value, boolean selected, boolean expanded,
                    boolean isLeaf, int row, boolean focused) {
                Component c = super.getTreeCellRendererComponent(tree, value,
                        selected, expanded, isLeaf, row, focused);

                    if (value instanceof CustomMutableTreeNode) {
                    CustomMutableTreeNode nodo = (CustomMutableTreeNode) value;
                    setIcon(nodo.getNodeType().getIcon());
                }
                
                return this;
   
            }
        });
            padre.add(nodo);
            Element nodosHijos = (Element)nuevoNodo.getElementsByTagName("nodos").item(0);
            NodeList listanodos = nodosHijos.getElementsByTagName("nodo");
            for(int i = 0; i < listanodos.getLength(); i++){  
                if(listanodos.item(i).getAttributes().getNamedItem("tipo").getNodeValue().equals("clasificador")){
                     Node nodoParametro = listanodos.item(i);
                    Element parametro = (Element)nodoParametro;
                    metodoCrearNodos((CustomMutableTreeNode)nodo, parametro, proyecto, rutaPr);
                }
               
            }*/
        }
        else if(nuevoNodo.getAttributes().getNamedItem("tipo").getNodeValue().equals("clasificador")){
            
            CustomMutableTreeNode nodo = new CustomMutableTreeNode(nuevoNodo.getAttributes().getNamedItem("nombre").getNodeValue());
            nodo.setNombre(nuevoNodo.getAttributes().getNamedItem("nombre").getNodeValue());
            INodeType nodoExp = new ClassifierNode();
            nodo.setNodeType(nodoExp);
            ClassifierNode n = (ClassifierNode) nodo.getNodeType();
            
            WindowsInstances.mainGUI.setProyectosTree(nodo, (CustomMutableTreeNode)padre);
            
            ParClasificador par = new ParClasificador(proyecto.getElementsByTagName("nodo").item(0).getAttributes().getNamedItem("nombre").getNodeValue(), nuevoNodo.getAttributes().getNamedItem("nombre").getNodeValue());
            WindowsInstances.createClasificadorGUI.paresExCL.add(par);
            WindowsInstances.createClasificadorGUI.setClasCombo(nuevoNodo.getAttributes().getNamedItem("nombre").getNodeValue());
            WindowsInstances.createTareaGUI.setExpCombo(proyecto.getElementsByTagName("nodo").item(0).getAttributes().getNamedItem("nombre").getNodeValue());
            CustomMutableTreeNode padreCN = (CustomMutableTreeNode) padre;
            if(padreCN.getNodeType() instanceof ExperimentNode){
                ExperimentNode en = (ExperimentNode) padreCN.getNodeType();
                n.setRutaCarpeta(en.getRutaCarpeta());
            }
            else{
                CustomMutableTreeNode cm = (CustomMutableTreeNode) nodo.getParent();
                ClassifierNode cn = (ClassifierNode) cm.getNodeType();
                n.setRutaCarpeta(cn.getRutaCarpeta());
            }
            
            try{
                Element nodosHijos = (Element)nuevoNodo.getElementsByTagName("nodos").item(0);
                NodeList listanodos = nodosHijos.getElementsByTagName("nodo");
                for(int i = 0; i < listanodos.getLength(); i++){  
                    Node nodoParametro = listanodos.item(i);
                    Element parametro = (Element)nodoParametro;
                    metodoCrearNodos((CustomMutableTreeNode)nodo, parametro, proyecto, rutaPr);
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            } 
            
            /*CustomMutableTreeNode nodo = new CustomMutableTreeNode(nuevoNodo.getAttributes().getNamedItem("nombre").getNodeValue());
            ClassifierNode Clanodo = new ClassifierNode();
            Clanodo.setRutaCarpeta(rutaPr);
            nodo.setNodeType(Clanodo);
             ProyectosTree.setCellRenderer(new DefaultTreeCellRenderer() {
            
            @Override
            public Component getTreeCellRendererComponent(JTree tree,
                    Object value, boolean selected, boolean expanded,
                    boolean isLeaf, int row, boolean focused) {
                Component c = super.getTreeCellRendererComponent(tree, value,
                        selected, expanded, isLeaf, row, focused);

                    if (value instanceof CustomMutableTreeNode) {
                    CustomMutableTreeNode nodo = (CustomMutableTreeNode) value;
                    setIcon(nodo.getNodeType().getIcon());
                }
                
                return this;
   
            }
        });
            padre.add(nodo);
            try{
                Element nodosHijos = (Element)nuevoNodo.getElementsByTagName("nodos").item(0);
                NodeList listanodos = nodosHijos.getElementsByTagName("nodo");
                for(int i = 0; i < listanodos.getLength(); i++){  
                    Node nodoParametro = listanodos.item(i);
                    Element parametro = (Element)nodoParametro;
                    metodoCrearNodos((CustomMutableTreeNode)nodo, parametro, proyecto, rutaPr);
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            } */
        }
        else if(nuevoNodo.getAttributes().getNamedItem("tipo").getNodeValue().equals("tarea")){
            
            CustomMutableTreeNode nodo = new CustomMutableTreeNode(nuevoNodo.getAttributes().getNamedItem("nombre").getNodeValue());

                String rutaPlantilla = nuevoNodo.getElementsByTagName("plantilla").item(0).getAttributes().getNamedItem("ruta").getNodeValue();

            
                //Cargar Plantilla
                Document plantilla = null;
                StructXML cargar = new StructXML();
                plantilla = cargar.CargarPlantillaXML(rutaPlantilla);
                
                INodeType nodoExp = new TaskNode(rutaPlantilla, plantilla);   
                nodo.setNodeType(nodoExp);
                nodo.setNombre(nuevoNodo.getAttributes().getNamedItem("nombre").getNodeValue());
                TaskNode n = (TaskNode) nodo.getNodeType();
                n.setRutaPlantilla(rutaPlantilla);
                //Metemos los parametros de la plantilla
                StructXML xmlRead = new StructXML();
                ArrayList<String> etiquetas = new ArrayList<>();
                ArrayList<String> tipo = new ArrayList<>();
                ArrayList<Boolean> obligatorio = new ArrayList<>();
                
                HashMap valores = new HashMap();
                ArrayList<String> comandoPrin = new ArrayList<>();
                xmlRead.leerEtiquetas(comandoPrin, n.getPlantXML(), etiquetas, tipo, obligatorio, n);
                n.setComandoPrincipal(comandoPrin.get(0));
                Element parametros = (Element) nuevoNodo.getElementsByTagName("parametros").item(0);
                NodeList listanodos = parametros.getElementsByTagName("parametro");
                for(int i = 0; i < listanodos.getLength(); i++){  
                    Node nodoParametro = listanodos.item(i);
                    Element parametro = (Element)nodoParametro;
                    valores.put(parametro.getAttributes().getNamedItem("nombre").getNodeValue(), parametro.getAttributes().getNamedItem("valor").getNodeValue());
                }
                
                for(int i = 0; i < etiquetas.size(); i++){
                    if(tipo.get(i).equals("fichero")){
                        FileParam parametro = null;
                        if(valores.containsKey(etiquetas.get(i))){
                            String aux = valores.get(etiquetas.get(i)).toString();
                            parametro = new FileParam(etiquetas.get(i), aux , (i+1)*25, obligatorio.get(i));
                        }else{
                            parametro = new FileParam(etiquetas.get(i), (i+1)*25, obligatorio.get(i));
                        }
                        n.parametros.add(parametro);
                    }
                    else if(tipo.get(i).equals("string")){
                        StringParam parametro = null;
                        if(valores.containsKey(etiquetas.get(i))){
                            String aux = valores.get(etiquetas.get(i)).toString();
                            parametro = new StringParam(etiquetas.get(i), aux , (i+1)*25, obligatorio.get(i));
                        }else{
                            parametro = new StringParam(etiquetas.get(i), (i+1)*25, obligatorio.get(i));
                        }
                        n.parametros.add(parametro);
                    }
                }
                
                WindowsInstances.mainGUI.setProyectosTree(nodo, (CustomMutableTreeNode) padre);
                CustomMutableTreeNode cn = (CustomMutableTreeNode) nodo.getParent();
                ClassifierNode cln = (ClassifierNode) cn.getNodeType();
                n.setRutaPlantilla(rutaPlantilla);
                
            /*CustomMutableTreeNode nodo = new CustomMutableTreeNode(nuevoNodo.getAttributes().getNamedItem("nombre").getNodeValue());
            String rutaPlantilla = nuevoNodo.getAttributes().getNamedItem("plantilla").getNodeValue();
            StructXML cargarPlantilla = new StructXML();
            Document pantillaXML = cargarPlantilla.CargarPlantillaXML(rutaPlantilla);
            TaskNode tasknodo = new TaskNode(rutaPlantilla, pantillaXML);
            nodo.setNodeType(tasknodo);
             ProyectosTree.setCellRenderer(new DefaultTreeCellRenderer() {
            
            @Override
            public Component getTreeCellRendererComponent(JTree tree,
                    Object value, boolean selected, boolean expanded,
                    boolean isLeaf, int row, boolean focused) {
                Component c = super.getTreeCellRendererComponent(tree, value,
                        selected, expanded, isLeaf, row, focused);

                    if (value instanceof CustomMutableTreeNode) {
                    CustomMutableTreeNode nodo = (CustomMutableTreeNode) value;
                    setIcon(nodo.getNodeType().getIcon());
                }
                
                return this;
   
            }
        });
            padre.add(nodo);*/
        }
    }
    
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
        renderer.setLeafIcon(nodo.getNodeType().getIcon());
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
        //Se crea el icono
        ProyectosTree.setCellRenderer(new DefaultTreeCellRenderer() {
            
            @Override
            public Component getTreeCellRendererComponent(JTree tree,
                    Object value, boolean selected, boolean expanded,
                    boolean isLeaf, int row, boolean focused) {
                Component c = super.getTreeCellRendererComponent(tree, value,
                        selected, expanded, isLeaf, row, focused);

                    if (value instanceof CustomMutableTreeNode) {
                    CustomMutableTreeNode nodo = (CustomMutableTreeNode) value;
                    setIcon(nodo.getNodeType().getIcon());
                }
                
                return this;
   
            }
        });
        ProyectosTree.setShowsRootHandles(true);
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
    
    public void ejecutar(TaskNode taskNode) throws IOException, PrinterException{
        String comando = taskNode.getComandoPrincipal();
        String mensajeError = "";
        for(int i = 0; i < taskNode.parametros.size(); i++){
            JTextField jTextAux = (JTextField) taskNode.parametros.get(i).mostrar().get(1);
            JLabel jLabelAux = (JLabel) taskNode.parametros.get(i).mostrar().get(0);
            if(taskNode.parametros.get(i).isObligatorio() && jTextAux.getText().equals("")){
                mensajeError = mensajeError + jLabelAux.getText() + ", ";
            }else{
                comando = comando + taskNode.parametros.get(i).ejecutar();
            }
        }
        
        if(mensajeError.equals("")){
            Console cmd = new Console(comando);
            jTextAreaConsola.setText(jTextAreaConsola.getText()+"\n\n > Task: "+taskNode.toString()+"\n "+comando +"\n " +cmd.ejecutarComando());
            
            try {
                taskNode.icono = new ImageIcon(getClass().getResource("/assets/treeIcons/TaskIconCorrecto.png"));
            } catch (NullPointerException e) {
                taskNode.icono = new ImageIcon("assets/treeIcons/TaskIconCorrecto.png");
            }
        }
        else{
            jTextAreaConsola.setText(jTextAreaConsola.getText()+"\n\n > Task: "+taskNode.toString()+"\n ERROR. Required fields empty: "+mensajeError.substring(0, mensajeError.length()-2));
            
            try {
                taskNode.icono = new ImageIcon(getClass().getResource("/assets/treeIcons/TaskIconIncorrecto.png"));
            } catch (NullPointerException e) {
                taskNode.icono = new ImageIcon("assets/treeIcons/TaskIconIncorrecto.png");
            }
        }
        
        ProyectosTree.revalidate();
        ProyectosTree.repaint();
    }
    

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarrajMenu;
    private javax.swing.JTree ProyectosTree;
    private javax.swing.JMenu archivosjMenu;
    private javax.swing.JMenuItem clasificajMenu;
    private javax.swing.JMenu consolajMenu;
    private javax.swing.JMenu crearScriptjMenu;
    private javax.swing.JMenuItem experjMenu;
    private javax.swing.JMenuItem guardarSalidajMenuItem;
    private javax.swing.JMenu herramientasjMenu;
    private javax.swing.JButton jButtonCambiarPlantilla;
    private javax.swing.JButton jButtonEjecutar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonGuardarSalida;
    private javax.swing.JButton jButtonGuardarTodos;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonLimpiarSalida;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextArea jTextAreaConsola;
    private javax.swing.JTextField jTextFieldRutaPlantilla;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JMenuItem limpiarConsolajMenuItem;
    private javax.swing.JMenu nuevojMenu;
    private javax.swing.JMenuItem paraLinuxjMenuItem;
    private javax.swing.JMenuItem paraWindowsjMenuItem;
    private javax.swing.JMenu runjMenu;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JMenuItem tareajMenu;
    // End of variables declaration//GEN-END:variables


}
