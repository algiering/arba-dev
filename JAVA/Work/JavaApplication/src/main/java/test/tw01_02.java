package test;

import java.util.Scanner;

public class tw01_02 {
    
    public static void main(String[] args){
               
        Scanner keyboard = new Scanner(System.in);   
        Scanner keyboard2 = new Scanner(System.in);
        
        System.out.print("정수를 입력하세요 : ");
        int x = keyboard.nextInt();
      
        
        System.out.println("입력한 정수 : \n"+x);


        System.out.print("문자열를 입력하세요 : ");
        
        String y = keyboard2.nextLine();

        System.out.println("입력한 문자열 : "+y);        
     
        keyboard.close();
        keyboard2.close();
    }

}
