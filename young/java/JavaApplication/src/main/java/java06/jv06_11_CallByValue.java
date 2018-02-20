package java06;

public class jv06_11_CallByValue {
    
    public static void main(String[] args) {

        // 변수의 선언 과 초기화
        int a = 5;
        int b = 3;

        System.out.println("swap 전: a=" + a + ", b=" + b );
        swap(a, b);
        System.out.println("swap 후: a=" + a + ", b=" + b );
    }
    
    // a와 b의 값을 바꾸기 (a-->b, b-->a)
    public static void swap(int a, int b) {

        // 변수 선언 & 초기화
        int temp =0;

        // a-->b, b-->a
        temp = b;     // b = 3, temp = 3
        b    = a;     // a = 5, b = 5
        a    = temp;  // a = 3, temp = 3

        System.out.println("swap 안에서 : a=" + a + ", b=" + b );
    }
}
