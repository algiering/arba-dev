package java17.st1shape;

public class ShapeTest {

    public static void main(String[] args) {
        
        Circle c = new Circle();
        c.draw();
        
        System.out.println("-------------------");
        
        Rectangle r = new Rectangle();
        r.draw();
        
        System.out.println("-------------------");
        
        Triangle t = new Triangle();
        t.draw();

    }

}
