package project;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class TGS implements Server {

    String File_Server_ID = "CIS3319SERVERID";
    String TGS_ID = "CIS3319TGSID";
    String Client_ID = "CIS3319USERID";


    public TGS() {
    }

    @Override
    public void connection_Server() throws IOException {

        String key = null;
        String cipher_text = null;
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("waiting for the client");
        Socket socket = serverSocket.accept();
        System.out.println("Client Accept From TGS SERVER");


        //get the system input stream
        DataOutputStream send_to_client = new DataOutputStream(socket.getOutputStream());
        DataInputStream input_from_client = new DataInputStream(new BufferedInputStream(socket.getInputStream()));


        send_to_client.writeUTF("welcome to TGS server\nPlease enter the Cipher text");
        String Client_input = input_from_client.readUTF();

        while (Client_input != null) {
            cipher_text = Client_input;
            break;
        }
        System.out.println(cipher_text);

        send_to_client.writeUTF("Please enter the key");
        while (Client_input != null) {
            key = input_from_client.readUTF();
            break;
        }
        System.out.println(key);

        //Decryption
        conventer cv = new conventer(cipher_text);
        byte[] in_byte = cv.breaker();
        Decrypt decrypt = new Decrypt();
        decrypt.Decrypt(in_byte, key);



        Long TS_2 = System.currentTimeMillis() / 1000L;

        String ticket_before_encryption = "";
        key_generator Ktgs = new key_generator();
        String server_key = Ktgs.keyToString();

        ticket_before_encryption += "\n";
        ticket_before_encryption += server_key;
        ticket_before_encryption += "\n";
        ticket_before_encryption += "Client ID " + Client_ID;
        ticket_before_encryption += "\n";
        ticket_before_encryption += "TGS id " + TGS_ID;
        ticket_before_encryption += "\n";
        ticket_before_encryption += "Time session " + TS_2;
        ticket_before_encryption += "\n";

        Encrypt encrypt = new Encrypt();
        send_to_client.writeUTF("here is you new ticket to access Server\n\n" + encrypt.Encrypt(ticket_before_encryption, server_key) + "\nSave the decryption key:\n" + server_key);


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

    public static void main(String[] args) throws IOException {
        TGS tgs = new TGS();
        tgs.connection_Server();
    }
}
