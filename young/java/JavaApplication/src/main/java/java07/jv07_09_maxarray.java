package java07;

import java.util.Arrays;
import java.util.Scanner;

public class jv07_09_maxarray {
    
    public static void main(String[] args) {
        
        // 배열 만들기
        int size = 6;
        int[] array = new int[size];
        
        // 배열에 값을 넣기.
        array[0] = 3;
        array[1] = 1;
        array[2] = 7;
        array[3] = 6;
        array[4] = 9;
        array[5] = 2;
        
        // 최대값은 배열의 마지막방(배열명.length-1) 에, 최소값을 배열의 0번에.
        System.out.println("최대값 : " + array[array.length - 1]);
        System.out.println("최소값 : " + array[0]);
        
        // max 메서드를 이용한 최대값 구하기.
        int temp = max( array );
        System.out.println("temp의 최대값 : " + temp );        

        // 최대값은 배열의 마지막방(배열명.length-1) 에, 최소값을 배열의 0번에.
        System.out.println("최대값 : " + array[array.length - 1]);
        System.out.println("최소값 : " + array[0]);
    }
    
    public static int max( int [] x ){

        // 배열 정렬
        Arrays.sort( x );
                
        // 최대값 반환        
        return x[x.length - 1];
    }
    
}
