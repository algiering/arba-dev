package java11.st2car;

public class CarTest {
    
    public static void main(String[] args) {

        // Car 클래스의 인스턴스 생성.
        Car myCar = new Car();
        myCar.speedUp( 100 );  // myCar.speed == 100 ;
        myCar.speedPrint();
        System.out.println(  myCar.toString() );
        
        Car yourCar = new Car();
        yourCar.setColor("blue");
        yourCar.setGear(3);
        yourCar.setSpeed(60);
        System.out.println( yourCar.toString() );



        Car otherCar = new Car("blue", 60, 3);
        System.out.println( otherCar.toString() );
    }    
}
