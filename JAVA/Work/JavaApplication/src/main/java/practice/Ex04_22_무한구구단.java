package practice;

import java.util.Scanner;

public class Ex04_22_무한구구단 {

    public static void main(String[] args) {

        int x = 0;
        int y = 0;

        Scanner key = new Scanner(System.in);

        int i = 1;

        for (; true;) {

            System.out.print("시작단 입력 :");
            x = key.nextInt();
            System.out.print("종료단 입력 :");
            y = key.nextInt();

            if (x > y) {
                int temp = 0;

                temp = x;
                x = y;
                y = temp;
            }

            if (x == 0) {
                System.out.println("종료합니다.");
                break;
            }

            for (; true;) {
                if (i == 9) {
                    System.out.print(x + "*" + i + "=" + x * i + ".\n");
                    i = 1;
                    x = x + 1;
                }

                else if (x > y) {
                    x = 0;
                    break;
                }

                else {
                    System.out.print(x + "*" + i + "=" + x * i + ",");
                    i = i + 1;
                }
            }
        }
    }
}
