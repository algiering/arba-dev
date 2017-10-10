package java07;

import java.util.Scanner;

public class ex07_07_자리예약1차원 {

    public static void main(String[] args) {

        int[] sit = new int[10];
        Scanner keyboard = new Scanner(System.in);
        int sitSelect = 0;

        sitStatus(sit);

        for (; true;) {

            System.out.print("원하시는 좌석번호를 입력하세요 (종료는 -1:)");
            sitSelect = keyboard.nextInt();

            if (sitSelect == -1) {
                System.out.println("종료합니다");
                keyboard.close();
                System.exit(0);
            }

            else if (sit[sitSelect] == 0) {
                sit[sitSelect] = 1;
                System.out.println("예약되었습니다.");
                sitStatus(sit);
                continue;
            }

            else {
                System.out.println("이미 예약된 자리입니다.");
                sitStatus(sit);
                continue;
            }
        }
    }

    public static void sitStatus(int[] sit) {

        System.out.println("--------------------------------------");

        for (int i = 1; i <= 10; i = i + 1) {
            System.out.print(i + "   ");
        }
        System.out.println("\n--------------------------------------");

        for (int i = 0; i < 10; i = i + 1) {
            System.out.print(sit[i] + "   ");
        }
        System.out.println();
    }
}