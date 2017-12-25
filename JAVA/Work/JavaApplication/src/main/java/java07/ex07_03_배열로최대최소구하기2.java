package java07;

import java.util.Arrays;

public class ex07_03_배열로최대최소구하기2 {

    public static void main(String[] args) {

        int[] array = { 23, 96, 35, 42, 81, 19, 8, 77, 50, 64 };

        System.out.print("INPUT:");
        for (int i = 0; i < array.length; i = i + 1) {
            System.out.print(array[i] + ",");

            if (i == array.length - 1) {
                System.out.print(array[i] + "\n");
            }
        }

        System.out.print("배열 정렬 전:");
        for (int i = 0; i < array.length; i = i + 1) {
            System.out.print(array[i] + ",");

            if (i == array.length - 1) {
                System.out.print(array[i] + "\n");
            }
        }

        numSort(array);

        System.out.print("배열 정렬 후:");
        for (int i = 0; i < array.length; i = i + 1) {
            System.out.print(array[i] + ",");

            if (i == array.length - 1) {
                System.out.print(array[i] + "\n");
            }
        }

        System.out.println("최소값:" + array[0]);
        System.out.println("최대값:" + array[array.length - 1]);

    }

    public static void numSort(int x[]) {

        Arrays.sort(x);
    }
}
