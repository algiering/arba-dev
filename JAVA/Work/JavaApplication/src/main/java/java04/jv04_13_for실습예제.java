package java04;

import java.util.Scanner;

public class jv04_13_for실습예제 {
    
    public static void main(String[] args) {
        
        int dan = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("단수를 입력하세요 : ");
        dan = keyboard.nextInt();
        System.out.println();        

        int multi = 0;
        
        for(int i=1;i<10;i=i+1){
            
            multi = dan * i;
            
            System.out.println(dan + " * " + i + " = " + multi);
        }
        
        keyboard.close();
    }

}
