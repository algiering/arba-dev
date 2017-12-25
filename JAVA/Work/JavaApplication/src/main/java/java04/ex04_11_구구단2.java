package java04;

import java.util.Scanner;

public class ex04_11_구구단2 {

    public static void main(String[] args) {

        int x = 0;
        int y = 0;

        int temp = 0;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("시작 단수를 입력하세요: ");
        x = keyboard.nextInt();

        System.out.print("종료 단수를 입력하세요: ");
        y = keyboard.nextInt();

        if (x > y) {
            temp = x;
            x = y;
            y = temp;
        }

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
        keyboard.close();
    }
}