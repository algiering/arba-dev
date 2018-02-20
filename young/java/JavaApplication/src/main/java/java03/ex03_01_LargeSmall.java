package java03;

import java.util.Scanner;

public class ex03_01_LargeSmall {
    public  static  void main( String [] args ) {

        int n = 0;

        Scanner keyboard = new Scanner(System.in);
        System.out.print("점수를 입력하시오:");
        n = keyboard.nextInt();  // grade = 50

        if( n >= 100) {
            System.out.println("large");
        }
        else {
            System.out.println("small");
        }

        System.out.println(".");
    }
}
