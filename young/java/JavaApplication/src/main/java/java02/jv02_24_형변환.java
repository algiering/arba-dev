package java02;

public class jv02_24_형변환 {
    
    public static void main(String[] args) {
        int    result = 0;
        
        result = 1 + '2' ;       // o
        System.out.println(result);

        // result = '2' + true;     // x
        result = '2' + ( (true) ? 1 : 0 );

        // result = "15" - 5 ;      // x
        result = Integer.valueOf("15") - 5 ;

        // result = "1" + '2' ;     // x
        result = Integer.valueOf("1") + (int)'2' ;

        // result = false + true;   // x
        result = ( (false) ? 1 : 0 ) + ( (true) ? 1 : 0 ) ;

    }
}
