package java17.st1shape;

public class TestShape4 {
    
    private static Shape arrayOfShapes[];

    public static void main(String arg[]) {
        init();
        drawAll();
    }

    public static void init() {
        arrayOfShapes    = new Shape[3];
        arrayOfShapes[0] = new Rectangle();
        arrayOfShapes[1] = new Triangle();
        arrayOfShapes[2] = new Circle();
    }

    public static void drawAll() {
        for (int i = 0; i < arrayOfShapes.length; i++) {
            arrayOfShapes[i].draw();
        }
    }
}
