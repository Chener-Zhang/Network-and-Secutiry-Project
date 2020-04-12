package DES_cipher;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;


public class DES_encryption {

    static Cipher DESCipher;
    static KeyGenerator KEY_generator;
    static SecretKey myDesKey;
    static byte[] textEncrypted;


    public DES_encryption(){

    }
    public byte[] Encrypt(String user_input, String sk_string) {
        try {
            //Convert String to secret key
            byte[] decodedKey = Base64.getDecoder().decode(sk_string);
            SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
            // Create the cipher type as DES
            DESCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Initialize the cipher for encryption
            DESCipher.init(Cipher.ENCRYPT_MODE, originalKey);


            //Turn the String of user_input to the byte mode
            byte[] text = user_input.getBytes();

            // DES_encryption the text -> Do final
            textEncrypted = DESCipher.doFinal(text);

            //Return the text;
            return textEncrypted;

        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | InvalidKeyException | BadPaddingException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
