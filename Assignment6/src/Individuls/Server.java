package Individuls;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


public class Server {

    public final String AC_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQgdXxqcarLpW9Q7hOPYI6F/JP9vLth1pH8ppjQvv77RylHN/ctntIkFwPKnN20kP1sZZHIZsdMyrvPOGipZZKwfwe2VzbT5jceqnbAVFm+Iy8K1i5TFC5TYqFICEqpVoiv1itLYUWb30qAeXaAXcu7D0HVA0ghwkxuriFHxS5lwIDAQAB";
    public String data = "";
    public String message = "take cis3319 class this afternoon";
    public final String Server_ID = "ID-Server";
    public long TS_1 = System.currentTimeMillis() / 1000L;
    public long TS_4 = System.currentTimeMillis() / 1000L;
    public long TS_6 = System.currentTimeMillis() / 1000L;


    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Server server = new Server();
        //server.to_AC();
        server.connection_client();
    }

    public void connection_client() throws IOException {
        // Create server Socket
        ServerSocket ss = new ServerSocket(5000);

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


