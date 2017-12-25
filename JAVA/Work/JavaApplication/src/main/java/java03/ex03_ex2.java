package java03;

import java.util.Scanner;

public class ex03_ex2 {
    
    public static void main(String[] args){
        
        double k = 0;
        
        System.out.print("k값 입력 : ");
        Scanner keyboard = new Scanner(System.in);
        
        k = keyboard.nextDouble();
        
        if (k==0){
            System.out.println("A");
        }
        
        else if (k>3){
            System.out.println("B");
        }
        
        else {
            System.out.println("C");
        }
        
        keyboard.close();
    }

}
