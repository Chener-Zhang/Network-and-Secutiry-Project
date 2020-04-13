package DES_cipher;

import javax.crypto.*;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.io.*;


public class DES_key_generator {

    KeyGenerator keyGen;
    SecretKey desKey;
    String encodedKey;


    public DES_key_generator() {
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


}
