package java12.st3car;

public class CarTest {
    
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.speedUp(100); //myCar.speed==100;
        myCar.speedPrint();
        System.out.println(myCar.toString());
        System.out.println("numberOfCar="+myCar.getNumberOfCar());
        
        Car yourCar = new Car();
        yourCar.setColor("Blue");
        yourCar.setSpeed(60);
        yourCar.setGear(3);
        System.out.println(yourCar.toString());
        System.out.println("numberOfCar="+yourCar.getNumberOfCar());
        
        Car myCar2 = new Car("Green",120,6);
        System.out.println(myCar2.toString());
        System.out.println("numberOfCar="+myCar2.getNumberOfCar());
        
        System.out.println("-------------------------");
        System.out.println("numberOfCar="+myCar.getNumberOfCar());
        System.out.println("numberOfCar="+yourCar.getNumberOfCar());
        System.out.println("numberOfCar="+myCar2.getNumberOfCar());
        
        System.out.println("-------------------------");
        System.out.println(Car.getNumberOfCar());
        System.out.println(Car.numberOfCar);

    }

}
