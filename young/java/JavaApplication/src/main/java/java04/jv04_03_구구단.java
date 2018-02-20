package java04;

public class jv04_03_구구단 {
    
    public static void main(String[] args) {
    
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                
                // 단을 의미하는 변수명은 ? i
                // 수를 의미하는 변수명은 ? j
                System.out.println( i + "X" + j + "=" + i*j);                
            }
        }
    }
    
}
