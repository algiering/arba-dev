package java04;

import java.util.Scanner;

public class ex04_07_합계구하기swap {
    
    public static void main(String[] args) {
        
        
        // 변수 선언 및 초기화
        int sum = 0 ;
        int x  = 0 ; // 시작값
        int y  = 0 ; // 종료값
        
        
        // step1. 표준 입력: 키보드에서 숫자 2개 받기
        Scanner keyboard = new Scanner(System.in);        
        System.out.print("시작값을 입력하세요: ");
        x = keyboard.nextInt();
        
        System.out.print("종료값을 입력하세요: ");
        y = keyboard.nextInt(); 
        
        // step2.
        if( x > y) {
            int temp = y;
            y = x;
            x = temp;
        }
        
        // step3. 표준 출력 : 화면 출력 : 3 + 4 + 5 =12
        for(int i=x ; i<=y  ; i++ ) {
           sum = sum + i;   
        } 
        
        // step4. 표준 출력 : 1부터 4까지의 합계는 10입니다
        System.out.print(  x + "부터 " + y + "까지의 합계는 " + sum + "입니다." ); 
    }    
}
