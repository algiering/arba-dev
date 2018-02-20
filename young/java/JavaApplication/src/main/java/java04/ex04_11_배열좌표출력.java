package java04;

public class ex04_11_배열좌표출력 {
    public static void main( String [] args) {
        
        for( int i =1; i<=5; i=i+1) {
            for( int j = 1; j<=5; j=j+1) {
                
                // i == j 이면 [i,j] 출력 아니면 "     " 출력
                if( i == j ) {
                    System.out.print("[" + i + "," + j + "]"); 
                }
                else {
                    System.out.print("     "); 
                }               
            }

            // 줄바꿈 추가
            System.out.println();
        }
    }
    
}
