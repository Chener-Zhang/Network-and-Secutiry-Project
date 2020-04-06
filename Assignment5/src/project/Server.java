package project;

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
