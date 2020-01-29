package p1;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class DES {

    Cipher DESCipher;
    KeyGenerator KEY_generator;
    SecretKey myDesKey;
    byte[] textEncrypted;


    public DES() {
        // Init the setting for the key generator;
        try {
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();

            //init the local var to global;

            this.KEY_generator = keygenerator;
            this.myDesKey = myDesKey;


            // catch the exception just in case
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }


    public byte[] Encrypt(String user_input) {
        try {
            // Create the cipher
            DESCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Initialize the cipher for encryption
            DESCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

            //sensitive information
            byte[] text = user_input.getBytes();

            System.out.println("Text [Byte Format] : " + text);
            System.out.println("Text : " + new String(text));

            // Encrypt the text
            byte[] FINAL_TEXT = DESCipher.doFinal(text);
            this.textEncrypted = FINAL_TEXT;
            System.out.println("Text Encryted : " + textEncrypted);
            return textEncrypted;

        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | InvalidKeyException | BadPaddingException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public byte[] Decrypt(byte input[]) {
        try {
            // Initialize the same cipher for decryption
            DESCipher.init(Cipher.DECRYPT_MODE, myDesKey);

            // Decrypt the text
            byte[] textDecrypted = DESCipher.doFinal(input);

            System.out.println("Text Decryted : " + new String(textDecrypted));
            return textDecrypted;
        } catch (IllegalBlockSizeException | InvalidKeyException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }


}





