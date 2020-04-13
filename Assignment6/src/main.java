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
        PublicKey publicKey = rsa_ket_generator.get_public_key();
        PrivateKey privateKey = rsa_ket_generator.get_private_key();

        byte[] privateKeyBytes = privateKey.getEncoded();
        byte[] publicKeyBytes = publicKey.getEncoded();
        KeyFactory kf = KeyFactory.getInstance("RSA"); // or "EC" or whatever
        PrivateKey aPrivate = kf.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
        PublicKey aPublic = kf.generatePublic(new X509EncodedKeySpec(publicKeyBytes));

        RSA_encryption rsa_encryption = new RSA_encryption(aPublic, "hello wolrd");

        RSA_decryption rsa_decryption = new RSA_decryption(aPrivate, rsa_encryption.encrypt());
        System.out.println(new String (rsa_decryption.decrypt()));

    }
}
