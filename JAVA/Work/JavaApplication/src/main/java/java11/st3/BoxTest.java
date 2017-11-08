package java11.st3;

public class BoxTest {
    
    public static void main(String[] args) {
        
        Box myBox = new Box();
        myBox.setHeight(100);
        myBox.setLength(100);
        myBox.setWidth(100);
        
        myBox.getVolume();
        myBox.printVolume();
        
        
        Box myBox2 = new Box(100,100,100);
        
        myBox2.getVolume();
        myBox2.printVolume();

    }

}
