package java11.st4oper;

import java.util.Scanner;

public class OperTest {

    public static void main(String [] args ){

        int firstNum  = 2;
        int secondNum = 4;
        int    result = 0;

        Scanner keyboard = new Scanner(System.in);
        System.out.print("firstNum를 입력하세요 : ");
        firstNum = keyboard.nextInt(); // 정수 입력

        System.out.print("secondNum를 입력하세요 : ");
        secondNum = keyboard.nextInt(); // 정수 입력

        Oper op = new Oper(firstNum, secondNum);

        result = op.Add();
        System.out.println(result);

        result = op.Minus();
        System.out.println(result);


        result = op.Mul();
        System.out.println(result);

        double result2 = op.Div();
        System.out.println(result2);

    }
}
