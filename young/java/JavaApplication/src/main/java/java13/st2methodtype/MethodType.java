package java13.st2methodtype;

public class MethodType {
    private static int iCount = 0;  
    private int nums = 0;           
    
    // 인스턴스 메서드
    public void instanceMethod() {
        iCount  = 100;    
        nums = 10;
        System.out.println("instanceMethod");
    }
    public void instanceMethod2() {
        instanceMethod();
        // static 메서드는 인스턴스 메서드에서 사용할 수 없다.
        staticMethod();
    }
    
    // static 메서드
    public static void staticMethod() {
        iCount  = 100;    
        // nums = 10; 에러
        System.out.println("staticMethod");        
    }

    static void staticMethod2() {
        // 인스턴스 메서드는 static 메서드에서 사용할 수 없다.
        // instanceMethod(); // 에러
        // nums = 10 ;  // 에러
        staticMethod();
    }  
          
    // abstract 메서드
    //public abstract void abstractMethod();
}
