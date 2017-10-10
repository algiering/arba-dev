package java06;

import java.util.Scanner;

public class ex06_02_add {

    public static void main(String[] args) {
        
        int sum = 0;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("첫번째 정수를 입력하세요 :");
        int x = keyboard.nextInt();
        System.out.print("두번째 정수를 입력하세요 :");
        int y = keyboard.nextInt();

        System.out.println("합계 :" + add(x, y));
        
        sum = add(x,y);
        System.out.println("합계 :" + sum);

        keyboard.close();
    }

    public static int add(int x, int y) {

        int sum = x + y;

        return sum;
    }
}
