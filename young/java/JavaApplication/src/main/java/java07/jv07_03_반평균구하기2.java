package java07;

import java.util.Scanner;

public class jv07_03_반평균구하기2 {

    public static void main( String[] args) {

        // 키보드와 프로그램 연결
        Scanner keyboard = new Scanner(System.in);  // 키보드와 프로그램 연결

        // 키보드에서 배열의 크기를 입력 받는다    
        System.out.print("배열의 크기를 입력하세요 : ");  // 사용자를 위한 텍스트 출력
        int    x = keyboard.nextInt(); // 정수 입력 받아 x 공간에 저장.
     
        // 입력 받은 수( == x) 만큼의 배열을 만든다.
        int [] array = new int[ x ];

        // 배열에 넣는다.
        // array[0] = 0;
        // array[1] = 1;
        // array[2] = 2;
        
        // 키보드에서 입력 받은 값을 배열에 넣는다.
        // 키보드 입력을 입력 받은 수 만큼 반복한다.
        // 반복 : ~부터~까지,
        int sum = 0;
        for( int i = 0; i <= array.length-1 ; i=i+1 ) {
            System.out.print("숫자를 입력하세요 : ");  // 사용자를 위한 텍스트 출력
            array[0] =keyboard.nextInt(); // 정수 입력 받아 x 공간에 저장.
        }

        // 배열 값을 출력( print )  : for문을 이용해서
        // 반복 : ~부터~까지,
        for( int i = 0; i <= array.length-1 ; i=i+1 ) {
            System.out.println( array[ i ] );
        }
       

    }
}
