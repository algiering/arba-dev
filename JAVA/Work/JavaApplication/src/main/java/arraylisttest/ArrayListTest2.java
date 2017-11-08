package arraylisttest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest2 {

    public static void main(String[] args) {

        int sum = 0;
        Scanner key = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        // 리스트 추가
        addList(key, list);

        // 리스트 전체 합
        print(sum, list);

        // 배열 출력
        System.out.println(list.toString());

        // 배열 정렬
        Collections.sort(list);

        // 정렬후 배열 출력
        System.out.println(list.toString());

        sum = 0;

        // 최대최소 리스트 삭제
        removeMinMax(list);

        // 최대최소 리스트 삭제 후 배열 출력
        System.out.println(list.toString());

        sum = 0;

        System.out.println("유효 점수");

        // 유효 점수 출력
        print(sum, list);
    }

    public static void print(int sum, List<Integer> list) {
        double avg;
        for (int i = 0; i < list.size(); i = i + 1) {
            sum = sum + list.get(i);
        }
        System.out.print("총점 ");
        System.out.println(sum);

        // 리스트 합/리스트 사이즈
        avg = sum / list.size();
        System.out.print("평균점수 ");
        System.out.println(avg);
    }

    private static void addList(Scanner key, List<Integer> list) {
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
}
