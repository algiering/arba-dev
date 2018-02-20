package java14.st1car;

public class Car {
    private int speed;
    private int gear;
    private String color;


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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", gear=" + gear +
                ", color='" + color + '\'' +
                '}';
    }

    public Car() {
        System.out.println("Car()");
    }

    public Car(int speed, int gear, String color) {
        this.speed = speed;
        this.gear = gear;
        this.color = color;
        System.out.println("Car(int speed, int gear, String color)");
    }
}
