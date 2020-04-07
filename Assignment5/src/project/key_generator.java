package project;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class key_generator {

    KeyGenerator keyGen;
    SecretKey desKey;
    String encodedKey;
    
   
    public key_generator() {
    	try {
            //init the var
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();
            this.keyGen = keygenerator;
            this.desKey = myDesKey;
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    
    public String keyToString() {
    	try {
    		this.encodedKey = Base64.getEncoder().encodeToString(this.desKey.getEncoded());
    		return this.encodedKey;
    	} catch (Exception e) {
    		return "cannot get string";
    	}
    }
    
    public String writeKeyFile() {
    	try {
    		
    	    String str = this.encodedKey;
    	    return str;
    	} catch (Exception e) {
    		return "Error in writing file";
    	}
    }
    /*
    public static void main(String[] args) {
        key_generator k= new key_generator();
        System.out.println(k.keyToString());
    }
    */
       
}
