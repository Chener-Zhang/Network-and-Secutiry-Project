package steps;

import DES_cipher.DES_key_generator;
import Individuls.AC;
import Individuls.Server;
import RSA_cipher.RSA_encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class step1 {
    public static String server_id;
    public static String des_key;
    public static String AC_public_key;
    public static String data = "";
    public static String message;
    public static long TS_1;


    public static void main(String[] args) throws InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {

        Server server = new Server();
        DES_key_generator des_key_generator = new DES_key_generator();

        des_key = des_key_generator.keyToString();
        AC_public_key = server.AC_public_key;
        server_id = server.Server_ID;
        TS_1 = server.TS_1;

        data += "des_key:" + des_key;
        data += "\n";
        data += "server_id:" + server_id;
        data += "\n";
        data += "time_session:" + TS_1;
        data += "\n";

        RSA_encryption rsa_encryption = new RSA_encryption(AC_public_key,data);
        String cipher = rsa_encryption.encrypt();
        System.out.println(cipher);
        System.out.println("save the cipher send to AC");
    }
}
