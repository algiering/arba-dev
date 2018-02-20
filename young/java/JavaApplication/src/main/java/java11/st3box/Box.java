package java11.st3box;

public class Box {

    // 데이터, 필드, 멤버변수
    private int width  = 0;
    private int length = 0;
    private int height = 0;
    
    // getter & setter 
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    
    // toString()
    @Override
    public String toString() {
        return "Box [width=" + width + ", length=" + length + ", height="
                + height + "]";
    }
    
    // constructor
    public Box() {
        super();
    }
    public Box(int width, int length, int height) {
        super();
        this.width = width;
        this.length = length;
        this.height = height;
    }
    
    // 메서드  정의
    int getVolumn() {
        return width * length * height ;
    }
    
    void printVolum() {
        int volumn = getVolumn();
        System.out.println( volumn );
    }
    
}
