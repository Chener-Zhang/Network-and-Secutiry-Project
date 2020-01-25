package project1;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Arrays;

public class DES {




    public static void main(String[] args) {
        Cipher("hello world",0,null);

    }

    //0 - > encrypt
    // 1 - > decrypt
    public static void Cipher(String words, int mode, byte[] secrete_message){
        try{

            /*
            Just ignore this part
            */
            //Basic setup ---------------------------------->
            KeyGenerator kg = KeyGenerator.getInstance("DES");
            SecretKey mykey = kg.generateKey();
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE,mykey);
            //Basic setup Finished-------------------------->


            // Convert the worlds in to bytes mode  ---------------------------------------->
            byte[] words_in_bytes  = words.getBytes();
            // Print out the words in bytes
            System.out.println("\nwords -> Bytes : " + words_in_bytes);
            // Print out the original words
            System.out.println("Original words: " + new String(words_in_bytes) + "\n");
            // Convert the worlds in to bytes mode Finished -------------------------------->

            if (mode == 0) {

                //-------------------------------Encryption---------------------------------------->
                // Encrypt the words
                byte[] outcome_from_cipher = cipher.doFinal(words_in_bytes);
                System.out.println("After Cipher : " + outcome_from_cipher);
                System.out.println("New String : " + new String(outcome_from_cipher) + "\n");
                //-------------------------------Encryption Finished------------------------------->



            }

            else if(mode == 1){
                //-------------------------------Decryption---------------------------------------->
                cipher.init(Cipher.DECRYPT_MODE,mykey);
                byte[] to_words = cipher.doFinal(words.getBytes());
                System.out.println("Decipher : " + new String(to_words));
                //-------------------------------Decryption Finished------------------------------------>

            }









        }catch (Exception ignored){

        }

    }



}


