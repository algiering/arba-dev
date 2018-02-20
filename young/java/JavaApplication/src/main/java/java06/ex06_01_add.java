package java06;

import java.util.Scanner;

public class ex06_01_add {
    
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("x 정수 값을 입력하세요 : ");
        int x = keyboard.nextInt();

        System.out.print("y 정수 값을 입력하세요 : ");
        int y = keyboard.nextInt();
        
        int sum = add(x, y);
    }

    private static int add(int x, int y) {        
        return x+y;
    }
    
}
