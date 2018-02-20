package java14.st4shape;

public class Rectangle extends Shape {
    
    // 필드
    private int width  = 0;
    private int height = 0;
    
    // getter & setter    
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
    
    // toString    
    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height
                + ", Shape=" + super.toString() + "]";
    }
    
    // constructor
    public Rectangle() {
        super();
        System.out.println("Rectangle()");
    }
    public Rectangle(int x, int y, String color) {
        super(x, y, color);
        System.out.println("Rectangle(int x, int y, String color)");
    }
    
    // width, height를 매개변수로 넘겨받는 Rectangle 생성자를 만드시오.
    public Rectangle(int width, int height) {
        super();
        this.width = width;
        this.height = height;
        System.out.println("Rectangle(int width, int height)");
    }

    // x, y, color, width, height를 매개변수로 넘겨받는 Rectangle 생성자를 만드시오.
    public Rectangle(int x, int y, String color, int width, int height) {
        super(x, y, color);
        this.width = width;
        this.height = height;
        System.out.println("Rectangle(int x, int y, String color, int width, int height)");
    }
    
}
