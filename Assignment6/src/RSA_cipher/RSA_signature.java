package RSA_cipher;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class RSA_signature {
    public RSA_signature() {

    }

    public boolean sign(String privateKey, String publicKey) throws Exception {
        Signature sig = Signature.getInstance("SHA256withRSA");

        //convert string to key
        Byte_Key_Convert byte_key_convert = new Byte_Key_Convert();
        PublicKey pubk = byte_key_convert.convert_public(publicKey);
        PrivateKey prik = byte_key_convert.convert_private(privateKey);
        //private key sign
        sig.initSign(prik);

        byte[] signature = sig.sign();

        //verify the public key
        sig.initVerify(pubk);

        return sig.verify(signature);
    }

}
