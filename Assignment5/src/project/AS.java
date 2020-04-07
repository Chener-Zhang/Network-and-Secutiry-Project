package project;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class AS implements Server {
    Socket socket;
    String ID_C;
    String ID_TGS;
    long TS_1;


    String get_id_c = "Enter the Client ID";
    String get_id_tgs = "Enter the TGS ID";

    String client_id = "CIS3319USERID";
    String tgs_id = "CIS3319TGSID";
    String tgs_key;


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
        while (!Client_input.equals(client_id)) {
            send_to_client.writeUTF("please try again client id");
            Client_input = input_from_system.readUTF();
        }
        ID_C = Client_input;

        //get the tgs id
        send_to_client.writeUTF("log in success\n" + get_id_tgs);
        Client_input = input_from_system.readUTF();
        while (!Client_input.equals(tgs_id)) {
            send_to_client.writeUTF("please try again the tgs id");
            Client_input = input_from_system.readUTF();
        }
        ID_TGS = Client_input;


        TS_1 = System.currentTimeMillis() / 1000L;
        System.out.println("CLIENT ID : " + client_id + "\nTGS ID :" + tgs_id + "\nTS1 : " + TS_1);

        String ticket_before_encryption = "";
        key_generator Ktgs = new key_generator();
        tgs_key = Ktgs.keyToString();
        System.out.println("\nsave the key \n" + tgs_key);

        ticket_before_encryption += tgs_key;
        ticket_before_encryption += "\n";
        ticket_before_encryption += "Client ID " + ID_C;
        ticket_before_encryption += "\n";
        ticket_before_encryption += "TGS id " + ID_TGS;
        ticket_before_encryption += "\n";
        ticket_before_encryption += "Time session " + TS_1;
        ticket_before_encryption += "\n";


        Encrypt encrypt = new Encrypt();
        send_to_client.writeUTF("here is you ticket\n\n" + encrypt.Encrypt(ticket_before_encryption, tgs_key) + "\nSave the decryption key:\n" + tgs_key);
        send_to_client.writeUTF("thank you for using socket");

        try {
            while (socket.isConnected()) {
                send_to_client.writeUTF("you can type [quit] now ");
            }


            //close the socket
        } catch (Exception e) {

        } finally {
            socket.close();

        }


    }


}
