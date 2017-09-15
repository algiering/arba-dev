package java02;

import java.util.Scanner;

public class jv02_16_비교논리결합 {
    
    public static void main(String[] args){
        
        // 정수 변수 선언 & 초기화
        
        int x = 0;
        int y = 0;
        
        Scanner keyboard = new Scanner(System.in);

        System.out.println("논리계산기");       
        System.out.println();                
        System.out.print("x값 입력:");
        x = keyboard.nextInt();       
        System.out.print("y값 입력:");
        y = keyboard.nextInt();       
        keyboard.close();

        
        System.out.println();                
        System.out.println("x의 값:"+x+"      y의 값:"+y);        
        System.out.println();       
        
                
        System.out.print("(x == y)&&(x != y) ▶ ");
        System.out.println((x == y)&&(x != y));       
        System.out.print("(x > y)||(x < y) ▶ ");
        System.out.println((x > y)||(x < y));     
        System.out.print("(x >= y)||(x <= y) ▶ ");
        System.out.println((x >= y)||(x <= y));      
        System.out.print("(x == y)&&(x != y)||(x < y) ▶ ");
        System.out.println((x == y)&&(x != y)||(x < y));
        
        
    }
    
}
