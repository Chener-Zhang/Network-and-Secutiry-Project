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
        String public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQgdXxqcarLpW9Q7hOPYI6F/JP9vLth1pH8ppjQvv77RylHN/ctntIkFwPKnN20kP1sZZHIZsdMyrvPOGipZZKwfwe2VzbT5jceqnbAVFm+Iy8K1i5TFC5TYqFICEqpVoiv1itLYUWb30qAeXaAXcu7D0HVA0ghwkxuriFHxS5lwIDAQAB";
        String private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANCB1fGpxqsulb1DuE49gjoX8k/28u2HWkfymmNC+/vtHKUc39y2e0iQXA8qc3bSQ/Wxlkchmx0zKu884aKllkrB/B7ZXNtPmNx6qdsBUWb4jLwrWLlMULlNioUgISqlWiK/WK0thRZvfSoB5doBdy7sPQdUDSCHCTG6uIUfFLmXAgMBAAECgYA7ea2TP4Bh9+nSkOyTtMve0lHWKXTl+EPyXetYARVrqRkQqAnbJVpJOpRn5w4EiLnF7aAWLinWzG+kylL6WA1kRcrLtZQQqWb5LHrBrw8RvYSxQzAlvAYgOg37IrQcyRjxB5uW34t4HWSgVHo8BR760WIzEaoPEpWxS84U6l5aAQJBAO8swxGdskBZePluAplM9AXS+2py9GqawFa+Yn1aXuzJLF3ZDzTcJPfjTvnShpNAeOVSZh69P7BoLacLIFSiZBcCQQDfLMmTVApyURLhc04D0e8JiMWMUdvUtAZFumYOj3pjVktqHg2CT0cuaKtxUlcG+Q95B8PNP29i9P2XucNwbkaBAkEA0NGRAplfXuV/RK8y36ubRlZ9oeP51/WCxnl0viMfy7ac4Nc5eppWQIOamW2gh4H7y6RUerQanidm7Hg/YwVhQwJARd+48QbECoy1s56tU2bcR4jqCQfsIwmGWTiGEZL8h7OSAxSLuDvoFnCxFNbp5oX+QS+cL1voHPyFlYaU2VO9gQJBANWjjR6DfXfJLchtPnYIkoQTOMxe8T2YmaDLubYfJr8PkN88qR9wEVtiMdOAVZVkv99o/1Mi3AFLxhsWz92BcEU=";

        String text = "hello world";
        RSA_signature rsa_signature = new RSA_signature();
        System.out.println(rsa_signature.sign(private_key, public_key));
        RSA_encryption rsa_encryption = new RSA_encryption(public_key,text);
        System.out.println(rsa_encryption.encrypt());
        String cipher = "[56, 37, -74, 118, -12, 49, 66, 106, -91, 42, -60, -9, -34, -113, 36, -128, -32, -10, -91, -112, -95, 9, 104, -114, -120, -11, -61, -127, -104, 6, 87, -92, 56, 126, 42, -78, 9, 50, -110, -92, 122, 72, -112, 10, -96, 69, -32, 79, -121, 123, 48, 0, 36, 91, 101, 48, -110, -4, 39, -85, 41, 95, 52, -59, -47, -97, 123, 118, -9, -86, -97, 11, -26, 108, 121, 39, 79, 118, -122, 34, 118, -87, -27, 62, -48, 15, 111, -104, -127, -22, 115, 101, 102, 14, -102, -11, 114, -86, 113, 48, -115, 120, -31, -74, 71, -32, -120, 5, 111, -104, 80, -72, -1, 54, -101, 65, -5, 32, 111, 59, -17, -114, 67, 28, 100, -67, -32, 106]";
        conventer cv = new conventer(cipher);
        byte[] cipher_byte = cv.breaker();

        RSA_decryption rsa_decryption = new RSA_decryption(private_key,cipher_byte);
        System.out.println(new String(rsa_decryption.decrypt()));

    }
}
