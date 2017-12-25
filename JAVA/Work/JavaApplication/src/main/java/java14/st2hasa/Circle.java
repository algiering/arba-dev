package java14.st2hasa;

public class Circle {
    
    private int radius=0;
    private Point center;
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public Point getCenter() {
        return center;
    }
    public void setCenter(Point center) {
        this.center = center;
    }
    public Circle(int radius, Point center) {
        super();
        this.radius = radius;
        this.center = center;
    }
    public Circle() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", center=" + center + "]";
    }
    
    

}
