package java06;

public class jv06_04_어떻게메서드를만드는가 {

    public static void main(String[] args) {

        int sum = 0;
        int sum2 = 0;
        int sum3 = 0;

        sum = getSum(sum);

        for (int i = 1; i <= 100; i = i + 1) {

            sum2 = sum2 + i;
        }

        for (int i = 100; i <= sum2; i = i + 1) {

            sum3 = sum3 + i;
        }

        System.out.println(sum);
        System.out.println(sum2);
        System.out.println(sum3);

    }

    public static int getSum(int start, int end) {
        for (int i = start; i <= end; i = i + 1) {

            int sum = sum + i; {
                return sum;
            }
        }