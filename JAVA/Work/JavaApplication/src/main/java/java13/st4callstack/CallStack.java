package java13.st4callstack;

public class CallStack {
    
    public static void main(String[] args) {
        firstMethod();
    }

    private static void firstMethod() {
        // TODO Auto-generated method stub
        secondMethod();
    }

    private static void secondMethod() {
        // TODO Auto-generated method stub
        System.out.println("secondMethod()");
    }

}
