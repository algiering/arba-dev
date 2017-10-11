package java08;

import java.util.Scanner;

public class ex08_04_문자열비교 {
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("문자열을 입력하세요 (1번째):");
        String x = keyboard.nextLine();
        
        System.out.print("문자열을 입력하세요 (2번째):");
        String y = keyboard.nextLine();
        
        System.out.print("equals 결과 : ");
        
        if(x.equals(y)) {
            System.out.print("같음");
        }
        
        else {
            System.out.print("다름");
        }

        System.out.println();
        System.out.print("== 결과 : ");
        
        if(x==y) {
            System.out.print("같음");
        }
        
        else {
            System.out.print("다름");
        }
        
        keyboard.close();
    }

}
