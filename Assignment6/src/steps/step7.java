package steps;

import DES_cipher.DES_Encryption;
import DES_cipher.DES_key_generator;
import Individuls.Client;

public class step7 {
    public static void main(String[] args) {
        Client client = new Client();
        DES_key_generator des_key_generator = new DES_key_generator();
        String key = des_key_generator.keyToString();

        System.out.println("save the following key and cipher");
        System.out.println(key);
        DES_Encryption des_encryption = new DES_Encryption();
        String cipher = des_encryption.Encrypt(client.request,key);
        System.out.println(cipher);


    }
}
