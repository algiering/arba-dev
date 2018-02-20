package java03;

import java.util.Scanner;

public class jv03_03_중첩ifelse {
    
    public static void main(String[] args) {
    
        // 변수 선언 및 초기화
        int grade = 0;
        
        // 키보드 입력 & grade를 입력 받기.
        Scanner input = new Scanner(System.in); // 키보드 연결
        System.out.print("점수를 입력하세요: "); // 메세지 출력
        grade = input.nextInt(); // 정수 입력만 처리
        
        // grade 값 출력.
        System.out.println("점수는 " + grade );
        
        // 90점 이상이면 A
        // 80점 이상이면 B
        // 70점 이상이면 C
        // 60점 이상이면 D
        // 나머지는 F
        if( grade >= 90 ) {
            // 90~100까지
            System.out.println("A입니다.");
        }
        else {
            // 0~89까지            
            if( grade >=80 ) { // 80~89
                System.out.println("B입니다.");                
            }
            else {
                // 0~79까지 
                if( grade >= 70 ) { // 70~79
                    System.out.println("C입니다."); 
                }
                else {
                    // 0~69
                    if( grade >= 60 ) { //60~69
                        System.out.println("D입니다.");                         
                    }
                    else {
                        // 0~59
                        System.out.println("F입니다.");
                    }
                }
            }
        }
    }     
}
