package java07;

public class ja07_01_배열의선언과생성 {

    public static void main(String[] args) {

        int[] numbers = new int[6];

        numbers[0] = 0;
        numbers[1] = 1;
        numbers[2] = 2;
        numbers[3] = 3;
        numbers[4] = 4;
        numbers[5] = 5;

        int size = 6;
        int[] numbers2 = new int[size];

        for (int i = 0; i < numbers.length; i = i + 1) {
            
            System.out.println(numbers[i]);
        }
        
        for (int j = 0; j < numbers2.length; j = j + 1) {

            numbers2[j]=j;
            System.out.println(numbers2[j]);
            
        }
    }

}
