package java11.st4;

import java.util.Scanner;

public class operTest {

    public static void main(String[] args) {

        int x = 0;
        int y = 0;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("First num : ");
        x = keyboard.nextInt();
        System.out.print("Second num : ");
        y = keyboard.nextInt();

        System.out.println("Add : " + oper.Add(x, y));
        System.out.println("Minus : " + oper.Minus(x, y));
        System.out.println("Mul : " + oper.Mul(x, y));
        System.out.printf("Div : %.6f\n", oper.Div(x, y));

        keyboard.close();
    }

}
