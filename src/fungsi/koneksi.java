/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fungsi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author koperasi
 */

public class koneksi {
    private static final Properties prop = new Properties();
    private static String var="";
    
    public static String HOST(){
        try{
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var=prop.getProperty("HOST");
        }catch(IOException e){
            var=""; 
        }
        return var;
    }
}