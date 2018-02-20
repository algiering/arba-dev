package java07;

public class jv07_01_배열의선언생성대입 {

    public static void main(String [] args){

        // 변수 선언
        int    num = 0;

        // 배열 선언과 생성
        int [] nums = new int[6];

        int size = 6;
        int [] numbers = new int[size];

        // 배열에 값을 대입
        nums[0] = 10;
        nums[1] = 20;
        nums[2] = 30;
        nums[3] = 40;
        nums[4] = 50;
        nums[5] = 60;
        // nums[6] = 70;  // ArrayIndexOutOfBoundsException

        // 배열의 개별적인 값 출력
        System.out.println( nums[0] ); // 0번 값 출력
        System.out.println( nums[1] ); // 1번 값 출력
        System.out.println( nums[2] ); // 2번 값 출력
        System.out.println( nums[3] ); // 3번 값 출력
        System.out.println( nums[4] ); // 4번 값 출력
        System.out.println( nums[5] ); // 5번 값 출력

        // for를 이용한 배열값 출력// ~부터 ~까지
        for( int i = 0; i <  nums.length ; i++ ) {
            System.out.println( nums[ i ] );
        }

    }
}
