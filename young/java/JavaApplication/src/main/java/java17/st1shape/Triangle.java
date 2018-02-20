package java17.st1shape;

public class Triangle extends Shape {
    
    private int base = 0;
    private int height = 0;
    
    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public String toString() {
        return "Triangle [base=" + base + ", height=" + height + ", toString()="
                + super.toString() + "]";
    }
    
    public Triangle() {
        super();
    }

    // 메서드
    @Override
    public void draw() {
        System.out.println("Triangle Draw()");
    }

    @Override
    public Shape getShape() {
        return null;
    }
}