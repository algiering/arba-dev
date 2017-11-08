package java13.st3overload;

public class Dog {
    public void sound() {
        System.out.println("sound");
    }

    public void sleep() {
        System.out.println("sleep()");
    }

    public void sleep(int a) {
        System.out.println("sleep(int a)");
    }

    public void sleep(String a) {
        System.out.println("sleep(String a)");
    }
    
    public void sleep(int a, String b) {
        System.out.println("sleep(int a, String b");
    }
    
    public void sleep(String a, int b) {
        System.out.println("sleep(String a, int b)");
    }
    
    public int sleep(int a, int b) {
        System.out.println("sleep(int a, int b)");
        return 0;
    }
}
