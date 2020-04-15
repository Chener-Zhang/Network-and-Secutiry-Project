package RSA_cipher;


import java.security.*;
import java.util.Base64;

public class RSA_key_generator {
    private KeyPair keyPair;

    String encodedKey_public_key;
    String encodedKey_private_key;

    public RSA_key_generator() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        keyPair = keyGen.generateKeyPair();

    }

    public byte[] get_public_key() {
        return keyPair.getPublic().getEncoded();
    }

    public byte[] get_private_key() {
        return keyPair.getPrivate().getEncoded();
    }

    public String public_key_ToString() {
        try {
            this.encodedKey_public_key = Base64.getEncoder().encodeToString(get_public_key());
            return this.encodedKey_public_key;
        } catch (Exception e) {
            return "cannot get string";
        }
    }

    public String private_key_ToString() {
        try {
            this.encodedKey_private_key = Base64.getEncoder().encodeToString(get_private_key());
            return this.encodedKey_private_key;
        } catch (Exception e) {
            return "cannot get string";
        }
    }


}
