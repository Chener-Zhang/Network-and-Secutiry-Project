package RSA_cipher;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Byte_Key_Convert {
    KeyFactory kf;

    public Byte_Key_Convert() throws NoSuchAlgorithmException {
        kf = KeyFactory.getInstance("RSA");
    }

    public PublicKey convert_public(byte[] key_byte) throws InvalidKeySpecException {
        return kf.generatePublic(new X509EncodedKeySpec(key_byte));
    }

    public PrivateKey convert_private(byte[] key_byte) throws InvalidKeySpecException {
        return kf.generatePrivate(new PKCS8EncodedKeySpec(key_byte));
    }
}
