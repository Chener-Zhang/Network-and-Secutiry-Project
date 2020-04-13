import DES_cipher.DES_Encryption;
import DES_cipher.DES_decryption;
import DES_cipher.DES_key_generator;
import DES_cipher.conventer;
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

        String public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQgdXxqcarLpW9Q7hOPYI6F/JP9vLth1pH8ppjQvv77RylHN/ctntIkFwPKnN20kP1sZZHIZsdMyrvPOGipZZKwfwe2VzbT5jceqnbAVFm+Iy8K1i5TFC5TYqFICEqpVoiv1itLYUWb30qAeXaAXcu7D0HVA0ghwkxuriFHxS5lwIDAQAB";
        String private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANCB1fGpxqsulb1DuE49gjoX8k/28u2HWkfymmNC+/vtHKUc39y2e0iQXA8qc3bSQ/Wxlkchmx0zKu884aKllkrB/B7ZXNtPmNx6qdsBUWb4jLwrWLlMULlNioUgISqlWiK/WK0thRZvfSoB5doBdy7sPQdUDSCHCTG6uIUfFLmXAgMBAAECgYA7ea2TP4Bh9+nSkOyTtMve0lHWKXTl+EPyXetYARVrqRkQqAnbJVpJOpRn5w4EiLnF7aAWLinWzG+kylL6WA1kRcrLtZQQqWb5LHrBrw8RvYSxQzAlvAYgOg37IrQcyRjxB5uW34t4HWSgVHo8BR760WIzEaoPEpWxS84U6l5aAQJBAO8swxGdskBZePluAplM9AXS+2py9GqawFa+Yn1aXuzJLF3ZDzTcJPfjTvnShpNAeOVSZh69P7BoLacLIFSiZBcCQQDfLMmTVApyURLhc04D0e8JiMWMUdvUtAZFumYOj3pjVktqHg2CT0cuaKtxUlcG+Q95B8PNP29i9P2XucNwbkaBAkEA0NGRAplfXuV/RK8y36ubRlZ9oeP51/WCxnl0viMfy7ac4Nc5eppWQIOamW2gh4H7y6RUerQanidm7Hg/YwVhQwJARd+48QbECoy1s56tU2bcR4jqCQfsIwmGWTiGEZL8h7OSAxSLuDvoFnCxFNbp5oX+QS+cL1voHPyFlYaU2VO9gQJBANWjjR6DfXfJLchtPnYIkoQTOMxe8T2YmaDLubYfJr8PkN88qR9wEVtiMdOAVZVkv99o/1Mi3AFLxhsWz92BcEU=";
        RSA_encryption rsa_encryption = new RSA_encryption(public_key, "hello wolrd this is me ");
        String cipher = rsa_encryption.encrypt();
        System.out.println(cipher);

        conventer conventer = new conventer(cipher);
        byte[] ready_to_decrypted = conventer.breaker();
        RSA_decryption rsa_decryption = new RSA_decryption(private_key, ready_to_decrypted);
        System.out.println(new String(rsa_decryption.decrypt()));


    }
}
