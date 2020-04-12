package RSA_cipher;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;

public class RSA_encryption {

    private String before_encrypted;
    private Cipher cipher;

    public RSA_encryption(PublicKey publicKey, String text) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        this.before_encrypted = text;
        this.cipher = Cipher.getInstance("RSA");
        this.cipher.init(Cipher.ENCRYPT_MODE, publicKey);
    }

    public byte[] encrypt() throws BadPaddingException, IllegalBlockSizeException {
        byte[] text_byte = before_encrypted.getBytes();
        return cipher.doFinal(text_byte);
    }
}


