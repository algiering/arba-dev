package java04;

public class jv04_11_구구단세로출력2 {
    
    public static void main(String[] args) {
        
        for(int i=2; i<20; i=i+1) {
            
            for(int j=2; j<10; j=j+1){
                
                if(j==9) {
                    System.out.format("%d*%d=%d.", i, j, i*j);
                }
                
                else {
                    System.out.format("%d*%d=%d, ", i, j, i*j);
                }
                
            }
            System.out.println();
        }
        
    }
    
}