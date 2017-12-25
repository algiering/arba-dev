package java18.st03;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex18_07_Calendar {

    public static void main(String[] args) {

        Calendar now = Calendar.getInstance();
        Calendar c = Calendar.getInstance();

        System.out.println(c.getTime());

        // 년+3 월-4 일+2
        c.set(now.get(Calendar.YEAR) + 3, now.get(Calendar.MONTH) - 4, now.get(Calendar.DATE) + 2);
        System.out.println(printDate(c, "yyyy-MM-dd"));

        // 시+4 분-30 초+10
        c.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE), now.get(Calendar.HOUR) + 4,
                now.get(Calendar.MINUTE) - 30, now.get(Calendar.SECOND) + 10);
        System.out.println(printDate(c, "HH:mm:ss"));

        // 오늘의 요일
        c.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE));
        System.out.println(printDate(c, "EE"));

        // 이번달의 주차
        c.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE));
        System.out.println(printDate(c, "W"));

        // 2014년 01월 01일 기준 경과 년월일
        c.set(2014, 00, 01);

        int count = 0;
        String s = printDate(c, "yyyy-MM-dd");

        count = calSub(now, c, count, s);
        
        // 경과일
        System.out.println(count);

        // 경과 년 월 일
        c.set(0000, 00, 01);
        c.add(Calendar.DATE, count);
        System.out.println(printDate(c, "y-MM-dd"));

        // 오늘의 6개월 전
        c.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH) - 6, now.get(Calendar.DATE));
        System.out.println(printDate(c, "yyyy-MM-dd"));

        // 이번달 첫번째 요일
        c.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE) * 0 + 1);
        System.out.println(printDate(c, "EE"));

        // 이번달 월의 마지막 날
        c.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE) * 0);
        System.out.println(printDate(c, "yyyy-MM-dd"));
        System.out.println(printDate(c, "dd"));
    }

    public static String printDate(Calendar c, String format) {

        SimpleDateFormat sf = new SimpleDateFormat(format);

        return sf.format(c.getTime());

    }

    public static int calSub(Calendar now, Calendar c, int count, String s) {

        for (; true;) {

            if (s.equals(printDate(now, "yyyy-MM-dd"))) {
                break;
            }

            // System.out.println(printDate(c, "yyyy-MM-dd"));
            c.add(Calendar.DATE, +1);
            s = printDate(c, "yyyy-MM-dd");
            count = count + 1;
        }

        return count;

    }

}
