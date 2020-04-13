import RSA_cipher.Byte_Key_Convert;
import RSA_cipher.RSA_decryption;
import RSA_cipher.RSA_encryption;
import RSA_cipher.RSA_ket_generator;

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

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {

        RSA_ket_generator rsa_ket_generator = new RSA_ket_generator();

        byte[] publicKeyBytes = rsa_ket_generator.get_public_key();
        byte[] privateKeyBytes = rsa_ket_generator.get_private_key();

        Byte_Key_Convert conveter = new Byte_Key_Convert();
        PrivateKey privateKey = conveter.convert_private(privateKeyBytes);
        PublicKey publicKey = conveter.convert_public(publicKeyBytes);

        RSA_encryption rsa_encryption = new RSA_encryption(publicKey, "hello world this is a test");

        byte[] cipher = rsa_encryption.encrypt();
        RSA_decryption rsa_decryption = new RSA_decryption(privateKey, cipher);
        System.out.println(new String(rsa_decryption.decrypt()));

    }
}
