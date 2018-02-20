package java05;

public class jv05_02_예외처리 {
    
    public static void main(String[] args) {

        // 변수의 선언과 초기화
        int x = 10;
        int y = 0;        
        int z = 0;        

        try {
            z = x / y;
        } catch (Exception e) {  
            // ArithmeticException
            e.printStackTrace();
        } finally {
        }
        System.out.println("나누기 결과: " + z);

        // 배열의 선언과 초기화
        // 배열은 0부터 시작한다.
        int [] arr = { 1, 2, 3, 4 };
        try {
            System.out.println( arr[5] );
        } catch (Exception e) {        
            // ArrayIndexOutOfBoundsException
            e.printStackTrace();
        } finally {
        } 
        
        System.out.println("프로그램 정상 종료");
    }
}
