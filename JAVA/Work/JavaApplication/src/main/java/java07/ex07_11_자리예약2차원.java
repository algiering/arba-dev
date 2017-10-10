package java07;

public class ex07_11_자리예약2차원 {
    
    public static void main(String[] args) {
        
        int[][] fR= new int[3][3];
        int[][] sR= new int[3][4];
        
        for(int i=1; i<4; i=i+1) {

            System.out.println("");
            
            for(int j=1; j<4; j=j+1) {
                
                    System.out.print(fR[i-1][j-1]);
                    System.out.print(sR[i-1][j-1]);
                    if((0==(i-1)%1)&&(0==(j-1)%3)){
                        System.out.print("    ");
                    }
            }
        }
    }

}
