package java06;

public class jv06_04_어떻게메서드를만드는가 {
    
    public static void main(String[] args) {
                
        // 1부터 10까지의 합계를 구하고 
        // 그 합계를 sum에 저장하고 출력한다. 
        int sum = getSum(1, 10);
        System.out.println("1부터 10까지 합계 = " + sum );

        // 1부터 100까지의 합계를 구하고 
        // 그 합계를 sum2 에 저장하고 출력한다.        
        int sum2 = 0;
        for (int i = 1; i <= 100; i++) {
            sum2 = sum2 + i;
        }
        System.out.println("1부터 100까지 합계 = " + sum2 );
                
        // 100부터 sum2까지의 합계를 구하고 
        // 그 합계를 sum3 에 저장하고 출력한다. 
        int sum3 = 0;
        for (int i = 100 ; i<=sum2 ; i++) {
            sum3 = sum3 + i;
        }
        System.out.println("100부터 "+ sum2 + "까지 합계 = " + sum3 );
        
    }

    public static int getSum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum = sum + i;
        }
        return sum;
    }
    
}
