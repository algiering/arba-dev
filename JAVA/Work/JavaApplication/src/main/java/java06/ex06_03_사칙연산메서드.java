package java06;

import java.util.Scanner;

public class ex06_03_사칙연산메서드 {

    public static void main(String[] args) {

        int x = 0;
        int y = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("첫번째 정수를 입력하세요 :");
        x = keyboard.nextInt();
        
        System.out.print("두번째 정수를 입력하세요 :");
        y = keyboard.nextInt();

        int add = Add(x, y);
        int minus = Minus(x, y);
        int multi = Multi(x, y);
        double divi = Divi(x, y);

        System.out.println("덧셈 결과 : " + add);
        System.out.println("뺄셈 결과 : " + minus);
        System.out.println("곱셈 결과 : " + multi);
        System.out.println("나눗셈 결과 : " + divi);
        
        keyboard.close();

    }

    private static double Divi(double x, double y) {
        // TODO Auto-generated method stub

        double div = x / y;

        return div;
    }

    private static int Multi(int x, int y) {
        // TODO Auto-generated method stub

        int mul = x * y;

        return mul;
    }

    private static int Minus(int x, int y) {
        // TODO Auto-generated method stub

        int minus = x - y;

        return minus;
    }

    private static int Add(int x, int y) {
        // TODO Auto-generated method stub

        int add = x + y;

        return add;
    }

}
