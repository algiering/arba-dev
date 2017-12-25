package java03;

import java.util.Scanner;

public class ex03_02_MaxNumber {
    
    public static void main(String[] args){
        
        double x = 0;
        double y = 0;
        double z = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("x 입력 : ");
        x = keyboard.nextDouble();
        
        System.out.print("y 입력 : ");
        y = keyboard.nextDouble();
        
        System.out.print("z 입력 : ");
        z = keyboard.nextDouble();

        System.out.print("┃");
        System.out.print(" x:"+x);
        System.out.print(" ┃");
        System.out.print(" y:"+y);
        System.out.print(" ┃");
        System.out.print(" z:"+z);
        System.out.println(" ┃");
        
        if (x>y&&x>z){            
            System.out.println("가장 큰 수 : x = "+x);
            
            if (y>z){
                System.out.println("크기 비교 : x > y > z");
            }            
            else if (z>y){
                System.out.println("크기 비교 : x > z > y");
            }            
            else if (y==z){
                System.out.println("크기 비교 : x > y = z");
            }                        
        }
        
        else if (y>x&&y>z){
            System.out.println("가장 큰 수 : y = "+y);
            
            if (x>z){
                System.out.println("크기 비교 : y > x > z");
            }            
            else if (z>x){
                System.out.println("크기 비교 : y > z > x");
            }            
            else if (x==z){
                System.out.println("크기 비교 : y > x = z");
            }
        }
        
        else if (z>x&&z>y){
            System.out.println("가장 큰 수 : z = "+z);
            
            if (x>y){
                System.out.println("크기 비교 : z > x > y");
            }            
            else if(y>x){
                System.out.println("크기 비교 : z > y > x");
            }            
            else if(x==y){
                System.out.println("크기 비교 : z > x = y");
            }
        }
        
        else if (x==y&&x>z){
            System.out.println("가장 큰 수 : x = y = "+x);
            System.out.println("크기 비교 : x = y > z");
        }
        
        else if (x==z&&x>y){
            System.out.println("가장 큰 수 : x = z = "+x);
            System.out.println("크기 비교 : x = z > y");
        }
        
        else if (y==z&&y>x){
            System.out.println("가장 큰 수 : y = z ="+y);
            System.out.println("크기 비교 : y = z > x");
        }        
        
        else if (x==y&&y==z){
            System.out.println("가장 큰 수 : x = y = z ="+x);
            System.out.println("크기 비교 : x = y = z");
        }
        
        keyboard.close();
        
      }

}
