package java05;

class MyExceptin extends Exception {

    public MyExceptin() {
        super("사용자 정의 Exception");
    }
}

public class jv05_07_throw {
    
    public static void main(String[] args) {

        try {
            method1();
        } catch (MyExceptin myExceptin) {
            myExceptin.printStackTrace();
        }
    }

    public static void method1() throws MyExceptin {
        throw new MyExceptin();
    }
}
