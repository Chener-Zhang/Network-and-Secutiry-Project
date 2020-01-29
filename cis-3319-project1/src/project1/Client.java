package project1;


import java.net.*;
import java.io.*;

<<<<<<< HEAD
public class Client
{
    // initialize socket and input output streams
    private Socket socket		 = null;
    private DataInputStream input = null;
    private DataOutputStream out	 = null;

    // constructor to put ip address and port
    public Client(String address, int port)
    {
        // establish a connection
        try
        {
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

        // string to read message from input
        String line = "";

        // keep reading until "Over" is input
        while (!line.equals("Over"))
        {
            try
            {
                //Write the encryption here;
                
                line = input.readLine();
                out.writeUTF(line);

            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }

        // close the connection
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

    public static void main(String[] argv) throws Exception {


        Client client = new Client("127.0.0.1", 5000);
=======
public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",5000);
            

            System.out.println();
        } catch (UnknownHostException e) {
            System.out.println("IP not found" + e);
        } catch (IOException e) {
            System.out.println(e);
        }
>>>>>>> 255fefb4cfc9a37bab0a6ebf5814e62135d86370
    }

}