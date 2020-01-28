package project1;

import javax.crypto.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class DES {


    public static void main(String[] args) {
        byte[] final_word_in_byte = Cipher("hello world",0,null);
        System.out.println(Arrays.toString(final_word_in_byte));

        byte[] original = Cipher(null,1,final_word_in_byte);
        System.out.println(Arrays.toString(original));
    }

    //0 - > encrypt
    // 1 - > decrypt
    public static byte[] Cipher(String words, int mode,byte[] raw){
        try{

            if (mode == 0)
            {
                KeyGenerator kg = KeyGenerator.getInstance("DES");
                SecretKey mykey = kg.generateKey();
                Cipher Encipher = Cipher.getInstance("DES");
                byte[] words_in_bytes  = words.getBytes(StandardCharsets.UTF_8);
                Encipher.init(Cipher.ENCRYPT_MODE,mykey);
                return Encipher.doFinal(words_in_bytes);
            }


            else if(mode == 1){
                KeyGenerator kg = KeyGenerator.getInstance("DES");
                SecretKey second_key = kg.generateKey();
                Cipher Decipher =  Cipher.getInstance("DES");
                Decipher.init(Cipher.DECRYPT_MODE,second_key);
                return Decipher.doFinal(raw);
            }




        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }




}


