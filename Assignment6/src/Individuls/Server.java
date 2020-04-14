package Individuls;

import DES_cipher.DES_key_generator;
import RSA_cipher.RSA_encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

public class Server {

    public final String AC_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQgdXxqcarLpW9Q7hOPYI6F/JP9vLth1pH8ppjQvv77RylHN/ctntIkFwPKnN20kP1sZZHIZsdMyrvPOGipZZKwfwe2VzbT5jceqnbAVFm+Iy8K1i5TFC5TYqFICEqpVoiv1itLYUWb30qAeXaAXcu7D0HVA0ghwkxuriFHxS5lwIDAQAB";
    public String data = "take cis3319 class this afternoon";
    long TS_1;
    public final String Server_ID = "ID-Server";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Server server = new Server();
        server.to_AC();
    }

    public Server() {

    }
    public void to_AC() throws IOException, InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {

        // Create client socket
        Socket s = new Socket("localhost", 888);

        // to send data to the server
        DataOutputStream dos
                = new DataOutputStream(
                s.getOutputStream());

        // to read data coming from the server
        BufferedReader br
                = new BufferedReader(
                new InputStreamReader(
                        s.getInputStream()));

        // to read data from the keyboard
        BufferedReader kb
                = new BufferedReader(
                new InputStreamReader(System.in));
        String str, str1;


        //----->RSA implemetation
        DES_key_generator des_key_generator = new DES_key_generator();
        String DES_key = des_key_generator.keyToString();

        TS_1 = System.currentTimeMillis() / 1000L;
        data += "\n";
        data += "SERVER_ID:" + Server_ID;
        data += "\n";
        data += "TS_1:"+TS_1;
        data += "\n";
        data += "DES_KEY:" + DES_key;
        data += "\n";
        RSA_encryption rsa_encryption = new RSA_encryption(AC_public_key,data);
        String cipher = rsa_encryption.encrypt();
        //----->RSA implemetation

        // repeat as long as exit
        // is not typed at client
        System.out.println("type enter");
        dos.writeBytes(cipher);
        System.out.println("message successfully send it");
        while (!(str = kb.readLine()).equals("exit")) {

            // send to the server
            dos.writeBytes(str + "\n");

            // receive from the server
            str1 = br.readLine();
            System.out.println(str1);
        }

        // close connection.
        dos.close();
        br.close();
        kb.close();
        s.close();
    }

    }


