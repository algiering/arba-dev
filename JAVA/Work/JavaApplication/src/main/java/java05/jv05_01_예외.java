package java05;

public class jv05_01_예외 {

    public static void main(String[] args) {

        int x = 10;
        int y = 0;
        int z = 0;
        try {
            z = x / y;
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println("나누기 결과: "+z);
        
        int [] arr = {1,2,3,4};
        try {
            System.out.println(arr[5]);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("프로그램 정상 종료");
    }

}
