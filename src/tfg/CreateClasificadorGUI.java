/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg;


import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Alexandra Morón Méndez
 */
public class CreateClasificadorGUI extends javax.swing.JFrame {
    
    ArrayList<ParClasificador> paresExCL = new ArrayList<ParClasificador>();
    
    /**
     * Creates new form CreateClasificadorGUI
     */
    public CreateClasificadorGUI() {
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

        TituloLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ExperimentoLabel = new javax.swing.JLabel();
        NombreLabel = new javax.swing.JLabel();
        TipoLabel = new javax.swing.JLabel();
        CrearButton = new javax.swing.JButton();
        CancelarButton = new javax.swing.JButton();
        ExperimentosComboBox = new javax.swing.JComboBox<>();
        NombreTextField = new javax.swing.JTextField();
        TipoComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Clasificador");

        TituloLabel.setText("Crear nuevo clasificador");

        ExperimentoLabel.setText("Experimento");

        NombreLabel.setText("Nombre :");

        TipoLabel.setText("Tipo:");

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

        NombreTextField.setText("Inserte nombre del clasificador...");

        TipoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estandar", "Pre-Tareas", "Post-Tareas" }));

        jLabel1.setText("o Clasificador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(TituloLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CancelarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CrearButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NombreLabel)
                            .addComponent(TipoLabel)
                            .addComponent(jLabel1)
                            .addComponent(ExperimentoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ExperimentosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(NombreTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TipoComboBox, 0, 265, Short.MAX_VALUE)))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(ExperimentosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ExperimentoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel)
                    .addComponent(NombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoLabel)
                    .addComponent(TipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelarButton)
                    .addComponent(CrearButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearButtonActionPerformed

        if(NombreTextField.getText() == null){
            showMessageDialog(new JFrame(), "No se puede crear un clasificador sin nombre.","Error", JOptionPane.ERROR_MESSAGE);
        }
        if(ExperimentosComboBox.getSelectedItem() != null){
            CustomMutableTreeNode nodo = new CustomMutableTreeNode(NombreTextField.getText());
            WindowsInstances.mainGUI.setProyectosTree(nodo, ExperimentosComboBox.getSelectedItem());
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
            NombreTextField.setText("Introduzca el nombre del clasificador...");
            dispose();
        }
        else{
            showMessageDialog(new JFrame(), "No se ha seleccionado experimento.\nEl clasificador debe crearse dentro de un experimento.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_CrearButtonActionPerformed

    private void CancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarButtonActionPerformed
        dispose();
    }//GEN-LAST:event_CancelarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CreateClasificadorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateClasificadorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateClasificadorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateClasificadorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateClasificadorGUI().setVisible(true);
            }
        });*/
    }
    
    public void setCombo (String nodo){
        ExperimentosComboBox.addItem(nodo);
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarButton;
    private javax.swing.JButton CrearButton;
    private javax.swing.JLabel ExperimentoLabel;
    private javax.swing.JComboBox<String> ExperimentosComboBox;
    private javax.swing.JLabel NombreLabel;
    private javax.swing.JTextField NombreTextField;
    private javax.swing.JComboBox<String> TipoComboBox;
    private javax.swing.JLabel TipoLabel;
    private javax.swing.JLabel TituloLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
