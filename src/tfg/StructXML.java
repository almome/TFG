/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author alexa
 */
public class StructXML {
    
    public Document CargarPlantillaXML(String XMLRuta){
        Document xmlFile = null;
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setValidating(false);
            DocumentBuilder dBu  = dbf.newDocumentBuilder();
            File f = new File(XMLRuta);
            FileInputStream fis = new FileInputStream(f);
            xmlFile = dBu.parse(fis);

            //falta añadir comprobación con esquema
            
            //xmlFile = dBu.parse(new FileInputStream());

            //Leer
            //String aux = xmlFile.getElementsByTagName("conf").item(0).getAttributes().getNamedItem("name").getNodeValue();
            //System.out.println(aux);
            
        }catch(Exception ex){
            //agregar mensaje de error
        }
        return xmlFile;
    }
    
    public void leerOpciones(ArrayList<String> opciones){
        
    }
    
    public void leerEtiquetas(Document plantilla, ArrayList<String> etiquetas, ArrayList<String> tipo, ArrayList<Boolean> obligatorios){
        //String nombreComando = xmlFile.getElementsByTagName("conf").item(0).getAttributes().getNamedItem("name").getNodeValue();
	//confFile_array.add(confFileAtt1);
    }
    
}
