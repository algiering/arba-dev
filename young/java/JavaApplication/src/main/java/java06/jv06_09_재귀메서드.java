package java06;

public class jv06_09_재귀메서드 {
    
    public static void main(String[] args){
        int count = 0;
        Recursive(count);
    }

    public static void Recursive( int count) {
        count ++ ;
       System.out.println("Recursive Call! :: " + count );
       
       Recursive( count);
    }
}
