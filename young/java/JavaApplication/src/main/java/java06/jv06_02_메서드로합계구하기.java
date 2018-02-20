package java06;

public class jv06_02_메서드로합계구하기 {
    
    public static void main(String[] args) {
                
        // 1부터 10까지의 합계를 구하고 
        // 그 합계를 sum에 저장하고 출력한다. 
        int sum = getSum(1, 10);
        System.out.println("1부터 10까지 합계 = " + sum );

        // 1부터 100까지의 합계를 구하고 
        // 그 합계를 sum2 에 저장하고 출력한다.        
        int sum2 = getSum(1, 100);
        System.out.println("1부터 100까지 합계 = " + sum2 );
                
        // 100부터 sum2까지의 합계를 구하고 
        // 그 합계를 sum3 에 저장하고 출력한다. 
        int sum3 = getSum(100, sum2);
        System.out.println("100부터 "+ sum2 + "까지 합계 = " + sum3 );
        
    }


    
    // 합계를 구하시오.
    public static int getSum(int from, int to) {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum = sum + i;
        }

        return sum;
    }
}
