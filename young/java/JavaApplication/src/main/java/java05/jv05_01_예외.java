package java05;

public class jv05_01_예외 {
    
    public static void main(String[] args) {

        // 변수의 선언과 초기화
        int x = 10;
        int y = 0;        
        int z = 0;
        z = x / y;  // ArithmeticException 
        
        // 배열의 선언과 초기화
        // 배열은 0부터 시작한다.
        String [] array = { "a", "b", "c"};
        System.out.println( array[4] ); // ArrayIndexOutOfBoundsException
            
        System.out.println("정상 종료");
    }
}
