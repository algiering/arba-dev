package java14.st3car;

public class Car {

    private String color = "";
    private int gear = 0;
    private int speed = 0;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Car(String color, int gear, int speed) {
        super();
        this.color = color;
        this.gear = gear;
        this.speed = speed;
    }

    public Car() {
        super();
    }

    public Car(String color) {
        super();
        this.color = color;
    }

    public void SpeedUp(int s) {
        this.speed = this.speed + s;
    }

    public void SpeedDown(int s) {
        this.speed = this.speed - s;
    }

    @Override
    public String toString() {
        return "Car [color=" + color + ", gear=" + gear + ", speed=" + speed + "]";
    }
}
