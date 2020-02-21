package project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args)
			throws Exception {

		// Create server Socket
		ServerSocket ss = new ServerSocket(888);

		// connect it to client socket
		Socket s = ss.accept();
		System.out.println("Connection established");

		// to send data to the client
		PrintStream ps
				= new PrintStream(s.getOutputStream());

		// to read data coming from the client
		BufferedReader br
				= new BufferedReader(
				new InputStreamReader(
						s.getInputStream()));

		// to read data from the keyboard
		BufferedReader kb
				= new BufferedReader(
				new InputStreamReader(System.in));

		// server executes continuously
		while (true) {

			String str, str1;

			// repeat as long as the client
			// does not send a null string

			// read from client
			while ((str = br.readLine()) != null) {
				System.out.println(str);


				HMAC mac = new HMAC();

				Scanner scanner = new Scanner(System.in);
				//print out the system message
				System.out.println("Enter the message: ");
				String hmac_message = scanner.nextLine();

				System.out.println("Enter the HMAC key: ");
				String hmac_key = scanner.nextLine();

				System.out.println("Enter the DES Key: ");
				String key = scanner.nextLine();

				byte[] item = mac.Calculate_HMAC(hmac_message, hmac_key);
				//System.out.println("HMAC String:" + mac.StringToHex(item));
				String HMAC_Original = mac.StringToHex(item);
				System.out.println("Your message entered in server is :" + HMAC_Original);


				//DES decryption:
				DES_Decrypt_from_p1 DES_de = new DES_Decrypt_from_p1();
				conventer_from_p1 conventer = new conventer_from_p1(str);
				String Decrypt_message = DES_de.Decrypt(conventer.breaker(), key);
				System.out.println("The message you get from client :" + Decrypt_message);

				System.out.println("Are they the same? " + HMAC_Original.equals(Decrypt_message));


				str1 = kb.readLine();
				// send to client
				ps.println(str1);
			}

			// close connection
			ps.close();
			br.close();
			kb.close();
			ss.close();
			s.close();

			// terminate application
			System.exit(0);

		} // end of while
	}
}
