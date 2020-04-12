package project;


import DES_cipher.DES_encryption;
import DES_cipher.DES_key_generator;
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

        DES_key_generator des_key = new DES_key_generator();
        String key = des_key.keyToString();

        String message = "hello world my friend";

        DES_encryption des_encryption = new DES_encryption();
        System.out.println(des_encryption.Encrypt(message,key));




    }
}
