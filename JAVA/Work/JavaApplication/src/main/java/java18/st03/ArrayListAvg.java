package java18.st03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListAvg {

    static Scanner key = new Scanner(System.in);

    public static void main(String[] args) {

        int x = 0;

        double avg = 0;

        List<Integer> list = new ArrayList<Integer>();

        System.out.print("학생수를 입력하시오:");
        x = key.nextInt();
        addList(list, x);

        System.out.println(list.toString());

        avg = sumList(list);
        avg = avg / x;
        System.out.println("평균은:" + avg);
    }

    public static void addList(List<Integer> list, int x) {

        for (int i = 0; i < x; i = i + 1) {

            System.out.print("성적을 입력하시오:");
            int y = key.nextInt();

            list.add(i, y);
        }
    }

    public static double sumList(List<Integer> list) {
        
        double sum = 0;

        for (int i = 0; i < list.size(); i = i + 1) {

           sum = sum + list.get(i);
        }
        return sum;
    }
}
