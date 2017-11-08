package arraylisttest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest {

    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        add(key, list);

        int sum = 0;
        double avg = 0;

        for (Integer ilist : list) {
            sum = sum + ilist.intValue();
        }
        System.out.print("총점 ");
        System.out.println(sum);

        avg = sum / list.size();
        System.out.print("평균점수 ");
        System.out.println(avg);

        Collections.sort(list);

        removeMinMax(list);

        System.out.println(list.toString());

        sum = 0;
        avg = 0;

        for (Integer ilist : list) {
            sum = sum + ilist.intValue();
        }
        System.out.print("유효 총점 ");
        System.out.println(sum);

        avg = sum / list.size();
        System.out.print("유효 평균 ");
        System.out.println(avg);

        key.close();
    }

    public static void removeMinMax(List<Integer> list) {
        for (; true;) {
            if (list.get(0) == list.get(1)) {
                list.remove(0);
                Collections.sort(list);
            } else {
                list.remove(0);
                Collections.sort(list);
                break;
            }
        }

        for (; true;) {
            int i = 1;

            if (list.get(list.size() - i - 1) == list.get(list.size() - i)) {
                list.remove(list.size() - 1);
                Collections.sort(list);
            } else {
                list.remove(list.size() - 1);
                Collections.sort(list);
                break;
            }
        }
    }

    public static void add(Scanner key, List<Integer> list) {
        int s;
        int i = 1;
        for (; true;) {
            System.out.print("점수 입력(종료 0)" + i + "번째 :");
            s = key.nextInt();
            if (s == 0) {
                break;
            }
            i = i + 1;
            list.add(s);
        }
    }

}
