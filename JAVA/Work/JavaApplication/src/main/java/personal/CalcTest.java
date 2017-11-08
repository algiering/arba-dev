package personal;

import java.util.Scanner;

public class CalcTest {

    public static void main(String[] args) {
    
            Scanner keyboard = new Scanner(System.in);
    
            Calc myCalc = new Calc();
            
            System.out.print("First num : ");
            myCalc.setFirstNum(keyboard.nextInt());
            System.out.print("Second num : ");
            myCalc.setSecondNum(keyboard.nextInt());
    
            System.out.println("Add : "+myCalc.Add());
            System.out.println("Minus : "+myCalc.Minus());
            System.out.println("Mul : "+myCalc.Mul());
            System.out.printf("Div : %.6f\n", myCalc.Div());
            
            keyboard.close();
        }
}