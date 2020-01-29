package project1;


import java.net.*;
import java.io.*;

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
    }

}