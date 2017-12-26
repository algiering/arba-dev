package pt01;

public class Test02 {

    static String str = "banana apple candy";

    public static void main(String[] args) {
        str = Str_Uppercase(str);
        String[] temp = Str_Split_Blank(str);
        
        System.out.println(temp[1]);
    }

    public static String[] Str_Split_Blank(String a) {
        return a.split(" ");
    }

    private static String Str_Uppercase(String a) {
        a = a.toUpperCase();
        return a;
    }

}
