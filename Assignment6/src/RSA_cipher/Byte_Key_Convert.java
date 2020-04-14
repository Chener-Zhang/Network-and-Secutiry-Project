package RSA_cipher;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Byte_Key_Convert {
    KeyFactory kf;

    public Byte_Key_Convert() throws NoSuchAlgorithmException {
        kf = KeyFactory.getInstance("RSA");
    }

    public PublicKey convert_public(String key) throws InvalidKeySpecException {
        byte[] public_key = Base64.getDecoder().decode(key);
        return kf.generatePublic(new X509EncodedKeySpec(public_key));
    }

    public PrivateKey convert_private(String key) throws InvalidKeySpecException {
        byte[] private_key = Base64.getDecoder().decode(key);
        return kf.generatePrivate(new PKCS8EncodedKeySpec(private_key));
    }
}
