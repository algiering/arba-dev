package practice;

import java.util.Scanner;

import java06.ex06_02_inputVal;

public class Jv04_15_구구단가로출력 {
    
    public static void main(String[] args) {
        
        int x = 0;
        int y = 0;
        
        Scanner key = new Scanner(System.in);
        System.out.print("시작 단수를 입력하세요(0=종료):");
        x = key.nextInt();
        
        if(x==0||y==0) {
            System.out.println("종료합니다");
            System.exit(0);
        }
        
        System.out.print("종료 단수를 입력하세요(0=종료):");
        y = key.nextInt();
        
        if(x==0||y==0) {
            System.out.println("종료합니다");
            System.exit(0);
        }
        
        Print99(x,y);
        
    }

    public static void Print99(int x, int y) {
        
        int temp=0;
        
        if(x>y) {
            temp=x;
            x=y;
            y=temp;
        }
    
        for(int i=x; i<=y; i=i+1) {
            for(int j=1; j<10; j=j+1){
                if(j==9){
                    System.out.print(i+"*"+j+"="+i*j+".\n");
                }
                else{
                    System.out.print(i+"*"+j+"="+i*j+",");
                }
            }
        }
    }
}
