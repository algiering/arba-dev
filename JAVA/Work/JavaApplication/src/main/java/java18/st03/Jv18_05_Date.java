package java18.st03;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public interface Jv18_05_Date {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);

        Date date = new Date();

        date.setYear(date.getYear() + 3);
        date.setMonth(date.getMonth() - 4);
        date.setDate(date.getDate() + 2);

        date.setHours(date.getHours() + 4);
        date.setMinutes(date.getMinutes() - 30);
        date.setSeconds(date.getSeconds() + 10);

        SimpleDateFormat fo1 = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(fo1.format(date));

        fo1 = new SimpleDateFormat("HH:mm:ss");
        System.out.println(fo1.format(date));

        String s = "";

        System.out.print("날짜 시간 포맷 입력 :");
        s = key.nextLine();

        System.out.println(printDate(date, s));

        key.close();

    }

    public static String printDate(Date d, String format) {

        if (format == null || format == "" || format.equals("")) {

            format = "yyyy-MM-dd HH:mm:ss";

        }

        try {

            Date date = new Date();
            SimpleDateFormat fo1 = new SimpleDateFormat(format);
            System.out.println("input > " + format);

            return fo1.format(date);

        }

        catch (java.lang.IllegalArgumentException e) {

            System.out.println("Unknown Format!!");
            System.out.println("input > " + format + " > Default Date Format");
            format = "yyyy-MM-dd HH:mm:ss";

            Date date = new Date();
            SimpleDateFormat fo1 = new SimpleDateFormat(format);

            return fo1.format(date);

        }

        finally {

        }

    }

}
