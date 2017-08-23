/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;

/**
 *
 * @author alexa
 */
public class CreateTaskGUI extends javax.swing.JFrame {
    
    String Padre;

    public String getPadre() {
        return Padre;
    }

    public void setPadre(String Padre) {
        this.Padre = Padre;
    }
    /**
     * Creates new form CreateTareaGUI
     */
    public CreateTaskGUI() {
        initComponents();
    }
    
    public void ocultarCampos () {
        ExperimentosComboBox.setVisible(false);
        ExperimentoLabel.setVisible(false);
        ClasificadorComboBox.setVisible(false);
        ClasificadorLabel.setVisible(false);
    }
    public void mostrarCampos () {
        ExperimentosComboBox.setVisible(true);
        ExperimentoLabel.setVisible(true);
        ClasificadorComboBox.setVisible(true);
        ClasificadorLabel.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jFileChooser1 = new javax.swing.JFileChooser();
        TituloLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ExperimentoLabel = new javax.swing.JLabel();
        ClasificadorLabel = new javax.swing.JLabel();
        NombreLabel = new javax.swing.JLabel();
        PlantillaLabel = new javax.swing.JLabel();
        ExperimentosComboBox = new javax.swing.JComboBox<>();
        ClasificadorComboBox = new javax.swing.JComboBox<>();
        NombreTextField = new javax.swing.JTextField();
        PlantillaTextField = new javax.swing.JTextField();
        BuscarButton = new javax.swing.JButton();
        CrearButton = new javax.swing.JButton();
        CancelarButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TituloLabel.setText("Crear tarea");

        ExperimentoLabel.setText("Experimento :");

        ClasificadorLabel.setText("Clasificador :");

        NombreLabel.setText("Nombre :");

        PlantillaLabel.setText("Plantilla :");

        ExperimentosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExperimentosComboBoxActionPerformed(evt);
            }
        });

        NombreTextField.setText("Introduzca el nombre de la tarea");

        BuscarButton.setText("Buscar");
        BuscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarButtonActionPerformed(evt);
            }
        });

        CrearButton.setText("Crear");
        CrearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearButtonActionPerformed(evt);
            }
        });

        CancelarButton.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CancelarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CrearButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(TituloLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(ExperimentoLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ExperimentosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ClasificadorLabel)
                                        .addComponent(NombreLabel)
                                        .addComponent(PlantillaLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ClasificadorComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(NombreTextField)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(PlantillaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(BuscarButton)
                                            .addGap(0, 0, Short.MAX_VALUE))))))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExperimentoLabel)
                    .addComponent(ExperimentosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClasificadorLabel)
                    .addComponent(ClasificadorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel)
                    .addComponent(NombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlantillaLabel)
                    .addComponent(PlantillaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CrearButton)
                    .addComponent(CancelarButton))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearButtonActionPerformed

        if(NombreTextField.getText() == null){
            showMessageDialog(new JFrame(), "No se puede crear una tarea sin nombre.","Error", JOptionPane.ERROR_MESSAGE);
        }
        if(PlantillaTextField.getText() == null){
            showMessageDialog(new JFrame(), "Debe asignar una plantilla a la tarea.","Error", JOptionPane.ERROR_MESSAGE);
        }
        if(ExperimentosComboBox.getSelectedItem() != null && ClasificadorComboBox.getSelectedItem() != null){
            CustomMutableTreeNode nodo = new CustomMutableTreeNode(NombreTextField.getText());
            //Cargar Plantilla
            Document plantilla = null;
            StructXML cargar = new StructXML();
            plantilla = cargar.CargarPlantillaXML(PlantillaTextField.getText());
            
            INodeType nodoExp = new TaskNode(PlantillaTextField.getText(), plantilla);
            nodo.setNodeType(nodoExp);
            TaskNode n = (TaskNode) nodo.getNodeType();
            n.setRutaPlantilla(PlantillaTextField.getText());
            WindowsInstances.mainGUI.setProyectosTree(nodo, ClasificadorComboBox.getSelectedItem());
            if(ClasificadorComboBox.getSelectedItem() == "NINGUNO"){
                CustomMutableTreeNode cn = (CustomMutableTreeNode) nodo.getParent();
                ExperimentNode en = (ExperimentNode) cn.getNodeType();
                n.setRutaDatos(en.getRutaCarpeta());
            }
            else{
                CustomMutableTreeNode cn = (CustomMutableTreeNode) nodo.getParent();
                ClassifierNode cln = (ClassifierNode) cn.getNodeType();
                n.setRutaDatos(cln.getRutaCarpeta());
            }
            //SOLUCIONAR ASIGNAR DOCUMENTO XML
            /*Document xmlFile = null;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setValidating(false);
            try{
                DocumentBuilder db = dbf.newDocumentBuilder();
                File directorio = new File(n.getRutaPlantilla());   //AQUI SALTA
                xmlFile = (Document) db.parse(directorio);
                n.setDocXML(xmlFile);
            }
            catch(IOException | ParserConfigurationException | SAXException ex){
                
            }
            
            ////////////////////////////////////////*/
            NombreTextField.setText("Introduzca el nombre de la tarea");
            WindowsInstances.mainGUI.expandAllNodes(WindowsInstances.mainGUI.getProyectosTree(),  0, WindowsInstances.mainGUI.getProyectosTree().getRowCount());
            dispose();
        }
        else{
            if(Padre != null){
                CustomMutableTreeNode nodo = new CustomMutableTreeNode(NombreTextField.getText());
                //Cargar Plantilla
                Document plantilla = null;
                StructXML cargar = new StructXML();
                plantilla = cargar.CargarPlantillaXML(PlantillaTextField.getText());
                
                INodeType nodoExp = new TaskNode(PlantillaTextField.getText(), plantilla);   
                nodo.setNodeType(nodoExp);
                TaskNode n = (TaskNode) nodo.getNodeType();
                n.setRutaPlantilla(PlantillaTextField.getText());
                WindowsInstances.mainGUI.setProyectosTree(nodo, Padre);
                if(ClasificadorComboBox.getSelectedItem() == "NINGUNO"){
                    CustomMutableTreeNode cn = (CustomMutableTreeNode) nodo.getParent();
                    ExperimentNode en = (ExperimentNode) cn.getNodeType();
                    n.setRutaDatos(en.getRutaCarpeta());
                }
                else{
                    CustomMutableTreeNode cn = (CustomMutableTreeNode) nodo.getParent();
                    ClassifierNode cln = (ClassifierNode) cn.getNodeType();
                    n.setRutaDatos(cln.getRutaCarpeta());
                }
                NombreTextField.setText("Introduzca el nombre de la tarea");
                WindowsInstances.mainGUI.expandAllNodes(WindowsInstances.mainGUI.getProyectosTree(),  0, WindowsInstances.mainGUI.getProyectosTree().getRowCount());
                dispose();
            }
            else{
                showMessageDialog(new JFrame(), "No se ha seleccionado correctamente el lugar de creación de la tarea.","Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_CrearButtonActionPerformed

    private void ExperimentosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExperimentosComboBoxActionPerformed
        ArrayList<String> clasificadoresExp = new ArrayList<String>();
        for(int i = 0; i < WindowsInstances.createClasificadorGUI.paresExCL.size(); i++){
            if(WindowsInstances.createClasificadorGUI.paresExCL.get(i).Experimento == ExperimentosComboBox.getSelectedItem()){
                clasificadoresExp.add(WindowsInstances.createClasificadorGUI.paresExCL.get(i).Clasificador);
            }
        }
        ComboBoxModel modelo = new DefaultComboBoxModel(clasificadoresExp.toArray());
        ClasificadorComboBox.setModel(modelo);
    }//GEN-LAST:event_ExperimentosComboBoxActionPerformed

    private void BuscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarButtonActionPerformed
        jFileChooser1.setFileSelectionMode(jFileChooser1.FILES_ONLY);
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("XML files (*.xml)", "xml"));
        int boton = jFileChooser1.showOpenDialog(this);
        if (boton == jFileChooser1.APPROVE_OPTION){ //Si el usuario ha pulsado la opción Aceptar
            File fichero = jFileChooser1.getSelectedFile(); //Guardamos en la variable fichero el archivo seleccionado
            try {
              // What to do with the file, e.g. display it in a TextArea
              //CreateDirectoryGUI.LocalizacionTextField.setText.read( new FileReader( file.getAbsolutePath() ), null );
              //ruta = fichero.getAbsolutePath();
              PlantillaTextField.setText(fichero.getAbsolutePath());
            } catch (Exception ex) {
              System.out.println("Hubo un problema al intentar acceder al fichero "+fichero.getAbsolutePath());
            }
        }
    }//GEN-LAST:event_BuscarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CreateTaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateTaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateTaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateTaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateTaskGUI().setVisible(true);
            }
        });
    }
    
    
    
    public void setExpCombo (String nodo){
        int i = 0;
        Boolean estaRepetido =  false;
        for(i = 0; i < ExperimentosComboBox.getItemCount(); i++){
            if(ExperimentosComboBox.getItemAt(i).toString().equals(nodo)){
                estaRepetido = true;
            }
        }
        if(estaRepetido == false){
            ExperimentosComboBox.addItem(nodo);
        }
    }
    public void setClaCombo (String nodo){
        ClasificadorComboBox.addItem(nodo);
    }
    public void eliminarExpYCla(String nodo){
        ExperimentosComboBox.removeItem(nodo);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarButton;
    private javax.swing.JButton CancelarButton;
    private javax.swing.JComboBox<String> ClasificadorComboBox;
    private javax.swing.JLabel ClasificadorLabel;
    private javax.swing.JButton CrearButton;
    private javax.swing.JLabel ExperimentoLabel;
    private javax.swing.JComboBox<String> ExperimentosComboBox;
    private javax.swing.JLabel NombreLabel;
    private javax.swing.JTextField NombreTextField;
    private javax.swing.JLabel PlantillaLabel;
    private javax.swing.JTextField PlantillaTextField;
    private javax.swing.JLabel TituloLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}