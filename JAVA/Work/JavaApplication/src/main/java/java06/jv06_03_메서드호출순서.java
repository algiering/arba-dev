package java06;

public class jv06_03_메서드호출순서 {

    public static void main(String[] args) { // caller

        int a = 3, b = 4;
        int value = Add(a, b);

        System.out.print(value);

    }

    public static int Add(int i, int j) { // caller

        int result = i + j;
        return result; // return type은 int

    }

}
