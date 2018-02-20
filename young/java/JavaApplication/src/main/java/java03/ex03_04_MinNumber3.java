package java03;

import java.util.Scanner;

public class ex03_04_MinNumber3 {
    
    public static void main(String[] args) {
        
        // 변수의 선언과 초기화
        int x = 0;
        int y = 0;
        int z = 0;
        
        // 키보드 입력
        Scanner keyboard = new Scanner(System.in); // Scanner버퍼를 선언합니다.
        
        System.out.print("첫번째 정수를 입력하세요 : ");
        x = keyboard.nextInt();
        
        System.out.print("두번째 정수를 입력하세요 : ");
        y = keyboard.nextInt();
        
        System.out.print("세번째 정수를 입력하세요 : ");
        z = keyboard.nextInt();
        
        
        
        // 중첩 if 를 이용한 가장 큰 값을 찾기.
        
        // x 와 y를 비교
        if( x < y ) { // x가 y보다 큰 경우 : x
            
            // x 와 z를 비교
            if( x < z ) {
                // x가 z보다 크다
                System.out.println(x);
            }
            else {
                // z가 x보다 크다
                System.out.println(z);
            }
        }
        else { // y가 x보다 큰 경우 : y
            
            // y와 z 비교
            if( y < z ) {
                // y가 z보다 크다
                System.out.println(y);
            }
            else {
                // z가 y보다 크다
                System.out.println(z);
            }
        }
        
                   

        // 연속 if 를 이용한 가장 큰 값을 찾기.        
        if (x < y && x < z) {
            // x print
        } 
        else if (y < z) {
            // y print
        } 
        else {
            // z print
        }        
    }
}
