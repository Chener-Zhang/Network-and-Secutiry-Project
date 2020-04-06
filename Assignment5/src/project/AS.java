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


    String get_id_c = "Enter the Client ID";
    String get_id_tgs = "Enter the TGS ID";

    String client_id_data = "CIS3319USERID";
    String tgs_id_data = "CIS3319TGSID";


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

        send_to_client.writeUTF(get_id_c);

        //get the client id
        String Client_input = input_from_system.readUTF();
        while (!Client_input.equals(client_id_data)) {
            send_to_client.writeUTF("please try again client id");
            Client_input = input_from_system.readUTF();
        }
        this.ID_C = Client_input;

        //get the tgs id
        send_to_client.writeUTF("log in success\n" + get_id_tgs );
        Client_input = input_from_system.readUTF();
        while (!Client_input.equals(tgs_id_data)) {
            send_to_client.writeUTF("please try again the tgs id");
            Client_input = input_from_system.readUTF();
        }
        this.ID_TGS = Client_input;


        System.out.println(ID_C + ID_TGS);
        
        try{
            while (socket.isConnected()){
                send_to_client.writeUTF("you can type [quit] now ");
            }
            send_to_client.writeUTF("thank you for using socket");

            //close the socket
        }catch (Exception e){

        }


    }


}
