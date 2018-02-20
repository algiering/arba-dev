package java20.st4phonebook;

import java.util.*;
import java.util.Scanner;

public class TestPhone {
    public static void main(String[] args) {
        Map<String, Phone> map = new HashMap<>();
        Scanner input = new Scanner(System.in);
        
        System.out.println("전화번호 관리 프로그램을 시작합니다. 파일로 저장하지 않습니다");
        System.out.println(
                "---------------------------------------------------------------------");
        
        int num = 4;
        Phone old;
        for (;;) {
            System.out.print("삽입:0, 삭제:1, 찾기:2, 전체보기:3, 종료:4 >>");
            num = input.nextInt();
            if (num == 0) {
                Phone newNumber = new Phone();
                System.out.print("이름>>");
                newNumber.setName(input.next());
                System.out.print("주소>>");
                newNumber.setAddress(input.next());
                System.out.print("전번>>");
                newNumber.setNumber(input.next());
                if ((old = map.put(newNumber.getName(), newNumber)) != null) {
                    System.out.println("중복 입력되지 않습니다");
                    map.put(old.getName(), old);
                }
                
            } else if (num == 1) {
                String remove = "";
                System.out.println("이름>>");
                if (map.remove(remove = input.next()) == null) {
                    System.out.println(remove + " 없는 사람입니다");
                } else {
                    System.out.println(remove + "삭제되었습니다.");
                }
            } else if (num == 2) {
                int count = 0;
                System.out.println("이름>>");
                String findName = input.next();
                for (Map.Entry<String, Phone> elem : map.entrySet()) {
                    if (elem.getKey().equals(findName)) {
                        System.out.println(elem.getValue());
                        count++;
                        break;
                    }
                    
                }
                if (count == 0) {
                    System.out.println(findName + " 등록되지 않은 사람입니다");
                }
            } else if (num == 3) {
                for (Map.Entry<String, Phone> elem : map.entrySet()) {
                    System.out.println(elem.getValue());
                }
            } else if (num == 4) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }
            
        }
    }
    
}
