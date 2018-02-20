package java06;

import java.util.Scanner;

public class ex06_22_구구단_method {

    public static void main(String [] args) {

        int startVal =0, endVal = 0;
        
        for( ; ; ) {
            // step1. 키보드 입력
            Scanner keyboard = new Scanner(System.in);
            System.out.print("시작단수을 입력하세요 : ");
            startVal = keyboard.nextInt(); // 정수 입력

            System.out.print("종료단수를 입력하세요 : ");
            endVal = keyboard.nextInt(); // 정수 입력


            // step2. 루프 탈출
            if(startVal == 0 || endVal ==0) {
                break;
            }
            
            // step3. swap
            if(startVal > endVal){
                int temp = endVal;
                endVal = startVal;
                startVal = temp;
            }
            
            // step4. 출력
            printGugudan(startVal, endVal);
        }
    }

    public static void printGugudan(int startVal, int endVal) {
        for( int i=startVal; i<=endVal; i++) {

            for( int j=1; j<=9; j++ ){
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
