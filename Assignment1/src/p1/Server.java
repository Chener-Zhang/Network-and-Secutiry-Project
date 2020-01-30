package p1;

import javax.crypto.SecretKey;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {

    // constructor
    public Server(int port) throws ClassNotFoundException {
        // starts server and waits for a connection
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            //initialize socket and input stream
            Socket socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";
            // reads message from client until "Over" is sent

            //implement my cipher class
            DES cipher_test = new DES();
            while (!line.equals("Over")) {
                try {

                    line = in.readUTF();
                    DataInputStream dIn = new DataInputStream(socket.getInputStream());
                    int length = dIn.readInt();    
                    byte[] message = new byte[length];
                        if(length>0) {
                            dIn.readFully(message, 0, message.length); // read the message
                        }

                    //System.out.println("The message you received is :" + Arrays.toString(message));
                    //System.out.println("In String is :" + Arrays.toString(message));


                    //get the key object
                    InputStream inputStream = socket.getInputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

                    SecretKey key = (SecretKey) objectInputStream.readObject();
                    
                    //System.out.println("The key you received : \n" + Arrays.toString(key.getEncoded()));
                    //System.out.println(Arrays.toString(key.getEncoded()));

                    System.out.println("You got :");
                    cipher_test.Decrypt(message, key);

                } catch (IOException i) {
                    System.out.println(i.toString());
                }
            }

            System.out.println("Closing connection");
            // close connection
            socket.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i.toString());
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Server server = new Server(5000);
    }
}
