package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import TaskParam.FileParam;
import TaskParam.StringParam;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
        jButtonLimpiar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButtonCambiarPlantilla = new javax.swing.JButton();
        jTextFieldRutaPlantilla = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButtonEjecutar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        jPanelLabels = new javax.swing.JPanel();
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

        jTabbedPane3.addTab("Consola", jScrollPane2);

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

        jToolBar1.setRollover(true);

        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.setFocusable(false);
        jButtonLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonLimpiar);

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setFocusable(false);
        jButtonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonGuardar);
        jToolBar1.add(jSeparator1);

        jButtonCambiarPlantilla.setText("Cambiar Plantill");
        jButtonCambiarPlantilla.setFocusable(false);
        jButtonCambiarPlantilla.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCambiarPlantilla.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCambiarPlantilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCambiarPlantillaActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonCambiarPlantilla);

        jTextFieldRutaPlantilla.setEnabled(false);
        jToolBar1.add(jTextFieldRutaPlantilla);
        jToolBar1.add(jSeparator2);

        jButtonEjecutar.setText("Ejecutar");
        jButtonEjecutar.setFocusable(false);
        jButtonEjecutar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEjecutar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEjecutarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonEjecutar);
        jToolBar1.add(jSeparator3);

        jButton1.setText("Guardar Salida");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jPanelLabels.setAutoscrolls(true);

        javax.swing.GroupLayout jPanelLabelsLayout = new javax.swing.GroupLayout(jPanelLabels);
        jPanelLabels.setLayout(jPanelLabelsLayout);
        jPanelLabelsLayout.setHorizontalGroup(
            jPanelLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelLabelsLayout.setVerticalGroup(
            jPanelLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

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

        jMenuItem2.setText("Abrir Experimento");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        archivosjMenu.add(jMenuItem2);

        jMenuItem1.setText("Guardar Todo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        archivosjMenu.add(jMenuItem1);

        BarrajMenu.add(archivosjMenu);

        runjMenu.setText("Run");

        jMenuItem3.setText("Ejecutar Todos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        runjMenu.add(jMenuItem3);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelLabels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanelLabels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1))
                .addGap(8, 8, 8))
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
            if(SwingUtilities.isLeftMouseButton(evt)){  //Si es nodo tarea muestra la ventana principal con los campos del xml
                
                jPanelLabels.removeAll();
                
                TreePath path = ProyectosTree.getPathForLocation(evt.getX(), evt.getY());
                Rectangle pathBounds = ProyectosTree.getUI().getPathBounds(ProyectosTree, path);
                if(pathBounds != null && pathBounds.contains(evt.getX (), evt.getY ()))
                {
                    try{
                        CustomMutableTreeNode hijo = (CustomMutableTreeNode) path.getLastPathComponent();
                        jPanelLabels.setLayout(null);
                        TaskNode aux = (TaskNode) hijo.getNodeType();
                        jTextFieldRutaPlantilla.setText(aux.rutaPlantilla);
                        if(hijo.getNodeType() instanceof TaskNode){
                            TaskNode taskNode = (TaskNode) hijo.getNodeType();
                            for(Component param : taskNode.mostrar()){
                                jPanelLabels.add(param);
                            }
                            jPanelLabels.validate();
                            jPanelLabels.repaint();
                        }
                        else{
                            jPanelLabels.removeAll();
                            jPanelLabels.repaint();
                        }
                    }
                    catch(Exception ex){
                        jPanelLabels.removeAll();
                        jPanelLabels.repaint();
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
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonCambiarPlantillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCambiarPlantillaActionPerformed
        jPanelLabels.removeAll();
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
                  System.out.println("Hubo un problema al intentar acceder al fichero "+fichero.getAbsolutePath());
                }
            }
            
            
            TaskNode aux = (TaskNode) hijo.getNodeType();
            aux.setRutaPlantilla(nuevaRuta);
            StructXML cargar = new StructXML();
            aux.setPlantXML(cargar.CargarPlantillaXML(aux.getRutaPlantilla()));
            //Metemos los parametros de la plantilla
            StructXML xmlRead = new StructXML();
            ArrayList<String> etiquetas = new ArrayList<>();
            ArrayList<String> tipo = new ArrayList<>();
            ArrayList<Boolean> obligatorio = new ArrayList<>();
            xmlRead.leerEtiquetas(aux.getPlantXML(), etiquetas, tipo, obligatorio, aux);
            for(int i = 0; i < etiquetas.size(); i++){  //Creamos los objetos de la clase de parámetro 
                if(tipo.get(i).equals("fichero")){
                    FileParam parametro = new FileParam(etiquetas.get(i), i*50, obligatorio.get(i));
                    aux.parametros.add(parametro);
                }
                else if(tipo.get(i).equals("string")){
                    StringParam parametro = new StringParam(etiquetas.get(i), i*50, obligatorio.get(i));
                    aux.parametros.add(parametro);
                }
            }

            jPanelLabels.setLayout(null);
            jTextFieldRutaPlantilla.setText(aux.rutaPlantilla);
            TaskNode taskNode = (TaskNode) hijo.getNodeType();
            for(Component param : taskNode.mostrar()){
                    jPanelLabels.add(param);
            }
            jPanelLabels.validate();
            jPanelLabels.repaint();   
        }
        
        
    }//GEN-LAST:event_jButtonCambiarPlantillaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        consolaText = "  "+jTextAreaConsola.getText();
        WindowsInstances.dialogoGuardarConsola.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEjecutarActionPerformed
        //SOLO CUANDO ES UNA TAREA
        CustomMutableTreeNode hijo = (CustomMutableTreeNode) ProyectosTree.getLastSelectedPathComponent();
        if(hijo.getNodeType() instanceof TaskNode){
            TaskNode taskNode = (TaskNode) hijo.getNodeType();
            taskNode.ejecutar();
        }
        
    }//GEN-LAST:event_jButtonEjecutarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        for(int i = 0; i < root.getChildCount(); i++){
            CustomMutableTreeNode nodo = (CustomMutableTreeNode) root.getChildAt(i);
            ExperimentNode aux = (ExperimentNode) nodo.getNodeType();
            aux.ejecutar_rec(nodo);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        String rutaProyecto = "";
        JFileChooser jFileChooser1 = new JFileChooser();
        jFileChooser1.setFileSelectionMode(jFileChooser1.FILES_ONLY);
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("XML files (*.xml)", "xml"));
        int boton = jFileChooser1.showOpenDialog(this);
        if (boton == jFileChooser1.APPROVE_OPTION){ //Si el usuario ha pulsado la opción Aceptar
            File fichero = jFileChooser1.getSelectedFile(); //Guardamos en la variable fichero el archivo seleccionado
            try {
              // What to do with the file, e.g. display it in a TextArea
              //CreateDirectoryGUI.LocalizacionTextField.setText.read( new FileReader( file.getAbsolutePath() ), null );
              rutaProyecto = fichero.getAbsolutePath();
            } catch (Exception ex) {
              System.out.println("problem accessing file"+fichero.getAbsolutePath());
            }
        }
 
        StructXML proyectoXML = new StructXML();
        Document proyecto = proyectoXML.CargarProyecto(rutaProyecto);
        String rutaNueva = proyecto.getElementsByTagName("proyecto").item(0).getAttributes().getNamedItem("ruta").getNodeValue();
        
        WindowsInstances.cambiarRutaExperimento.setRuta(rutaNueva);
        WindowsInstances.cambiarRutaExperimento.setVisible(true);
        
        Element nuevoNodo = (Element) proyecto.getElementsByTagName("nodo").item(0);
        metodoCrearNodos(root, nuevoNodo );
        this.modelo.reload();
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void metodoCrearNodos(DefaultMutableTreeNode padre, Element nuevoNodo ){
        if(nuevoNodo.getAttributes().getNamedItem("tipo").getNodeValue().equals("experimento")){
            CustomMutableTreeNode nodo = new CustomMutableTreeNode(nuevoNodo.getAttributes().getNamedItem("nombre").getNodeValue());
            ExperimentNode expNod = new ExperimentNode();
            expNod.setRutaCarpeta(WindowsInstances.cambiarRutaExperimento.getRuta());
            nodo.setNodeType(expNod);
            padre.add(nodo);
            Element nodosHijos = (Element)nuevoNodo.getElementsByTagName("nodos").item(0);
            NodeList listanodos = nodosHijos.getElementsByTagName("nodo");
            for(int i = 0; i < listanodos.getLength(); i++){  
                if(listanodos.item(i).getAttributes().getNamedItem("tipo").getNodeValue().equals("clasificador")){
                     Node nodoParametro = listanodos.item(i);
                    Element parametro = (Element)nodoParametro;
                    metodoCrearNodos((CustomMutableTreeNode)nodo, parametro);
                }
               
            }
        }
        else if(nuevoNodo.getAttributes().getNamedItem("tipo").getNodeValue().equals("clasificador")){
            CustomMutableTreeNode nodo = new CustomMutableTreeNode(nuevoNodo.getAttributes().getNamedItem("nombre").getNodeValue());
            ClassifierNode Clanodo = new ClassifierNode();
            Clanodo.setRutaCarpeta(WindowsInstances.cambiarRutaExperimento.getRuta());
            nodo.setNodeType(Clanodo);
            padre.add(nodo);
            try{
                Element nodosHijos = (Element)nuevoNodo.getElementsByTagName("nodos").item(0);
                NodeList listanodos = nodosHijos.getElementsByTagName("nodo");
                for(int i = 0; i < listanodos.getLength(); i++){  
                    Node nodoParametro = listanodos.item(i);
                    Element parametro = (Element)nodoParametro;
                    metodoCrearNodos((CustomMutableTreeNode)nodo, parametro);
                }
            }
            catch(Exception ex){
                //Clasificador sin tareas
            } 
        }
        else if(nuevoNodo.getAttributes().getNamedItem("tipo").getNodeValue().equals("tarea")){
            CustomMutableTreeNode nodo = new CustomMutableTreeNode(nuevoNodo.getAttributes().getNamedItem("nombre").getNodeValue());
            String rutaPlantilla = nuevoNodo.getAttributes().getNamedItem("plantilla").getNodeValue();
            StructXML cargarPlantilla = new StructXML();
            Document pantillaXML = cargarPlantilla.CargarPlantillaXML(rutaPlantilla);
            TaskNode tasknodo = new TaskNode(rutaPlantilla, pantillaXML);
            nodo.setNodeType(tasknodo);
            padre.add(nodo);
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
        String comando = "java ";
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
            jTextAreaConsola.setText(jTextAreaConsola.getText()+"\n\n > Tarea: "+taskNode.toString()+"\n "+comando +"\n " +cmd.ejecutarComando());
        }
        else{
            jTextAreaConsola.setText(jTextAreaConsola.getText()+"\n\n > Tarea: "+taskNode.toString()+"\n ERROR. Campos obligatorios vacios: "+mensajeError.substring(0, mensajeError.length()-2));
        }
        
        
                
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarrajMenu;
    private javax.swing.JTree ProyectosTree;
    private javax.swing.JMenu archivosjMenu;
    private javax.swing.JMenuItem clasificajMenu;
    private javax.swing.JMenuItem experjMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCambiarPlantilla;
    private javax.swing.JButton jButtonEjecutar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanelLabels;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextArea jTextAreaConsola;
    private javax.swing.JTextField jTextFieldRutaPlantilla;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu nuevojMenu;
    private javax.swing.JMenu runjMenu;
    private javax.swing.JMenuItem tareajMenu;
    // End of variables declaration//GEN-END:variables

    void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
