/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg;


import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Alexandra Morón Méndez
 */
public class CreateClassifierGUI extends javax.swing.JFrame {
    String Padre;
    String ruta = "";
    ArrayList<ParClasificador> paresExCL = new ArrayList<ParClasificador>();
    public String getPadre() {
        return Padre;
    }

    public void setPadre(String Padre) {
        this.Padre = Padre;
    }
    /**
     * Creates new form CreateClasificadorGUI
     */
    public CreateClassifierGUI() {
        initComponents();
    }
    
    /**
     * Creates new form CreateClasificadorGUI
     */
    public void ocultarCampos () {
        ExperimentosComboBox.setVisible(false);
        ExperimentoLabel.setVisible(false);
        ClasificadorComboBox.setVisible(false);
        jLabel1.setVisible(false);
    }
    public void mostrarCampos () {
        ExperimentosComboBox.setVisible(true);
        ExperimentoLabel.setVisible(true);
        ClasificadorComboBox.setVisible(true);
        jLabel1.setVisible(true);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ExperimentoLabel = new javax.swing.JLabel();
        NombreLabel = new javax.swing.JLabel();
        CrearButton = new javax.swing.JButton();
        CancelarButton = new javax.swing.JButton();
        ExperimentosComboBox = new javax.swing.JComboBox<>();
        NombreTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ClasificadorComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Clasificador");

        TituloLabel.setText("Crear nuevo clasificador");

        ExperimentoLabel.setText("Experimento :");

        NombreLabel.setText("Nombre :");

        CrearButton.setText("Crear");
        CrearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearButtonActionPerformed(evt);
            }
        });

        CancelarButton.setText("Cancelar");
        CancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarButtonActionPerformed(evt);
            }
        });

        ExperimentosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExperimentosComboBoxActionPerformed(evt);
            }
        });

        NombreTextField.setText("Inserte nombre del clasificador...");

        jLabel1.setText("Clasificador :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(TituloLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ExperimentoLabel)
                            .addComponent(NombreLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NombreTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ExperimentosComboBox, 0, 265, Short.MAX_VALUE)
                            .addComponent(ClasificadorComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CancelarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CrearButton)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExperimentoLabel)
                    .addComponent(ExperimentosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClasificadorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelarButton)
                    .addComponent(CrearButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearButtonActionPerformed

        if(NombreTextField.getText() == null){
            showMessageDialog(new JFrame(), "No se puede crear un clasificador sin nombre.","Error", JOptionPane.ERROR_MESSAGE);
        }
        if(Padre == null){
            CustomMutableTreeNode nodo = new CustomMutableTreeNode(NombreTextField.getText());
            INodeType nodoExp = new ClassifierNode();
            nodo.setNodeType(nodoExp);
            ClassifierNode n = (ClassifierNode) nodo.getNodeType();
            
            System.out.println(n.getRutaCarpeta());
            if(ClasificadorComboBox.getSelectedItem()!= "NINGUNO"){
                WindowsInstances.mainGUI.setProyectosTree(nodo, ClasificadorComboBox.getSelectedItem());
            }
            else{
                     WindowsInstances.mainGUI.setProyectosTree(nodo, ExperimentosComboBox.getSelectedItem());
            }
            
           
            //WindowsInstances.createTareaGUI.setClaCombo(NombreTextField.getText());

            CustomMutableTreeNode exp = new CustomMutableTreeNode();
            exp = (CustomMutableTreeNode) nodo.getParent();
            while(exp.getParent() != WindowsInstances.mainGUI.root){
                exp = (CustomMutableTreeNode) exp.getParent();
            }
            
            ParClasificador par = new ParClasificador(exp.toString(), NombreTextField.getText());
            paresExCL.add(par);
            WindowsInstances.createClasificadorGUI.setClasCombo(NombreTextField.getText());
            WindowsInstances.createTareaGUI.setExpCombo(exp.toString());
            if(ClasificadorComboBox.getSelectedItem() == "NINGUNO"){
                ExperimentNode en = (ExperimentNode) exp.getNodeType();
                n.setRutaCarpeta(en.getRutaCarpeta());
            }
            else{
                CustomMutableTreeNode cm = (CustomMutableTreeNode) nodo.getParent();
                ClassifierNode cn = (ClassifierNode) cm.getNodeType();
                n.setRutaCarpeta(cn.getRutaCarpeta());
            }
            NombreTextField.setText("Introduzca el nombre del clasificador...");
            WindowsInstances.mainGUI.expandAllNodes(WindowsInstances.mainGUI.getProyectosTree(),  0, WindowsInstances.mainGUI.getProyectosTree().getRowCount());
            dispose();
        }
        else{
            if(Padre != null){
                INodeType nodoExp = new ClassifierNode();   
                CustomMutableTreeNode nodo = new CustomMutableTreeNode(NombreTextField.getText());
                nodo.setNodeType(nodoExp);
                ClassifierNode n = (ClassifierNode) nodo.getNodeType();
                WindowsInstances.mainGUI.setProyectosTree(nodo, Padre);
                //WindowsInstances.createTareaGUI.setClaCombo(NombreTextField.getText());

                CustomMutableTreeNode exp = new CustomMutableTreeNode();
                exp = (CustomMutableTreeNode) nodo.getParent();
                while(exp.getParent() != WindowsInstances.mainGUI.root){
                    exp = (CustomMutableTreeNode) exp.getParent();
                }

                ParClasificador par = new ParClasificador(exp.toString(), NombreTextField.getText());
                paresExCL.add(par);
                WindowsInstances.createClasificadorGUI.setCombo(NombreTextField.getText());
                WindowsInstances.createTareaGUI.setExpCombo(exp.toString());
                if(ClasificadorComboBox.getSelectedItem() == "NINGUNO"){
                    ExperimentNode en = (ExperimentNode) exp.getNodeType();
                    n.setRutaCarpeta(en.getRutaCarpeta());
                }
                else{
                    CustomMutableTreeNode cm = (CustomMutableTreeNode) nodo.getParent();
                    ClassifierNode cn = (ClassifierNode) cm.getNodeType();
                    n.setRutaCarpeta(cn.getRutaCarpeta());
                }
                NombreTextField.setText("Introduzca el nombre del clasificador...");
                WindowsInstances.mainGUI.expandAllNodes(WindowsInstances.mainGUI.getProyectosTree(),  0, WindowsInstances.mainGUI.getProyectosTree().getRowCount());
                dispose();
            }
            else{
                showMessageDialog(new JFrame(), "No se ha seleccionado correctamente el lugar de creación del clasificador.","Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_CrearButtonActionPerformed

    private void CancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarButtonActionPerformed
        WindowsInstances.mainGUI.expandAllNodes(WindowsInstances.mainGUI.getProyectosTree(),  0, WindowsInstances.mainGUI.getProyectosTree().getRowCount());
        dispose();
    }//GEN-LAST:event_CancelarButtonActionPerformed

    private void ExperimentosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExperimentosComboBoxActionPerformed
         ArrayList<String> clasificadoresExp = new ArrayList<>();
        for(int i = 0; i < WindowsInstances.createClasificadorGUI.paresExCL.size(); i++){
            if(WindowsInstances.createClasificadorGUI.paresExCL.get(i).Experimento == ExperimentosComboBox.getSelectedItem()){
                clasificadoresExp.add(WindowsInstances.createClasificadorGUI.paresExCL.get(i).Clasificador);
            }
        }
        clasificadoresExp.add("NINGUNO");
        ComboBoxModel modelo = new DefaultComboBoxModel(clasificadoresExp.toArray());
        ClasificadorComboBox.setModel(modelo);
    }//GEN-LAST:event_ExperimentosComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(CreateClassifierGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateClassifierGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateClassifierGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateClassifierGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateClasificadorGUI().setVisible(true);
            }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateClassifierGUI().setVisible(true);
            }
        });*/
    }
    
    public void setCombo (String nodo){
        ExperimentosComboBox.addItem(nodo);
    }
    
    public void setClasCombo (String nodo){
        ClasificadorComboBox.addItem(nodo);
    }
    
    public void eliminarExpYCla(String nodo){
        ExperimentosComboBox.removeItem(nodo);
    }
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarButton;
    private javax.swing.JComboBox<String> ClasificadorComboBox;
    private javax.swing.JButton CrearButton;
    private javax.swing.JLabel ExperimentoLabel;
    private javax.swing.JComboBox<String> ExperimentosComboBox;
    private javax.swing.JLabel NombreLabel;
    private javax.swing.JTextField NombreTextField;
    private javax.swing.JLabel TituloLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
