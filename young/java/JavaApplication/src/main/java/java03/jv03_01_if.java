package java03;

import java.util.Scanner;

public class jv03_01_if {
    
    public static void main(String[] args) {
    
        // 변수 선언 및 초기화
        int grade = 0;
        
        // 키보드 입력 & grade를 입력 받기.
        Scanner keyboard = new Scanner(System.in); // 키보드 연결
        System.out.print("점수를 입력하세요: "); // 메세지 출력
        grade = keyboard.nextInt(); // 정수 입력만 처리


        // grade 값 출력.
        System.out.println("점수는 " + grade );


        // ~이면
        if( grade >= 60 ) {

            System.out.println("합격입니다.");
        }
    }
}