package java07;

public class jv07_00_Sum01Variable {

    public static void main(String[] args) {

        int score1 = 1, score2 = 2, score3 = 3, score4 = 4, score5 = 5;

        int[] score = new int[5];

        score[0] = 0;
        score[1] = 1;
        score[2] = 2;
        score[3] = 3;
        score[4] = 4;
        
        
        System.out.println("0층의 값:"+score[0]);
        System.out.println("1층의 값:"+score[1]);
        System.out.println("2층의 값:"+score[2]);
        System.out.println("3층의 값:"+score[3]);
        System.out.println("4층의 값:"+score[4]);
        
        for (int i = 0; i < score.length; i = i + 1) {
            System.out.println(i+"층의 값:"+score[i]);
        }
    }

}
