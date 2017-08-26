package Main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexa
 */
public class Console {
    String command;
    String resultado = "";
    
    public Console(String comando){
        command = comando;
    }
    
    public String ejecutarComando() throws IOException{
        Process process = Runtime.getRuntime().exec(command);                    
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));                                          
        String s;                                                                
        while ((s = reader.readLine()) != null) { 
            resultado = resultado+"\n"+ s; 
        }
        return resultado;
    }
    
}
