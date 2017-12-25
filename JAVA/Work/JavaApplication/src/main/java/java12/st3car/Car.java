package java12.st3car;

public class Car {

    private String color = "빨강";
    private int speed = 100;
    private int gear = 4;
    private int carId = 0;

    public static int numberOfCar = 0;

    public void speedUp(int s) {
        speed = speed + s;
    }

    public void speedDown(int s) {
        speed = speed - s;
    }

    public void speedPrint() {
        System.out.println("속도 " + speed + "km");
    }

    // getter & setter

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public static int getNumberOfCar() {
        return numberOfCar;
    }

    // default 생성자
    public Car() {
        super();
        carId = ++numberOfCar;
    }

    // constructor(생성자)

    public Car(String color, int speed, int gear) {
        super();
        this.color = color;
        this.speed = speed;
        this.gear = gear;
        carId = ++numberOfCar;
    }

    // toString()

    @Override
    public String toString() {
        return "Car [color=" + color + ", speed=" + speed + ", gear=" + gear + ", carId=" + carId +", numberOfCar="+ numberOfCar + "]";
    }

}
