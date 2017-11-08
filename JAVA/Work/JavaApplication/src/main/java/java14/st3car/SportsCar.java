package java14.st3car;

public class SportsCar extends Car {

    boolean turbo;

    public boolean isTurbo() {
        return turbo;
    }

    public void setTurbo(boolean turbo) {
        this.turbo = turbo;
    }

    public SportsCar() {
        super();
    }

    public SportsCar(String color, int gear, int speed) {
        super(color, gear, speed);
    }

    public SportsCar(boolean turbo) {
        super();
        this.turbo = turbo;
    }

    public SportsCar(String color, int gear, int speed, boolean turbo) {
        super(color, gear, speed);
        this.turbo = turbo;
    }

    public SportsCar(String color, boolean turbo) {
        super(color);
        this.turbo = turbo;
    }

    @Override
    public String toString() {
        return "SportsCar [turbo=" + turbo + ", toString()=" + super.toString() + "]";
    }

}
