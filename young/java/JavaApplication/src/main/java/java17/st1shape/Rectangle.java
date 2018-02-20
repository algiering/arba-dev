package java17.st1shape;

public class Rectangle extends Shape {
    
    public int width = 0;
    public int height = 0;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height
                + ", toString()=" + super.toString() + "]";
    }
    public Rectangle() {
        super();
    }

    // 메서드
    @Override
    public void draw() {
        System.out.println("Rectangle Draw()");
    }

    @Override
    public Shape getShape() {
        return null;
    }
}