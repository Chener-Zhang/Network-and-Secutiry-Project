package project;


import RSA_cipher.RSA_decryption;
import RSA_cipher.RSA_encryption;
import RSA_cipher.RSA_ket_generator;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        RSA_ket_generator rsa_ket_generator = new RSA_ket_generator();
        PublicKey publicKey = rsa_ket_generator.get_public_key();
        PrivateKey privateKey = rsa_ket_generator.get_private_key();

        String text = "hello world";
        RSA_encryption rsa_encryption = new RSA_encryption(publicKey,text);
        System.out.println("raw text :" + text);
        byte[] e_test = rsa_encryption.encrypt();
        System.out.println("after encrypted :" + e_test);

        RSA_decryption rsa_decryption = new RSA_decryption(privateKey,e_test);
        System.out.println("after decrypted :" + new String(rsa_decryption.decrypt()));



    }
}
