package project;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static Socket socket;

    public Server() {

    }


    public static void connection_recerved() throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("waiting for the client");
        socket = serverSocket.accept();
        System.out.println("Client Accept");

        //get the system input stream
        DataInputStream input_from_system = new DataInputStream(socket.getInputStream());
        System.out.println(input_from_system.readUTF());
        socket.close();
    }



    public static void main(String[] args) throws IOException {
            connection_recerved();
    }





    private class AS {
        public AS() {

        }
    }

    private class TGS {
        public TGS() {

        }


    }

}
