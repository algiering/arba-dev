package java07;

import java.util.Scanner;

public class ex07_06_숨겨진카드 {

    public static void main(String[] args) {

        int fMax = 0;
        int max = 99;
        int min = 0;
        int sel = 0;

        fMax = (int) (Math.random() * 99);

        Scanner keyboard = new Scanner(System.in);

        for (int i = 0; true; i = i + 1) {

            if (i == 0) {
                System.out.println("수를 결정하였습니다. 맞추어 보세요");
                System.out.println(min + "-" + max);
            }

            else {
                System.out.println(i + ">>" + min + "-" + max);
            }

            sel = keyboard.nextInt();

            if ((sel > fMax) && (sel < max)) {
                max = sel;
                System.out.println("더 낮게");
            }

            else if ((sel < fMax) && (sel > min)) {
                min = sel;
                System.out.println("더 높게");
            }

            else if (sel == fMax) {

                String y;
                System.out.print("맞았습니다.\n다시 하시겠습니까(Y/N)");

                for (; true;) {

                    y = keyboard.next();
                    {

                        if (y.equals("y") || y.equals("Y")) {
                            i = -1;
                            fMax = (int) (Math.random() * 99);
                            min = 0;
                            max = 99;
                            break;
                        }

                        else if (y.equals("n") || y.equals("N")) {
                            System.out.println("종료합니다");
                            keyboard.close();
                            System.exit(0);
                        }

                        else {
                            System.out.println("잘못 입력하셨습니다 (Y/N)만 입력하세요");
                        }
                    }
                }
            }

            else {
                System.out.println("범위 외의 값 입니다");
                i = i - 1;
            }
        }
    }
}
