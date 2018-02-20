package java06;

import java.util.Scanner;

public class ex06_03_isNumber {
    
    public static void main(String[] args) {

        // 키보드 연결
        Scanner keyboad = new Scanner(System.in);
        
        // 키보드에서 문자열을 입력 받아 변수에 저장
        System.out.print("문자열을 입력하세요");
        String x = keyboad.next();
        
        // isNumber 메서드 호출
        boolean tf = isNumber( x );        
        
        System.out.println(tf);
    }
    
        
    public static boolean isNumber( String args ){
        
        boolean result = false ;
        
        if( args == null || args.equals("") ) {
            result = false;
        }
        else {
            result = true;
        }   
        
        return result;
    }
}
