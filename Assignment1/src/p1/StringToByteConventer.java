package p1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringToByteConventer {

    // We want String a = "[B@7b23ec81"
    // byte[] a_in_bytes = [B@7b23ec81



    String Cipher_text_in_string_1;
    byte[] Cipher_text_in_string_Get_Byte_2;
    String ArrayToString_Cipher_text_in_string_Get_Byte_3;
    byte[] Final_byte_Arr;

    public StringToByteConventer(String text){
        this.Cipher_text_in_string_1 = text;
        this.Cipher_text_in_string_Get_Byte_2 = Cipher_text_in_string_1.getBytes();
        this.ArrayToString_Cipher_text_in_string_Get_Byte_3 = Arrays.toString(Cipher_text_in_string_Get_Byte_2);
    }

    public byte[] get_byte_from_string(){

        //System.out.println(ArrayToString_Cipher_text_in_string_Get_Byte_3);
        int len = Cipher_text_in_string_1.length();
        StringTokenizer MySt = new StringTokenizer(ArrayToString_Cipher_text_in_string_Get_Byte_3,"[]");
        String dele_begin_end =  MySt.nextToken();
        //System.out.println(dele_begin_end);

        StringTokenizer multiTokenizer = new StringTokenizer(dele_begin_end, ", ");
        Final_byte_Arr = new byte[len];
        int counter = 0;
        while (multiTokenizer.hasMoreTokens())
        {
            String assgn = multiTokenizer.nextToken();

            int i = Integer.parseInt(assgn);
            byte b1 = (byte) i;
            //System.out.println(b1);
            Final_byte_Arr[counter] = b1;
            counter++;
        }
        System.out.println(Final_byte_Arr);
        System.out.println(Arrays.toString(Final_byte_Arr));

        return null;
    }




}
