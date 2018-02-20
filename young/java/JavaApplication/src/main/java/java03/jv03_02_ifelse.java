package java03;

import java.util.Scanner;

public class jv03_02_ifelse {
    
    public static void main(String[] args) {

        // 변수 선언 및 초기화
        int grade = 0;

        // 키보드 입력 & grade를 입력 받기.
        Scanner keyboard = new Scanner(System.in); // 키보드 연결
        System.out.print("점수를 입력하세요: "); // 메세지 출력
        grade = keyboard.nextInt(); // 정수 입력만 처리

        // grade 값 출력.
        System.out.println("점수는 " + grade );

        // grade가 60보다 크다 면
        if ( grade >= 60 ) {
            System.out.println("합격입니다.");
        }
        else {
            System.out.println("불합격입니다.");
        }
        
        System.out.println("수고하싰읍니다.");
        
    }    
}
