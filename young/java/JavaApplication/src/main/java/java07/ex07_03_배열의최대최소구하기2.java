package java07;

import java.util.Arrays;

/*
 * 10개의 정수를 입력 받아 
 * 정수형 배열에 저장하고 
 * 최대, 최소값을 구하시오
 */
public class ex07_03_배열의최대최소구하기2 {
    
    public static void main(String[] args) {

        // 배열 선언 및 생성
        int size = 10;
        int [] nums = new int[size];


        //배열에 값을 저장한다.
        nums[0] = 23 ;
        nums[1] = 96 ;
        nums[2] = 35 ;
        nums[3] = 42 ;
        nums[4] = 81 ;
        nums[5] = 19 ;
        nums[6] = 8  ;
        nums[7] = 77 ;
        nums[8] = 50 ;
        nums[9] = 64 ;

        // 정렬 전 배열 출력
        배열출력(nums, "배열 정렬 전: ");

        // sort 함수를 이용하여 정렬
        Arrays.sort(nums);

        // 정렬 후 배열 출력
        배열출력(nums, "배열 정렬 후: ");

        //최소값을 출력

        //최대값을 출력

    }

    public static void 배열출력(int[] nums, String msg) {
        System.out.print(msg);
        for( int i = 0; i < nums.length ; i++ ) {
            System.out.print(nums[i] + ", ");
        }

        System.out.println();
    }

}
