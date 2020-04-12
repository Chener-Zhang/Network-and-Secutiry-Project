package project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("string\\d+");
        Matcher m = p.matcher("string1234more567string890");
        while (m.find()) {
            System.out.println(m.group());
        }


    }
}
