package java18;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ex18_05_Date {
    
    public static void main(String[] args) {
        
        SimpleDateFormat tf = null; 

        // 현재 날짜와 시간 출력
        Date now = new Date();

        // 현재 연도만 출력
        System.out.println(now.getYear() ); // 117
        
        // 2017으로 출력되게.
        tf = new SimpleDateFormat("yyyy");
        System.out.println( tf.format(now) ); // 2017

        // 현재 월만 출력
        System.out.println(now.getMonth() ); // 9
        
        tf = new SimpleDateFormat("MM");
        System.out.println( tf.format(now) ); // 10

        // 현재 일만 출력
        System.out.println(now.getDate() ); // 
        
        // 현재 시간만 출력
        System.out.println(now.getHours() ); // 
        
        // 현재 분만 출력
        System.out.println(now.getMinutes() ); // 
        
        // 현재 초만 출력
        System.out.println(now.getSeconds() ); // 

        // 현재에 +3년, -4월, +2일 "yyyy-MM-dd" 형태로 출력하시오
        now.setYear ( now.getYear()  +3); // 117+3
        now.setMonth( now.getMonth() -4);
        now.setDate ( now.getDate()   +2);
        
        tf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println( tf.format(now) ); // 2020-06-27

        // 현재에 +4시간, -30분, + 10초 "HH:mm:ss" 형태로 출력하시오
        now.setHours  ( now.getHours()   + 4 );
        now.setMinutes( now.getMinutes() - 30);
        now.setSeconds( now.getSeconds() + 10);
        
        tf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( tf.format(now) ); // 
    }

    public static String printDate( Date i, String format ) {

        if(format==null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }

        // 날짜 출력 포맷 지정 하기: SimpleDateFormat 클래스 사용
        Date from = new Date();
        SimpleDateFormat tf = new SimpleDateFormat( format );
        return tf.format(from);
    }

}
