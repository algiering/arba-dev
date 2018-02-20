package java16.st2day;

import java.util.Calendar;

public class DayTest {

    public static void main( String[] args){

        Calendar date = Calendar.getInstance();

        int i = date.get(Calendar.DAY_OF_WEEK) +1;

        Day week = Day.fromId(i);

        if ( week == Day.SUN ) {

        }
    }
}
