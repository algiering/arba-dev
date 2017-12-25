package java06;

import java.util.Scanner;

public class ex06_03_isNumber {
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("문자열을 입력하세요 :");
        String s = keyboard.nextLine();
        
        boolean b = isNumber(s);
        
        System.out.println(b);
        
        keyboard.close();
    }
    
    public static boolean isNumber(String x) {
        
        if(x.equals("")||x==null) {
            return false;
        }
        
        else {
            return true;
        }
                
    }

}
