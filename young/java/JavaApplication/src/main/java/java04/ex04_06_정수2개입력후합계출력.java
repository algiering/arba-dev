package java04;

import java.util.Scanner;

public class ex04_06_정수2개입력후합계출력 {
    
    public static void main(String[] args) {
        
        // 변수 선언 및 초기화
        int sum = 0 ;
        int x  = 0 ; // 시작값
        int y  = 0 ; // 종료값
        
        
        // step1. 표준 입력: 키보드에서 숫자 2개 받기
        Scanner keyboard = new Scanner(System.in);        
        System.out.print("시작값을 입력하세요: ");
        x = keyboard.nextInt();

        System.out.print("두번째 정수를 입력하세요 : ");
        y = keyboard.nextInt();
        
        // step2. 계 구하기 : from x to y 
        for(int i=x ; i<=y  ; i++ ) {
            sum = sum + i;        
        }
        
        // step3. 표준 출력 : 화면 출력 : 3 + 4 + 5 =12
        for(int i=x ; i<=y  ; i++ ) {
            System.out.print(  i   ); 
            
            // i == 5 이면 + 출력하지 않게
            if( i == y ) {
                System.out.print(  "" );            
            }
            else {
                System.out.print(  "+" );
            }     
        } 

        // step4. 출력하기
        System.out.print(  "=" + sum ); 
    }    
}
