package Individuls;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public long TS_3 = System.currentTimeMillis() / 1000L;
    public String client_id = "ID-CLIENT";
    public String ip_address = "127.0.0.1";
    public int port_number = 5000;

    public long TS_5 = System.currentTimeMillis() / 1000L;
    public Client(){

    }
    public static void main(String[] args) throws IOException {
        // Create client socket
        Socket s = new Socket("localhost", 5000);

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
