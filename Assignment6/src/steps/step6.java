package steps;

import DES_cipher.DES_Encryption;
import DES_cipher.conventer;
import Individuls.Client;
import Individuls.Server;
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
        Server server = new Server();
        Client client = new Client();

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


        //wrapping class ----->
        String data_to_client = "";
        data_to_client += "TS_6:" + server.TS_6;
        data_to_client += "\n";
        data_to_client += "Client id: " + client.client_id;
        data_to_client += "\n";

        System.out.println("enter the des key ");
        String des_key = scanner.nextLine();
        DES_Encryption des_encryption = new DES_Encryption();
        String cipher  = des_encryption.Encrypt(data_to_client,des_key);
        System.out.println(cipher);
        System.out.println("please save the cipher");


    }
}
