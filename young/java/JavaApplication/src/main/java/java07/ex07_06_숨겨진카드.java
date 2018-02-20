package java07;

import java.util.Random;
import java.util.Scanner;

public class ex07_06_숨겨진카드 {

    public static void main(String [] args ){

        int flag= 1;
        int 시작값 = 0, 종료값=99;
        Scanner keyboard = new Scanner(System.in);

        // Random 을 이용해서 0과 99 사이의 임의의 정수 만들기
        Random rand = new Random();
        int 난수 = rand.nextInt(100);

        // "수를 결정하였습니다. 맞추어 보세요" 표준출력
        System.out.println("수를 결정하였습니다. 맞추어 보세요");

        // 무한 루프 안에서
        for( int i=1; true ; i++ ) {

            if(flag==0){
                난수 = rand.nextInt(100);
                flag=1;
            }            

            // 키보드에서 정수 입력값 입력 받기
            System.out.println(시작값 + "-" + 종료값);
            System.out.print(i+">>" );
            int  입력값 = keyboard.nextInt(); // 정수 입력

            // 입력값이 난수 보다 크다면 "더 낮게" 출력
            // 입력값이 난수 보다 작다면 "더 높게" 출력
            // 난수와 입력값이 같다면 "맞습니다" 출력하고 무한 루프 종료
            if( 입력값 > 난수 ) {
                System.out.println("더 낮게");
                종료값 = 입력값;
            }
            else if( 입력값 < 난수 ) {
                System.out.println("더 높게");
                시작값 = 입력값;
            }
            else  { // if( 입력값 == 난수 )
                System.out.println("맞습니다");
                
                System.out.print("다시하시겠습니까? (y/n) >> ");
                char yn = keyboard.next().charAt(0);
                
                if(yn =='y'){
                    i=0;
                    flag=0;                    
                }
                else if(yn =='n'){break;}
            }
        }
    }
}
