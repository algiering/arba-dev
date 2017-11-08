package personal;

import java.util.Scanner;

public class oper2Test {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.print("First num : ");
        oper2.setFirstNum(keyboard.nextInt());
        System.out.print("Second num : ");
        oper2.setSecondNum(keyboard.nextInt());

        System.out.println("Add : " + oper2.Add());
        System.out.println("Minus : " + oper2.Minus());
        System.out.println("Mul : " + oper2.Mul());
        System.out.printf("Div : %.6f\n", oper2.Div());

        keyboard.close();
    }

}
