package java06;

import java.util.Scanner;

public class jv06_05_isNumber {

    public static void main(String[] args) {

        String x = "a";

        Scanner keyboard = new Scanner(System.in);

        x = keyboard.nextLine();

        System.out.println(isNumber(x));

        keyboard.close();

    }

    public static boolean isNumber(String x) {

        boolean result;

        if (x == null || x.equals("")) {
            result = false;
        }

        else {
            result = true;
        }

        return result;
    }
}
