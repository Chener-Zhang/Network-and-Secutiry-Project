package project;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Scanner;

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
        System.out.println(mac.StringToHex(item));

        //DES key generator
        DES_key_generator_from_p1 generator = new DES_key_generator_from_p1();
        String DES_key = generator.keyToString();
        System.out.println(DES_key);


    }

}
