package project;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DES_Decrypt_from_p1 {

    static Cipher DESCipher;
    static KeyGenerator KEY_generator;
    static SecretKey myDesKey;
    static byte[] textEncrypted;

    public String Decrypt(byte[] input, String sk_string) {
        byte[] textDecrypted;
        try {
            //Convert String to secret key
            byte[] decodedKey = Base64.getDecoder().decode(sk_string);
            SecretKeySpec originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
            //init the Mode
            DESCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Initialize the same cipher for decryption
            DESCipher.init(Cipher.DECRYPT_MODE, originalKey);


            // DES_Decrypt_from_p1 the text
            textDecrypted = DESCipher.doFinal(input);

            //Prints the text that has been decrypted
            String output = new String(textDecrypted);
            //System.out.println("Text Decryted : " + output);
            return output;
        } catch (IllegalBlockSizeException | InvalidKeyException | BadPaddingException | NoSuchPaddingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Cipher?");
        String input = in.nextLine();
        System.out.println("Secret Key?");
        String sk = in.nextLine();

        String gb = input;
        conventer_from_p1 cv = new conventer_from_p1(gb);

        byte[] in_byte = cv.breaker();

        System.out.println("Your Cipher: " + input);


    }
     */

}
