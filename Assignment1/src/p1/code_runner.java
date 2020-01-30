package p1;

import javax.crypto.SecretKey;

class code_runner {

    public static void main(String[] args) {


        DES cipher_test = new DES();
        byte[] encrypt = cipher_test.Encrypt("whatever\n");
        SecretKey key = cipher_test.getkey();
        byte[] original = cipher_test.Decrypt(encrypt, key);


    }
}