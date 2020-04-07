package project;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    int port;
    String id;
    String address;


    public Client() {
    }

    public static void main(String[] args) throws IOException {
        //AS_connection_start
        Client client = new Client();
        //1
        //client.AS_connection_start(5000);

        //2
        //client.TGS_connection_start(5000);

        //3
        client.Server_connection_start(5000);

    }


    public void Server_connection_start(int port) throws IOException {
        String input = "";

        Socket socket = new Socket("127.0.0.1", port);
        //set up the input and output
        Scanner my_input = new Scanner(System.in);
        DataOutputStream my_output = new DataOutputStream(socket.getOutputStream());
        DataInputStream message_from_server = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        //check if connection success
        if (socket.isConnected()) {
            System.out.println("connection success\n");

            while (!input.equals("quit")) {
                System.out.println(message_from_server.readUTF());
                input = my_input.nextLine();
                my_output.writeUTF(input);
            }

            //disconnected
            System.out.println("Connection End!\nBye Bye");

        } else {
            System.out.println("connection fail");
        }


    }

    public void TGS_connection_start(int port) throws IOException {
        String input = "";

        Socket socket = new Socket("127.0.0.1", port);
        //set up the input and output
        Scanner my_input = new Scanner(System.in);
        DataOutputStream my_output = new DataOutputStream(socket.getOutputStream());
        DataInputStream message_from_server = new DataInputStream(new BufferedInputStream(socket.getInputStream()));


        //check if connection success
        if (socket.isConnected()) {
            System.out.println("connection success\n");

            while (!input.equals("quit")) {
                System.out.println(message_from_server.readUTF());
                input = my_input.nextLine();
                my_output.writeUTF(input);
            }

            //disconnected
            System.out.println("Connection End!\nBye Bye");

        } else {
            System.out.println("connection fail");
        }


    }








    public void AS_connection_start(int port) throws IOException {
        String input = "";

        //create a socket
        Socket socket = new Socket("127.0.0.1", port);


        //set up the input and output
        Scanner my_input = new Scanner(System.in);
        DataOutputStream my_output = new DataOutputStream(socket.getOutputStream());
        DataInputStream message_from_server = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        //check if connection success
        if (socket.isConnected()) {
            System.out.println("connection success\n");
            while (!input.equals("quit")) {
                System.out.println(message_from_server.readUTF());
                input = my_input.nextLine();
                my_output.writeUTF(input);
            }

            //disconnected
            System.out.println("Connection End!\nBye Bye");

        } else {
            System.out.println("connection fail");
        }

        //close the connection
        socket.close();

    }
}
