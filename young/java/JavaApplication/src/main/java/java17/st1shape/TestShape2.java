package java17.st1shape;

public class TestShape2 {
    public static void main(String arg[]) {

        // 클래스 상향 형변환
        Shape s = null;
        Rectangle r = new Rectangle();
        r.x = 5;
        r.y = 5;
        r.width = 100 ;
        r.height = 100 ;
        System.out.println( "r" + r.toString() );

        s = r ; // 클래스 형변환: Rectangle ----> Shape
        System.out.println( "s" + s.toString() );  // r.toString() 호출됨
        
        s.x = 10;
        s.y = 10;
        // s.width = 100 ;
        // s.height = 100 ;
        System.out.println( "s" + s.toString() );
        System.out.println( "r" + r.toString() );

        // 클래스 하향 형변환
        s = new Rectangle();
        r = (Rectangle) s; 
        r.x = 10;
        r.y = 10;
        r.width = 200;
        r.height = 200;
        System.out.println( "s" + s.toString() );
        System.out.println( "r" + r.toString() );
    }
}
