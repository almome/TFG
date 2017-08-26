package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
    
    public void leerEtiquetas(Document plantilla, ArrayList<String> etiquetas, ArrayList<String> tipo, ArrayList<Boolean> obligatorios, TaskNode taskNode){
        String nombretarea = plantilla.getElementsByTagName("tarea").item(0).getAttributes().getNamedItem("nombre").getNodeValue();
        
        String nombrecomando = plantilla.getElementsByTagName("comando").item(0).getTextContent();
        
        NodeList listaParametros = plantilla.getElementsByTagName("parametro");
        
        for(int i = 0; i < listaParametros.getLength(); i++){   
            
            Node nodoParametro = listaParametros.item(i);
            Element parametro = (Element)nodoParametro;
            
            String nombreParam = parametro.getAttribute("nombre");//getElementsByTagName("parametro").item(0).getAttributes().getNamedItem("nombre").getNodeValue();
            etiquetas.add(nombreParam);

            String tipoParam = parametro.getAttribute("tipo");
            tipo.add(tipoParam);
            String obligParam = parametro.getAttribute("obligatorio");
            if(obligParam == "no"){
                obligatorios.add(false);
            }
            else{
                obligatorios.add(true);
            }
              
        } 
	
    }
    
    public void guardarProyecto(TreeModel model, CustomMutableTreeNode exp){

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document doc = factory.newDocumentBuilder().newDocument();
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
            // Get tree root...
            //CustomMutableTreeNode exp = (CustomMutableTreeNode) root.getChildAt(0);
            parseTreeNode(exp, doc);

            // Save the document to disk...
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty(OutputKeys.METHOD, "xml");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource domSource = new DOMSource(doc);
            ExperimentNode aux = (ExperimentNode) exp.getNodeType();
            StreamResult sr = new StreamResult(new File(aux.getRutaCarpeta()+"\\"+exp.getNombre()+".xml"));
            tf.transform(domSource, sr);

        } catch (ParserConfigurationException | TransformerException ex) {
            ex.printStackTrace();
        }
    }
    
     private static void parseTreeNode(CustomMutableTreeNode treeNode, Document doc) {

        //String value = treeNode.getUserObject().toString();
        Element rootElement = doc.createElement("proyecto");
        doc.appendChild(rootElement);
        Attr attrName = doc.createAttribute("nombre");   //AQUI PETA NO SE PORQUE
        attrName.setNodeValue(treeNode.getNombre()+".xml");
        rootElement.getAttributes().setNamedItem(attrName); 
        
        
        Element experimentElement = doc.createElement("nodo");
        Attr attrName2 = doc.createAttribute("nombre");
        attrName2.setNodeValue(treeNode.getNombre());
        experimentElement.getAttributes().setNamedItem(attrName2); 
        Attr attrName3 = doc.createAttribute("tipo");
        attrName3.setNodeValue("experimento");
        experimentElement.getAttributes().setNamedItem(attrName3); 
        rootElement.appendChild(experimentElement);
        
        Enumeration kiddies = treeNode.children();
        while (kiddies.hasMoreElements()) {
            CustomMutableTreeNode child = (CustomMutableTreeNode) kiddies.nextElement();
            parseTreeNode(child, experimentElement);
        }
    }
     
      protected static void parseTreeNode(CustomMutableTreeNode treeNode, Element doc) {
        Element parentElement = null;
        if (treeNode.getNodeType() instanceof ClassifierNode) {
            parentElement = doc.getOwnerDocument().createElement("nodo");

            CustomMutableTreeNode clasificador = (CustomMutableTreeNode) treeNode;
            // Apply properties to root element...
            Attr attrName = doc.getOwnerDocument().createAttribute("nombre");
            attrName.setNodeValue(clasificador.getNombre());
            parentElement.getAttributes().setNamedItem(attrName);

            Attr attrURL = doc.getOwnerDocument().createAttribute("tipo");
            attrURL.setNodeValue("clasificador");
            parentElement.getAttributes().setNamedItem(attrURL);
        } else if (treeNode.getNodeType() instanceof TaskNode) {
            parentElement = doc.getOwnerDocument().createElement("nodo");

            CustomMutableTreeNode tarea = (CustomMutableTreeNode) treeNode;
            // Apply properties to root element...
            Attr attrName = doc.getOwnerDocument().createAttribute("nombre");
            attrName.setNodeValue(tarea.getNombre());
            parentElement.getAttributes().setNamedItem(attrName);
            
            Attr attrURL = doc.getOwnerDocument().createAttribute("tipo");
            attrURL.setNodeValue("tarea");
            parentElement.getAttributes().setNamedItem(attrURL); 
            
            //HAY QUE METER LOS PARÁMETROS

        } else if (treeNode.getNodeType() instanceof ExperimentNode) {
            parentElement = doc.getOwnerDocument().createElement("nodo");

            CustomMutableTreeNode experimento = (CustomMutableTreeNode) treeNode;
            // Apply properties to root element...
            Attr attrName = doc.getOwnerDocument().createAttribute("nombre");
            attrName.setNodeValue(experimento.getNombre());
            parentElement.getAttributes().setNamedItem(attrName);
            
            Attr attrURL = doc.getOwnerDocument().createAttribute("tipo");
            attrURL.setNodeValue("experimento");
            parentElement.getAttributes().setNamedItem(attrURL);
            
            
        }

        doc.appendChild(parentElement);

        Enumeration kiddies = treeNode.children();
        while (kiddies.hasMoreElements()) {
            CustomMutableTreeNode child = (CustomMutableTreeNode) kiddies.nextElement();
            parseTreeNode(child, parentElement);
        }
    }
    
}
