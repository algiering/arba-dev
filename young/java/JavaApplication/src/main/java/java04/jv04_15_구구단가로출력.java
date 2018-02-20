package java04;

public class jv04_15_구구단가로출력 {
    
    public static void main(String [] args) {
        
        int r = 0;
        for( int i=2; i<=19; i=i+1){
            
            // 줄바꿈을 넣을 있는곳 : 첫번째
            
            for( int j=1; j<=9; j=j+1){
                r = i * j;                              
                System.out.format("%2d*%d=%3d", i, j, r);
                
                if( j == 9 ) {
                    System.out.print(". ");
                }
                else {
                    System.out.print(", ");
                }
            }

            // 줄바꿈을 넣을 있는곳 : 두번째
            System.out.println();
        }
    }
}