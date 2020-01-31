package p1;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class DES {

    //Declare the var;

    Cipher DESCipher;
    KeyGenerator KEY_generator;
    SecretKey myDesKey;
    byte[] textEncrypted;


    //Constructor
    public DES() {
        try {
            //init the var
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();
            this.KEY_generator = keygenerator;
            this.myDesKey = myDesKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    public byte[] Encrypt(String user_input) {
        try {
            // Create the cipher type as DES
            DESCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Initialize the cipher for encryption
            DESCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

            //Turn the String of user_input to the byte mode
            byte[] text = user_input.getBytes();

            // Encrypt the text -> Do final
            this.textEncrypted = DESCipher.doFinal(text);

            //Return the text;
            //System.out.println(textEncrypted);
            return textEncrypted;

        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | InvalidKeyException | BadPaddingException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }


    //Get the key just in case
    public SecretKey gettingkey() {
        //System.out.println(myDesKey);
        return myDesKey;
    }


    public byte[] Decrypt(byte[] input, SecretKey the_key) {
        try {
            //init the Mode
            DESCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Initialize the same cipher for decryption
            DESCipher.init(Cipher.DECRYPT_MODE, the_key);

            // Decrypt the text
            byte[] textDecrypted = DESCipher.doFinal(input);

            //Return the text has been decrypted
            System.out.println("Text Decryted : " + new String(textDecrypted));
            return textDecrypted;
        } catch (IllegalBlockSizeException | InvalidKeyException | BadPaddingException | NoSuchPaddingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}





