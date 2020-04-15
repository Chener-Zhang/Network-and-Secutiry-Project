package steps;

import DES_cipher.DES_decryption;
import DES_cipher.conventer;
import Individuls.Server;

import java.util.Scanner;

public class step8 {
    public static void main(String[] args) {
        Server server = new Server();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the cipher ");
        String cipher_test = scanner.nextLine();
        System.out.println("enter the key");
        String key = scanner.nextLine();

        DES_decryption des_decryption = new DES_decryption();
        conventer conventer = new conventer(cipher_test);
        byte[] breaker = conventer.breaker();

        String last_message = new String(des_decryption.Decrypt(breaker,key));
        System.out.println(last_message + server.message);
    }
}
