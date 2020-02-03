package project0;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;

public class Decrypt {
	
  static  Cipher DESCipher;
  static  KeyGenerator KEY_generator;
  static  SecretKey myDesKey;
  static byte[] textEncrypted;
    
	public static byte[] Decrypt(byte[] input, String sk_string) {
        try {
        	//Convert String to secret key
        	byte[] decodedKey = Base64.getDecoder().decode(sk_string);
        	SecretKeySpec originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
            //init the Mode
            DESCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Initialize the same cipher for decryption
            DESCipher.init(Cipher.DECRYPT_MODE, originalKey);


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
	
	public static void main(String[] args) {
		//String sk = "3Kh/EMEHxBA=";
		//String input = "[B@7a92922";
		//byte[] gb= input.getBytes();
		//Decrypt(gb,sk);
		
		Scanner in= new Scanner(System.in);
    	System.out.println("Cipher?");
    	String input= in.nextLine();
    	System.out.println("Secret Key?");
    	String sk= in.nextLine();




    	String gb= input;
        //System.out.println(gb);
        conventer cv = new conventer(gb);

        byte[] in_byte = cv.breaker();
        //System.out.println(in_byte);
        //System.out.println(Arrays.toString(in_byte));

    	System.out.println("Your Cipher: " + input);
    	System.out.println("Text Decrypted : " + Decrypt(in_byte,sk));
		
	}
}
