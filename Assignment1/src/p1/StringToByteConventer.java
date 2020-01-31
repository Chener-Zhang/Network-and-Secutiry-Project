package p1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringToByteConventer {

    // We want String a = "[B@7b23ec81"
    // byte[] a_in_bytes = [B@7b23ec81



    String Cipher_text_in_string_1;
    byte[] Cipher_text_in_string_Get_Byte_2;
    String ArrayToString_Cipher_text_in_string_Get_Byte_3;

    public StringToByteConventer(String text){
        this.Cipher_text_in_string_1 = text;
        this.Cipher_text_in_string_Get_Byte_2 = Cipher_text_in_string_1.getBytes();
        this.ArrayToString_Cipher_text_in_string_Get_Byte_3 = Arrays.toString(Cipher_text_in_string_Get_Byte_2);
    }

    public byte[] get_byte_from_string(){
        System.out.println(Cipher_text_in_string_1);
        System.out.println(Cipher_text_in_string_Get_Byte_2);
        System.out.println(ArrayToString_Cipher_text_in_string_Get_Byte_3);
        return null;
    }

}
