package java17.st1shape;

public class TestShape1 {
    
    public static void main(String arg[]) {
        Circle c = new Circle();
        c.draw();  // Circle Draw()

        Rectangle r= new Rectangle();
        r.draw();  // Rectangle Draw()

        Triangle t = new Triangle();
        t.draw();  // Triangle Draw()
        
        // 질문.
        Shape s = new Rectangle();
        s.draw();  // Shape Draw() or Rectangle Draw()
        
    }
}
