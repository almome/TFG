/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 *
 * @author sandra
 */
public class Validacion {
    public String esquema;
    public String xml;
    
    public Validacion(String esquema, String xml){
        this.esquema = esquema;
        this.xml = xml;
    }
    
    public Boolean validar(){
        Boolean valido = true;
        File schemaFile = new File(esquema); // etc.
        Source xmlFile = new StreamSource(new File(xml));
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
          Schema schema = schemaFactory.newSchema(schemaFile);
          Validator validator = schema.newValidator();
          validator.validate(xmlFile);
          System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (SAXException e) {
            valido = false;
            System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
        } catch (IOException e) {valido = false;} 
        return valido;
    }
}
