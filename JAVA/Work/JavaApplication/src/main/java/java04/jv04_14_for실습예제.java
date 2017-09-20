package java04;

public class jv04_14_for실습예제 {
    
    public static void main(String[] args) {
        
        int multi = 0;
        
        for (int i=1;i<10;i=i+1){
            
            multi = 2 * i;
            
            if(i<9){
                System.out.print("2 * "+i+" = "+multi+", ");
            }
            
            else {
                System.out.print("2 * "+i+" = "+multi+". ");
            }
        }
    }

}
