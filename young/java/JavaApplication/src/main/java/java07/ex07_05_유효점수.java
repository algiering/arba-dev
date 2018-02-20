package java07;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 다섯 명 심사위원의 점수를 입력하여 
 * 유효 점수와 평균을 출력하는 프로그램을 작성합니다. 
 * 유효점수는 최고점과 최저점을 제외한 점수이며 
 * 평균은 유효점수로 계산합니다
 */
public class ex07_05_유효점수 {
    
    public static void main(String[] args) {
        
        // 심사 위원 수를 키보드에서 입력 받기
        Scanner keyboard = new Scanner(System.in);
        System.out.print("위원 수를 입력하세요 : ");
        int size = keyboard.nextInt(); // 정수 입력
        
        // 배열 선언과 생성
        int[] nums = new int[size];
        
        // 심사 위원의 입력 점수를 배열에 저장
        for (int i = 0; i < nums.length; i++) {
            System.out.print("점수를 입력하세요 : ");
            nums[i] = keyboard.nextInt(); // 정수 입력
        }
        
        // 최대값, 최소값을 어떻게 찾을 것인가?
        // java.util.Arrays.sort() 함수를 이용하여 정렬해서
        Arrays.sort(nums);
        
        // 유효점수 출력하기
        for (int i = 1; i <= nums.length - 2; i++) {
            System.out.print(nums[i] + "  ");
        }
        System.out.println();
        
        // 유효점수 합계 구하기.최소값과 최대값을 뺀 합계 구하고 출력하기
        int sum = getsum(nums);
        System.out.println("합계 : " + sum);
        
        // 유효점수의 평균을 구하고 출력하기
        double avg = getavg(sum, nums.length - 2);
        System.out.format("평균 : %.2f", avg);
    }
    
    private static double getavg(int sum, int i) {
        return (double) sum / i;
    }
    
    public static int getsum(int[] nums) {
        int sum = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }
}
