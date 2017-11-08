package java17.st1shape;

public class ShapeTest2 {

    public static void main(String[] args) {

        Shape s = null;
        Rectangle r = new Rectangle();

        r.x = 5;
        r.y = 5;
        r.width = 100;
        r.height = 100;
        System.out.println("r" + r.toString());

        s = r;
        System.out.println("s" + s.toString());

        s.x = 10;
        s.y = 10;
        ((Rectangle)s).height = 100;
        ((Rectangle)s).width = 100;
        
        System.out.println("s" + s.toString());
        System.out.println("r" + r.toString());

    }

}
