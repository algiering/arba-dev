package java18.st03;

import java.util.Random;

public class sdf {

    public static void main(String[] args) {

        Random rand = new Random();

        for (int i = 0; i < 10; i = i + 1) {

            double rand4 = rand.nextDouble() * 3 + 2;
            
            System.out.println(rand4);

        }

    }

}
