/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author amoron
 */
public class CustomJDialog extends JDialog{
    private final JPanel contentPanel = new JPanel();
    private String ruta = "";

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    public CustomJDialog(String ruta) {
        this.ruta = ruta;
        // evita cambio de tamaño
        setResizable(false);
        // título del diáolog
        setTitle("Cargar Proyecto");
        // dimensiones que ocupa en la pantalla
        setBounds(100, 100, 450, 150);
        // capa que contendrá todo
        getContentPane().setLayout(new BorderLayout());
        // borde de la ventan
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        // pone el panel centrado
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        // sin capas para poder posicionar los elementos por coordenadas 
        contentPanel.setLayout(null);
        {
            // aquí se pone el JTextArea dentro de un JScrollPane 
            // para que tenga barras de desplazamiento
            JPanel scrollPane = new JPanel();
            scrollPane.setBounds(10, 11, 450, 90);
            contentPanel.add(scrollPane);
            {
                JLabel txtrstoEsUn = new JLabel();
                txtrstoEsUn.setText("El proyecto se cargará en la siguiente ruta:");
                JLabel txtrstoEsUnI = new JLabel();
                txtrstoEsUnI.setText(ruta);
                //txtrstoEsUnI.setLocation(50, 50);
                scrollPane.add(txtrstoEsUn);
                scrollPane.add(txtrstoEsUnI);
            }
        }
        {
            // a continuación tenemos los botones clásicos 'Vale' y 'Cancela'
            // éste código lo ha generado Eclipse...
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("Cambiar ruta...");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String RutaAux = "";
                        JFileChooser jFileChooser1 = new JFileChooser();
                        jFileChooser1.setFileSelectionMode(jFileChooser1.DIRECTORIES_ONLY);
                        int boton = jFileChooser1.showOpenDialog(jFileChooser1);
                        if (boton == jFileChooser1.APPROVE_OPTION){ //Si el usuario ha pulsado la opción Aceptar
                            File fichero = jFileChooser1.getSelectedFile(); //Guardamos en la variable fichero el archivo seleccionado
                            try {
                                setRuta(fichero.getAbsolutePath());
                            } catch (Exception ex) {
                              System.out.println("problem accessing file"+fichero.getAbsolutePath());
                            }
                        }

                        dispose();
                    }
                });
                okButton.setActionCommand("Cambiar ruta...");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Vale");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        // aquí van las acciones al hacer click en Vale
                        // envía el diálogo al recolector de basura de Java
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancelar");
                buttonPane.add(cancelButton);
            }
        }
    }    
}
