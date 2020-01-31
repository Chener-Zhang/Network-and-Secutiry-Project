package p1;

import javax.crypto.SecretKey;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

class code_runner {

    public static void main(String[] args) {
        DES item = new DES();
        byte[] message =item.Encrypt("hello world");
        System.out.println(Arrays.toString(message));

        conventer c = new conventer(Arrays.toString(message));


        item.Decrypt(c.breaker(),item.gettingkey());

    }
}