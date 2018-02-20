package java04;


public class jv04_12_삼각형출력 {

    public static void main( String [] args ) {

        for( int i = 1; i <= 10 ; i++ ) {
            for( int j = 1; j <= 10 ; j++ ) {
                System.out.print("*");
            }            
            System.out.println();
        }

        System.out.println();

        for( int i = 1; i <= 10 ; i++ ) {
            for( int j = 1; j <= i ; j++ ) {
                System.out.print("*");
            }            
            System.out.println();
        }
        
        System.out.println();
        
        for( int i = 1; i <= 10 ; i++ ) {
            for( int j = 1; j <= 10 ; j++ ) {
                
                if(j>=i) 
                    System.out.print("*");
                else 
                    System.out.print(" ");
            }            
            System.out.println();
        }
    }
}
