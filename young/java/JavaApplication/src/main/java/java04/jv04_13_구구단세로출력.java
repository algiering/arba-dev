package java04;

public class jv04_13_구구단세로출력 {
    
    public static void main(String [] args) {
        
        int r = 0;
        for( int i=2; i<=19; i=i+1){
            
            for( int j=1; j<=9; j=j+1){
                r = i * j;
                
                //System.out.println( i+"*"+j + " = " + r );              
                //System.out.format("%d*%d=%d \n", i, j, r);               
                System.out.format("%2d*%3d=%5d \n", i, j, r);
            }
        }
    }
}

