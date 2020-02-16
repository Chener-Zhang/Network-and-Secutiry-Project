package project;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;


public class Encrypt {

    static Cipher DESCipher;
    static KeyGenerator KEY_generator;
    static SecretKey myDesKey;
    static byte[] textEncrypted;


    public static String Encrypt(String user_input, String sk_string) {
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

            // Encrypt the text -> Do final
            textEncrypted = DESCipher.doFinal(text);

            //Return the text;
            String new_return = Arrays.toString(textEncrypted);
            return new_return;

        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | InvalidKeyException | BadPaddingException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Plaintext?");
        String pt = in.nextLine();
        System.out.println("Secret Key?");
        String sk = in.nextLine();

        System.out.println("Your Plaintext: " + pt);
        System.out.println("Text Encrypted : " + Encrypt(pt, sk));

        in.close();
    }

}
