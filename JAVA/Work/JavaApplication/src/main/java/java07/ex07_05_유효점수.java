package java07;

import java.util.Arrays;
import java.util.Scanner;

public class ex07_05_유효점수 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.print("심사 위원의 수를 입력하시오 : ");
        int size = keyboard.nextInt();

        int[] arr = new int[size];

        System.out.print(arr.length + "명 심사 위원의 점수 입력 : ");
        for (int i = 0; i < arr.length; i = i + 1) {
            arr[i] = keyboard.nextInt();
        }

        Arrays.sort(arr);

        System.out.print("유효점수 : ");

        int sum = 0;
        double average = 0;

        for (int i = 1; i < arr.length - 1; i = i + 1) {
            System.out.print(" " + arr[i]);
            sum = sum + arr[i];
            if (i == arr.length - 2) {
                System.out.println();
            }
        }

        average = (double) sum / (arr.length - 2);

        System.out.println("합계 : " + sum);
        System.out.println("평균 : " + Math.round(average * 100) / 100.0);

        keyboard.close();
    }

}
