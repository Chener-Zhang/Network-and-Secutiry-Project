package project1;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import org.apache.commons.codec.binary.Base64;

public class DES {




    public static void main(String[] args) {
        //Cipher("hello world",0);
        Cipher("[B@762efe5d",1);

    }

    //0 - > encrypt
    // 1 - > decrypt
    public static void Cipher(String words, int mode){
        try{

            /*
            Just ignore this part
            */
            //Basic setup ---------------------------------->
            KeyGenerator kg = KeyGenerator.getInstance("DES");
            SecretKey mykey = kg.generateKey();

            Cipher Ecipher = Cipher.getInstance("DES");;
            Cipher Dcipher =  Cipher.getInstance("DES");;;

            //Basic setup Finished-------------------------->


            if (mode == 0) {
                // Convert the worlds in to bytes mode  ---------------------------------------->
                byte[] words_in_bytes  = words.getBytes();
                // Print out the words in bytes
                System.out.println("\nwords -> Bytes : " + words_in_bytes);
                // Print out the original words
                System.out.println("Original words: " + new String(words_in_bytes) + "\n");
                // Convert the worlds in to bytes mode Finished -------------------------------->

                //-------------------------------Encryption---------------------------------------->
                // Encrypt the words
                Ecipher.init(Cipher.ENCRYPT_MODE,mykey);
                byte[] outcome_from_cipher = Ecipher.doFinal(words_in_bytes);
                System.out.println("After Encrypt : " + outcome_from_cipher);
                System.out.println("New String : " + new String(outcome_from_cipher) + "\n");
                //-------------------------------Encryption Finished------------------------------->

            }
            else if(mode == 1){
                //-------------------------------Decryption---------------------------------------->
                Dcipher.init(Cipher.DECRYPT_MODE,mykey);
                byte [] decodedBytes =


                //-------------------------------Decryption Finished------------------------------------>

            }





        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }

    }



}


