package p1;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class Client {

    // constructor to put ip address and port
    public Client(String address, int port) {
        // establish a connection
        // initialize socket and input output streams
        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream out = null;
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException u) {
            System.out.println(u.toString());
        }
        //<---------------------------------------------------------------------------->
        // string to read message from input
        String line = "";
        DES cipher_test = new DES();
        // keep reading until "Over" is input
        while (!line.equals("Over"))
        {
            try {

                assert input != null;
                line = input.readLine();
                byte[] message = cipher_test.Encrypt(line);
                System.out.println("You have enter : " + line);
                assert out != null;
                out.writeUTF(line);
                DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
                dOut.writeInt(message.length);
                dOut.write(message);
                System.out.println("After encrypted:  " + Arrays.toString(message));
                System.out.println(Arrays.toString(message) + "\n\n");

                //send object
                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(cipher_test.gettingkey());
                System.out.println("The key you send \n" + Arrays.toString(cipher_test.gettingkey().getEncoded()));
                System.out.println("in String :\n" + Arrays.toString(cipher_test.gettingkey().getEncoded()));

            }
            catch(IOException i)
            {
                System.out.println(i.toString());
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
            System.out.println(i.toString());
        }
    }

    public static void main(String[] args) {
        Client client = new Client("10.109.29.92", 5000);
    }
} 
