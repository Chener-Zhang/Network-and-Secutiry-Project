import javax.crypto.SecretKey;


class main {

    public static void main(String[] args) {


        
    DES cipher_test = new DES();
        byte[] encrypt = cipher_test.Encrypt("whatever\n");
        SecretKey key = cipher_test.getkey();
        byte[] orignal = cipher_test.Decrypt(encrypt,key);


    }
}