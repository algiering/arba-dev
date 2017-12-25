package pt03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class PhoneNumberManager {

    static int counter = 0;

    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);

        int s = 0;

        Map<String, Phone> map = new HashMap<String, Phone>();

        for (; true;) {

            System.out.print("| 삽입:0 | 삭제:1 | 찾기:2 | 전체보기:3 | 종료:4 | >>");
            s = key.nextInt();

            if (s == 0) {

                addPhone(key, map);

            }

            else if (s == 1) {

                deletePhone(key, map);

            }

            else if (s == 2)

            {

                pickPrint(key, map);

            }

            else if (s == 3) {

                printAllMap(map);

            }

            else if (s == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

        }

    }

    public static void deletePhone(Scanner key, Map<String, Phone> map) {
        System.out.print("이름 >>");
        String str = key.next();

        Iterator<Entry<String, Phone>> mapIter = map.entrySet().iterator();

        while (mapIter.hasNext()) {

            Entry<String, Phone> k = mapIter.next();

            if (str.equals(k.getValue().getName())) {

                map.remove(k.getKey());
                break;
            }
        }

        System.out.println(str + "은 삭제되었습니다.");
    }

    public static void pickPrint(Scanner key, Map<String, Phone> map) {
        String str;
        System.out.print("이름 >>");
        str = key.next();

        for (Phone p : map.values()) {
            if (p.getName().equals(str)) {
                System.out.println(
                        String.format("| 이름 >> %s | 주소 >> %s | 전화번호 >> %s |", p.getName(), p.getAddr(), p.getPn()));
                break;
            }
        }
    }

    public static void printAllMap(Map<String, Phone> map) {
        for (Map.Entry<String, Phone> e : map.entrySet()) {

            System.out.println(String.format("| 이름 >> %s | 주소 >> %s | 전화번호 >> %s |", e.getValue().getName(),
                    e.getValue().getAddr(), e.getValue().getPn()));

        }
    }

    public static void addPhone(Scanner key, Map<String, Phone> map) {

        String str;
        str = key.next();
        Phone pn = new Phone();

        System.out.print("이름 >>");
        str = key.next();
        pn.setName(str);

        System.out.print("주소 >>");
        str = key.next();
        pn.setAddr(str);

        System.out.print("전화번호 >>");
        str = key.next();
        pn.setPn(str);

        map.put(String.valueOf(counter), pn);

        counter = counter + 1;
    }

}
