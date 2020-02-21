package project;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args)
			throws Exception {

		// Create client socket
		Socket s = new Socket("localhost", 888);
		System.out.println("server found, send the first message!");
		System.out.println("(you both must send one message at a time)");

		// to send data to the server
		DataOutputStream dos
				= new DataOutputStream(
				s.getOutputStream());

		// to read data coming from the server
		BufferedReader br
				= new BufferedReader(
				new InputStreamReader(
						s.getInputStream()));

		// to read data from the keyboard
		BufferedReader kb
				= new BufferedReader(
				new InputStreamReader(System.in));
		String str, str1;

		// repeat as long as exit
		// is not typed at client
		while (!(str = kb.readLine()).equals("exit")) {


			HMAC mac = new HMAC();
			Scanner scanner = new Scanner(System.in);

			//print out the system message
			System.out.println("Enter they message:");
			String message = scanner.nextLine();
			System.out.println("Enter the key:");
			String key = scanner.nextLine();

			//HMAC conventer
			byte[] item = mac.Calculate_HMAC(message, key);
			System.out.println("HMAC String:" + mac.StringToHex(item));
			String HMAC_Original = mac.StringToHex(item);

			//DES key generator
			DES_key_generator_from_p1 generator = new DES_key_generator_from_p1();
			String DES_key = generator.keyToString();
			System.out.println("DES key: " + DES_key);

			//DES encryption:
			DES_Encrypt_from_P1 DES_en = new DES_Encrypt_from_P1();
			String Encryption_message = DES_en.Encrypt(HMAC_Original, DES_key);
			System.out.println("Encryption_message: " + Encryption_message);


			// send to the server
			dos.writeBytes(Encryption_message + "\n");

			// receive from the server
			str1 = br.readLine();

			System.out.println(str1);
		}

		// close connection.
		dos.close();
		br.close();
		kb.close();
		s.close();
	}
}
