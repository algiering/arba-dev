package test;

import java.util.Scanner;

public class tw02_01 {
    
    public static void main(String[] args){
        
        double w = 0;
        double h = 0;
        
        double area = 0;
        double perimeter = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("가로를 입력하세요 : ");
        w = keyboard.nextDouble();
        
        System.out.print("세로를 입력하세요 : ");
        h = keyboard.nextDouble();
        
        area = w*h;
        perimeter = (w+h)*2;
        
        keyboard.close();
        
        System.out.println();
        System.out.println("면적 : "+ area);
        System.out.println("둘레 : "+ perimeter);
        
    }

}
