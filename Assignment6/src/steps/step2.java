package steps;

import DES_cipher.DES_Encryption;
import DES_cipher.conventer;
import Individuls.AC;
import RSA_cipher.RSA_decryption;
import RSA_cipher.RSA_key_generator;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class step2 {

    public static String privatekey_AC;
    public static String publickey_AC;
    public static String publickey_server;
    public static String privatekey_server;
    public static String Server_id;
    public static long TS_2;
    public static String data_to_server = "";

    public static void main(String[] args) throws InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        AC ac = new AC();

        privatekey_AC = ac.private_key;
        publickey_AC = ac.public_key;

        Scanner sc = new Scanner(System.in);
        String information = sc.nextLine();
        System.out.println(information);

        conventer conventer = new conventer(information);
        byte[] imformation_byte = conventer.breaker();

        RSA_decryption rsa_decryption = new RSA_decryption(privatekey_AC,imformation_byte);
        String outcome = new String(rsa_decryption.decrypt());
        System.out.println(outcome);

        Pattern server_id = Pattern.compile("server_id:.+\n");
        Matcher server_id_matcher = server_id.matcher(outcome);

        if (server_id_matcher.find()) {
            Server_id = server_id_matcher.group();
        }
        TS_2 = System.currentTimeMillis() / 1000L;

        RSA_key_generator rsa_key_generator = new RSA_key_generator();

        publickey_server = rsa_key_generator.public_key_ToString();
        privatekey_server = rsa_key_generator.private_key_ToString();

        //Wrap data;
        data_to_server += "public_key:" +publickey_server;
        data_to_server +="\n";
        data_to_server += "private_key:" +privatekey_server;
        data_to_server +="\n";
        data_to_server += Server_id;
        data_to_server +="\n";
        data_to_server += "TS_2:" + TS_2;
        //Wrap data;


        //[24, -32, -101, 65, -110, -88, 52, 11, -76, -36, 40, -43, 18, -59, 81, -26, -119, -86, 123, 126, 34, 82, 126, -42, -33, 125, -85, 12, 43, -120, 90, 98, 97, -38, -105, -25, 77, 45, 25, 106, -80, 89, 13, -118, -105, -64, -78, -119, 68, -57, -123, -122, -76, -55, 34, 83, 85, -76, -119, 68, 62, 0, 122, -108, 82, -90, -71, -17, 110, 24, -107, 42, -8, -14, 28, -13, -20, 76, -119, -102, -121, -115, 67, 92, -39, -118, -56, 53, -91, 22, -87, -11, -25, -14, 20, 90, 3, -42, 112, -101, -107, 36, 103, 17, -80, -26, 92, -8, -21, 14, 73, 17, 35, -121, 72, 67, 88, -106, 94, 48, 55, -48, 30, -88, -81, 17, -98, 53]
    }
}
