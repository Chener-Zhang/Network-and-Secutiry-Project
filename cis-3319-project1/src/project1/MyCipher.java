package project1;


class MyCipher{

    public static void main(String[] args) {
        DES item = new DES();
        item.Encrypt("this is me ");
        item.Decrypt();
    }
}