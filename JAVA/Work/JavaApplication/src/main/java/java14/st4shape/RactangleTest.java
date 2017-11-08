package java14.st4shape;

public class RactangleTest {
    
    public static void main(String[] args) {
        
        //use setter
        Rectangle r1 = new Rectangle();
        r1.setColor("Yellow");
        r1.setHeight(10);
        r1.setWidth(15);
        r1.setX(12);
        r1.setY(14);
        
        //all value
        Rectangle r2 = new Rectangle(12, 14, "Black", 30, 20);
        
        //Rectangle width, height
        Rectangle r3 = new Rectangle(20, 30);
        
        //Shape x,y,color
        Rectangle r4 = new Rectangle(20, 25, "Green");
        
        //nothing value
        Rectangle r5 = new Rectangle();
        
        //just color
        Rectangle r6 = new Rectangle("Magneta");
        
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println(r3.toString());
        System.out.println(r4.toString());
        System.out.println(r5.toString());
        System.out.println(r6.toString());
    }
}
