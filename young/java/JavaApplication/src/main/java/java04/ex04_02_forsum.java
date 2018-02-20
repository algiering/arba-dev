package java04;

import java.util.Scanner;

public class ex04_02_forsum {
    
    public static void main(String[] args) {
                
        int sum = 0;
        for( int i=1;  i<=10; i=i+1 ) {
            sum = sum + i;
            
            // 합계 출력
            System.out.println("1부터 " + i + " 까지의 합: " + sum );

            // System.out.format("1부터 %2d 까지의 합: %3d", i, sum ); 
        }
    }    
}
