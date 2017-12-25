package java12.st2date;

import java.util.Scanner;

public class DateTest {
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        Date date = new Date();
        
        System.out.print("년 입력 :");
        date.setYear(keyboard.nextInt());
        
        System.out.print("월 입력 :");
        date.setMonth(keyboard.nextLine());
        
        System.out.print("일 입력 :");
        date.setDay(keyboard.nextInt());
    }

}
