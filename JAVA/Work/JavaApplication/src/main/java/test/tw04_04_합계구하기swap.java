package test;

import java.util.Scanner;

public class tw04_04_합계구하기swap {

    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        int x = 0;
        int y = 0;
        
        int temp = 0;
        
        System.out.print("시작값을 입력하세요 : ");
        x = keyboard.nextInt();
        
        System.out.print("종료값을 입력하세요 : ");
        y = keyboard.nextInt();
        
        
        if (x>y) {            
            temp = x;
            x = y;
            y = temp;
        }
        
        else{            
        }
        
        int sum = 0;
        
        for (int i=x;i<=y;i=i+1){
            
            sum = sum + i;
        }
        System.out.println(sum);
    
        keyboard.close();
    }
    
}
