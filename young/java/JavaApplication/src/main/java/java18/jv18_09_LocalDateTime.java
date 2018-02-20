package java18;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class jv18_09_LocalDateTime {
    
    public static void main(String[] args) {

        // 날짜 설정하기
        LocalDate date  = LocalDate.of( 2014, 3, 18);
        System.out.println( date.getYear()       ); // 2014 
        System.out.println( date.getMonth()      ); // MARCH 
        System.out.println( date.getMonthValue() ); // 3 
        System.out.println( date.getDayOfMonth() ); // 18 
        System.out.println( date.getDayOfWeek()  ); // TUESDAY 
        System.out.println( date.lengthOfMonth() ); // 31 
        System.out.println( date.isLeapYear()    ); // false
        
        // 현재 날짜 가져오기 
        LocalDate  today = LocalDate.now();
        
        // 현재 연도만 출력
        System.out.println( today.get(ChronoField.YEAR) );
        
        // 현재 월만 출력
        System.out.println( today.get(ChronoField.MONTH_OF_YEAR) );
        
        // 현재 일만 출력
        System.out.println( today.get(ChronoField.DAY_OF_MONTH) );

        // 시간 설정 하기
        LocalTime time = LocalTime.of( 13,45,20);
        System.out.println( time.getHour()   );
        System.out.println( time.getMinute() );
        System.out.println( time.getSecond() );

        // 현재 시간 가져오기
        LocalTime curtime = LocalTime.now();
        
        // 현재 시간만 출력
        System.out.println( curtime.get(ChronoField.HOUR_OF_DAY) );  // 24
        System.out.println( curtime.get(ChronoField.HOUR_OF_AMPM) ); // 12
        
        // 현재 분만 출력
        System.out.println( curtime.get(ChronoField.MINUTE_OF_HOUR) );
        
        // 현재 초만 출력
        System.out.println( curtime.get(ChronoField.SECOND_OF_MINUTE) );
       
        
        // 현재에 +3년, -4월, +2일, +4시간, -30분, +10초 더해서 
        // "yyyy-MM-dd HH:mm:ss" 형태로 출력하시오.
        LocalDateTime dt = LocalDateTime.now();
        dt = dt.plusYears( +3 );
        dt = dt.plusMonths( -4 );
        dt = dt.plusDays( +2 );
        dt = dt.plusHours( +4 );
        dt = dt.plusMinutes(-30);
        dt = dt.plusSeconds(+10);          
        System.out.println( dt.toString() );     
        String s = dt.format( DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") );
        System.out.println( s );
        
        

        // 현재에 +3년, -4월, +2일, +4시간, -30분, +10초 더해서 
        // "yyyy-MM-dd HH:mm:ss" 형태로 출력하시오.
        LocalDateTime dt2 = LocalDateTime.now();
        dt2 = dt2.plus(+3, ChronoUnit.YEARS);
        dt2 = dt2.plus(-4, ChronoUnit.MONTHS);
        dt2 = dt2.plus(+2, ChronoUnit.DAYS);
        dt2 = dt2.plus(+4, ChronoUnit.HOURS);
        dt2 = dt2.plus(-30, ChronoUnit.MINUTES);
        dt2 = dt2.plus(+10, ChronoUnit.SECONDS);        
        System.out.println( dt2.toString() );       
        String s2 = dt.format( DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") );
        System.out.println( s2 );
             
    }    
}
