package java17.st1shape;

public class TestInstanceOf {
    
    public static void main(String arg[]) {
        Circle c = new Circle();
        Shape.getShape(c);  

        Rectangle r= new Rectangle();
        Shape.getShape(r);  

        Triangle t = new Triangle();
        Shape.getShape(t);  
        
        // 질문.
        Shape s = new Rectangle();
        Shape.getShape(s);  
        
    }
}
