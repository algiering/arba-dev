package java04;

public class ex04_32_369게임_string {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000000; i++) {
            String n = String.valueOf(i);
            int 박수횟수 = 0;
            for (int j = 0; j < n.length(); j++) {
                if (n.charAt(j) == '3' || n.charAt(j) == '6'
                        || n.charAt(j) == '9')
                    박수횟수++;
            }
            
            if (박수횟수 == 1) {
                System.out.println(n + " 박수 한번");
            } else if (박수횟수 == 2) {
                System.out.println(n + " 박수 두번");
            } else if (박수횟수 == 3) {
                System.out.println(n + " 박수 세번");
            } else if (박수횟수 == 4) {
                System.out.println(n + " 박수 네번");
            } else if (박수횟수 == 5) {
                System.out.println(n + " 박수 다섯번");
            } else if (박수횟수 == 6) {
                System.out.println(n + " 박수 여섯번");
            }
        }        
    }
    
}
