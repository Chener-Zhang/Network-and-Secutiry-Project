package steps;

import Individuls.Client;

public class step3 {
    public static String client_id;
    public static long TS_3;

    public static void main(String[] args) {
        Client client = new Client();

        client_id =client.client_id;
        TS_3 = client.TS_3;
        System.out.println("save the message and the KEY send to the server");
        System.out.println(client_id + " TS_3" + TS_3);


    }
}
