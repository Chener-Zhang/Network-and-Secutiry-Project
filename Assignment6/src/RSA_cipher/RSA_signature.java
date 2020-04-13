package RSA_cipher;

import java.security.PrivateKey;
import java.security.Signature;
import java.util.Base64;

public class RSA_signature {
    public RSA_signature() {

    }

    public byte[] sign(String plainText, PrivateKey privateKey) throws Exception {
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(privateKey);
        privateSignature.update(plainText.getBytes());
        return privateSignature.sign();
    }

}
