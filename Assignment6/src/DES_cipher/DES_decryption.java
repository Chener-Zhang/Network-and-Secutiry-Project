package DES_cipher;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;

public class DES_decryption {
	
  static  Cipher DESCipher;

    
	public static void Decrypt(byte[] input, String sk_string) {
        try {
        	//Convert String to secret key
        	byte[] decodedKey = Base64.getDecoder().decode(sk_string);
        	SecretKeySpec originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
            //init the Mode
            DESCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Initialize the same cipher for decryption
            DESCipher.init(Cipher.DECRYPT_MODE, originalKey);


            // DES_decryption the text
            byte[] textDecrypted = DESCipher.doFinal(input);

            //Prints the text that has been decrypted
            System.out.println("Text Decryted : " + new String(textDecrypted));
            
        } catch (IllegalBlockSizeException | InvalidKeyException | BadPaddingException | NoSuchPaddingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
