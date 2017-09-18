package java03;

import java.util.Scanner;

public class jv03_03_중첩ifelse {
    
    public static void main(String[] args){
        
        System.out.print("점수를 입력하세요 : ");
        
        Scanner keyboard = new Scanner(System.in);
        int grade = keyboard.nextInt();

        keyboard.close();

        
        if (grade>=90){
            System.out.println("A");
        }
        
        else if (grade>=80){
            System.out.println("B");
        }
        
        else if (grade>=70){
            System.out.println("C");
        }
        
        else if (grade>=60){
            System.out.println("D");
        }
        
        else {
            System.out.println("F");
        }
        
    }

}
