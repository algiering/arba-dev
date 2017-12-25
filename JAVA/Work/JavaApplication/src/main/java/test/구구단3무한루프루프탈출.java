package test;

import java.util.Scanner;

public class 구구단3무한루프루프탈출 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int fdan = 0;
        int edan = 0;
        int m = 0;
        int tmp = 0;

        for (; true;) {

            System.out.print("시작 단수를 입력하세요 : ");
            fdan = keyboard.nextInt();

            System.out.print("종료 단수를 입력하세요 : ");
            edan = keyboard.nextInt();

            if ((fdan == 0) || (edan == 0)) {

                System.out.println("종료합니다.");
                break;
            }

            else {

                if (fdan > edan) {

                    tmp = fdan;
                    fdan = edan;
                    edan = tmp;
                }

                for (int j = fdan; j <= edan; j = j + 1) {

                    for (int i = 1; i < 10; i = i + 1) {

                        m = j * i;

                        if (i == 9) {
                            System.out.printf("%d   *   %d   =   %d\n\n", j, i, m);
                        }

                        else {
                            System.out.printf("%d   *   %d   =   %d\n", j, i, m);

                        }
                    }
                }
            }
        }
        keyboard.close();
    }
}