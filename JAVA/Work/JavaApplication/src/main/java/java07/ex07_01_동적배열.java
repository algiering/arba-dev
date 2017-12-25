package java07;

import java.util.Scanner;

public class ex07_01_동적배열 {
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("배열 크기를 입력하세요:");
        int x = keyboard.nextInt();
        
        int[] num = new int[x];
        
        System.out.println(num.length);
        
        keyboard.close();
    }

}
