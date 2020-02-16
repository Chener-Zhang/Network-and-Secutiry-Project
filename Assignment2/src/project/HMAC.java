package project;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public class HMAC {

    public void Calculate_HMAC(String message, String key)
            throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec mykey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
        Mac mymac = Mac.getInstance("HmacSHA1");
        mymac.init(mykey);

        byte[] container = mymac.doFinal(message.getBytes());

        System.out.println(container);
    }
}
