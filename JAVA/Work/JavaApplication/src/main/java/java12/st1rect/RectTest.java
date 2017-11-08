package java12.st1rect;

import java.util.Scanner;

public class RectTest {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Rect rect = new Rect();

        System.out.print("가로 수치 : ");
        rect.setWidth(keyboard.nextInt());

        System.out.print("세로 수치 : ");
        rect.setHeight(keyboard.nextInt());

        System.out.println("사각형의 넓이 : " + rect.area());
        System.out.println("사각형의 둘레 : " + rect.perimeter());

        keyboard.close();
    }

}
