package project;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public class Code_Runner {

    public static void main(String[] args) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {

        HMAC mac = new HMAC();
        mac.Calculate_HMAC("hello world", "hey");

    }

}
