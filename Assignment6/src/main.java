import DES_cipher.DES_Encryption;
import DES_cipher.DES_decryption;
import DES_cipher.DES_key_generator;
import DES_cipher.conventer;
import RSA_cipher.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class main {

    public static void main(String[] args) throws Exception {
        System.out.println("hello world");
    }
}
