package java04;

import java.util.Scanner;

public class ex04_12 {
    
    public static void main(String[] args){
        
        int a = 0;
        int b = 0;
        
        int sum = 0;
        
        System.out.print("시작값을 입력하세요 : ");
        Scanner keyboard = new Scanner(System.in);
        a = keyboard.nextInt();

        System.out.print("종료값을 입력하세요 : ");
        b = keyboard.nextInt();
        
        if(a<b){
            for(int i=a;i<=b;i=i+1){
                sum = sum + i;
            }
            System.out.printf("%d부터 %d까지의 합계는 %d입니다\n",a,b,sum);
        }
        
        else {
            for(int i=b;i<=a;i=i+1){
                sum = sum + i;
            }
            System.out.printf("%d부터 %d까지의 합계는 %d입니다\n",b,a,sum);
        }
    
        
        keyboard.close();
    }

}
