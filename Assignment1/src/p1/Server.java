import java.net.*;
import java.io.*;
import java.util.Arrays;
import javax.crypto.SecretKey;

public class Server {

    //initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    // constructor with port
    public Server(int port) throws ClassNotFoundException {
        // starts server and waits for a connection
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket

            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            String line = "";
             DES cipher_test = new DES();
            // reads message from client until "Over" is sent
            // Edit here for cipher project
            while (!line.equals("Over")) {
                try {

                    line = in.readUTF();
                    //System.out.println(line);

                    DataInputStream dIn = new DataInputStream(socket.getInputStream());
                    int length = dIn.readInt();    
                    byte[] message = new byte[length];// read length of incoming message
                        if(length>0) {
                            dIn.readFully(message, 0, message.length); // read the message
                        }

                    System.out.println("The message you received is :" + message);
                    System.out.println("In String is :" + Arrays.toString(message));


                    //get the key object
                    InputStream inputStream = socket.getInputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                    
                    SecretKey key = (SecretKey) objectInputStream.readObject();
                    System.out.println("The key you received : \n" + key.getEncoded());
                    System.out.println(Arrays.toString(key.getEncoded()));

                    System.out.println("You got :");
                    cipher_test.Decrypt(message, key);
                    
                    
                } catch (IOException i) {
                    System.out.println(i);
                }
            }

            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) throws ClassNotFoundException {
        Server server = new Server(5000);
    }
}
