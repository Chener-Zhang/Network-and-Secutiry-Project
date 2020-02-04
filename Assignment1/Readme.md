# Project 1
## Name: 
## Date:

### **what you have learned about DES (10);**

##### We learned that DES is an encryption algorithm that uses one key to encrypt and decrypt a message. DES is also a block cipher, meaning that it splits data into blocks and encrypts the chunks of data in each block with the key. DES encrypt and decrypt are essentially the same, but encrypt takes in the plaintext and key while decrypt takes in the cipher and key. Each data block is 64 bits while the key is 56 bits. 


### **language and library you used**
#### We are using JAVA
```
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.StringTokenizer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;
import javax.crypto.*;
import java.util.Arrays;
```
### **Code and Comment**
```
    Import the sample code for connection:

    Class Client;
    Class Server;


    Write by us: 
    Class Encrypt;
    Class Decrypt;
    Class key_generator;
    Class Main;
```

## Code and Comment Description: 

```
public static String Encrypt(String user_input, String sk_string)
                
                DESCipher.init(Cipher.ENCRYPT_MODE, originalKey);
               
                Return String;
```
Takes user_input from the user, and enter the secretKey; Before run the Encrypt, you have to run the main first in order to get a key;

Main takes the class of secret_key generator; Which generate the key using

` KeyGenerator.getInstance("DES");`

We also have to encoded into 64base 

`this.encodedKey = Base64.getEncoder().encodeToString(this.desKey.getEncoded());`

---

```
public static void Decrypt(byte[] input, String sk_string)

        DESCipher.init(Cipher.DECRYPT_MODE, originalKey);

        Print out the words which decrypted;
```
Decode the key

`byte[] decodedKey = Base64.getDecoder().decode(sk_string);`

Getting the instance

`DESCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");`

doFinal()

`DESCipher.doFinal(input)`

---

### **problems you encountered and how you solved them**




---

### **Screen captures is recommended (20).** 
