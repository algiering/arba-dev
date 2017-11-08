package java16.st2interface;

public class RemoteControlTest {
    
    public static void main(String[] args) {
        
        RemoteControl obj = new Television();
        obj.turnOn();
        obj.turnOff();
        obj.moveLeft();
        obj.moveRight();
        
        obj = new Fridge();
        obj.turnOn();
        obj.turnOff();
        obj.moveLeft();
        obj.moveRight();
        
        SerialCommunication objs = new Television();
        
        objs.send();
        objs.receive();
        
        objs = new Fridge();
        
        objs.send();
        objs.receive();
        
    }

}
