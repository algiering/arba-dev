package java14.st5animal2;

public class AnimalTest {
    
    public static void main(String[] args) {
        
        Animal a = new Animal();
        Dog d = new Dog();
        Cat c = new Cat();
        
        System.out.println("Animal");
        a.sleep();
        a.eat();
        
        System.out.println();
        System.out.println("Dog");
        d.bark();
        d.sleep();
        d.eat();
        
        System.out.println();
        System.out.println("Cat");
        c.play();
        c.sleep();
        c.eat();
    }

}
