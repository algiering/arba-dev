package java06;

import java.util.Scanner;

public class ex06_07_합계구하기_method {
    
    public static void main(String[] args) {
        
        // 변수 선언 및 초기화
        
        // step1. 표준 입력: 키보드에서 숫자 2개 받기
        Scanner keyboard = new Scanner(System.in);        
        System.out.print("시작값을 입력하세요: ");
        int x = keyboard.nextInt();
        
        System.out.print("종료값을 입력하세요: ");
        int y = keyboard.nextInt(); 
        
        // step2. swap
        if( x > y ) {
            int temp = y;
            y = x ;
            x = temp;
        }
        
        // step3. 합계 구하기 : from x to y 
        int sum = getsum( x, y);
                
        // step4.표준 출력 : 화면 출력 : 3 + 4 + 5 =12
        printResult(sum, x, y); 
    }

    public static int getsum(int x, int y) {
        int sum = 0;
        for(int i=x ; i<=y  ; i++ ) {
            sum = sum + i;        
        }
        return sum;
    }

    public static void printResult(int sum, int x, int y) {
        for(int i=x ; i<=y  ; i++ ) {
            System.out.print(  i   );

            // i == 5 이면 + 출력하지 않게
            if( i != y ) {
                System.out.print(  "+" );         
            } 
        }
        System.out.print(  "=" + sum );
    }    
}
