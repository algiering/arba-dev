package java20;

import java.util.Scanner;

public class ex20_03_숫자문자판독 {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("문자를 입력하세요 : ");
        
        // 힌트. 문자열에서 0번째 문자를 추출하는 방법.
        String input = keyboard.next();  //
        char ch = input.charAt( 0 ) ;   

        // 문자로 산술연산을 하는 경우 정수로 형변환되어 비교된다.
        if( ('a'<=ch && ch<='z' ) || ('A'<=ch && ch<='Z') )  {
            System.out.println( "영문자입니다" );
        }

        // '0' == 48, '9' == 57
        // 문자로 산술연산을 하는 경우 정수로 형변환되어 비교된다.
        if( '0'<=ch && ch<='9' )  {
            System.out.println( "숫자입니다" );
        }
    }    
}
