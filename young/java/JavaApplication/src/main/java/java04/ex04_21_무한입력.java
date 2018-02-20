package java04;

import java.util.Scanner;

public class ex04_21_무한입력 {
    
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int input = 0;
        for( ; true; ){
            System.out.print("정수를 입력하세요 : ");
            input = keyboard.nextInt();
            
            System.out.println("입력한 값은 " + input + " 입니다.");
            
            if( input < 0) {
                System.out.println("정상 종료합니다.");
                break;
            }
        }        
    }    
}
