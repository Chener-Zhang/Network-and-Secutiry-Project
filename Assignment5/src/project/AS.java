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

    String client_id_data = "CIS3319USERID";
    String tgs_id_data = "CIS3319TGSID";

    DataInputStream input_from_system;
    DataOutputStream send_to_client;

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
        DataOutputStream send_to_client = new DataOutputStream(socket.getOutputStream());
        DataInputStream input_from_system = new DataInputStream(new BufferedInputStream(socket.getInputStream()));


        send_to_client.writeUTF("please enter you ID");

        while (!Client_input.equals(client_id_data)) {
            send_to_client.writeUTF("please try again");
            Client_input = input_from_system.readUTF();
            System.out.println(Client_input);
        }

        send_to_client.writeUTF("you have enter " + input_from_system.readUTF());


        System.out.println("Connection End\nbye bye");
        socket.close();
        //close the socket
    }


}
