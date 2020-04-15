package steps;

import DES_cipher.DES_key_generator;
import Individuls.Client;
import Individuls.Server;
import RSA_cipher.RSA_encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

public class step5 {
    public static void main(String[] args) throws InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the public key");

        Client client = new Client();
        String public_key = scanner.nextLine();

        DES_key_generator des_key_generator = new DES_key_generator();
        String des_key2 = des_key_generator.keyToString();

        String message = "";
        long TS_5 = client.TS_5;
        String ip = client.ip_address;
        int port_number = client.port_number;
        //need one more des key;
        //wraping
        message += "TS_5" + TS_5;
        message += "\n";
        message += "ip:" + ip;
        message += "\n";
        message += "port number:" + port_number;
        message += "\n";
        message += "des_key2:" + des_key2;

        RSA_encryption rsa_encryption = new RSA_encryption(public_key, message);
        String cipher = rsa_encryption.encrypt();
        System.out.println("send the following cipher to the server");
        System.out.println(cipher);

    }
}
