package java18.st03;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Jv18_07_Calendar {

    public static void main(String[] args) {
        
        Scanner key = new Scanner(System.in);
        Calendar d = Calendar.getInstance();
        
        System.out.println(d);
        System.out.println(d.get(Calendar.YEAR));
        System.out.println(d.get(Calendar.MONTH));
        System.out.println(d.get(Calendar.DATE));
        System.out.println(d.get(Calendar.HOUR));
        System.out.println(d.get(Calendar.MINUTE));
        System.out.println(d.get(Calendar.SECOND));
        
        d.set(Calendar.YEAR, 2000);
        d.set(Calendar.MONTH, 4);
        d.set(Calendar.DATE, 13);
        d.set(Calendar.HOUR, 12);
        d.set(Calendar.MINUTE, 13);
        d.set(Calendar.SECOND, 15);
        System.out.println(d.toString());
        
        System.out.println(printDate(d));
        
        key.close();
        
    }
    
    public static String printDate(Calendar d) {
        
        SimpleDateFormat fo1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        return fo1.format(d.getTime());
        
    }

}
