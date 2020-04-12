package RSA_cipher;


import java.security.*;

public class RSA_ket_generator {
    private KeyPair keyPair;

    public RSA_ket_generator() throws NoSuchAlgorithmException {
        this.keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
    }

    public PublicKey get_public_key() {
        return keyPair.getPublic();
    }

    public PrivateKey get_private_key() {
        return keyPair.getPrivate();
    }


}
