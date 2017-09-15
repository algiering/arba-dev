package java02;

public class jv02_11_ASCII코드 {

    public static void main(String[] args) {
        
        int x = '4';
        int y = '5';
        int result = 0;
        
        System.out.println( "4의 ASCII코드 = " + x );
        System.out.println( "5의 ASCII코드 = " + y  + "\n");
        
        result = x + y;
        System.out.println( "더하기 = " + result ); // 출력: 더하기 = 9
        
        result = x - y;
        System.out.println( "빼기 = " + result );
        
        result = x * y;
        System.out.println( "곱하기 = " + result );
        
        result = x / y;
        System.out.println( "나누기 = " + result );
        
        result = x % y;
        System.out.println( "나머지 = " + result );

    }
    
}
