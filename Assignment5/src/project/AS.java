package project;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class AS implements Server {
    private Socket socket;
    private String ID_C;
    private String ID_TGS;
    private int TS_1;

    public AS() {
    }

    public static void main(String[] args) throws IOException {
            AS as = new AS();
            as.connection_Server();
    }

    @Override
    public void connection_Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("waiting for the client");
        socket = serverSocket.accept();
        System.out.println("Client Accept");

        //get the system input stream
        DataInputStream input_from_system = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String Client_input = "";
        while (!Client_input.equals("quit")) {
            Client_input = input_from_system.readUTF();
            System.out.println(Client_input);
        }
        //close the socket
        System.out.println("Connection End\nbye bye");
        socket.close();
    }
}
