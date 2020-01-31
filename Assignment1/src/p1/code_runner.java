package p1;

import javax.crypto.SecretKey;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

class code_runner {

    public static void main(String[] args) {
        DES item = new DES();
            byte[] message =item.Encrypt("hello world");
            //System.out.println(message);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the message");
            String user_enter = sc.nextLine();  // Read user input
            System.out.println("The user has enter :" + user_enter);


            StringToByteConventer conver = new StringToByteConventer(user_enter);

            byte[] final_message = conver.get_byte_from_string();








    }
}