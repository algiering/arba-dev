package java12.st1rect;

import java.util.Scanner;

public class RectTest {

    public static void main(String [] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("가로:");
        int w = keyboard.nextInt();

        System.out.print("세로:");
        int h = keyboard.nextInt();
        
        Rect re = new Rect();        
        re.setHeight( h );
        re.setWidth( w );

        int area = re.area();
        System.out.println("넓이 : " + area);

        int perimeter = re.perimeter();
        System.out.println("둘레 : " + perimeter);
    }
}
