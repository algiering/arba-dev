package java13.st2methodtype;

public class MethodTypeTest {
    public static void main(String[] args) {
        MethodType test = new MethodType();

        test.InstanceMethod();
        MethodType.StaticMethod();
        //test.StaticMethod(); - 사용하지 않는다
    }

}
