package java13.st1var;

public class VarArgs {
    public void sub( int... v){
        System.out.println("인수의 갯수 : " + v.length );
        
        for( int i : v ) {
            System.out.print( i + " " );
        }
        System.out.println("\n------");  
        
        for( int i=0; i<v.length; i=i+1 ) {
            System.out.print( v[i] + " " );
        }
        System.out.println("\n****************************");
    }
    
}
