package java18;

import java.util.Calendar;

public class ex18_07_Calendar {
    
    public static void main(String[] args) {

        Calendar d = Calendar.getInstance();
        
        System.out.println( d.toString() );
        // 현재에 +4시간 , -30분 , +10초을 "HH:mm:ss" 형태로 출력하시오
        

        d = Calendar.getInstance();
        
        // 오늘의 요일이 출력하되도록 하시오.
        System.out.println( d.get(Calendar.DAY_OF_WEEK ));
        
        // 오늘은 이번달의 몇 주차인가?
        // 오늘부터 '2014-01-01'까지의 개월 수 차이를 계산하시오. 
        // 오늘부터 '2014-01-01'까지의 년수 차이를 계산하시오.
        // 오늘부터 '2014-01-01'까지의 일수를 계산하시오.
        
        
        // 오늘의 -6개월 전을 계산하시오.
        d.set(Calendar.MONTH, -6);
        System.out.println( d.toString() );
        
        // 이번달의 첫째날 요일 구하기
        d.set(d.get(Calendar.YEAR), d.get(Calendar.MONTH), 1);
        System.out.println( d.toString() );
        System.out.println(d.get(Calendar.DAY_OF_WEEK));
        
        // 이번달 월의 마지막 일을 출력하시오
        

    }
}
