package RSA_cipher;


import java.security.*;

public class RSA_ket_generator {
    private KeyPair keyPair;

    public RSA_ket_generator() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        keyPair = keyGen.generateKeyPair();

    }

    public PublicKey get_public_key() {
        return keyPair.getPublic();
    }

    public PrivateKey get_private_key() {
        return keyPair.getPrivate();
    }


}
