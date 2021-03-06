package XML;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import TreeNodes.CustomMutableTreeNode;
import TreeNodes.ClassifierNode;
import TreeNodes.ExperimentNode;
import TreeNodes.TaskNode;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
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
    
    
    public void leerEtiquetas(ArrayList<String> comandoPrinci, Document plantilla, ArrayList<String> etiquetas, ArrayList<String> tipo, ArrayList<Boolean> obligatorios, TaskNode taskNode){
        String nombretarea = plantilla.getElementsByTagName("tarea").item(0).getAttributes().getNamedItem("nombre").getNodeValue();
        
        String nombrecomando = plantilla.getElementsByTagName("comando").item(0).getTextContent();
        comandoPrinci.add(nombrecomando);
        NodeList listaParametros = plantilla.getElementsByTagName("parametro");
        
        for(int i = 0; i < listaParametros.getLength(); i++){   
            
            Node nodoParametro = listaParametros.item(i);
            Element parametro = (Element)nodoParametro;
            
            String nombreParam = parametro.getAttribute("nombre");//getElementsByTagName("parametro").item(0).getAttributes().getNamedItem("nombre").getNodeValue();
            etiquetas.add(nombreParam);

            String tipoParam = parametro.getAttribute("tipo");
            tipo.add(tipoParam);
            String obligParam = parametro.getAttribute("obligatorio");
            if(obligParam.equals("no")){
                obligatorios.add(false);
            }
            else{
                obligatorios.add(true);
            }
              
        } 
	
    }
    
    /*public DefaultTreeModel leerProyecto(Document proyecto){
        String nombreExp = proyecto.getElementsByTagName("nodo").item(0).getAttributes().getNamedItem("nombre").getNodeValue();
        CustomMutableTreeNode experimento = new CustomMutableTreeNode(nombreExp)
        DefaultTreeModel subArbol = new DefaultTreeModel(root)
    }*/
    
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
            StreamResult sr = new StreamResult(new File(aux.getRutaCarpeta() + File.separator + exp.getNombre()+".xml"));
            
            tf.transform(domSource, sr);

        } catch (ParserConfigurationException | TransformerException ex) {
            ex.printStackTrace();
        }
    }
    
     private static void parseTreeNode(CustomMutableTreeNode treeNode, Document doc) {

        //String value = treeNode.getUserObject().toString();
        Element rootElement = doc.createElement("proyecto");
        doc.appendChild(rootElement);
        Attr attrName = doc.createAttribute("nombre");  
        attrName.setNodeValue(treeNode.getNombre());
        rootElement.getAttributes().setNamedItem(attrName); 
        
        Attr attrRutaPro = doc.createAttribute("ruta");  
        ExperimentNode aux = (ExperimentNode) treeNode.getNodeType();
        attrRutaPro.setNodeValue(aux.getRutaCarpeta());
        rootElement.getAttributes().setNamedItem(attrRutaPro);
        
        
        Element experimentElement = doc.createElement("nodo");
        Attr attrName2 = doc.createAttribute("nombre");
        attrName2.setNodeValue(treeNode.getNombre());
        experimentElement.getAttributes().setNamedItem(attrName2); 
        Attr attrName3 = doc.createAttribute("tipo");
        attrName3.setNodeValue("experimento");
        experimentElement.getAttributes().setNamedItem(attrName3); 
        rootElement.appendChild(experimentElement);
        
        Enumeration kiddies = treeNode.children();
        if(!treeNode.isLeaf()){
            Element nodosHijo = doc.createElement("nodos");  
            experimentElement.appendChild(nodosHijo);
            experimentElement = nodosHijo;
        }
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

            Attr attrTipo = doc.getOwnerDocument().createAttribute("tipo");
            attrTipo.setNodeValue("clasificador");
            parentElement.getAttributes().setNamedItem(attrTipo);
            
            doc.appendChild(parentElement);
            
        } else if (treeNode.getNodeType() instanceof TaskNode) {
            parentElement = doc.getOwnerDocument().createElement("nodo");

            CustomMutableTreeNode tarea = (CustomMutableTreeNode) treeNode;
            TaskNode taskNode = (TaskNode) tarea.getNodeType();
            // Apply properties to root element...
            Attr attrName = doc.getOwnerDocument().createAttribute("nombre");
            attrName.setNodeValue(tarea.getNombre());
            parentElement.getAttributes().setNamedItem(attrName);
            
            Attr attrTipo = doc.getOwnerDocument().createAttribute("tipo");
            attrTipo.setNodeValue("tarea");
            parentElement.getAttributes().setNamedItem(attrTipo); 

            doc.appendChild(parentElement);
            
            Element plantillaElement = doc.getOwnerDocument().createElement("plantilla");
            Attr attrRutaPlant = doc.getOwnerDocument().createAttribute("ruta");
            attrRutaPlant.setNodeValue(taskNode.getRutaPlantilla());
            plantillaElement.getAttributes().setNamedItem(attrRutaPlant);
            parentElement.appendChild(plantillaElement);
            
            Element parametrosElement = doc.getOwnerDocument().createElement("parametros");
            parentElement.appendChild(parametrosElement);
            
            for(int i = 0; i < taskNode.parametros.size(); i++){
                Element paramElement = doc.getOwnerDocument().createElement("parametro");
                String nombre = "";
                String valor = "";
                for(int j = 0; j < taskNode.parametros.get(i).mostrar().size(); j++){
                    if(taskNode.parametros.get(i).mostrar().get(j) instanceof JLabel){
                        Attr attrNameParam = doc.getOwnerDocument().createAttribute("nombre");
                        JLabel LabelAux = (JLabel) taskNode.parametros.get(i).mostrar().get(j);
                        attrNameParam.setNodeValue(LabelAux.getText());
                        paramElement.getAttributes().setNamedItem(attrNameParam);
                    }
                    else if(taskNode.parametros.get(i).mostrar().get(j) instanceof JTextField){
                        Attr attrValorParam = doc.getOwnerDocument().createAttribute("valor");
                        JTextField TextFieldAux = (JTextField) taskNode.parametros.get(i).mostrar().get(j);
                        attrValorParam.setNodeValue(TextFieldAux.getText());
                        paramElement.getAttributes().setNamedItem(attrValorParam);
                    }
                        
                }
                parametrosElement.appendChild(paramElement);
            }
            

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
            
            doc.appendChild(parentElement);
            
        }

        Enumeration kiddies = treeNode.children();
        if(!treeNode.isLeaf()){
            Element nodosHijo = doc.getOwnerDocument().createElement("nodos");  //NO SE DONDE PONERLO PARA QUE ENGLOBE UN GRUPO DE NODOS HIJOS
            parentElement.appendChild(nodosHijo);
            parentElement = nodosHijo;
        }

        while (kiddies.hasMoreElements()) {
            CustomMutableTreeNode child = (CustomMutableTreeNode) kiddies.nextElement();
            parseTreeNode(child, parentElement);
        }
    }
      
    public Document CargarProyecto(String proyectoRuta){
        return CargarPlantillaXML(proyectoRuta);
    }
    
}
