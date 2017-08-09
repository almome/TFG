package tfg;

import java.io.File;
import static javax.swing.JOptionPane.showMessageDialog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandra Moron Mendez
 */
public class CreateDirectoryGUI extends javax.swing.JFrame {
    public static String ruta = "";
    public int nExp = 0;    
    /**
     * Creates new form CreateDirectory
     */
    public CreateDirectoryGUI() {
        initComponents(); 
    }
    
    public static void recibirRuta(String r){
        ruta = r;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        TituloLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        NombreLabel = new javax.swing.JLabel();
        LocalizacionLabel = new javax.swing.JLabel();
        LocalizacionTextField = new javax.swing.JTextField();
        BuscarButton = new javax.swing.JButton();
        CrearButton = new javax.swing.JButton();
        CancelarButton = new javax.swing.JButton();
        NombreTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Experimento");

        TituloLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TituloLabel.setText("Nombre y Localización");

        jSeparator1.setToolTipText("");

        NombreLabel.setText("Nombre :");

        LocalizacionLabel.setText("Localización :");

        BuscarButton.setText("Buscar...");
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
        CancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarButtonActionPerformed(evt);
            }
        });

        NombreTextField.setText(this.nombreExp());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(TituloLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CancelarButton)
                        .addGap(18, 18, 18)
                        .addComponent(CrearButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LocalizacionLabel)
                            .addComponent(NombreLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LocalizacionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(NombreTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscarButton)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel)
                    .addComponent(NombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LocalizacionLabel)
                    .addComponent(LocalizacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CrearButton)
                    .addComponent(CancelarButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //METODO QUE GENERA NOMBRE POR DEFECTO PARA EL EXPERIMENTO
    //SIEMPRE CREA UNO QUE NO SEA REPETIDO
    public String nombreExp(){
        return ("Experimento"+this.nExp);
    }
    
    
    private void BuscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarButtonActionPerformed
        
        jFileChooser1.setFileSelectionMode(jFileChooser1.DIRECTORIES_ONLY);
        int boton = jFileChooser1.showOpenDialog(this);
        if (boton == jFileChooser1.APPROVE_OPTION){ //Si el usuario ha pulsado la opción Aceptar
            File fichero = jFileChooser1.getSelectedFile(); //Guardamos en la variable fichero el archivo seleccionado
            try {
              // What to do with the file, e.g. display it in a TextArea
              //CreateDirectoryGUI.LocalizacionTextField.setText.read( new FileReader( file.getAbsolutePath() ), null );
              CreateDirectoryGUI.recibirRuta(fichero.getAbsolutePath());
              LocalizacionTextField.setText(fichero.getAbsolutePath());
            } catch (Exception ex) {
              System.out.println("problem accessing file"+fichero.getAbsolutePath());
            }
        }
    }//GEN-LAST:event_BuscarButtonActionPerformed

    private void CrearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearButtonActionPerformed
        //Se crea directorio del experimento
        nExp++;
        String sSistemaOperativo = System.getProperty("os.name");
        File directorio;
        if(sSistemaOperativo.equals("Linux")){   //Si es Linux
            directorio = new File(ruta+"//"+NombreTextField.getText());
            
        }
        else{   //Si es Windows
            directorio = new File(ruta+"\\"+NombreTextField.getText());
            
        }
        //Comprobamos si el directorio existe
        if(!directorio.exists()){
            //Creamos el directorio
            directorio.mkdir();
             //Crea nodo experimento en el JTree
            INodeType nodoExp = new ExperimentNode();   
            CustomMutableTreeNode CnodoExp = new CustomMutableTreeNode(NombreTextField.getText());
            CnodoExp.setNodeType(nodoExp);
            WindowsInstances.mainGUI.setProyectosTree(CnodoExp);
            String nombrenodo = CnodoExp.getUserObject().toString();
            WindowsInstances.createClasificadorGUI.setCombo(nombrenodo);
            WindowsInstances.createTareaGUI.setExpCombo(nombrenodo);  
            NombreTextField.setText("Experimento"+this.nExp);
            dispose();
        }
        else{
            showMessageDialog(null, "El nombre del experimento ya existe.");
        }
       
    }//GEN-LAST:event_CrearButtonActionPerformed

    private void CancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarButtonActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(CreateDirectoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateDirectoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateDirectoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateDirectoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateDirectoryGUI().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarButton;
    private javax.swing.JButton CancelarButton;
    private javax.swing.JButton CrearButton;
    private javax.swing.JLabel LocalizacionLabel;
    private javax.swing.JTextField LocalizacionTextField;
    private javax.swing.JLabel NombreLabel;
    private javax.swing.JTextField NombreTextField;
    private javax.swing.JLabel TituloLabel;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
