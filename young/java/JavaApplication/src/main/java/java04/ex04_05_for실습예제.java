package java04;

public class ex04_05_for실습예제 {
    
    public static void main( String [] args) {
        
        int sum = 0;
        for( int i = 9; 
                        i >= 1 ; 
                                 i=i-1 ) {
            sum = 2 * i ;
            System.out.println("2*" + i + "=" + sum );
        }
        
    }
}
