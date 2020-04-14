package Individuls;

import DES_cipher.conventer;
import RSA_cipher.RSA_decryption;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class AC {

    public final String public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQgdXxqcarLpW9Q7hOPYI6F/JP9vLth1pH8ppjQvv77RylHN/ctntIkFwPKnN20kP1sZZHIZsdMyrvPOGipZZKwfwe2VzbT5jceqnbAVFm+Iy8K1i5TFC5TYqFICEqpVoiv1itLYUWb30qAeXaAXcu7D0HVA0ghwkxuriFHxS5lwIDAQAB";
    public final String private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANCB1fGpxqsulb1DuE49gjoX8k/28u2HWkfymmNC+/vtHKUc39y2e0iQXA8qc3bSQ/Wxlkchmx0zKu884aKllkrB/B7ZXNtPmNx6qdsBUWb4jLwrWLlMULlNioUgISqlWiK/WK0thRZvfSoB5doBdy7sPQdUDSCHCTG6uIUfFLmXAgMBAAECgYA7ea2TP4Bh9+nSkOyTtMve0lHWKXTl+EPyXetYARVrqRkQqAnbJVpJOpRn5w4EiLnF7aAWLinWzG+kylL6WA1kRcrLtZQQqWb5LHrBrw8RvYSxQzAlvAYgOg37IrQcyRjxB5uW34t4HWSgVHo8BR760WIzEaoPEpWxS84U6l5aAQJBAO8swxGdskBZePluAplM9AXS+2py9GqawFa+Yn1aXuzJLF3ZDzTcJPfjTvnShpNAeOVSZh69P7BoLacLIFSiZBcCQQDfLMmTVApyURLhc04D0e8JiMWMUdvUtAZFumYOj3pjVktqHg2CT0cuaKtxUlcG+Q95B8PNP29i9P2XucNwbkaBAkEA0NGRAplfXuV/RK8y36ubRlZ9oeP51/WCxnl0viMfy7ac4Nc5eppWQIOamW2gh4H7y6RUerQanidm7Hg/YwVhQwJARd+48QbECoy1s56tU2bcR4jqCQfsIwmGWTiGEZL8h7OSAxSLuDvoFnCxFNbp5oX+QS+cL1voHPyFlYaU2VO9gQJBANWjjR6DfXfJLchtPnYIkoQTOMxe8T2YmaDLubYfJr8PkN88qR9wEVtiMdOAVZVkv99o/1Mi3AFLxhsWz92BcEU=";
    public Socket socket;


    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        AC ac = new AC();
        ac.my_connection();
    }

    public AC(){

    }

    public void my_connection() throws IOException, InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {

        // Create server Socket
        ServerSocket ss = new ServerSocket(888);

        // connect it to client socket
        Socket s = ss.accept();
        System.out.println("Connection established");

        // to send data to the client
        PrintStream ps
                = new PrintStream(s.getOutputStream());

        // to read data coming from the client
        BufferedReader br
                = new BufferedReader(
                new InputStreamReader(
                        s.getInputStream()));

        // to read data from the keyboard
        BufferedReader kb
                = new BufferedReader(
                new InputStreamReader(System.in));

        // server executes continuously
        while (true) {

            String str, str1;

            // repeat as long as the client
            // does not send a null string

            // read from client
            while ((str = br.readLine()) != null) {
                System.out.println(str);
                System.out.println("data received");
                conventer conventer = new conventer(str);
                byte[] new_byte_string = conventer.breaker();
                RSA_decryption rsa_decryption = new RSA_decryption(private_key,new_byte_string);
                byte[] decrypted = rsa_decryption.decrypt();
                System.out.println(new String(decrypted));

                str1 = kb.readLine();
                // send to client
                ps.println(str1);
            }

            // close connection
            ps.close();
            br.close();
            kb.close();
            ss.close();
            s.close();

            // terminate application
            System.exit(0);

        } // end of while
    }


}
