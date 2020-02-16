package project;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class DES_key_generator_from_p1 {

    KeyGenerator keyGen;
    SecretKey desKey;
    String encodedKey;

    public DES_key_generator_from_p1() {
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

    public static void main(String[] args) {
        DES_key_generator_from_p1 k = new DES_key_generator_from_p1();
        System.out.println(k.keyToString());
        System.out.println(k.writeKeyFile());
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("key_file_generated.txt"));
            writer.write(str);

            writer.close();
            return "File Written";
        } catch (Exception e) {
            return "Error in writing file";
        }
    }


}
