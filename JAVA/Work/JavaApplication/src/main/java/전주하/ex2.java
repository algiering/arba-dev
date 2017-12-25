package 전주하;

import java.util.Arrays;

public class ex2 {

    public static void main(String[] args) {

        int[] intArr = { 23, 96, 35, 42, 81, 19, 8, 77, 50 };

        System.out.print("정렬전: ");
        arrPrint(intArr);
        System.out.println();

        Arrays.sort(intArr);

        System.out.print("정렬후: ");
        arrPrint(intArr);
    }

    public static void arrPrint(int[] intArr) {
        for (int i = 0; i < intArr.length; i = i + 1) {
            System.out.print(intArr[i] + " ");
        }
    }

}
