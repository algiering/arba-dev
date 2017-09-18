package java03;

import java.util.Scanner;

public class ex03_01_LargeSmall {
    
    public static void main(String[] args){
        
        System.out.println("정수를 입력하세요 : ");
        
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        
        keyboard.close();
        
        if (n >= 100){
            System.out.println("Large");
        }
        
        else{
            System.out.println("Small");
        }
    }

}
