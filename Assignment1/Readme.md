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
---
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
---

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

### **Screen captures** 
* Some difficulties we had were that when we were trying to use decrypt, we noticed that we kept getting this error: 

![GitHub Logo](/Assignment1/Picture1.png)
* But then we realized that it was due to how we were printing the cipher in encrpyt:

![GitHub Logo](/Assignment1/Picture2.png)

Encrypt was supposed to print as an array of bytes, but instead we got some sort of representation of this array that is essentially meaningless when it comes to using it in decrypt, causing the error. This was due to the facts that we had Encrypt() returning byte[]. So we went into encrypt and changed it so that it returns the array in string form rather than byte[]:



```
We want to make String arr = "a[j@c3bv&"  ----- > byte[] arr = "a[j@c3bv&";

1: Using Encrypt() to return String in "[1],[2],[3],[4],[5],[6],[7],[8],[9]"
2: delim("[ ] ,")
3: get the raw 1 2 3 4 5 6 7 8 9
4: using loop to assign these number into byte[]; 
such as --- > 
arr[0] = 1
arr[1] = 2
arr[2] = 3
arr[3] = 4
arr[4] = 5
.
.
.

5: return byte[] arr; // which become the parameter in decryption;

```

Old:

![GitHub Logo](/Assignment1/Picture3.png)

![GitHub Logo](/Assignment1/Picture4.png)

Also, we had to add an extra class called conventer so that it can convert our array string into a byte[] to be used in decrypt. After that, we set up decrypt so that it directly prints the plaintext, rather than returning the byte[] (which was the cause to our problems in the first place):
Conventer:

![GitHub Logo](/Assignment1/Picture5.png)
Decrypt:

![GitHub Logo](/Assignment1/Picture6.png)


Overall, our code was able to work once wwe fixed some of these bugs.
