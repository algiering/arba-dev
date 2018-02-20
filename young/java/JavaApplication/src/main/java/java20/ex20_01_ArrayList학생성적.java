package java20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex20_01_ArrayList학생성적 {
    
    public static void main(String[] args) {
        
        // 1. ArrayList 만들기.
        List<Integer> list = new ArrayList<>();
        
        // 2. 학생수 입력 받기. 최소 3명이상    
        Scanner keyboard = new Scanner(System.in);
        System.out.print("학생수를 입력하세요 : ");
        int count = keyboard.nextInt();
        
        // 3. 학생 성적 입력 받기. 몇번 입력받아야 하는가?
        for( int i=1; i<=count; i=i+1) {

            System.out.print("성적을 입력하세요 : ");
            int score = keyboard.nextInt(); 
            
            // list에 입력 받은 학생 성적을 추가한다.  
            list.add(  score  ); // array[i] = score;
        }
        
        // 4. 3번 학생의 성적을 100점으로 바꾸시오.
        list.set( 2, 100); // list는 0번부터 시작. 2= 3-1
        
        // 5. list에서 마지막 학생 삭제.
        int 삭제할index = list.size()-1;
        list.remove(삭제할index);
        
        // 6. list에서 0번 값을 출력하시오.
        int 첫번째값 = list.get(0);
        
        // 7. 평균을 구하고 출력.
        //  
        
        
    }
}
