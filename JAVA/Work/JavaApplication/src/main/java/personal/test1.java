package personal;

public class test1 {

    public static void main(String[] args) {

        int count = 0;

        for (int i = 0; i < 100000; i = i + 1) {
            String s = Integer.toString(i);

            for (int j = 0; j < s.length(); j = j + 1) {
                char c = s.charAt(j);
                if (c == '3' || c == '6' || c == '9') {
                    count = count + 1;
                }
            }

            String craps[] = { "한번", "두번", "세번", "네번", "다섯번", "여섯번" };

            if (count > 0 && count <= 6) {
                System.out.printf("%d 박수 %s\n", i, craps[count - 1]);
                count = 0;
            }
        }

    }
}