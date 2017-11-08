package 전주하;

import java.util.Scanner;

public class ex1 {

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int sum = 0;

        Scanner key = new Scanner(System.in);

        System.out.print("시작값을 입력하세요.");
        x = key.nextInt();
        System.out.print("종료값을 입력하세요.");
        y = key.nextInt();

        inputSum(x, y, sum);
        key.close();
    }

    public static void inputSum(int x, int y, int sum) {
        int temp;
        if (x > y) {
            temp = x;
            x = y;
            y = temp;
        }

        for (; x <= y; x = x + 1) {
            sum = sum + x;

            if (x == y) {
                System.out.print(x + " = " + sum);
            }

            else {
                System.out.print(x + " + ");
            }
        }
    }
}
