package java18.st03;

import java.util.Random;
import java.util.Scanner;

public class Jv18_03_Random {

    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);

        Random rand = new Random();
        double rand1 = rand.nextDouble();
        System.out.println(rand1);

        double rand3 = rand.nextDouble() * 2;
        System.out.println(rand3);

        System.out.println("문제1");

        double rand4 = rand.nextDouble() * (3 - 1) + 1;
        System.out.println(rand4);

        System.out.println("문제2");

        for (int i = 0; i < 5; i = i + 1) {

            double rand5 = rand.nextDouble() * 10;

            System.out.println(rand5);

        }
        
        System.out.println("문제3");

        int a = 0;
        int b = 0;

        System.out.print("A입력:");
        a = key.nextInt();
        System.out.print("B입력:");
        b = key.nextInt();

        int temp = 0;

        if (a > b) {

            temp = a;
            a = b;
            b = temp;

        }

        for (int i = 0; i < 10; i = i + 1) {

            double rand6 = rand.nextDouble() * (b - 1) + a;
            System.out.println((int) rand6);

        }
        
        key.close();

    }
}
