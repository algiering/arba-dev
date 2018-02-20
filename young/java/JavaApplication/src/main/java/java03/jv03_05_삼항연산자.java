package java03;

public class jv03_05_삼항연산자 {

    public static void main( String [] args ){

        int x=10, y=20;
        int max = 0;

        // x와 y 중에서 max 값 찾기
        if( x > y ) {
            max = x;
        }
        else {
            max = y;
        }
        System.out.println( "첫번째 max = " + max);


        // 삼항연산자 : ?
        max = ( x > y ) ? x : y ;
        System.out.println( "두번째 max = " + max);
    }
}
