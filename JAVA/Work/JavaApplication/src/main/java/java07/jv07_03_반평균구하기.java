package java07;

import java.util.Scanner;

public class jv07_03_반평균구하기 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("사람수를 입력하세요:");
        int pNum = keyboard.nextInt();
        
        int[] score = new int[pNum];

        for (int i = 0; i < score.length; i = i + 1) {

            System.out.print("점수를 입력하세요 (" + (i + 1) + "명째):");
            score[i] = keyboard.nextInt();
        }

        double ev = 0;
        
        System.out.print("배열의 값은:");

        for (int i = 0; i < score.length; i = i + 1) {
            ev = ev + score[i];
            
            if (i == (score.length - 1)) {
                System.out.print(score[i] + ".\n");
            } 
            else {
                System.out.print(score[i] + ",");
            }
        }
        System.out.println("반평균:" + ev / pNum);

        keyboard.close();
    }

}
