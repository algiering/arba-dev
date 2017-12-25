package java14.st2hasa;

public class CircleTest {
    
    public static void main(String[] args) {
        
        Circle c = new Circle();
        Point p = new Point();
        
        Point center = new Point();
        center.setX(25);
        center.setY(78);
        
        Circle c1 = new Circle();
        c1.setRadius(10);
        c1.setCenter(center);
        
        Circle c2 = new Circle();
        c2.setRadius(10);
        center = new Point(25,75);
        c2.setCenter(center);
        
        
        System.out.println(c.toString());
        System.out.println(p.toString());
        
    }

}
