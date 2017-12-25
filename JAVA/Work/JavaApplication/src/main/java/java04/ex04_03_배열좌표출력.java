package java04;

public class ex04_03_배열좌표출력 {
    
    public static void main(String[] args) {
        
   
        for (int i=1; i<=5; i=i+1){
            
            if (i==1){
                for(int x=1; x<=5; x=x+1)
                    if (x==1)
            System.out.print("["+i+","+x+"]");
            }
            
            if (i==2){
                for(int x=1; x<=5; x=x+1)
                    if (x==2)
            System.out.print("     ["+i+","+x+"]");
            }
            
           
            if (i==3){
                for(int x=1; x<=5; x=x+1)
                    if (x==3)
            System.out.print("          ["+i+","+x+"]");
            }
            
            if (i==4){
                for(int x=1; x<=5; x=x+1)
                    if (x==4)
            System.out.print("               ["+i+","+x+"]");
            }
            
            if (i==5){
                for(int x=1; x<=5; x=x+1)
                    if (x==5)
            System.out.print("                    ["+i+","+x+"]");
                    
            }

            System.out.println();
        }
    }

}
