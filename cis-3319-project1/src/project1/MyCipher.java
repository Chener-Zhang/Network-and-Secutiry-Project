package project1;


class MyCipher{

    public static void main(String[] args) {
        DES item = new DES();

        byte[]in = item.Encrypt("my name is chener");

        byte[] out = item.Decrypt(in);









    }
}