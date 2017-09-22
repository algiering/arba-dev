package java04;

public class jv04_11_구구단세로출력 {
    
    public static void main(String[] args) {
        
        int dan = 2;
        int multi = 0;
        
        for(int j=dan; j<=19; j=j+1){

            for(int i=1; i<=9; i=i+1) {
                
                multi = dan*i;
                
                System.out.format("%d*%d=%d  ",dan,i,multi);
            

            if (i==9){
            
                System.out.format("%d*%d=%d\n",dan,i,multi);
            }
        }            
            dan=dan+1;        
        }
    }
}
