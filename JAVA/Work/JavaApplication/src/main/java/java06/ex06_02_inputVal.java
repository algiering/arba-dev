package java06;

import java.util.Scanner;

public class ex06_02_inputVal {

    public static void main(String[] args) {

        String x = "a";

        Scanner keyboard = new Scanner(System.in);

        x = keyboard.nextLine();
        System.out.println(x);

        keyboard.close();
    }

    public static String[] inputVal(String[] x) {
        return x;
    }

}
