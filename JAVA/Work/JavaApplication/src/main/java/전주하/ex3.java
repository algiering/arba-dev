package 전주하;

import java.util.Scanner;

public class ex3 {

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        Scanner key = new Scanner(System.in);

        for (;;) {
            System.out.print("시작단(0 종료):");
            x = key.nextInt();
            if (x == 0) {
                System.out.print("종료합니다.");
                break;
            }
            System.out.print("종료단(0 종료):");
            y = key.nextInt();
            if (y == 0) {
                System.out.print("종료합니다.");
                break;
            }

            y = printGUGU(x, y);
        }
        key.close();
    }

    public static int printGUGU(int x, int y) {
        int temp;
        if (x > y) {
            temp = x;
            x = y;
            y = temp;
        }

        for (; x <= y; x = x + 1) {
            for (int i = 1; i <= 9; i = i + 1) {
                System.out.print(x + "*" + i + "=" + x * i + " ");
                if (i == 9) {
                    System.out.println();
                }
            }
        }
        return y;
    }
}
