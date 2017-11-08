package 전주하;

import java.util.Scanner;

public class ex4 {

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        Scanner key = new Scanner(System.in);

        System.out.print("First num : ");
        x = key.nextInt();

        System.out.print("Second num : ");
        y = key.nextInt();

        Oper op = new Oper();
        op.setFirstNum(x);
        op.setSecondNum(y);

        System.out.println("Add : " + op.add());
        System.out.println("Minus : " + op.minus());
        System.out.println("Mul : " + op.mul());
        System.out.format("Div : %6f", op.div());

        key.close();
    }

}
