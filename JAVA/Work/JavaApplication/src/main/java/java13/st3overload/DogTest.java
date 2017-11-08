package java13.st3overload;

public class DogTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Dog dog = new Dog();
        
        dog.sound();
        dog.sleep();
        dog.sleep(0);
        dog.sleep("a");
        dog.sleep(0, "a");
        dog.sleep("a", 0);
        dog.sleep(0, 0);
        System.out.println(dog.sleep(0, 0));
    }

}
