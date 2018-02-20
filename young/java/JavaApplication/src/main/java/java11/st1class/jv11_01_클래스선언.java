package java11.st1class;

public class jv11_01_클래스선언 {
    
    // 필드(=변수, 명사, 상태) 선언
    // 필드 선언이 변수 선언과 다른점은 
    // private 이나 public 이 붙는다
    private int     field1 = 0;
    public  boolean field2 = false;
    
    // 메서드(동사, 동작) 선언
    public void method1( int a) {
        int     field1;
        boolean field2; 
        
        System.out.println(a);
    }
    
    public int method2( int a, int b) {
        int add = a + b;
        return add;
    }
}
