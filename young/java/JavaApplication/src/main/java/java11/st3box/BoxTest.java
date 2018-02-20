package java11.st3box;

public class BoxTest {
    
    public static void main( String[] args ){

        // Box 인스턴스 생성하시오
        Box c = new Box(100, 100, 100);
        

        Box b = new Box();
        // width : 100
        b.setWidth(100);

        // length: 100
        b.setLength(100);
        
        // height: 100
        b.setHeight(100);

        // 부피를 계산하고 출력하시오.
        c.printVolum();
        
        b.printVolum();

        
        
    }
    
}
