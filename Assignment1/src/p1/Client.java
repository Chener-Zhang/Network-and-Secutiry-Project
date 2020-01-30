package p1;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Client {
    // initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    // constructor to put ip address and port
    public Client(String address, int port) {
        // establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
        //<---------------------------------------------------------------------------->
        // string to read message from input
        String line = "";
        DES cipher_test = new DES();
        // keep reading until "Over" is input
        while (!line.equals("Over"))
        {
            try
            {

                line = input.readLine();
                byte[] message = cipher_test.Encrypt(line);
                System.out.println("You have enter : " + line);                
                out.writeUTF(line);
                DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
                dOut.writeInt(message.length); 
                dOut.write(message);           
                System.out.println("After encrypted:  " + message);
                System.out.println(Arrays.toString(message)+"\n\n");
                
                //send object
                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(cipher_test.getkey());
                System.out.println("The key you send \n" + cipher_test.getkey().getEncoded());
                System.out.println("in String :\n" + Arrays.toString(cipher_test.getkey().getEncoded()));

            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }

        // close the connection
        //<---------------------------------------------------------------------------->

        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 5000);
    }
} 
