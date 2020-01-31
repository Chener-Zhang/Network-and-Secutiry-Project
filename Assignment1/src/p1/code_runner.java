package p1;

import javax.crypto.SecretKey;
import java.sql.Array;
import java.util.Arrays;

class code_runner {

    public static void main(String[] args) {
            String something = "hello world";
            byte[] get_something_in_bytes = something.getBytes();
            System.out.println(get_something_in_bytes);
            System.out.println(Arrays.toString(get_something_in_bytes));
    }
}