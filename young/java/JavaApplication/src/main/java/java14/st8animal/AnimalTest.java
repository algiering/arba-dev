package java14.st8animal;

public class AnimalTest {
    
    public static void main(String[] args) {
        Animal a = new Animal();
        a.sleep(); // sleep 출력
        a.eat();   // eat 출력
    
        Dog d = new Dog();
        d.sleep(); // sleep 출력
        d.eat();   // eat 출력
        d.bark();   // bark 출력
    
        Cat c = new Cat();
        c.sleep(); // sleep 출력
        c.eat();   // eat 출력
        c.play();  // play 출력
        
    }
    
}
