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
        System.out.println("Please paste the cipher");
        String information = sc.nextLine();

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


        TS_2 = ac.TS_2;

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

        DES_Encryption des_encryption = new DES_Encryption();
        System.out.println("enter the des key");
        String key = sc.nextLine();

        String cipher = des_encryption.Encrypt(data_to_server,key);
        System.out.println(cipher);
        System.out.println("save the cipher send to Server");

    }
}
