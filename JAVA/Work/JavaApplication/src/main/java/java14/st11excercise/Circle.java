package java14.st11excercise;

public class Circle extends Shape {
    
    private int radius = 0;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", toString()=" + super.toString() + "]";
    }

    public Circle(String color, Point pt, int radius) {
        super(color, pt);
        this.radius = radius;
        System.out.println("Circle(String color, Point pt, int radius)");
    }

    public Circle() {
        super();
        System.out.println("Circle");
    }

}
