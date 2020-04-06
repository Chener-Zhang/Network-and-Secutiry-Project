package project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Client {
    String id;

    String address;
    int port;


    public Client() {
    }

    public static void main(String[] args) throws IOException {
        connection_start(5000);
    }


    public static void connection_start(int port) throws IOException {
        //create a socket
        Socket socket = new Socket("127.0.0.1", port);

        //check if connection success
        if (socket.isConnected()) {
            System.out.println("connection success");

            
        } else {
            System.out.println("connection fail");
        }

        //close the connection
        socket.close();

    }
}
