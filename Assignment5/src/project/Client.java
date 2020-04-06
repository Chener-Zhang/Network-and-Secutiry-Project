package project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


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

        //set up the input and output
        Scanner my_input = new Scanner(System.in);
        DataOutputStream my_output = new DataOutputStream(socket.getOutputStream());

        //check if connection success
        if (socket.isConnected()) {
            System.out.println("connection success");

            {
                String input = "";
                while(!input.equals("quit")){
                    input = my_input.nextLine();
                    my_output.writeUTF(input);
                }
                System.out.println("Connection End!\nBye Bye");

            }


        } else {
            System.out.println("connection fail");
        }

        //close the connection
        socket.close();

    }
}
