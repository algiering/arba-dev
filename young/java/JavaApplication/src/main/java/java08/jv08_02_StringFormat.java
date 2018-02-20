package java08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class jv08_02_StringFormat {
    
    public static void main(String[] args) {
        
        // String.format() vs System.out.format() 사용법
        // %s : 문자열
        // %d : 정수
        // %f : 부동소수점
        // %c : 문자한개

        String fo3 = String.format("H_%d", 2);
        System.out.println(fo3); // H_2
        
        String fo4 = String.format("%04d", 30);
        System.out.println(fo4); //0030
        
        String fo5 = String.format("%, d", 1000000000);
        System.out.println(fo5); //1,000,000,000
        
        String fo6 = String.format("%.2f ", 44444444.4444444);
        System.out.println(fo6); // 44444.44
        
        String fo7 = String.format("%,.2f", 44444444.4444444);        
        System.out.println(fo7); // 44,444,444.44

        // 날짜 출력 포맷 지정 하기: SimpleDateFormat 클래스 사용
        Date from = new Date();
        SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fo2 = tf.format(from);
        System.out.println(fo2); // 2016-07-02 11:03:44
    }
}
