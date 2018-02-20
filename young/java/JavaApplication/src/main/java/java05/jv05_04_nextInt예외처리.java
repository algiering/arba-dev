package java05;

import java.util.Scanner;

public class jv05_04_nextInt예외처리 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print( "숫자를 입력하시오: " );
        
        try {
            int x = input.nextInt();
            
            System.out.println("입력한 값은 " + x);
        }
        catch( Exception e) {
            System.out.println( "오류 발생 " + e );
        }

        System.out.println("Success!!!");        
    }    
}
