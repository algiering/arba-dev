package java20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ex20_02_ArrayList유효점수 {
    
    public static void main( String[] args) {
         /*
         step1. ArrayList 인스턴스, list  만들기.
         step2. 심사 위원수를 입력 받는다.   
         step3. 심사 위원의 점수 입력 받아서 list에 저장. 
                몇 번 입력 받아야 하는가? 심사 위원수 만큼
         step4. 합계를 구하는 메서드 만들기
                1번방부터 마지막방 -1 까지 
         step5. 평균을 구하는 메서드 만들기. 
                평균값 = (double)sum / ( list.size() - 2 ) 
         step6. ArrayLis 정렬하기.
         step7. 합계를 구하고 출력한다.
         step8. 평균을 구하고 출력한다.
         */
        
        // step1. 
        List<Integer> list = new ArrayList<>();
        
        // step2.
        Scanner keyboard = new Scanner(System.in);
        System.out.print("심사 위원수 : ");
        int 심사위원수 = keyboard.nextInt();
        
        // step3
        for(int i=0; i<심사위원수; i=i+1 ) {
            System.out.print("점수를 입력하세요 : ");
            int temp = keyboard.nextInt();
            
            // list 에 추가.
            list.add( temp );
        }
        
        // step6. ArrayLis 정렬하기.
        Collections.sort(list); // 오름차순으로 정렬됨.
        
        // step7. 합계를 구하고 출력한다.
        int sum = getsum(list);
        System.out.println("합계 : " + sum );
        

        // step8. 평균을 구하고 출력한다. size = list.size() -2
        double avg = getavg(sum, list.size() -2 );
        System.out.format("합계 : %.2f ",  avg );
        
    }

    // step4. 합계를 구하는 메서드 만들기
    // 1번방부터 마지막방(==list.size()-1) -1 까지 
    public static int  getsum(  List<Integer> list  ) {
        
        int sum = 0;
        for( int i=1; i<= list.size()-1 -1 ; i=i+1) {
            // 1번방에서 값 가져오기: list.get( 1 )
            // 2번방에서 값 가져오기: list.get( 2 )
            sum = sum + list.get(i); 
        }
        
        return sum;
    }
   

    // step5. 평균을 구하는 메서드 만들기. 
    //        평균값 = (double)sum / ( list.size() - 2 ) 
    public static double getavg( int sum , int size ) {
        return (double)sum / (double)size;
    }
    
    public static void printScore(List<Integer> list) {
        
        System.out.print("유효 점수 : ");
        for (int i = 1; i <= list.size()-2; i = i + 1) {            
            System.out.print( list.get(i) + " " );
        }
    }
}