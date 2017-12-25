package java11.st2;

public class CarTest {
    
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.speedUp(100); //myCar.speed==100;
        myCar.speedPrint();
        System.out.println(myCar.toString());
        
        Car yourCar = new Car();
        yourCar.setColor("Blue");
        yourCar.setSpeed(60);
        yourCar.setGear(3);
        System.out.println(yourCar.toString());
        
        Car myCar2 = new Car("Green",120,6);
        System.out.println(myCar2.toString());
    }

}
