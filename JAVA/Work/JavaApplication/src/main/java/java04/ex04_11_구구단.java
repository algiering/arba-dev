package java04;

import java.util.Scanner;

public class ex04_11_구구단 {

    public static void main(String[] args) {

        int x = 0;
        int y = 0;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("시작 단수를 입력하세요: ");
        x = keyboard.nextInt();

        System.out.print("종료 단수를 입력하세요: ");
        y = keyboard.nextInt();

        for (int k = y - x; k <= (y - x); k = k + 1) {
            for (int i = x; i <= y; i = i + 1) {
                for (int j = 1; j < 10; j = j + 1) {

                    if (j == 9) {
                        System.out.format("%3d *%3d =%4d.", i, j, i * j);
                    }

                    else {
                        System.out.format("%3d *%3d =%4d,", i, j, i * j);
                    }
                }

                System.out.println();
            }
        }
        keyboard.close();
    }
}