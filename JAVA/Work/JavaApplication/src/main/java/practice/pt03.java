package practice;

import java.util.Arrays;
import java.util.Calendar;

public class pt03 {

    public static void main(String[] args) {

        String global = "082-2-777-5566";

        double r = Math.random();
        int x = (int) (r * 100) + 0;

        System.out.println(x);

        String[] str = global.split("-");

        for (int i = 0; i < str.length; i = i + 1) {
            System.out.println(str[i]);
        }

        System.out.println("국가 번호:" + str[0]);
        System.out.println("도시 식별 번호:" + str[1]);
        System.out.println("가입자 번호:" + str[2] + "-" + str[3]);

        Calendar cal = Calendar.getInstance();

        int year = cal.get(cal.YEAR);
        int month = cal.get(cal.MONTH) + 1;
        int date = cal.get(cal.DATE);

        int hour = cal.get(cal.HOUR_OF_DAY);
        int min = cal.get(cal.MINUTE);
        int sec = cal.get(cal.SECOND);

        System.out.println(year + "-" + month + "-" + date);

        for (int i = 0; i <= 90; i = i + 5) {
            System.out.println(i + " sin : " + Math.sin(i));
        }

        double r2 = Math.random();
        int x2 = (int) (r2 * 10) + 0;

        System.out.println(x2);

        String str2 = "By doubting we come at the truth";
        String[] str22 = str2.split(" ");

        for (int i = 0; i < str22.length; i = i + 1) {
            System.out.println(str22[i]);
        }

        Calendar cal2 = Calendar.getInstance();
        int year2 = cal.get(cal.YEAR);
        int month2 = cal.get(cal.MONTH) + 1;
        int date2 = cal.get(cal.DATE) - 1;

        System.out.print(year2 + "-" + month2 + "-" + date2);
        
        double[] arr = new double[10];
        Arrays.sort(arr);

    }

}
