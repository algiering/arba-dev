package java18;

import java.util.Random;
import java.util.Scanner;

public class jv18_03_Random {
    
    public static void main(String[] args) {
        // 난수(임의의 수) 만들기       
        // new Random().nextDouble()는 0부터 1사이의 실수값        
        Random rand = new Random();
        double rand1 = rand.nextDouble();
        System.out.println(rand1);
        
        // 난수를 이용해서 0부터 2사이의 값을 만드시오.       
        double rand3 = rand.nextDouble() * 2;       
        System.out.println(rand3);  
        
        // 문제 1. 1부터 3미만 사이의 실수 난수 값을 만드시오.     
        rand3 = rand.nextDouble() * 3;       
        System.out.println(rand3);   
        

        // 문제 2. 0이상 10 미만의 실수 난수 5개를 생성해서 출력하시오. 
        for( int i=1; i<6; i=i+1){
            rand3 = rand.nextDouble() * 5;       
            System.out.println(rand3);
        }

        // 문제 3. 사용자로 부터 최대 정수 A와 최소 정수 B를 입력 받는다.         
        //         그리고 A와 B 사이에 존재하는 정수 난수 10개를 생성해서 출력하시오.
        Scanner key = new Scanner(System.in);
        System.out.print("최대값 입력 : ");
        int max = key.nextInt();
        System.out.print("최소값 입력 : ");
        int min = key.nextInt();

        for (int i = 1; i <= 10; i++) {
            int rand2 = rand.nextInt(max - min + 1) + min;
            System.out.println(rand2);
        }
    }
}
