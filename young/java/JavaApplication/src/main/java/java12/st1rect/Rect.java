package java12.st1rect;

public class Rect {
    private int width  = 0;
    private int height = 0;
    
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
        return "Area [width=" + width + ", height=" + height + "]";
    }
    
    public Rect() {
        super();
    }
    public Rect(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }
    
    
    // 메서드
    public int perimeter() {
        return 2 * (width + height);
    }
    
    public int area() {
        return width * height;
    }
}
