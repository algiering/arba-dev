package java15.st2interface;

public class RemoteControlTest {
    
    public static void main(String[] args) {

        // 전통적인 인스턴스 생성
        Television t1 = new Television();
        t1.turnOn();
        t1.turnOff();
        
        Fridge f1 = new Fridge();
        f1.turnOn();
        f1.turnOff();


        // 인터페이스를 이용한 인스턴스 생성
        RemoteControl obj = new Television();
        obj.turnOn();
        obj.turnOff();

        obj = new Fridge();
        obj.turnOn();
        obj.turnOff();
    }    
}
