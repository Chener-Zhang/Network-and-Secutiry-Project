package RSA_cipher;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;

public class RSA_decryption {
    private Cipher cipher;
    private byte[] text_before_decrypted;

    public RSA_decryption(PrivateKey privateKey, byte[] cipher_text) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        this.text_before_decrypted = cipher_text;
        this.cipher = Cipher.getInstance("RSA");
        this.cipher.init(Cipher.DECRYPT_MODE, privateKey);
    }

    public byte[] decrypt() throws BadPaddingException, IllegalBlockSizeException {
        byte[] text_byte = text_before_decrypted;
        return cipher.doFinal(text_before_decrypted);
    }
}
