package steps;

import DES_cipher.DES_decryption;
import DES_cipher.conventer;
import Individuls.Server;

import java.util.Scanner;

public class step4 {
    public static void main(String[] args) {

        Server server = new Server();

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the cipher");
        String cipher = sc.nextLine();
        System.out.println("enter the des_key");
        String des_key = sc.nextLine();

        DES_decryption des_decryption = new DES_decryption();
        conventer conventer = new conventer(cipher);
        byte[] decrypted = conventer.breaker();
        String decrypted_message = new String(des_decryption.Decrypt(decrypted,des_key));
        System.out.println(decrypted_message);

        System.out.println("copy paste the public key to the client");



    }
}
