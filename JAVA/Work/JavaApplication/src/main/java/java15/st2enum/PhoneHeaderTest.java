package java15.st2enum;

import java.util.Scanner;

public class PhoneHeaderTest {

    public static void main(String[] args) {
        
        String phone = "";
        Scanner key = new Scanner(System.in);
        
        System.out.print("휴대폰 번호 입력 :");
        
        phone = key.nextLine();
        
        String header = phone.substring(0,3);
        
        System.out.println("use Class");
        if(header.equals(PhoneHeaderClass.P010)) {
            System.out.println("general");
        }
        else if(header.equals(PhoneHeaderClass.P011)) {
            System.out.println("sk");
        }
        else if(header.equals(PhoneHeaderClass.P016)) {
            System.out.println("kt");
        }
        else if(header.equals(PhoneHeaderClass.P019)) {
            System.out.println("lg");
        }
        else {
            System.out.println("unknown");
        }
        
        System.out.println();
        
        System.out.println("use Enum");
        
        
        if(header.equals(PhoneHeaderEnum.P010.getValue())) {
            System.out.println("general");
        }
        else if(header.equals(PhoneHeaderEnum.P011.getValue())) {
            System.out.println("sk");
        }
        else if(header.equals(PhoneHeaderEnum.P016.getValue())) {
            System.out.println("kt");
        }
        else if(header.equals(PhoneHeaderEnum.P019.getValue())) {
            System.out.println("lg");
        }
        else {
            System.out.println("unknown");
        }
    }
}
