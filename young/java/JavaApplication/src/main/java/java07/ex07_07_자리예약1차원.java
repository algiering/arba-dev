package java07;

import java.util.Scanner;

/*
 * 배열을 이용하여 간단한 극장 예약 시스템을 작성하시오. 
 * 총 자석은 10개 이다. 
 * 사용자가 예약을 하려고 하면 먼저 좌석 배치를 보여 준다. 
 * 즉 예약이 끝난 좌석은 1로, 예약이 안 된 자석은 0으로 표시한다. 
 * 중복 예약이 안되도록 주의 하시오.
 */
public class ex07_07_자리예약1차원 {
    
    public static void main(String[] args) {
        
        // 배열 선언 및 생성
        int [] seat;
        seat = new int[10];
        
        // for문을 이용해서 seat 배열의 값을 0으로 만든다.
        for (int i = 0; i < seat.length; i++) {
            seat[i] = 0;
        }
        
        // int [] seat = {0,0,0,0,0,0,0,0,0,0};
        
        
        // 무한 루프 만들기
        for(  ; true;  ) {
            
            // 예약 현황 출력 : 배열 출력
            printResevation(seat);
            
            // "원하시는 좌석 번호를 입력하세요(종료는 -1) :  " 출력
            System.out.print("원하시는 좌석 번호를 입력하세요(종료는 -1) :  ");
            
            // 키보드에서 좌석 번호 입력 받기
            Scanner keyboard = new Scanner(System.in);            
            int temp = keyboard.nextInt();
            
            
            // 키보드 입력값이 -1 이면 루프 탈출
            if( temp == -1  ) break;
            
            
            if( seat[temp-1] == 0) { // 예약 받을 수 있다.
                seat[temp-1] = 1;
            }
            else {
                System.out.println("이미 예약된 자리입니다.");
            }  
        }
    }

    public static void printResevation(int[] seat) {
        for (int i = 0; i < seat.length; i++) {
            System.out.print("---");
        }
        System.out.println();
        for (int i = 0; i < seat.length; i++) {
            System.out.printf("%3d", i+1);
        }
        System.out.println();
        for (int i = 0; i < seat.length; i++) {
            System.out.print("---");
        }
        System.out.println();
        for (int i = 0; i < seat.length; i++) {
            System.out.printf("%3d", seat[i]);
        }
        System.out.println();
    }    
}
