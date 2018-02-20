package java04;

import java.util.Scanner;

public class ex04_13_구구단 {

    public static void main(String [] args) {

        int startVal =0, endVal = 0;

        // 키보드 입력
        Scanner keyboard = new Scanner(System.in);
        System.out.print("시작단수를 입력하세요 : ");
        startVal = keyboard.nextInt(); // 정수 입력

        System.out.print("종료단수를 입력하세요 : ");
        endVal = keyboard.nextInt(); // 정수 입력


        // step2. swap . startVal > endVal 이면
        if( startVal > endVal ) {
            // startVal,  endVal 값 교환하기
            int temp = endVal;
            endVal = startVal;
            startVal = temp;
        }

        // step3. 구구단 출력
        for( int i = startVal; i <= endVal ; i++ ) {
            for (int j = 1; j <= 9; j++) {
                System.out.print( i + "X" + j + "=" + i*j );

                if( j==9 ) {
                    System.out.print(".\n"); //System.out.println(".");
                }
                else {
                    System.out.print(", ");
                }
            }
        }
    }
}
