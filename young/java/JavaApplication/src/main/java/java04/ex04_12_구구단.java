package java04;

import java.util.Scanner;

public class ex04_12_구구단 {
    
    public static void main(String [] args) {
        
        int r = 0;
        
        Scanner keyboard = new Scanner(System.in);  // 키보드와 프로그램 연결

        System.out.print("시작값를 입력하세요 : ");  // 사용자를 위한 텍스트 출력
        int    시작값 = keyboard.nextInt(); // 정수 입력 받아 변수 공간에 저장.

        System.out.print("종료값를 입력하세요 : ");  // 사용자를 위한 텍스트 출력
        int    종료값 = keyboard.nextInt(); // 정수 입력 받아 변수 공간에 저장.
        
        for( int i=시작값; i<=종료값; i=i+1){
            
            // 줄바꿈을 넣을 있는곳 : 첫번째
            
            for( int j=1; j<=9; j=j+1){
                r = i * j;                              
                System.out.format("%2d*%d=%3d ", i, j, r);
            }

            // 줄바꿈을 넣을 있는곳 : 두번째
            System.out.println();
        }
    }
}