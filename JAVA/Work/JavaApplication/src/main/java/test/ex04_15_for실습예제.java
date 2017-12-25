package test;

import java.util.Scanner;

public class ex04_15_for실습예제 {
    
    public static void main(String[] args) {
        
        int dan = 0;
        int multi = 0;
        
        Scanner keyboard = new Scanner(System.in);        
        System.out.print("단수를 입력하세요 : ");
        dan = keyboard.nextInt();
        System.out.println();
        
        System.out.println("Number:"+dan+"\n");
        System.out.println("Result:");
        
        for(int i=9; i>0; i=i-1){
            
            multi = dan * i;
            System.out.println(dan+"*"+i+"="+multi);
        }
        
        keyboard.close();
    }

}
