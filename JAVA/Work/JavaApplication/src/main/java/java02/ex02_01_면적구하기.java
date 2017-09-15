package java02;

import java.util.Scanner;

public class ex02_01_면적구하기 {
    
    public static void main(String[] args){
        
        int w = 0;
        int h = 0;
        
        int area = 0;
        int perimeter = 0;
  
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print( "가로 입력:" );
        w = keyboard.nextInt();
        
        System.out.print( "세로 입력:" );
        h = keyboard.nextInt();
        
        keyboard.close();
        
        area = w * h;
        perimeter = 2 * ( w + h );
        
        System.out.println();
        System.out.println( "면적:"+ area );
        System.out.println( "둘레:"+ perimeter );     
        
        
    }
    
}
