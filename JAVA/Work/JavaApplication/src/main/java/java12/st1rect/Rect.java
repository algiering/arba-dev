package java12.st1rect;

public class Rect {

    private double width = 0;
    private double height = 0;

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Rect() {
        super();
    }

    @Override
    public String toString() {
        return "Rect [width=" + width + ", height=" + height + "]";
    }
    

}
