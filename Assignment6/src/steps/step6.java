package steps;

import DES_cipher.conventer;
import RSA_cipher.RSA_decryption;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

public class step6 {
    public static void main(String[] args) throws InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the cipher you just save");
        String cipher_text = scanner.nextLine();

        System.out.println("please enter the private key of the server you just save");
        String server_private_key = scanner.nextLine();

        conventer conventer =  new conventer(cipher_text);
        byte[] breaker_message = conventer.breaker();
        RSA_decryption rsa_decryption = new RSA_decryption(server_private_key,breaker_message);
        String message = new String(rsa_decryption.decrypt());
        System.out.println(message);
        System.out.println("please save the key");

        

    }
}
