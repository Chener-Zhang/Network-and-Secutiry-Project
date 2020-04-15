# Assignment 6

## package i have created
![](my_package.PNG)

## Step 1:
```
send:
the Server ID
Time session 1
Des_key 1 
to:
AC
```

setup the message which need to send
![](Step_1.PNG)
get the cipher text with the following image and send through the server to AC
![](step_1_output.PNG)

## Step 2

enter the cipher to the console, let the CA encrypt decryp the cipher by RSA and encrypt by DES

![](step_2.PNG)
in the console you will get
![](step2_output.PNG)

## Step 3
we will send the message to Client to Server again
![](step3.PNG)
## Step 4
we will decrypte the previous message and store the public key
![](step4.PNG)
here is the public and private key after the decryption(it only visible in Server Side)
![](step4_output.PNG)
## Step 5
you will send the public key to encrypted the message and send to the server again by using RSA Algorithem
![](step5.PNG)
then send the follow cipher to the server
![](step5_output.PNG)
## Step 6
in order to get the message, you will need to use the private key to decrypted the message and re-generate a new DES key for the next encryption
![](step6.PNG)
you will get the very detail imformation about what you received and just send 
![](step6_output.PNG)

## Step 7
you will encrypted the mesaage again for the final delivery
![](step7.PNG)
## Step 8
get the message from the final deliver
![](step8.PNG)