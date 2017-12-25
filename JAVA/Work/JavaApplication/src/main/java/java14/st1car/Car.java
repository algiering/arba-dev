package java14.st1car;

public class Car {
    
    private int speed=0;
    private int gear=0;
    private String Color="a";
    
    public void speedUp(int s) {
        speed=speed+1;
    }
    
    public void speedDown(int s) {
        speed=speed-1;
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

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public Car() {
        super();
    }

    @Override
    public String toString() {
        return "Car [speed=" + speed + ", gear=" + gear + ", Color=" + Color + "]";
    }
    
}
