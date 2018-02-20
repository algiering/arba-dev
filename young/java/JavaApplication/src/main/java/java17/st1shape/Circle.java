package java17.st1shape;

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
        return "Circle [radius=" + radius + ", toString()=" + super.toString()
                + "]";
    }

    public Circle() {
        super();
    }

    // 메서드
    @Override
    public void draw() {
        System.out.println("Circle Draw()");
    }

    @Override
    public Shape getShape() {
        return null;
    }
}