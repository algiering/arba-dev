package java07;

import java.util.Arrays;
import java.util.Scanner;

public class jv07_09_maxarray {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.print("배열의 크기를 입력하세요:");
        int arrSize = keyboard.nextInt();
        int[] arr = new int[arrSize];

        for (int i = 0; i < arr.length; i = i + 1) {
            System.out.print(i + 1 + "번째 값을 입력하세요:");
            int x = keyboard.nextInt();
            arr[i] = x;
        }

        numSort(arr);

        System.out.println("최소값:" + arr[0]);
        System.out.println("최대값:" + arr[numSort(arr)]);
        keyboard.close();
    }

    public static int numSort(int x[]) {

        /* java.util. */Arrays.sort(x);
        return x[x.length - 1];
    }

}
