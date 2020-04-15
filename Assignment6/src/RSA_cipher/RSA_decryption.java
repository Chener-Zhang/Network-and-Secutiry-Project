package RSA_cipher;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class RSA_decryption {
    private Cipher cipher;
    private byte[] text_before_decrypted;

    public RSA_decryption(String privateKey, byte[] cipher_text) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        this.text_before_decrypted = cipher_text;
        this.cipher = Cipher.getInstance("RSA");

        Byte_Key_Convert convert = new Byte_Key_Convert();
        PrivateKey pb = convert.convert_private(privateKey);

        this.cipher.init(Cipher.DECRYPT_MODE, pb);
    }

    public byte[] decrypt() throws BadPaddingException, IllegalBlockSizeException {
        byte[] text_byte = text_before_decrypted;
        return cipher.doFinal(text_before_decrypted);
    }
}
