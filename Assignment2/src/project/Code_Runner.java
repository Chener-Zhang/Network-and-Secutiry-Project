package project;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Scanner;


// In one machine simulator
public class Code_Runner {


    public static void main(String[] args) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        // Init the function
        HMAC mac = new HMAC();
        Scanner scanner = new Scanner(System.in);

        //print out the system message
        System.out.println("Enter they message:");
        String message = scanner.nextLine();
        System.out.println("Enter the key:");
        String key = scanner.nextLine();

        //HMAC conventer
        byte[] item = mac.Calculate_HMAC(message, key);
        System.out.println("HMAC String:" + mac.StringToHex(item));
        String HMAC_Original = mac.StringToHex(item);

        //DES key generator
        DES_key_generator_from_p1 generator = new DES_key_generator_from_p1();
        String DES_key = generator.keyToString();
        System.out.println("DES key: " + DES_key);

        //DES encryption:
        DES_Encrypt_from_P1 DES_en = new DES_Encrypt_from_P1();
        String Encryption_message = DES_en.Encrypt(HMAC_Original, DES_key);
        System.out.println("Encryption_message: " + Encryption_message);

        //DES decryption:
        DES_Decrypt_from_p1 DES_de = new DES_Decrypt_from_p1();
        conventer_from_p1 conventer = new conventer_from_p1(Encryption_message);
        String Decrypt_message = DES_de.Decrypt(conventer.breaker(), DES_key);
        System.out.println(Decrypt_message);

        System.out.println(HMAC_Original.equals(Decrypt_message));


    }

}
