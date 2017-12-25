package test;

import java.util.Scanner;

public class es04_21_무한입력 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        for (int i = 0; true;) {

            System.out.print("정수를 입력하세요:");
            i = keyboard.nextInt();

            if (i >= 0) {

                System.out.printf("입력한 값은 %d입니다.\n", i);
            }

            else {

                System.out.print("정상 종료합니다.");
                break;
            }

        }
        keyboard.close();
    }

}
