package java06;

public class jv06_02_왜메서드를쓰는가 {

    public static int getSum(int start, int end) {

        int sum = 0;

        for (int i = start; i <= end; i = i + 1) {
            sum = sum + i;
        }

        return sum;
    }

    public static void main(String[] args) {

        int sum = getSum(1, 10);
        int sum2 = getSum(1, 100);
        int sum3 = getSum(100, sum2);

        /*
         * for (int i = 1; i <= 10; i = i + 1) {
         * 
         * sum = sum + i; }
         * 
         * for (int i = 1; i <= 100; i = i + 1) {
         * 
         * sum2 = sum2 + i; }
         * 
         * for (int i = 100; i <= sum2; i = i + 1) {
         * 
         * sum3 = sum3 + i; }
         */
        System.out.println(sum);
        System.out.println(sum2);
        System.out.println(sum3);

    }

}
