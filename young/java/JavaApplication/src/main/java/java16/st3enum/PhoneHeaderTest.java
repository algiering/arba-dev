package java16.st3enum;

import java.util.Scanner;


public class PhoneHeaderTest {

    public static void main(String [] args) {

        // 키포드로 폰번호 입력받는다.
        Scanner keyboard = new Scanner(System.in);

        System.out.print("폰번호를 입력하세요 : ");
        String phone = keyboard.next();    // 문자열 입력

        // 입력 받은 폰번호에서 앞으로부터 3자리 추출
        String header = phone.substring(0,3);

        // PhoneHeaderClass를 사용하여 아래를 출력되게 하시오.
        // header 가 O10이면 general, O11이면 sk, O16이면 kt, O19이면 lg.
        if( header.equals( PhoneHeaderClass.P010) ){
            System.out.println("general");
        }
        else if( header.equals( PhoneHeaderClass.P011) ){
            System.out.println("sk");
        }
        else if( header.equals( PhoneHeaderClass.P016) ){
            System.out.println("kt");
        }
        else if( header.equals( PhoneHeaderClass.P019) ){
            System.out.println("lg");
        }
        
        // PhoneHeaderEnum을 사용하여 아래를 출력되게 하시오.
        // header 가 O10이면 general, O11이면 sk, O16이면 kt, O19이면 lg.
        if( header.equals( PhoneHeaderEnum.P010.getValue() ) ){
            System.out.println("general");
        }
        else  if( header.equals( PhoneHeaderEnum.P011.getValue() ) ){
            System.out.println("sk");
        }
        else  if( header.equals( PhoneHeaderEnum.P016.getValue() ) ){
            System.out.println("kt");
        }
        else  if( header.equals( PhoneHeaderEnum.P019.getValue() ) ){
            System.out.println("lg");
        }

    }
}
