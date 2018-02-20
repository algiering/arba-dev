package java06;

public class jv06_03_메서드호출순서 {

    public static void main(String[] args) {        
        int a =3, b=4;        
        int sum = Add(a, b);
        System.out.print(sum);
    }

    public static int Add(int i, int j) {
        int result = i + j;

        return result;
    }
}
