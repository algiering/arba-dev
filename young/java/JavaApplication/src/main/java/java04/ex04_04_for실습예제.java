package java04;

public class ex04_04_for실습예제 {
    
    public static void main( String [] args) {
        
        int sum = 0;
        for( int i = 1; 
                        i <= 9 ; 
                                 i=i+1 ) {
            
            sum = 2 * i ;
            
            // for문 안에서 출력 : 9번
            System.out.print("2*" + i + "=" + sum );
            
            if( i == 9 ){
                System.out.print(".");
            }
            else {
                System.out.print(", ");
            }
        }
        
    }
}
