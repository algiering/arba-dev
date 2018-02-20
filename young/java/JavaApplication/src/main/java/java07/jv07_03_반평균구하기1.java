package java07;

import java.util.Scanner;

public class jv07_03_반평균구하기1 {
    
    public static void main(String[] args) {
        
        // 배열 만들기
        int size = 3;
        int[] array = new int[size];

        // 키보드와 프로그램 연결
        Scanner keyboard = new Scanner(System.in); // 키보드와 프로그램 연결 : 1한번만 연결
        
        // 입력 받아 배열에 저장
        int sum = 0;
        for (int i = 0; i <= array.length - 1; i = i + 1) {
            System.out.print("숫자를 입력하세요 : "); // 사용자를 위한 텍스트 출력
            array[i] = keyboard.nextInt(); // 정수 입력 받아 x 공간에 저장.
        }
        
        // 배열 값을 출력 : for문을 이용해서
        System.out.print("배열의 값은: ");
        for (int i = 0; i <= array.length - 1; i = i + 1) {
            System.out.print(array[i]);
            
            if (i == array.length - 1) {
                
            } else {
                System.out.print(", ");
            }
        }
        System.out.println();
        
        // 배열 값을 출력 : format을 이용해서
        System.out.format("배열의 값은: %d, %d, %d", array[0], array[1], array[2]);
    }
}
