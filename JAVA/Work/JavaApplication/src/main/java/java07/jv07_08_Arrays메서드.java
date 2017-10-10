package java07;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class jv07_08_Arrays메서드 {

    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);

        int x = 6;
        int[] arr = new int[x];

        for (int i = 0; i <= arr.length - 1; i = i + 1) {
            arr[i] = arr.length - i;
            System.out.print(arr[i]+",");
        }

        System.out.println();
        
        Arrays.sort(arr);
        printArray(arr);
        
        System.out.println();

        int val = java.util.Arrays.binarySearch(arr, 4);
        System.out.println("4값의 위치 " + val);
        
        Arrays.fill(arr, -1);
        printArray(arr);
    }

    public static void printArray(int[] x) {
        for (int i = 0; i < x.length; i = i + 1) {
            System.out.print(x[i]+",");
        }
    }
}
