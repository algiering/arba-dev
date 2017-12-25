package java12.st2date;

public class Date {

    private int year = 0;
    private String month = "a";
    private int day = 0;

    public void setDate(int year, String month, int day) {

    }

    public void printDate() {
        System.out.println(year + "년 " + month + "월 " + day + "일 ");
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Date() {
        super();
    }

    @Override
    public String toString() {
        return "Date [year=" + year + ", month=" + month + ", day=" + day + "]";
    }

}
