package java18.st03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class Jv18_09_LocalDateTime {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        System.out.println(today);

        System.out.println(today.get(ChronoField.YEAR));
        System.out.println(today.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(today.get(ChronoField.DAY_OF_MONTH));

        LocalTime now = LocalTime.now();

        System.out.println(now);

        System.out.println(now.get(ChronoField.HOUR_OF_DAY));
        System.out.println(now.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println(now.get(ChronoField.SECOND_OF_MINUTE));
        System.out.println(now.get(ChronoField.MICRO_OF_SECOND));

        LocalDateTime dateTime = LocalDateTime.now();

        dateTime = dateTime.plusYears(+3);
        dateTime = dateTime.plusMonths(-4);
        dateTime = dateTime.plusDays(+2);
        dateTime = dateTime.plusHours(+4);
        dateTime = dateTime.plusMinutes(-30);
        dateTime = dateTime.plusSeconds(+10);

        System.out.println(dateTime.toString());
        
        String s = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        System.out.println(s);
    }

}
