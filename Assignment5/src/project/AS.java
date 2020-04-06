package project;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class AS implements Server {
    private Socket socket;
    private String ID_C;
    private String ID_TGS;
    private int TS_1;

    String Client_input = "";
    String get_id_c = "Enter the Client ID";
    String get_id_tgs = "Enter the TGS ID";

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
        System.out.println(1);
        DataOutputStream send_to_client = new DataOutputStream(socket.getOutputStream());
        System.out.println(2);



        while (!Client_input.equals("quit")) {
            send_to_client.writeUTF(get_id_c);
            send_to_client.writeUTF(get_id_c);
            Client_input = input_from_system.readUTF();
            send_to_client.writeUTF(get_id_tgs);
        }
        //close the socket
        System.out.println("Connection End\nbye bye");
        socket.close();
    }
}
