package RSA_cipher;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class RSA_encryption {

    private String before_encrypted;
    private Cipher cipher;

    public RSA_encryption(String publicKey, String text) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        this.before_encrypted = text;
        this.cipher = Cipher.getInstance("RSA");

        byte[] public_key = Base64.getDecoder().decode(publicKey);

        Byte_Key_Convert convert = new Byte_Key_Convert();
        PublicKey pb = convert.convert_public(public_key);
        this.cipher.init(Cipher.ENCRYPT_MODE, pb);
    }

    public byte[] encrypt() throws BadPaddingException, IllegalBlockSizeException {
        byte[] text_byte = before_encrypted.getBytes();
        return cipher.doFinal(text_byte);
    }
}


