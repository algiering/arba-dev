package test;

import java.util.Scanner;

public class upperlower {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        String x = keyboard.nextLine();
        String s = "Z";

        int y = x.charAt(0);
        int t = s.charAt(0);

        int con = 0;

        if (y <= t) {
            con = y + 32;
        }

        else {
            con = y - 32;
        }

        System.out.println(" [실행결과] ");
        System.out.println(" ch: " + (char) con);

        keyboard.close();
    }
}