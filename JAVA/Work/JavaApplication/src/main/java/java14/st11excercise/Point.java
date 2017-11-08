package java14.st11excercise;

public class Point extends Shape {
    
    private int x = 0;
    private int y = 0;
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + ", toString()=" + super.toString() + "]";
    }

    public Point(String color, Point pt, int x, int y) {
        super(color, pt);
        this.x = x;
        this.y = y;
        
        System.out.println("Point(String color, Point pt, int x, int y)");
    }

    public Point() {
        super();
        System.out.println("Point");
    }
    
}
