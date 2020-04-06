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

    public static void connection_start() throws IOException {
            Socket socket = new Socket("127.0.0.1",5000);
            if(socket.isConnected()){
                System.out.println("connection success");
            }else{
                System.out.println("connection fail");
            }
            socket.close();
    }

    public static void main(String[] args) throws IOException {
        connection_start();
    }

}
